package webflux.Webflux.webflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import webflux.Webflux.document.Playlist;
import webflux.Webflux.service.PlaylistServiceImpl;

/* Classe handler responsavel por capturar todas as requisições que chegam do endpoint que fica no Rounter
 *   eles sempre vai retornar tipo Mono
 *
 *
 * */
@Component
public class PlaylistHandler {
    @Autowired
    private PlaylistServiceImpl service;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.findAll(), Playlist.class); // Aqui o Flux trabalha até terminar
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        String id = request.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.findById(id), Playlist.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        final Mono<Playlist> playlist = request.bodyToMono(Playlist.class); // promete que o dado vai chegar
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(playlist.flatMap(service::save), Playlist.class);
    }
}
