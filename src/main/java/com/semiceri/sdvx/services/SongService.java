package com.semiceri.sdvx.services;

import com.semiceri.sdvx.components.DataLoader;
import com.semiceri.sdvx.model.Song;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongService {

    DataLoader loader;
    public SongService(DataLoader loader){
        this.loader = loader;
    }

    @PostConstruct
    private void init(){
        SONG_LIST = loader.LoadData();
    }

    private  List<Song> SONG_LIST = new ArrayList<>();


    public List<Song> findAllSongs() {
        return SONG_LIST;
    }

    public List<Song> findMatches(Integer playerOneStart,
                                  Integer playerOneEnd,
                                  Integer playerTwoStart,
                                  Integer playerTwoEnd){
        List<Song> sublist = SONG_LIST
                .stream().filter(x-> x.getDifficulties().stream()
                        .anyMatch(value-> value >= playerOneStart && value <= playerOneEnd)).collect(Collectors.toList());
       sublist = sublist.stream().filter(x -> x.getDifficulties().stream()
                .anyMatch(value -> value >= playerTwoStart && value <= playerTwoEnd)).collect(Collectors.toList());
       return sublist;
    }


}

