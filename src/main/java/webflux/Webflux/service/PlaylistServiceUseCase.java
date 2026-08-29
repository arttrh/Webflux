package webflux.Webflux.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import webflux.Webflux.document.Playlist;

public interface PlaylistServiceUseCase {
    Flux<Playlist> findAll();

    Mono<Playlist> findById(String id);

    Mono<Playlist> save(Playlist playlist);
}
