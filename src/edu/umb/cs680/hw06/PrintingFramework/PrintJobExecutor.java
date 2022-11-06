package edu.umb.cs680.hw06.PrintingFramework;


import edu.umb.cs680.hw06.EncryptedString;
import edu.umb.cs680.hw06.SecurityContext;
import edu.umb.cs680.hw06.User;

public abstract class PrintJobExecutor {

    public void execute(Printjob job, EncryptedString pwd, SecurityContext ctx){
        doAuthentication(pwd, ctx);
        doAccessControl();
        doPrint();
        doErrorHandling();
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

        Printjob job;
        User user = null;
        SecurityContext ctx = new SecurityContext(user);

        xyz.execute(null,null,ctx);
        abc.execute(null,null,ctx);

    }


}
