package kea.bowlingBackend.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class TestConfig {

    @Bean
    public WebTestClient webTestClient(RouterFunction<ServerResponse> routerFunction) {
        return WebTestClient.bindToRouterFunction(routerFunction).build();
    }
}
