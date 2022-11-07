package edu.umb.cs680.hw06.PrintingFramework;

import edu.umb.cs680.hw06.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintJobExecutorTest {

    PrintJobExecutor xyz = new edu.umb.cs680.hw06.ModelXYZ.PrintJobExecutor();
    PrintJobExecutor abc = new edu.umb.cs680.hw06.ModelABC.PrintJobExecutor();

    User user;
    SecurityContext ctx = new SecurityContext(user);
    EncryptedString pwd;


    @Test
    public void checkabc(){
        abc.execute(null,null,ctx);
        assertTrue(ctx.getState() instanceof LoggedIn);
    }

    @Test
    public void checkexception(){
        try{
            if(!Authenticator.authenticate(ctx,pwd)){
                ctx.login(pwd);
            }
            else {
                throw new RuntimeException("Authentication failed in test file");
            }
        }
        catch(Exception e){
            throw e;
        }
    }



}