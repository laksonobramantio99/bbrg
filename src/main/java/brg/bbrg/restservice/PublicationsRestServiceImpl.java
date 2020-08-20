package brg.bbrg.restservice;

import brg.bbrg.rest.PublicationsData;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PublicationsRestServiceImpl implements PublicationsRestService {
    private WebClient webClient = WebClient.create();

    @Override
    public PublicationsData getPublicationsData() {
        Mono<PublicationsData> publicationsData = webClient.get()
                .uri("http://cse.bth.se/~fer/googlescholar-api/googlescholar.php?user=3t3aHO4AAAAJ")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(PublicationsData.class);

        return  publicationsData.block();
    }
}
