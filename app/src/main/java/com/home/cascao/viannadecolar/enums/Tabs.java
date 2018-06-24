package com.home.cascao.viannadecolar.enums;

public enum Tabs {
    VOOS(0),
    PASSAGENS(1);

    private final int code;

    Tabs(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

}
