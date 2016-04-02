package id.ryandzhunter.tescatur.Model;

import android.graphics.Color;

import id.ryandzhunter.tescatur.R;

/**
 * Created by ryandzhunter on 4/2/16.
 */

public class Chess {
    private int id;
    private String name;
    private int row;
    private String col;

    public Chess(int id) {
        this.id = id;
        name = "";
    }

    public Chess(int id, String n, String r, String c) {
        this.id = id;
        this.name = n;
        this.row = Integer.valueOf(r).intValue();
        this.col = c;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {

        int res = 0;
        switch (this.col) {
            case "a":
                res = 1;
                break;

            case "b":
                res = 2;
                break;

            case "c":
                res = 3;
                break;

            case "d":
                res = 4;
                break;

            case "e":
                res = 5;
                break;

            case "f":
                res = 6;
                break;

            case "g":
                res = 7;
                break;

            case "h":
                res = 8;
                break;
        }

        return res;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public boolean isBlack() {

        if ((this.id / 8) % 2 == 0) {
            if (this.id % 2 == 0) {
                return false;
            } else {
                return true;
            }
        } else {
            if (this.id % 2 == 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public int getImageResouce() {

        int res = 0;

        switch (this.name) {
            case "K":
                res = R.drawable.whiteking;
                break;

            case "Q":
                res = R.drawable.whitequeen;
                break;

            case "N":
                res = R.drawable.whiteknight;
                break;

            case "B":
                res = R.drawable.whitebishop;
                break;

            case "R":
                res = R.drawable.whiterook;
                break;

            case "k":
                res = R.drawable.blackking;
                break;

            case "q":
                res = R.drawable.blackqueen;
                break;

            case "n":
                res = R.drawable.blackknight;
                break;

            case "b":
                res = R.drawable.blackbishop;
                break;

            case "r":
                res = R.drawable.blackrook;
                break;

            default:
                res = android.R.color.transparent;
        }

        return res;
    }



}

