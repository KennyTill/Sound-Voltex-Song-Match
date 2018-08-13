package com.semiceri.sdvx.services;

import com.semiceri.sdvx.components.DataLoader;
import com.semiceri.sdvx.model.Song;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SongServiceTest {

    @Mock
    private DataLoader loader;
    @InjectMocks
    private SongService songService;

    private static final Song TEST_SONG_ONE = new Song("Test Song 1", Lists.newArrayList(1,5,12,15));
    private static final Song TEST_SONG_TWO = new Song("Test Song 2", Lists.newArrayList(6,9,15,20));
    private static final Song TEST_SONG_THREE = new Song("試聴3曲", Lists.newArrayList(1,5,12,15));

    private static final List<Song> SONGS = Lists.newArrayList(TEST_SONG_ONE, TEST_SONG_TWO, TEST_SONG_THREE);


    @Before
    public void setUp() throws Exception {
        Mockito.when(this.loader.loadData()).thenReturn(SONGS);
        songService.init();
    }


    @Test
    public void findAllSongs() {
        List<Song> actual = songService.findAllSongs();
        Assertions.assertThat(actual).isSameAs(SONGS);
    }

    @Test
    public void findMatches_emptyList() {
        List<Song> actual = songService.findMatches(7,7,1,1);
        Assertions.assertThat(actual).isEmpty();
    }


    @Test
    public void findMatches_allList() {
        List<Song> actual = songService.findMatches(1,20,1,20);
        Assertions.assertThat(actual).isEqualTo(SONGS);
    }


    @Test
    public void findMatches_oneSong() {
        List<Song> actual = songService.findMatches(6,9,15,20);
        Assertions.assertThat(actual).containsExactly(TEST_SONG_TWO);
    }

    @Test
    public void findMatches_twoSongs() {
        List<Song> actual = songService.findMatches(1,5,15,20);
        Assertions.assertThat(actual).hasSize(2).containsOnlyOnce(TEST_SONG_ONE, TEST_SONG_THREE);
    }

    @Test
    public void findMatches_badData() {
        List<Song> actual = songService.findMatches(10,1,15,20);
        Assertions.assertThat(actual).isEmpty();
    }
}