package edu.umb.cs680.hw10;

import edu.umb.cs680.hw05.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    public void checkLoginAfterLogout(){
        ctx.logout();
        ctx.login(pwd);
        assertTrue(ctx.getState() instanceof LoggedIn);
    }

    @Test
    public void checkLogoutAfterLogin(){
        ctx.login(pwd);
        ctx.logout();
        assertTrue(ctx.getState() instanceof LoggedOut);
    }

}
