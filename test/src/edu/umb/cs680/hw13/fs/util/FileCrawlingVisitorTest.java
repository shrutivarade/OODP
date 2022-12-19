package src.edu.umb.cs680.hw13.fs.util;

import edu.umb.cs680.hw09.fs.Directory;
import edu.umb.cs680.hw09.fs.File;
import edu.umb.cs680.hw09.fs.Link;
import edu.umb.cs680.hw09.fs.util.FileCrawlingVisitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FileCrawlingVisitorTest {


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
    public void testFilesInRoot(){
        LinkedList<File> expected = new LinkedList<File>();
        expected.add(x);
        expected.add(y);
        expected.add(a);
        expected.add(b);
        expected.add(c);

        Object[] exp = expected.toArray();

        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        root.accept(visitor);
        LinkedList<File> actual = visitor.getF();
        Object[] act = actual.toArray();

        assertArrayEquals(exp, act);
    }

    @Test
    public void testFilesInHome(){
        LinkedList<File> expected = new LinkedList<File>();

        expected.add(a);
        expected.add(b);
        expected.add(c);

        Object[] exp = expected.toArray();

        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        home.accept(visitor);
        LinkedList<File> actual = visitor.getF();
        Object[] act = actual.toArray();

        assertArrayEquals(exp, act);
    }

    @Test
    public void testFilesInApps(){
        LinkedList<File> expected = new LinkedList<File>();

        expected.add(x);

        Object[] exp = expected.toArray();

        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        Apps.accept(visitor);
        LinkedList<File> actual = visitor.getF();
        Object[] act = actual.toArray();

        assertArrayEquals(exp, act);
    }

}