package kea.bowlingBackend.users;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kea.bowlingBackend.security.entity.Role;
import kea.bowlingBackend.project.model.User;


import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    // for tests, we want to
    @Test
    void testUser() {

        User user = new User();
        user.setName("test");
        user.setPassword("test");
        user.addRole(("test"));
        user.setEmail("test@mail.com");
        Date testDate = new Date();
        user.setDateCreated(testDate);
        user.setDateEdited(testDate);
        user.setDateLastLogin(testDate);

        assertEquals("test", user.getName());
        assertEquals("test", user.getPassword());
        assertEquals("test", user.getRoles()[0]);
        assertEquals("test@mail.com", user.getEmail());
        assertEquals(testDate, user.getDateCreated());
        assertEquals(testDate, user.getDateEdited());
        assertEquals(testDate, user.getDateLastLogin());
    }

    @Test
    void testUserConstructor(){
        List<String> testRoleList = new ArrayList<String>();
        testRoleList.add("testRole");
        User user = new User("testName", "testPassword","testMail",testRoleList);

        assertEquals("testName", user.getName());
        assertEquals("testPassword", user.getPassword());
        assertEquals("testMail", user.getEmail());
        assertEquals("testRole", user.getRoles()[0]);
    }




}
