package com.semiceri.sdvx.model;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.List;

@Data
@AllArgsConstructor
public class Song {
    private String name;
    private List<Integer> difficulties;
}
