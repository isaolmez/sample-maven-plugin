package com.isa.maven.plugin.sample1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
/*
 * Basic maven plugin example that shows a parameterless plugin
 */
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Basic maven plugin example that showcases parameter usage 
 * https://maven.apache.org/guides/plugin/guide-java-plugin-development.html
 */

@Mojo(name = "hello")
public class GreetingMojo extends AbstractMojo {
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

	@Parameter(defaultValue = "${project.artifactId}")
	private String project;

	public void execute() throws MojoExecutionException, MojoFailureException {
		Date now = new Date();
		getLog().info(dateFormat.format(now));
		getLog().info(project + " =====> Hello world!");
	}
}
