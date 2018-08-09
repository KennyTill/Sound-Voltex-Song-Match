package com.semiceri.sdvx.controllers;

import com.semiceri.sdvx.model.Song;
import com.semiceri.sdvx.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class SongController {

    private SongService songService;

    @Autowired
    public SongController(SongService songService){
        this.songService = songService;
    }

    @GetMapping("/findMatches")
    public List<Song> findMatches(@RequestParam Integer playerOneStart,
                              @RequestParam Integer playerOneEnd,
                              @RequestParam Integer playerTwoStart,
                              @RequestParam Integer playerTwoEnd) {
        return songService.findMatches(playerOneStart, playerOneEnd, playerTwoStart, playerTwoEnd);
    }

    @PostMapping(value = "/findMatches", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public List<Song> findMatches(@RequestBody MultiValueMap<String, String> body){

        Integer playerOneStart = Integer.parseInt(body.getFirst("playerOneStart"));
        Integer playerTwoStart = Integer.parseInt(body.getFirst("playerTwoStart"));
        Integer playerOneEnd = Integer.parseInt(body.getFirst("playerOneEnd"));
        Integer playerTwoEnd = Integer.parseInt(body.getFirst("playerTwoEnd"));
        List<Song> songs = songService.findMatches(playerOneStart, playerOneEnd, playerTwoStart, playerTwoEnd);
        return songs;

    }


    @PostMapping("/findAll")
    public @ResponseBody List<Song> findAllSongs(){
       return songService.findAllSongs();
    }




}
