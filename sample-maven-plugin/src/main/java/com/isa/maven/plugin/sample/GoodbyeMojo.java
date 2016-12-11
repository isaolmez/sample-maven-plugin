package com.isa.maven.plugin.sample;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Basic maven plugin example that showcases parameter usage and default phase binding 
 */

@Mojo(name = "goodbye", defaultPhase = LifecyclePhase.COMPILE)
public class GoodbyeMojo extends AbstractMojo {
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

	@Parameter(defaultValue = "${project.artifactId}")
	private String project;

	public void execute() throws MojoExecutionException, MojoFailureException {
		Date now = new Date();
		getLog().info(dateFormat.format(now));
		getLog().info(project + " =====> Goodbye world!");

	}
}
