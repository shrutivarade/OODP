package edu.umb.cs680.hw06;

public class LoggedOut implements State {

    SecurityContext ctx;
    EncryptedString pwd;

    private static LoggedOut instance = null;

    LoggedOut(SecurityContext ctx) {
        this.ctx = ctx;
    }

    public static LoggedOut getInstance(SecurityContext ctx) {
        if (instance == null)
            instance = new LoggedOut(ctx);
        return instance;
    }

//    public LoggedOut(SecurityContext ctx){
//        this.ctx = ctx;
//    }

    public void login(EncryptedString pwd){
        if(Authenticator.authenticate(ctx,pwd)){
            ctx.changeState(new LoggedIn(ctx));

        }
        else {
            System.out.println("Incorrect password");
        }
    }

    public void logout(){

    }
}
