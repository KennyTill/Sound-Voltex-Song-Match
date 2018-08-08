package com.semiceri.sdvx.components;

import com.semiceri.sdvx.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CSVDataLoader implements DataLoader {
    @Override
    public List<Song> LoadData() {
        List<Song> loadedList = new ArrayList<>();


        return loadedList;
    }
}
