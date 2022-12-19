package edu.umb.cs680.hw10.fs;

import edu.umb.cs680.hw10.SecurityContext;

import java.time.LocalDateTime;

public class File extends FSElement {


    public File(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
    }

    @Override
    public boolean isDirectory() {

        return false;
    }

    @Override
    public boolean isFile() {
        return true;
    }

    @Override
    public boolean isLink() {
        return false;
    }

    @Override
    public void accept(FSVisitor v, SecurityContext ctx) throws Exception {
        if (ctx.isActive()) {
            v.visit(this);
        } else {
            System.out.println("Stop in File");
            throw new Exception();
        }
    }
}