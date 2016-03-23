/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test4_1;
import java.io.*;
import javax.swing.JTextArea;

public class WriteTextFile
{
  public void writeTF(String w) throws IOException
  {
    File outFile = new File ("output.txt");
    FileWriter fWriter = new FileWriter (outFile);
    
      try (PrintWriter pWriter = new PrintWriter (fWriter)) {
          pWriter.println (w);
      }
  }
}