package ru.otus;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;

@Mojo(name = "base-mojo")
public class BaseMojo extends AbstractMojo {

    @Parameter
    private String artifactId;

    @Parameter
    private String version;

    @Override
    public void execute() {
        File jar = new File(getPluginContext().get("project.build.directory") + "/"
                + getPluginContext().get("project.build.finalname") + "/" + artifactId + "-" + version);
        if(jar.exists()){
            getLog().info("The file exists! " + jar.getAbsolutePath());
        } else {
            getLog().info("The file does not exist: " + jar.getAbsolutePath());
        }
    }
}