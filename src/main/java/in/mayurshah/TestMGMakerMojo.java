package in.mayurshah;

import in.mayurshah.util.Const;
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
        verifyEnvVariableExists(Const.suiteName);
        verifyEnvVariableExists(Const.ReportLocation);
        verifyEnvVariableExists(Const.remoteURL);
        verifyEnvVariableExists(Const.baseURL);
        verifyEnvVariableExists(Const.internal);
        verifyEnvVariableExists(Const.parallel);
        verifyEnvVariableExists(Const.thread_count);
        verifyEnvVariableExists(Const.tests);
        verifyEnvVariableExists(Const.browsers);
        verifyEnvVariableExists(Const.packageName);
        envVarToFile.write();
    }
    public void verifyEnvVariableExists(String var){
        if(System.getenv(var) == null || "".equals(System.getenv(var)))
            throw new NullPointerException("Env " + var + " is mandatory.");

    }
}
