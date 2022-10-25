package edu.umb.cs680.hw03;

import edu.umb.cs680.hw03.Singleton;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SingletonTest {

    @Test
    public void checking_identical_instance() {
        Singleton inst1 = Singleton.getInstance();
        Singleton inst2 = Singleton.getInstance();

        assertSame(inst1, inst2);
        assertEquals(inst1.hashCode(),inst2.hashCode());

    }

    @Test
    public void checking_not_null_value(){
        Singleton s = Singleton.getInstance();
        assertNotNull(s);
    }





}