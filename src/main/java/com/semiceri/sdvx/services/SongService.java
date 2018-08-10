package com.semiceri.sdvx.services;

import com.semiceri.sdvx.components.DataLoader;
import com.semiceri.sdvx.model.Song;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SongService {

    private final DataLoader loader;
    private List<Song> songList = new ArrayList<>();


    @PostConstruct
    private void init() {
        this.songList = loader.LoadData();
    }


    public List<Song> findAllSongs() {
        return this.songList;
    }


    public List<Song> findMatches(Integer playerOneStart,
                                  Integer playerOneEnd,
                                  Integer playerTwoStart,
                                  Integer playerTwoEnd) {
        List<Song> sublist = this.songList
                .stream().filter(x -> x.getDifficulties().stream()
                        .anyMatch(value -> value >= playerOneStart && value <= playerOneEnd)).collect(Collectors.toList());
        sublist = sublist.stream().filter(x -> x.getDifficulties().stream()
                .anyMatch(value -> value >= playerTwoStart && value <= playerTwoEnd)).collect(Collectors.toList());
        return sublist;
    }


}

