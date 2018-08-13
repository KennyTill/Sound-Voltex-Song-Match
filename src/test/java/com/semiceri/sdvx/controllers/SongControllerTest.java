package com.semiceri.sdvx.controllers;

import com.semiceri.sdvx.model.Song;
import com.semiceri.sdvx.services.SongService;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(SongController.class)
public class SongControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SongService songService;


    @Test
    public void findMatches() throws Exception {
        List<Song> songs = Lists.newArrayList(new Song("test song 1",
                Lists.newArrayList(1, 5, 8, 15)));

        Mockito.when(this.songService.findMatches(1, 1, 1, 1))
                .thenReturn(songs);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/findMatches")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .param("playerOneStart", "1")
                .param("playerOneEnd", "1")
                .param("playerTwoStart", "1")
                .param("playerTwoEnd", "1");
        this.mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("test song 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].difficulties").value(Lists.newArrayList(1, 5, 8, 15)));
    }


    @Test
    public void findAllSongs_notSupported() throws Exception {
        List<Song> songs = Lists.newArrayList(new Song("test song 1",
                Lists.newArrayList(1, 5, 8, 15)));
        Mockito.when(this.songService.findAllSongs()).thenReturn(songs);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/findAll");
        this.mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status()
                        .isMethodNotAllowed());
    }

    @Test
    public void findAllSongs() throws Exception {
        List<Song> songs = Lists.newArrayList(new Song("test song 1",
                Lists.newArrayList(1, 5, 8, 15)));
        Mockito.when(this.songService.findAllSongs()).thenReturn(songs);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/findAll");
        this.mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.handler().methodName("findAllSongs"))
                .andExpect(MockMvcResultMatchers.status()
                        .isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name")
                        .value("test song 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].difficulties")
                        .value(Lists.newArrayList(1, 5, 8, 15)));
    }

}