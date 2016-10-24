package in.mayurshah.util;

import org.testng.reporters.XMLStringBuffer;
import org.testng.xml.LaunchSuite;
import org.testng.xml.SuiteGenerator;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.util.*;

/**
 * Created by mayur on 16-10-2016.
 */
public class EnvVarToFile {
    private String projectName;
    private Collection<String> packageNames;
    private Map<String,Collection<String>> classAndMethodNames;
    private Collection<String> groupNames;
    private Map<String,String> suiteParameters;
    private Map<String,String> testParameters;
    private String annotationType;
    private Map<String,String> suiteAttributes;
    private Map<String,String> testAttributes;
    private int logLevel;

    public EnvVarToFile(String projectName){
        this.projectName = projectName;

        setPackageNames(new ArrayList<String>());
        setClassAndMethodNames(new HashMap<String,Collection<String>>());
        setGroupNames(new ArrayList<String>());
        setSuiteParameters(new HashMap<String, String>());
        setTestParameters(new HashMap<String, String>());
        setSuiteAttributes(new HashMap<String, String>());
        setTestAttributes(new HashMap<String, String>());
        annotationType = "true";
        logLevel = 3;
    }

    public void write(){

        LaunchSuite launchSuite =
                SuiteGenerator.createSuite(
                        projectName,
                        getPackageNames(),
                        getClassAndMethodNames(),
                        getGroupNames(),
                        getSuiteParameters(),
                        annotationType,
                        logLevel);
        File file = new File(".");
        XMLStringBuffer xmlStringBuffer = launchSuite.getSuiteBuffer();
        //xmlStringBuffer.pop("suite");
        Properties attrs = new Properties();
        attrs.setProperty("parallel", XmlSuite.ParallelMode.TESTS.toString());
        xmlStringBuffer.push("suite", attrs);
        xmlStringBuffer.push("test",attrs);
        xmlStringBuffer.pop();
        xmlStringBuffer.pop();
        //xmlStringBuffer.
        String xmlOP = xmlStringBuffer.toXML();
        System.out.print(xmlOP);
        launchSuite.save(file);
    }

    public Collection<String> getPackageNames() {
        return packageNames;
    }

    public void setPackageNames(Collection<String> packageNames) {
        this.packageNames = packageNames;
    }

    public void addPackageName(String packageName){
        this.packageNames.add(packageName);
    }

    public Map<String, Collection<String>> getClassAndMethodNames() {
        return classAndMethodNames;
    }

    public void setClassAndMethodNames(Map<String, Collection<String>> classAndMethodNames) {
        this.classAndMethodNames = classAndMethodNames;
    }

    public void addClassAndMethodName(String className, String...methodNames){
        Collection<String> _methodNames = new ArrayList<String>();
        for (String methodName: methodNames) {
            _methodNames.add(methodName);
        }
        this.classAndMethodNames.put(className,_methodNames);
    }

    public Collection<String> getGroupNames() {
        return groupNames;
    }

    public void setGroupNames(Collection<String> groupNames) {
        this.groupNames = groupNames;
    }

    public void addGroupName(String groupName){
        this.groupNames.add(groupName);
    }

    public Map<String, String> getSuiteParameters() {
        return suiteParameters;
    }

    public void setSuiteParameters(Map<String, String> suiteParameters) {
        this.suiteParameters = suiteParameters;
    }
    public void addSuiteParameter(String key, String value){
        this.suiteParameters.put(key,value);
    }
    public void addTestParameter(String key, String value){
        this.testParameters.put(key,value);
    }
    public void addSuiteAttribute(String key,String value){this.suiteAttributes.put(key,value);}
    public void addTestAttribute(String key,String value){this.testAttributes.put(key, value);}
    public Map<String, String> getTestParameters() {
        return testParameters;
    }

    public void setTestParameters(Map<String, String> testParameters) {
        this.testParameters = testParameters;
    }

    public Map<String, String> getSuiteAttributes() {
        return suiteAttributes;
    }

    public void setSuiteAttributes(Map<String, String> suiteAttributes) {
        this.suiteAttributes = suiteAttributes;
    }

    public Map<String, String> getTestAttributes() {
        return testAttributes;
    }

    public void setTestAttributes(Map<String, String> testAttributes) {
        this.testAttributes = testAttributes;
    }
}
