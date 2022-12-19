package edu.umb.cs680.hw10.fs.util;

import edu.umb.cs680.hw10.fs.Directory;
import edu.umb.cs680.hw10.fs.FSVisitor;
import edu.umb.cs680.hw10.fs.File;
import edu.umb.cs680.hw10.fs.Link;

public class CountingVisitor implements FSVisitor {

    int countFile = 0;
    int countLink = 0;
    int countDir = 0;

    @Override
    public void visit(Link link) {
        countLink = countLink + 1;
    }

    @Override
    public void visit(Directory dir) {
        countDir = countDir + 1;
    }

    @Override
    public void visit(File file) {
        countFile = countFile + 1;
    }

    public int getCountFile() {
        return countFile;
    }

    public int getCountLink() {
        return countLink;
    }

    public int getCountDir() {
        return countDir;
    }
}
