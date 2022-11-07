package edu.umb.cs680.hw06.ModelXYZ;

import edu.umb.cs680.hw06.EncryptedString;
import edu.umb.cs680.hw06.SecurityContext;

public class PrintJobExecutor extends edu.umb.cs680.hw06.PrintingFramework.PrintJobExecutor {


    @Override
    protected void doAccessControl() {
        super.doAccessControl();
    }
    @Override
    protected void doAuthentication(EncryptedString pwd, SecurityContext ctx) {
        super.doAuthentication(pwd, ctx);
    }
    @Override
    protected void doPrint() {
        super.doPrint();
        System.out.println("Print successful without authentication");
    }
    @Override
    protected void doErrorHandling() {
        super.doErrorHandling();
    }
}
