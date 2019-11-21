package geco;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoginGeneratorTest {



    @Test
    public void testGen(){
        LoginService loginService = new LoginService(new String[] {"JROL", "BPER", "CGUR", "JDU", "JRAL", "JRAL1"});
        new LoginGenerator(loginService).generateLoginForNomAndPrenom("Durand","Paul");
        assertTrue(loginService.loginExists("PDUR"));
    }

    @Test
    public void testGenIncrement(){
        LoginService loginService = new LoginService(new String[] {"JROL", "BPER", "CGUR", "JDU", "JRAL", "JRAL1"});
        new LoginGenerator(loginService).generateLoginForNomAndPrenom("Ralling","John");
        assertTrue(loginService.loginExists("JRAL2"));
    }


}