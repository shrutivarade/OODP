package edu.umb.cs680.hw05;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SecurityContextTest {

    User user;
    EncryptedString pwd;
    SecurityContext ctx = new SecurityContext(user);
    @Test
    public void checkLogout(){
        assertTrue(ctx.getState() instanceof LoggedOut);
    }

    @Test
    public void checkLogin(){
        ctx.login(pwd);
        assertTrue(ctx.getState() instanceof LoggedIn);
    }

    @Test
    public void equalityCheck(){
        assertNotEquals(ctx.getState() instanceof LoggedOut,ctx.getState() instanceof LoggedIn);
    }

}
