package edu.umb.cs680.hw07;


import org.junit.jupiter.api.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {

    public static LocalDateTime ldt = LocalDateTime.now();
    static Directory root = new Directory(null,"root", 0, ldt);
    static Directory Apps = new Directory(root,"Apps", 0, ldt);
    static Directory lib = new Directory(root,"lib", 0, ldt);
    static Directory home = new Directory(root,"home", 0, ldt);
    static Directory code = new Directory(home,"code", 0, ldt);
    static File file_x = new File(Apps,"x",1,ldt);
    static File file_y = new File(Apps, "y", 1, ldt);
    static File file_z = new File(lib,"z",1,ldt);
    static File file_d = new File(home,"d",1,ldt);
    static File file_a = new File(code,"a",1,ldt);
    static File file_b = new File(code,"b",1,ldt);
    static File file_c = new File(code,"c",1,ldt);

        @BeforeAll
        static void createFS(){
            root.appendChild(Apps);
            Apps.appendChild(file_x);
            Apps.appendChild(file_y);

            root.appendChild(lib);
            lib.appendChild(file_z);

            root.appendChild(home);
            home.appendChild(code);

            code.appendChild(file_a);
            code.appendChild(file_b);
            code.appendChild(file_c);
            home.appendChild(file_d);

        }

    private String[] dirToStringArray(Directory d){

        String[] dirInfo = {
                String.valueOf(d.isFile()),
                d.getName(),
                String.valueOf(d.getSize()),
                (d.getParent() != null)? String.valueOf(d.getParent().getName()) : null,
                String.valueOf(d.getCreationTime()),
                String.valueOf(d.countChildren()),
                String.valueOf(d.getTotalSize()),

        };
        return dirInfo;
    }

    @Test
    public void verifyEqualityForDirectoryRoot(){
        String[] expected = new String[]{"false","root", "0",null,String.valueOf(ldt),"3","7"};
        Directory actual = root;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyEqualityForDirectoryHome () {
        String[] expected = new String[]{"false","home", "0","root",String.valueOf(ldt),"2","4"};
        Directory actual = home;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyEqualityForDirectoryApps (){
        String[] expected = new String[]{"false","Apps", "0","root",String.valueOf(ldt),"2","2"};
        Directory actual = Apps;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyEqualityForDirectoryCode (){
        String[] expected = new String[]{"false","code", "0","home",String.valueOf(ldt),"3","3"};
        Directory actual = code;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyEqualityForDirectoryLib (){
        String[] expected = new String[]{"false","lib", "0","root",String.valueOf(ldt),"1","1"};
        Directory actual = lib;
        assertArrayEquals(expected, dirToStringArray(actual));
    }



}