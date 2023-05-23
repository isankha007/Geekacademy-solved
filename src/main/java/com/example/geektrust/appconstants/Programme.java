package com.example.geektrust.appconstants;

public enum Programme {
    CERTIFICATION("CERTIFICATION"),
    DEGREE("DEGREE"),
    DIPLOMA("DIPLOMA");

    private final String type;

    Programme(String type) {
        this.type=type;
    }
}
