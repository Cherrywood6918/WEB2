package beanComponents;

import java.io.Serializable;
import java.util.Date;

public class TableData implements Serializable {
    private double x;
    private double y;
    private double r;
    private String date;
    private float time;
    private String res;

    public TableData(double x, double y, double r, String date, float time, String res) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.date = date;
        this.time = time;
        this.res = res;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }
}
