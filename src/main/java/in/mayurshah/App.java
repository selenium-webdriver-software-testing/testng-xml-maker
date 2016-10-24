package in.mayurshah;

import in.mayurshah.util.EnvVarToFile;

/**
 * Created by mayur on 16-10-2016.
 */
public class App {

    public static void main(String[] args){
        EnvVarToFile envVarToFile = new EnvVarToFile("my-project");
        envVarToFile.addSuiteAttribute("name", System.getenv("name"));
        envVarToFile.addSuiteAttribute("parallel", System.getenv("parallel"));
        envVarToFile.addSuiteAttribute("thread-count", System.getenv("thread-count"));

        envVarToFile.addSuiteParameter("remoteURL", System.getenv("remoteURL"));
        envVarToFile.addSuiteParameter("ReportLocation", System.getenv("ReportLocation"));
        envVarToFile.addSuiteParameter("baseURL", System.getenv("baseURL"));
        envVarToFile.addSuiteParameter("internal", System.getenv("internal"));



        envVarToFile.write();
    }
}

