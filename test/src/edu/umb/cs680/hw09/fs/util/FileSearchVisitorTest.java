package edu.umb.cs680.hw09.fs.util;

import edu.umb.cs680.hw09.fs.Directory;
import edu.umb.cs680.hw09.fs.File;
import edu.umb.cs680.hw09.fs.Link;
import edu.umb.cs680.hw09.fs.util.FileSearchVisitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class FileSearchVisitorTest {

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

    static Link link_d = new Link(root, "d", 6, ldt, pictures);
    static Link link_e = new Link(root, "e", 6, ldt, x);

    @BeforeAll
    static void createFS() {
        root.appendChild(Apps);
        root.appendChild(bin);
        root.appendChild(home);
        root.appendChild(link_d);
        root.appendChild(link_e);

        Apps.appendChild(x);

        bin.appendChild(y);

        home.appendChild(pictures);
        home.appendChild(c);

        pictures.appendChild(a);
        pictures.appendChild(b);

    }

    @Test
    public void testAcceptForSize(){
        FileSearchVisitor visitor = new FileSearchVisitor("y");
        root.accept(visitor);
        visitor.setFileName("x");
        root.accept(visitor);
        visitor.setFileName("c");
        root.accept(visitor);
        assertSame(3,visitor.getFoundFiles().size());
    }

    @Test
    public void testAcceptToLocateMultipleFile(){

        LinkedList<File> expected = new LinkedList<File>();
        expected.add(x);
        expected.add(y);

        Object[] exp = expected.toArray();

        FileSearchVisitor visitor = new FileSearchVisitor("x");
        root.accept(visitor);
        visitor.setFileName("y");
        root.accept(visitor);
        LinkedList<File> actual = visitor.getFoundFiles();

        Object[] act = actual.toArray();
        assertArrayEquals(exp, act);

    }
}

