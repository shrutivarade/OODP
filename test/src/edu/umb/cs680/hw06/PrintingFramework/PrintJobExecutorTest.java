package edu.umb.cs680.hw06.PrintingFramework;

import edu.umb.cs680.hw06.*;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class PrintJobExecutorTest {

    PrintJobExecutor xyz = new edu.umb.cs680.hw06.ModelXYZ.PrintJobExecutor();
    PrintJobExecutor abc = new edu.umb.cs680.hw06.ModelABC.PrintJobExecutor();

    User user;
    EncryptedString pwd;
    PrintJob job;

    @Test
    public void checkabc(){
        SecurityContext ctx = new SecurityContext(user);
        abc.execute(job,null,ctx);
        assertTrue(ctx.getState() instanceof LoggedIn);
    }

    @Test
    public void checkexception(){
        SecurityContext ctx = new SecurityContext(user);
        try{
            abc.doAuthentication(pwd,ctx);
        }
        catch(Exception e){
            throw e;
        }
    }



}