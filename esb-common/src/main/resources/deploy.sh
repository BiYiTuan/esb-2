#!/bin/sh

# set debug mode
#set -x

alias client_cmd="/opt/fuse/bin/client -p admin -u admin "

gitAdd(){
	cd ~/dev/stash/fuse_git/

	rm -rf *
	rm -rf .git

	git clone http://admin:admin@localhost:8182/git/fabric
	cd ~/dev/stash/fuse_git/fabric/fabric/

	git checkout $1

	echo "Listing properties after checkout"

	ls -lrt ~/dev/stash/fuse_git/fabric/fabric/profiles/esb/profile.profile

	cp -R ~/github/esb/esb-common/src/main/resources/properties/* ~/dev/stash/fuse_git/fabric/fabric/profiles/esb/profile.profile

	ls -lrt ~/dev/stash/fuse_git/fabric/fabric/profiles/esb/profile.profile

	cd ~/dev/stash/fuse_git/fabric/fabric/profiles/esb/profile.profile

	pwd

	git add .

	git commit -m "comitting properties for version $1"

	git push
	echo "********Finished git comitting**********"
}

#create features function
createFeatures (){
	echo "Adding features"
	while read -r line; do
		client_cmd ="fabric:profile-edit --features $line $1 $2"
	done < features.txt
}

createProfile(){
	echo "-----------Creating Profile---- $1----$2----$3-----------"
	client_cmd "fabric:profile-create --parents jboss-fuse-full --version $1 $2"
	echo "Profile created "
	client_cmd "fabric:profile-edit --repositories mvn:com.esb/esb-features/$3/xml/features $2 $1"
	echo "Repository added"
}

cleanContainer(){
	client_cmd "fabric:container-delete $2"
	echo "Container deleted"
	echo "----------------------------------"
	client_cmd "fabric:version-delete $1"
	echo "Version deleted"
	echo "----------------------------------"
	client_cmd "fabric:version-create $1"
	echo "Version created"
}

createContainer(){
	echo "creating container $1, $2"
	client_cmd ="fabric:container-create-child --profile $1 --version $2 --jvm-opts '-Xms256M -Xmx1024M -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=1044' --jmx-password admin  root $3 "
	client_cmd ="fabric:container-add-profile $3 $1"
}

createFabric(){
	client_cmd ="fabric:create --global-resolver localhostname --zookeeper-password admin --wait-for-provisioning"
}

#properties
version="$1"
repo_version="$2"
container_name="esb-fuse"
profile_name="esb-profile"
search_dir="properties"

#function calls
cleanContainer $version $container_name
createProfile $version $profile_name $repo_version
createFeatures $profile_name $version
gitAdd $version
createContainer $profile_name $version $container_name

echo "Finished deploying"
