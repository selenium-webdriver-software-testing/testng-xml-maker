package in.mayurshah;

import in.mayurshah.util.EnvVarToFile;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * Created by mayur on 25-10-2016.
 */
@Mojo(name="make")
public class TestMGMakerMojo extends AbstractMojo{
    public void execute() throws MojoExecutionException, MojoFailureException {
        EnvVarToFile envVarToFile = new EnvVarToFile();
        envVarToFile.write();
    }
}
