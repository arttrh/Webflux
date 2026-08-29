package webflux.Webflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import webflux.Webflux.document.Playlist;
import webflux.Webflux.repository.PlaylistRepository;

@Service
public class PlaylistServiceImpl implements PlaylistServiceUseCase {
    @Autowired
    private PlaylistRepository repository;

    @Override
    public Flux<Playlist> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Playlist> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Playlist> save(Playlist playlist) {
        return repository.save(playlist);
    }
}
