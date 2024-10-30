package com.jah.jismail3;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class Data {

    private String data;
    private File file; //handle the file


    public Data() {
        data = "";

    }

    public Data(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setFile(String filepath){
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
                FileWriter fw = new FileWriter(file);
                fw.write(data+ "\n");
                fw.flush();
                fw.close();
                System.out.println("Successfully wrote to file. the file:\n");
                ok = true;
            }
        }

        return ok;
    }
}
