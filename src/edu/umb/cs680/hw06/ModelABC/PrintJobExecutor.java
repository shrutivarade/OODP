package edu.umb.cs680.hw06.ModelABC;

import edu.umb.cs680.hw06.*;

public class PrintJobExecutor extends edu.umb.cs680.hw06.PrintingFramework.PrintJobExecutor {

    User user;
    SecurityContext ctx = new SecurityContext(user);
    @Override
    protected void doAuthentication(EncryptedString pwd, SecurityContext ctx) {
        if(Authenticator.authenticate(ctx,pwd)){
            ctx.login(pwd);
        }

        super.doAuthentication(pwd, ctx);
    }

    @Override
    protected void doAccessControl() {
        super.doAccessControl();
    }

    @Override
    protected void doPrint() {
        super.doPrint();
        if((ctx.getState() instanceof LoggedIn))
            System.out.println("Print Successful with authentication");
        else
            System.out.println("Authentication Failed");
    }

    @Override
    protected void doErrorHandling() {
        super.doErrorHandling();
    }
}
