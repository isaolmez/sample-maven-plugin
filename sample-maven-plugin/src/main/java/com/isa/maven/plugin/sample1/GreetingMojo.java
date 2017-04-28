package com.isa.maven.plugin.sample1;

import java.util.Map;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Basic maven plugin example that showcases parameter usage 
 * https://maven.apache.org/guides/plugin/guide-java-plugin-development.html
 */

@Mojo(name = "hello")
public class GreetingMojo extends AbstractMojo {
	// TODO Why does it fail when name is specified 
	@Parameter(defaultValue = "${project.artifactId}")
	private String project;

	@Parameter(defaultValue = "en")
	private String language;

	@Parameter
	private Map<String, String> dictionary;

	public void execute() throws MojoExecutionException, MojoFailureException {
		getLog().info("Plugin Configuration");
		getLog().info(String.format("%s : %s", "projectName", project));
		getLog().info(String.format("%s : %s", "language", language));
		if(dictionary != null && !dictionary.isEmpty()){
			for (Map.Entry<String, String> entry : dictionary.entrySet()) {
				getLog().info(String.format("%s : %s", entry.getKey(), entry.getValue()));
			}
		}
	}
}
