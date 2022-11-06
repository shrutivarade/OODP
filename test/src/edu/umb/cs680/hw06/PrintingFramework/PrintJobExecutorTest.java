package edu.umb.cs680.hw06.PrintingFramework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintJobExecutorTest {

    PrintJobExecutor xyz = new edu.umb.cs680.hw06.ModelXYZ.PrintJobExecutor();
    PrintJobExecutor abc = new edu.umb.cs680.hw06.ModelABC.PrintJobExecutor();


    @Test
    public void checkxyz(){
        String expected = "Print Successful with authentication";
//        String actual =
//        assertEquals("Print Successful with authentication");
    }

    @Test
    public void checkabc(){

    }

    @Test
    public void checkexception(){

    }

}