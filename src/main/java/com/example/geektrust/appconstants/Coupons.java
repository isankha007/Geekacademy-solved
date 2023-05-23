package com.example.geektrust.appconstants;

public enum Coupons {
    B4G1("B4G1"),
    DEAL_G20("DEAL_G20"),
    DEAL_G5("DEAL_G5"),

    NONE("NONE");

    private final String type;

    Coupons(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Coupons{" +
                "type='" + type + '\'' +
                '}';
    }
}
