package com.jah.jismail3;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 * Name: Jahangir Ismail
 * ID: A00036852
 * Assignment 3
 * Store the data from the client
 */

@Component
public class Data {

    private String data; // data from client
    private File file; //handle the file
    private File datafile;

    public Data() {
        data = "";

    }

    public String getData() {
        return data;
    }



    public Data(String data) {
        this.data = data;
    }


    // get the data from the file
    public String getFileData() {
        String somestuff = "";
        try {
            Scanner myscan = new Scanner(datafile);
            while(myscan.hasNextLine()){
                String data = myscan.nextLine();
                System.out.println(data);
                somestuff += data + "\n";
            }
            myscan.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setFile(String filepath){
        System.out.println("file path: " + filepath);
        file = new File(filepath);

    }

    public boolean isExist(){
        if(file != null)
            return file.exists();
        else return false;
    }

    public boolean saveData() throws IOException {
        boolean ok = false;
        if(isExist()){
            if(file.canWrite()){
               write();
               ok = true;
            }
        }else{
            // file doesn't exist, need to create
            System.out.println("File doesn't exist, creating...");
            if(file.createNewFile()){
                write();
                ok = true;
            }else{
                System.out.println("failed to create file");
            }
        }

        return ok;
    }

    private void write() throws IOException {
        FileWriter fw = new FileWriter(file);
        fw.write(data+ "\n");
        fw.flush();
        fw.close();
        System.out.println("Successfully wrote to file. the file:\n");
    }

    public boolean write(File f) throws IOException{
        boolean ok =false;
        FileWriter fw = new FileWriter(f);
        fw.write(data+ "\n");
        fw.flush();
        fw.close();
        System.out.println("Successfully wrote to file. the file:\n");
        ok = true;
        return ok;
    }
}
