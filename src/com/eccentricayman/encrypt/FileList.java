package com.eccentricayman.encrypt;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FileList {

    //used to store the different filenames
    private ArrayList<String> filePaths;
    //some common plaintext extensions
    protected final static String plaintextextensions = "txt,html,java,py,css,js,cpp,c,h,lua,rkt,nlogo,pde,el,ps1,md";

    public static void getfiles(File dir, ArrayList<String> stored) {
        try {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    //recursive, if file is a directory run the method on that directory
                    getfiles(file, stored);
                } 
                else {
                    //get substring of path after last "/", so just filename with extension
                    String filename = file.getCanonicalPath().substring(file.getCanonicalPath().lastIndexOf("/") + 1);
                    //checks if file is some form of txt file
                    if (txtTrue(filename)) {
                        //store the file path to the arraylist
                        stored.add(file.getCanonicalPath());    
                    }
                }
            }
        } 
        catch (IOException e) {
            e.printStackTrace(); 
        }
    }

    public static boolean txtTrue(String file) {
        String extension = "";
        int i = file.lastIndexOf('.');
        if (i >= 0) {
            extension = file.substring(i + 1);
        }
        return plaintextextensions.toLowerCase().contains(extension.toLowerCase());
    }

    public FileList() {
        filePaths = new ArrayList<String>();
        //gets home directory of the user
        File homedir = new File(System.getProperty("user.home"));
        //stores files in directory
        getfiles(homedir, filePaths);
    }
    
}