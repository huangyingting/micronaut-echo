package micronaut.echo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

@MicronautTest 
public class EchoControllerTest {

    @Inject
    @Client("/")  
    HttpClient client;

    @Test
    public void testGet() {
        HttpRequest<String> request = HttpRequest.GET("/");  
        String body = client.toBlocking().retrieve(request);
        assertNotNull(body);
    }

    @Test
    public void testDelete() {
        HttpRequest<String> request = HttpRequest.DELETE("/");  
        String body = client.toBlocking().retrieve(request);
        assertNotNull(body);
    }

    @Test
    public void testPost() {
        HttpRequest<String> request = HttpRequest.POST("/", "{\"echo\": \"echo\"}");  
        String body = client.toBlocking().retrieve(request);
        assertNotNull(body);
    }

    @Test
    public void testPut() {
        HttpRequest<String> request = HttpRequest.PUT("/", "{\"echo\": \"echo\"}");  
        String body = client.toBlocking().retrieve(request);
        assertNotNull(body);
    }

}