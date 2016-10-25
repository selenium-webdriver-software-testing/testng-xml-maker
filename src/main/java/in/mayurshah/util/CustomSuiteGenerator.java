package in.mayurshah.util;

import org.testng.reporters.XMLStringBuffer;
import org.testng.xml.LaunchSuite;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;

/**
 * Created by mayur on 17-10-2016.
 */
public class CustomSuiteGenerator extends LaunchSuite{

    private static final Collection<String> EMPTY_CLASS_LIST= Collections.emptyList();
    private XMLStringBuffer suiteBuffer;

    protected CustomSuiteGenerator(boolean b) {
        super(b);
        suiteBuffer = new XMLStringBuffer();
        suiteBuffer.setDocType("suite SYSTEM \"" + Parser.TESTNG_DTD_URL + "\"");
    }


    public File save(File directory) {
        final File suiteFile = new File(directory, "testng.xml");

        saveSuiteContent(suiteFile, getSuiteBuffer());

        return suiteFile;
    }

    protected void saveSuiteContent(final File file, final XMLStringBuffer content) {

        try {
            OutputStreamWriter fw = new OutputStreamWriter(new FileOutputStream(file), Charset.forName("UTF-8"));
            fw.write(content.getStringBuffer().toString());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public XMLStringBuffer getSuiteBuffer() {
        return suiteBuffer;
    }
}
