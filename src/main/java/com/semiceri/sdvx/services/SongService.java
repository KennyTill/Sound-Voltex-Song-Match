package com.semiceri.sdvx.services;

import com.google.common.collect.Lists;
import com.semiceri.sdvx.model.Song;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongService {

    private static List<Song> SONG_LIST = new ArrayList<>();
    
    static {
        SONG_LIST.add(new Song("Boss Rush", Lists.newArrayList(6,12,15,18)));
        SONG_LIST.add(new Song("Royal Judgement", Lists.newArrayList(6,11,14,17)));
        SONG_LIST.add(new Song("I", Lists.newArrayList(8,15,18,20)));
        SONG_LIST.add(new Song("Beast Bass Bomb", Lists.newArrayList(6,10,15,18)));
        SONG_LIST.add(new Song("TWO-TORIAL", Lists.newArrayList(7,14,17,19)));
        SONG_LIST.add(new Song("Chrono Diver -PENDULUMs-", Lists.newArrayList(7,14,17,19)));
    }

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

