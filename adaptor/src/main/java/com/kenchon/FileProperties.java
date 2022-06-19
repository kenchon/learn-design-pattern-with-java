package com.kenchon;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileProperties extends FileIO {
    private Properties props;

    public FileProperties() {
        this.props = new Properties();
    }

    @Override
    public void readFromFile(String filename) throws IOException {
        this.props = transformFileStringToProperties(filename);
    }
    
    @Override
    public void writeToFile(String filename) throws IOException {
        String outputString = transformPropsToRowwiseFormat(props);
        Files.writeString(Paths.get(filename), outputString);
    }

    @Override
    public void setValue(String key, String value) {
        props.setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return props.getProperty(key);
    }

    private Properties transformFileStringToProperties(String filename) throws IOException {
        Properties p = new Properties();
        List<String> fileRows = Files.readAllLines(Paths.get(filename));
        for (String fileRow: fileRows) {
            String[] splitedFileRow = fileRow.split("=");
            String key = splitedFileRow[0];
            String value = splitedFileRow[1];

            p.setProperty(key, value);
        }
        return p;
    }

    private String transformPropsToRowwiseFormat(Properties props) {
        String rowWiseFormat = new String();
        Set<String> propsKeys = props.stringPropertyNames();
        for (final String key: propsKeys) {
            String value = props.getProperty(key);
            rowWiseFormat += String.format("%s=%s\n", key, value);
        }
        return rowWiseFormat;
    }
}
