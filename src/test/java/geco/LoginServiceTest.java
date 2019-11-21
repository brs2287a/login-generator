package geco;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LoginServiceTest {

    @Test
    public void testExist(){
        String[] tab = new String[]{"yes","yes2"};
        LoginService loginService = new LoginService(tab);
        assertTrue(loginService.loginExists("yes"));
    }

    @Test
    public void testNotExist(){
        String[] tab = new String[]{"yes","yes2"};
        LoginService loginService = new LoginService(tab);
        assertFalse(loginService.loginExists("yes3"));
    }

    @Test
    public void testAdd(){
        String[] tab = new String[]{"yes","yes2"};
        LoginService loginService = new LoginService(tab);
        loginService.addLogin("yes3");
        assertTrue(loginService.loginExists("yes3"));
    }

    @Test
    public void testfindAll(){
        String[] tab = new String[]{"yes","yes2"};
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(tab));
        LoginService loginService = new LoginService(tab);
        for (String str: loginService.findAllLogins()
             ) {
            assertTrue(list.contains(str));
        }
    }

    @Test
    public void testfindAllStartingWith(){
        String[] tab = new String[]{"yes","yes2","banana","banana2"};
        LoginService loginService = new LoginService(tab);
        List<String> listRetour = loginService.findAllLoginsStartingWith("bana");
        assertTrue(listRetour.contains("banana"));
        assertTrue(listRetour.contains("banana2"));
        assertFalse(listRetour.contains("yes"));
        assertFalse(listRetour.contains("yes2"));
    }
}