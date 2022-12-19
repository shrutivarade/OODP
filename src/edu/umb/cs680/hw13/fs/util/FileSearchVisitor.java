package edu.umb.cs680.hw13.fs.util;

import edu.umb.cs680.hw13.fs.Directory;
import edu.umb.cs680.hw13.fs.FSVisitor;
import edu.umb.cs680.hw13.fs.File;
import edu.umb.cs680.hw13.fs.Link;

import java.util.LinkedList;

public class FileSearchVisitor implements FSVisitor {


    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    LinkedList<File> foundFiles  = new LinkedList<File>();

    public FileSearchVisitor(String fileName) { //constructor
        this.fileName = fileName;
    }

    @Override
    public void visit(Link link) { //override methods from interface
//        System.out.println(this+"Link Visited");
        return;
    }
    @Override
    public void visit(Directory dir) { //override methods from interface
//        System.out.println(this+"Directory Visited");
        return;
    }
    @Override
    public void visit(File file) { //override methods from interface
//        System.out.println(this+"File Visited");
        if(file.getName().equals(fileName)){
            foundFiles.add(file);
//            System.out.println(this+"File added");
        }
    }
    public LinkedList<File> getFoundFiles() { //getter
        return foundFiles;
    }
}
