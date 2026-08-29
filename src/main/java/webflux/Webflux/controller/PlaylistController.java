package webflux.Webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import webflux.Webflux.document.Playlist;
import webflux.Webflux.service.PlaylistServiceImpl;

import java.time.Duration;

@RestController
public class PlaylistController {

    @Autowired
    PlaylistServiceImpl service;

    @GetMapping(value = "/playlist")
    public Flux<Playlist> getPlaylist(){
        return service.findAll();
    }

    @GetMapping(value = "/playlist/{id}")
    public Mono<Playlist> getId(@PathVariable String id){
        return service.findById(id);
    }

    @PostMapping(value = "/playlsit/post")
    public Mono<Playlist> save(@RequestBody Playlist playlist){
        return service.save(playlist);
    }

    @GetMapping(value = "/playlist/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, Playlist>> getPlaylistByEvents(){
        Flux<Long> intervalo = Flux.interval(Duration.ofSeconds(10));
        Flux<Playlist> events = service.findAll();
        System.out.println("Rodando evento");
        return Flux.zip(intervalo, events);
    }
}
