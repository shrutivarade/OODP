package edu.umb.cs680.hw09.fs.util;

import edu.umb.cs680.hw09.fs.Directory;
import edu.umb.cs680.hw09.fs.File;
import edu.umb.cs680.hw09.fs.Link;
import edu.umb.cs680.hw09.fs.util.CountingVisitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CountingVisitorTest {


    static private LocalDateTime ldt = LocalDateTime.now();

    static Directory root = new Directory(null,"root", 0, ldt);

    static Directory Apps = new Directory(root,"Apps", 0, ldt);
    static File x = new File(Apps,"x",1,ldt);

    static Directory bin = new Directory(root,"bin", 0, ldt);
    static File y = new File(bin,"y",19,ldt);

    static Directory home = new Directory(root,"home", 0, ldt);
    static File c = new File(home,"c",1,ldt);

    static Directory pictures = new Directory(home,"pictures", 0, ldt);
    static File a = new File(pictures,"a",1,ldt);
    static File b = new File(pictures,"b",1,ldt);

    static Link d = new Link(root, "d", 6, ldt, pictures);
    static Link e = new Link(root, "e", 6, ldt, x);

    @BeforeAll
    static void createFS() {
        root.appendChild(Apps);
        root.appendChild(bin);
        root.appendChild(home);
        root.appendChild(d);
        root.appendChild(e);

        Apps.appendChild(x);

        bin.appendChild(y);

        home.appendChild(pictures);
        home.appendChild(c);

        pictures.appendChild(a);
        pictures.appendChild(b);

    }

    @Test
    public void testDirectoriesForRoot() {
        CountingVisitor CV = new CountingVisitor();
        root.accept(CV);
        assertEquals(5,CV.getCountDir());
    }
    @Test
    public void testLinksForRoot() {
        CountingVisitor CV = new CountingVisitor();
        root.accept(CV);
        assertEquals(2,CV.getCountLink());
    }
    @Test
    public void testFilesForRoot() {
        CountingVisitor CV = new CountingVisitor();
        root.accept(CV);
        assertEquals(5,CV.getCountFile());
    }
    @Test
    public void testFilesForPicture() {
        CountingVisitor CV = new CountingVisitor();
        pictures.accept(CV);
        assertEquals(2,CV.getCountFile());
    }
    @Test
    public void testDirectoriesForHome() {
        CountingVisitor CV = new CountingVisitor();
        home.accept(CV);
        assertEquals(2,CV.getCountDir());
    }
    @Test
    public void testFilesForHome() {
        CountingVisitor CV = new CountingVisitor();
        home.accept(CV);
        assertEquals(3,CV.getCountFile());
    }
}