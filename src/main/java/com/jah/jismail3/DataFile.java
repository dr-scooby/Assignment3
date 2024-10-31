package com.jah.jismail3;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class DataFile {

    private File datafile;


    public DataFile() {
    }


    public File getDatafile() {
        return datafile;
    }

    public void setDatafile(File datafile) {
        this.datafile = datafile;
    }
}
