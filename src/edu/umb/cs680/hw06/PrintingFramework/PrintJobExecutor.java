package edu.umb.cs680.hw06.PrintingFramework;


import edu.umb.cs680.hw06.EncryptedString;
import edu.umb.cs680.hw06.SecurityContext;
import edu.umb.cs680.hw06.User;

import java.awt.*;
public abstract class PrintJobExecutor {

    public void execute(PrintJob job, EncryptedString pwd, SecurityContext ctx){

        try{
            doAccessControl();
            doAuthentication(pwd, ctx);
            doPrint();
        }
        catch (Exception e){
            doErrorHandling();
            throw e;
        }
    }

    protected void doAuthentication(EncryptedString pwd, SecurityContext ctx){

    }

    protected void doAccessControl(){

    }

    protected void doPrint(){

    }

    protected void doErrorHandling(){

    }

    public static void main(String[] args) {

        PrintJobExecutor xyz = new edu.umb.cs680.hw06.ModelXYZ.PrintJobExecutor();
        PrintJobExecutor abc = new edu.umb.cs680.hw06.ModelABC.PrintJobExecutor();

        PrintJob job;
        User user = null;
        SecurityContext ctx = new SecurityContext(user);

        xyz.execute(null,null,ctx);
        abc.execute(null,null,ctx);

    }


}
