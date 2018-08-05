package com.semiceri.sdvx.components;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.semiceri.sdvx.model.Song;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileDataLoader implements DataLoader {
    @Override
    public List<Song> LoadData() {
        List<Song> loadedList = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();

        try {
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("songs.json");
            loadedList = mapper.readValue(in, new TypeReference<List<Song>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }


        return loadedList;
    }
}
