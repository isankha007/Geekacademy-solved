package com.example.geektrust.appconstants;

public enum CommandTypes {
    ADD_PROGRAMME("ADD_PROGRAMME"),
    APPLY_COUPON("APPLY_COUPON"),
    ADD_PRO_MEMBERSHIP("ADD_PRO_MEMBERSHIP"),
    PRINT_BILL("PRINT_BILL");

    private final String type;

    CommandTypes(String typeStr) {
        this.type=typeStr;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
