package edu.umb.cs680.hw07;

import edu.umb.cs680.hw07.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {
        public static LocalDateTime ldt = LocalDateTime.now();
        static Directory root = new Directory(null,"root", 0, ldt);
        static Directory Apps = new Directory(root,"Apps", 0, ldt);
        static Directory lib = new Directory(root,"lib", 0, ldt);
        static Directory home = new Directory(root,"home", 0, ldt);
        static Directory code = new Directory(home,"code", 0, ldt);
        static File file_x = new File(Apps,"x",2,ldt);
        static File file_y = new File(Apps, "y", 5, ldt);
        static File file_z = new File(lib,"z",6,ldt);
        static File file_d = new File(home,"d",16,ldt);
        static File file_a = new File(code,"a",7,ldt);
        static File file_b = new File(code,"b",8,ldt);
        static File file_c = new File(code,"c",15,ldt);

        @BeforeAll
        static void createFS(){
            root.appendChild(Apps);
            Apps.appendChild(file_x);
            Apps.appendChild(file_y);

            root.appendChild(lib);
            lib.appendChild(file_z);

            root.appendChild(home);
            home.appendChild(code);
            home.appendChild(file_d);
            code.appendChild(file_a);
            code.appendChild(file_b);
            code.appendChild(file_c);

        }

        private String[] fileToStringArray(File file){
            String[] file_Info = {
                    String.valueOf(file.isFile()),
                    file.getName(),
                    String.valueOf(file.getSize()),
                    (file.getParent() != null)? String.valueOf(file.getParent().getName()) : null,
                    String.valueOf(file.getCreationTime())
            };
            return file_Info;
        }

        @Test
        public void verifyEqualityForFileY(){
            String[] expected = new String[]{"true","y", "5","Apps",String.valueOf(ldt)};
            File actual = file_y;
            assertArrayEquals(expected, fileToStringArray(actual));
        }

        @Test
        public void verifyEqualityForFileZ() {
            String[] expected = new String[]{"true","z", "6","lib",String.valueOf(ldt)};
            File actual = file_z;
            assertArrayEquals(expected, fileToStringArray(actual));
        }

        @Test
        public void verifyEqualityForFileA(){
            String[] expected = new String[]{"true","a", "7","code",String.valueOf(ldt)};
            File actual = file_a;
            assertArrayEquals(expected, fileToStringArray(actual));
        }

        @Test
        public void verifyEqualityForFileD(){
            String[] expected = new String[]{"true","d", "16","home",String.valueOf(ldt)};
            File actual = file_d;
            assertArrayEquals(expected, fileToStringArray(actual));
        }
}