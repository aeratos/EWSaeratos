/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ewsa.client;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nicholas
 */
public class CsvDbReader {
    
    private String fileName;
    private BufferedReader br;
    
    public CsvDbReader(String country){
        this.fileName=country+".csv";
        read();
    }
    
    
    private void read(){
        try {
            br = new BufferedReader(new FileReader(fileName));
            String line;
            while((line= br.readLine())!=null){
                System.out.println(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CsvDbReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CsvDbReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
