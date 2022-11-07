package edu.umb.cs680.hw06.ModelABC;

import edu.umb.cs680.hw06.*;

public class PrintJobExecutor extends edu.umb.cs680.hw06.PrintingFramework.PrintJobExecutor {

    User user;
    SecurityContext ctx = new SecurityContext(user);

    @Override
    protected void doAccessControl() {
        super.doAccessControl();
    }

    @Override
    protected void doAuthentication(EncryptedString pwd, SecurityContext ctx) {
        super.doAuthentication(pwd, ctx);
        try{
            if(Authenticator.authenticate(ctx,null)){
                ctx.login(pwd);
            }
            else {
                throw new RuntimeException("Authentication failed in ModelABC");
            }
        }
        catch(Exception e){
            throw e;
        }
    }

    @Override
    protected void doPrint() {
        super.doPrint();
        if((ctx.getState() instanceof LoggedIn))
            System.out.println("Print Successful with authentication");
    }

    @Override
    protected void doErrorHandling() {
        super.doErrorHandling();
        System.out.println("Authentication failed in doErrHandling");
    }
}
