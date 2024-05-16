

class UserTest {
    @Test
    void testUser() {
        User user = new User("testUser", "testPassword");
        assertEquals("testUser", user.getUsername());
        assertEquals("testPassword", user.getPassword());
    }
}