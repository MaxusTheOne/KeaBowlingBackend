package kea.bowlingBackend.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import kea.bowlingBackend.security.api.AuthenticationController;
import kea.bowlingBackend.security.dto.LoginRequest;
import kea.bowlingBackend.security.entity.UserWithRoles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.Mockito.verify;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimNames;

import java.time.Instant;
import java.util.Collections;

import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthenticationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthenticationManager authenticationManager;

    @MockBean
    private JwtEncoder jwtEncoder;



    @BeforeEach
    public void setup() {
        UserWithRoles user = new UserWithRoles();
        user.setUsername("user1");

        Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

        when(authenticationManager.authenticate(any())).thenReturn(auth);

        Map<String, Object> headers = Collections.singletonMap("alg", "HS256");

        Jwt mockJwt = new Jwt("mockToken", Instant.now(), Instant.now().plusSeconds(3600),
                headers,
                Collections.singletonMap(JwtClaimNames.SUB, "user1"));

        when(jwtEncoder.encode(any(JwtEncoderParameters.class))).thenReturn(mockJwt);

    }

    @Test
    public void testLogin() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("user1");
        loginRequest.setPassword("test12");

        String jsonRequest = new ObjectMapper().writeValueAsString(loginRequest);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/login")
                        .content(jsonRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Verify that authenticate method was called with the expected argument
        verify(authenticationManager).authenticate(any(UsernamePasswordAuthenticationToken.class));
    }
}