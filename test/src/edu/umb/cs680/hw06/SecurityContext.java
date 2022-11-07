package edu.umb.cs680.hw06;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class SecurityContext {


    private static State state;
    LinkedList<LocalDateTime> datetime = new LinkedList<LocalDateTime>();
    LocalDateTime local = LocalDateTime.now();

    public SecurityContext(User user) {
        state = new LoggedOut(this);
    }

    public void changeState(State newState){
        state = newState;
    }

    public void login(EncryptedString pwd){

        datetime.add(LocalDateTime.now());
        state.login(pwd);
    }

    public void logout(){
        state.logout();
    }

    boolean isActive(){
        if(datetime.getLast().getDayOfMonth() == local.getDayOfMonth() && datetime.getLast().getHour() == local.getHour()){
            if(datetime.getLast().getMinute() - local.getMinute() < 10)
                return true;

        }
        return false;
    }

    public State getState(){
        return state;
    }

    public static void main(String[] args) {
        User user = null;
        SecurityContext ctx = new SecurityContext(user);
        EncryptedString pwd = null;


        ctx.login(pwd);
        ctx.login(pwd);
        ctx.logout();

//        ctx.login(pwd);
//        ctx.logout();
//        ctx.login(pwd);



    }


}
