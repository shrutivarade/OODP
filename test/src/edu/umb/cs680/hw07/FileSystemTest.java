package edu.umb.cs680.hw07;

import org.junit.jupiter.api.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FileSystemTest {

    private LocalDateTime ldt = LocalDateTime.now();
    private Directory[] LinkedListToArray(LinkedList<Directory> r_List) {

        Directory[] r_Array = new Directory[r_List.size()];
        int i = 0;
        for (Directory root : r_List) {
            r_Array[i++] = root;
        }
        return r_Array;
    }

    @Order(1)
    @Test
    public void testGetRootDirectoryMethod() {
        FileSystem fs = FileSystem.getFileSystem();
        Directory[] expected = {};
        Directory[] actual = this.LinkedListToArray(fs.getRootDirs());
        assertArrayEquals(expected, actual);
    }

    @Order(2)
    @Test
    public void testWhetherFileSystemEquate() {
        FileSystem fs1 = FileSystem.getFileSystem();
        FileSystem fs2 = FileSystem.getFileSystem();
        assertSame(fs1, fs2);
    }

    @Order(3)
    @Test
    public void testAddRootDirectoryMethod() {

        Directory root = new Directory(null, "Root", 0, ldt);

        FileSystem fs = FileSystem.getFileSystem();
        fs.appendRootDirs(root);
        LinkedList<Directory> gRD = fs.getRootDirs();

        Directory[] expected = { root };
        Directory[] actual = this.LinkedListToArray(gRD);

        assertArrayEquals(expected, actual);

    }


}