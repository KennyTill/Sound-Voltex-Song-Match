package com.semiceri.sdvx.model;

import lombok.Data;

import java.util.List;

@Data
public class Song {
    private String name;
    private List<Integer> difficulties;

    @java.beans.ConstructorProperties({"name", "difficulties"})
    public Song(String name, List<Integer> difficulties) {
        this.name = name;
        this.difficulties = difficulties;
    }
}
