package webflux.Webflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import webflux.Webflux.document.Playlist;

public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String> {
}
