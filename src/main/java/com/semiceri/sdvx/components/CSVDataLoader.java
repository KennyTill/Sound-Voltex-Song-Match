package com.semiceri.sdvx.components;

import com.semiceri.sdvx.model.Song;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Primary
@Component
public class CSVDataLoader implements DataLoader {

    private static final String DELIMITER = ",";
    private static final String CSV= "static/csv/songs.csv";


    @Override
    public List<Song> loadData() {

        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(CSV);
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

            List<Song> loadedList = br.lines().map(x -> x.split(DELIMITER))
                    .map(songstr -> {
                        List<Integer> difficulties = Arrays.stream(songstr)
                                .skip(1)
                                .map(Integer::parseInt)
                                .collect(Collectors.toList());
                        Song song = new Song(songstr[0], difficulties);
                        return song;
                    }).collect(Collectors.toList());

            return loadedList;

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return Collections.emptyList();
    }
}
