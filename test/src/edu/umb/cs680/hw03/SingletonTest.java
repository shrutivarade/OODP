package edu.umb.cs680.hw03;

import edu.umb.cs680.hw03.Singleton;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SingletonTest {

    @Test
    public void checking_identical_instance() {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        assertSame(s1, s2);
        assertEquals(s1.hashCode(),s2.hashCode());

    }

    @Test
    public void checking_not_null_value(){
        Singleton s = Singleton.getInstance();
        assertNotNull(s);
    }





}