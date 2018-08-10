package com.semiceri.sdvx.components;

import com.semiceri.sdvx.model.Song;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


@Primary
@Component
public class CSVDataLoader implements DataLoader {

    private static final String DELIMITER = ",";
    private static final String CSV= "static/csv/songs.csv";


    @Override
    public List<Song> loadData() {

        List<Song> loadedList = new ArrayList<>();
        
        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(CSV);
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

            String line = "";

            while ((line = br.readLine()) != null) {
                String[] songString = line.split(DELIMITER);
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
        }

        return loadedList;
    }

}
