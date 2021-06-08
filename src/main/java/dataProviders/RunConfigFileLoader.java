package dataProviders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class RunConfigFileLoader {

    Properties propertyFile;
    String fileName;

    public RunConfigFileLoader(String fileName) throws IOException {
        System.out.println("RunConfigFileLoader");
        this.fileName = fileName;
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        propertyFile = new Properties();
        propertyFile.load(reader);
        reader.close();
    }




}
