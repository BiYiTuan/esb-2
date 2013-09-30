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
	public static final String MIME_BUNDLE_SN = "org.apache.sling.commons.mime";
	@Inject
	BundleContext ctx;
	// pax exam configuration, what to provision etc.
	@SuppressWarnings("deprecation")
	@Configuration
	public Option[] config() {
		return options(
				karafDistributionConfiguration().frameworkUrl(
			            maven().groupId("org.apache.karaf").artifactId("apache-karaf").type("zip").version("2.3.1"))
			            .karafVersion("2.3.1").name("Apache Karaf"),
				junitBundles(),
				systemPackages("javax.servlet"),
				provision(
						scanFeatures(maven().groupId("com.boohoo")
								.artifactId("fuse-database-features").version("0.0.1-SNAPSHOT")
								.classifier("features").type("xml"),
								"boohoo-esb-database-dependencies"),
						mavenBundle().groupId("org.springframework")
								.artifactId("spring-context")
								.version(SPRING_VERSION),
						mavenBundle().groupId("org.springframework")
								.artifactId("spring-beans")
								.version(SPRING_VERSION),
						mavenBundle().groupId("org.springframework")
								.artifactId("spring-core")
								.version(SPRING_VERSION),
						mavenBundle().groupId("org.springframework")
								.artifactId("spring-tx")
								.version(SPRING_VERSION),
						mavenBundle().groupId("org.springframework")
								.artifactId("spring-jdbc")
								.version(SPRING_VERSION)));
	}

	@Test
	public void testBundleStarted() {
		assertNotNull("Expecting BundleContext to be supplied", ctx);
		
		Bundle[] bundles = ctx.getBundles();
		for (Bundle bundle : bundles) {
			System.out.println(bundle.getSymbolicName() + " - "
					+ bundle.getState());
		}
	}

}