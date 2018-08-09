package com.semiceri.sdvx.components;

import com.semiceri.sdvx.model.Song;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@Component
@Primary
public class CSVDataLoader implements DataLoader {
    @Override
    public List<Song> LoadData() {
        List<Song> loadedList = new ArrayList<>();
        String csv = "static/csv/songs.csv";

        BufferedReader br = null;
        String line = "";
        String CSVSplitBy = ",";
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(csv);

        try {
            br = new BufferedReader(new InputStreamReader(inputStream));

            while ((line = br.readLine()) != null) {
                String[] songString = line.split(CSVSplitBy);
                List<Integer> difficulties = new ArrayList<>();
                difficulties.add(Integer.parseInt(songString[1]));
                difficulties.add(Integer.parseInt(songString[2]));
                difficulties.add(Integer.parseInt(songString[3]));
                difficulties.add(Integer.parseInt(songString[4]));
                Song song = new Song(songString[0], difficulties);
                loadedList.add(song);
            }


        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    //it's already closed prolly.
                }
            }
        }

        return loadedList;
    }
}
