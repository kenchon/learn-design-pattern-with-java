package com.kenchon;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args )
    {
        FileIO f = new FileProperties();
        try {
            f.readFromFile("/home/kenchon/source/designpattern/adaptor/file.txt");
            f.setValue("width", "1024");
            f.writeToFile("/home/kenchon/source/designpattern/adaptor/newfile.txt");
            System.out.println("newfile.txt is created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
