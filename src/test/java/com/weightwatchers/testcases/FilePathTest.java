package com.weightwatchers.testcases;

import java.io.File;
import java.io.*;

public class FilePathTest {

  private BufferedReader inStream;
  private static String usr_dir = System.getProperty("user.dir");

  public void doesFileExist(String fileName) throws FileNotFoundException{
    File mFile = new File(fileName);
    if (mFile.exists()) {
      FileReader fr = new FileReader(mFile);
      inStream = new BufferedReader(fr);
    }else{
      inStream = null;
    }
  }

  public void print_words() throws IOException{
    String inString;

    while ((inString = inStream.readLine()) != null) {
     // System.out.println(inString);
      int dashIndex = inString.indexOf("–");
      if (dashIndex < 0 ){
        // What is the requiremnt? Assume now just skip this line
      }else {
        String word = inString.substring(0, dashIndex);

        System.out.println("The word is : " + word.trim());

        String meanings = inString.substring(dashIndex + 1);

        int commaIndex;
        do{
          commaIndex = meanings.indexOf(",");
          if (commaIndex >= 0 ) {
            String s = meanings.substring(0, commaIndex).trim();
            if (s.length() > 0)
              System.out.println("The meaning is: " + s);
            meanings = meanings.substring(commaIndex + 1);
          }
        }while(commaIndex >= 0);
        String lastPart = meanings.trim();
        if (lastPart.length() > 0 ) System.out.println("The meaning is: " + lastPart);
      }
    }


  }

  public static void main(String[] args) {
    try {
      FilePathTest test = new FilePathTest();
      test.doesFileExist(usr_dir+ "/src/main/java/test.txt");
      test.print_words();
    } catch (FileNotFoundException ex) {
      ex.printStackTrace();

    } catch (IOException ex) {
      ex.printStackTrace();
    }

  }
}


