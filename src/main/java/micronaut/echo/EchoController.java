package micronaut.echo;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.HttpRequest;

@Controller("/")
public class EchoController {

    private String echo(HttpRequest<?> request) {
        StringBuilder response = new StringBuilder();
        response.append(":method: ");
        response.append(request.getMethod());
        response.append("\r\n");

        response.append(":url: ");
        response.append(request.getUri());
        response.append("\r\n");

        request.getHeaders().forEach(
            (key, values) -> response.append(key + ": " + values.toString() + "\r\n"));
        return response.toString();
    }

    @Get(produces = MediaType.TEXT_PLAIN)
    public String Get(HttpRequest<?> request) {
        return echo(request);
    }

    
    @Post(produces = MediaType.TEXT_PLAIN, consumes = { MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON})
    public String Post(HttpRequest<?> request, @Body String payload) {
        StringBuilder response = new StringBuilder();
        response.append(echo(request));
        response.append("\r\n");
        response.append(payload);
        return response.toString();
    }

    @Put(produces = MediaType.TEXT_PLAIN, consumes = { MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON})
    public String Put(HttpRequest<?> request, @Body String payload) {
        StringBuilder response = new StringBuilder();
        response.append(echo(request));
        response.append("\r\n");
        response.append(payload);
        return response.toString();
    }

    @Delete(produces = MediaType.TEXT_PLAIN)
    public String Delete(HttpRequest<?> request) {
        return echo(request);
    }    
}