package kea.bowlingBackend.users;

import kea.bowlingBackend.project.model.User;
import kea.bowlingBackend.security.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIntegrationTest {

    @Autowired
    private WebTestClient webClient;

    @Test
    void testGetAllUsers() {
        webClient.get().uri("/users")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(User.class);
    }

    @Test
    void testGetUserById() {
        webClient.get().uri("/users/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody(User.class);
    }

    @Test
    void testCreateUser() {
        User user = new User();
        user.setName("testName");
        user.setPassword("testPassword");
        user.setEmail("testMail");
        user.addRole(new Role("testRole"));

        webClient.post().uri("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(user)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(User.class);
    }
}
