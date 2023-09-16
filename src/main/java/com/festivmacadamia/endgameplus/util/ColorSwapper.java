package com.festivmacadamia.endgameplus.util;

public class ColorSwapper {

    private int mcColor;

    public ColorSwapper(int r, int g, int b){
        mcColor=(b)+(g*256)+(r*65536);
    }
    public ColorSwapper(String hex){
        mcColor = 65536*Integer.parseInt(hex.substring(1,3),16)+
                256*Integer.parseInt(hex.substring(3,5),16)+
                Integer.parseInt(hex.substring(5,7),16);
    }
    public int getMcColor() {
        return mcColor;
    }
}
