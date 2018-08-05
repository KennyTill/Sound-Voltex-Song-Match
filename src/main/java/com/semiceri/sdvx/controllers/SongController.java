package com.semiceri.sdvx.controllers;

import com.google.common.collect.Lists;
import com.semiceri.sdvx.model.Song;
import com.semiceri.sdvx.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class SongController {

    private SongService songService;

    @Autowired
    public SongController(SongService songService){
        this.songService = songService;
    }

    @GetMapping("/songTest")
        public String geSingleSong(){
        Song testSong = new Song("Boss Rush", Lists.newArrayList(6,12,15,18));
        return testSong.toString();
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
