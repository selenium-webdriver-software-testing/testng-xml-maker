package in.mayurshah;

import in.mayurshah.util.EnvVarToFile;

/**
 * Created by mayur on 16-10-2016.
 */
public class App {

    public static void main(String[] args){
        EnvVarToFile envVarToFile = new EnvVarToFile("my-project");
        //envVarToFile.addPackageName("in.mayurshah");
        //envVarToFile.addClassAndMethodName("login","correctUserNamePassword","WrongUserNamePassword");
        //envVarToFile.addGroupName("sanity");
        //envVarToFile.addParameter("browser","ff");
        //envVarToFile.addParameter("version","latest");
        //envVarToFile.addParameter("OS","WIN_8");
        envVarToFile.write();
    }
}

