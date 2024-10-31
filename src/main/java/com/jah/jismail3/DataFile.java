package com.jah.jismail3;

import org.springframework.stereotype.Component;

import java.io.File;
/**
 * Name: Jahangir Ismail
 * ID: A00036852
 * Assignment 3
 * Handle to the File where data is store
 */

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
