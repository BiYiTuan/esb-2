package com.boohoo.esb.database.tests;

import static org.apache.karaf.tooling.exam.options.KarafDistributionOption.karafDistributionConfiguration;
import static org.junit.Assert.assertNotNull;
import static org.ops4j.pax.exam.CoreOptions.junitBundles;
import static org.ops4j.pax.exam.CoreOptions.maven;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.options;
import static org.ops4j.pax.exam.CoreOptions.provision;
import static org.ops4j.pax.exam.CoreOptions.scanFeatures;
import static org.ops4j.pax.exam.CoreOptions.systemPackages;

import javax.inject.Inject;

import org.apache.karaf.features.Feature;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.ExamReactorStrategy;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.ops4j.pax.exam.spi.reactors.AllConfinedStagedReactorFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

/** Use pax exam test runner */
@RunWith(JUnit4TestRunner.class)
/*
 * Restart OSGi framework for each test (which is the default setting)
 */
@ExamReactorStrategy(AllConfinedStagedReactorFactory.class)
/** Example test that runs with pax exam, just
 *  checks that BundleContext is supplied and that
 *  we can install bundles
 */
public class SetupTest extends KarafTestSupport {

	private static final String SPRING_VERSION = "3.1.3.RELEASE";
	@Inject
	BundleContext ctx;
	// pax exam configuration, what to provision etc.
	@SuppressWarnings("deprecation")
	@Configuration
	public Option[] config() {
		return options(
				karafDistributionConfiguration().frameworkUrl(
			            maven().groupId("org.apache.karaf").artifactId("apache-karaf").type("tar.gz").version(getKarafVersion()))
			            .karafVersion(getKarafVersion()).name("Apache Karaf"),
				junitBundles(),
				systemPackages("javax.servlet")
			);
	}

	private String getKarafVersion() {
		return "2.3.0.fuse-71-047";
	}

	@Test
	public void testBundleStarted() throws Exception {
		System.out.println(executeCommand("features:addurl mvn:com.boohoo.esb/esb-features/1.0.0-SNAPSHOT/xml/features"));
		String featureName = "esb-common";
		System.out.println(executeCommand("features:install esb-common"));
		Feature feature = featureService.getFeature(featureName);
		
		assertNotNull("Features not install : " + featureName, feature);
		executeCommand("features:list");
	}

}