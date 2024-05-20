package kea.bowlingBackend.security.users;

import kea.bowlingBackend.security.entity.UserWithRoles;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kea.bowlingBackend.security.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;


import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    // for tests, we want to


    @Test
    void testUser() {



        UserWithRoles user = new UserWithRoles();
        user.setUsername("test");
        user.setEmail("test@mail.com");
        LocalDateTime testDate = LocalDateTime.now();
        user.setCreated(testDate);
        user.setEdited(testDate);


        assertEquals("test", user.getUsername());
        assertEquals("test@mail.com", user.getEmail());
        assertEquals(testDate, user.getCreated());
        assertEquals(testDate, user.getEdited());

    }





}
