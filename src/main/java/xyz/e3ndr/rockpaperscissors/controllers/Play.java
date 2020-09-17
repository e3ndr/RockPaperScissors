package xyz.e3ndr.rockpaperscissors.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import xyz.e3ndr.rockpaperscissors.ThrowType;

@Getter
@AllArgsConstructor
public class Play {
    private String name;
    private ThrowType played;

}
