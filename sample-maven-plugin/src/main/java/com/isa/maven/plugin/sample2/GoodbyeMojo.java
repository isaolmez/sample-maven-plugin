package com.isa.maven.plugin.sample2;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Basic maven plugin example that showcases parameter usage and default phase binding
 * Refer to https://maven.apache.org/guides/plugin/guide-java-plugin-development.html
 */

@Mojo(name = "goodbye", defaultPhase = LifecyclePhase.COMPILE)
public class GoodbyeMojo extends AbstractMojo {
	@Parameter(defaultValue = "${project.artifactId}")
	private String project;

	@Parameter
	private String country;

	public void execute() throws MojoExecutionException, MojoFailureException {
		getLog().info("Plugin Configuration");
		getLog().info(String.format("%s : %s", "project", project));
		getLog().info(String.format("%s : %s", "country", country));
	}
}
