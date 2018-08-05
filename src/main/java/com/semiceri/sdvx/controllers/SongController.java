package com.semiceri.sdvx.controllers;

import com.semiceri.sdvx.model.Song;
import com.semiceri.sdvx.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/findAll")
    public List<Song> findAllSongs(){
       return songService.findAllSongs();
    }




}
