/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author thanh
 */
public class Floor {
//    [floor] [int] NOT NULL,
//	[Square] [int] NOT NULL,
//	[usagetype] [varchar](255) NULL,
//	[note] [varchar](4000) NULL,
    private int number;
    private float square;
    private String usageType;
    private String not;

    public Floor() {
    }

    public Floor(int number, float square, String usageType, String not) {
        this.number = number;
        this.square = square;
        this.usageType = usageType;
        this.not = not;
    }

    
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getSquare() {
        return square;
    }

    public void setSquare(float square) {
        this.square = square;
    }

    public String getUsageType() {
        return usageType;
    }

    public void setUsageType(String usageType) {
        this.usageType = usageType;
    }

    public String getNot() {
        return not;
    }

    public void setNot(String not) {
        this.not = not;
    }
    
}
