package edu.umb.cs680.hw06;

public class LoggedIn implements State {

    SecurityContext ctx;

    private static LoggedIn instance = null;

    LoggedIn(SecurityContext ctx){
        this.ctx = ctx;
    }


    public static LoggedIn getInstance(SecurityContext ctx) {
        if(instance == null)
            instance = new LoggedIn(ctx);
        return instance;
    }

//    public LoggedIn(SecurityContext ctx) {
//        this.ctx = ctx;
//    }

    public void login(EncryptedString pwd){
        if(!ctx.isActive()){
            ctx.changeState(new LoggedOut(ctx));
            ctx.login(pwd);
        }
    }

    public void logout(){
        ctx.changeState(new LoggedOut(ctx));
    }

}
