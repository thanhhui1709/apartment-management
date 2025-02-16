/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto.response;

/**
 *
 * @author thanh
 */
public class FloorResponseDTO {

    private int number;
    private float square;
    private String usageType;
    private String note;
    private int noPerson;
    private int noUsingRoom;
    private int noNotUsingRoom;

    public FloorResponseDTO() {
    }

    public FloorResponseDTO(int number, float square, String usageType, String note, int noPerson, int NoUsingRoom, int NoNotUsingRoom) {
        this.number = number;
        this.square = square;
        this.usageType = usageType;
        this.note = note;
        this.noPerson = noPerson;
        this.noUsingRoom = NoUsingRoom;
        this.noNotUsingRoom = NoNotUsingRoom;
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

    public String getNote() {
        return note;
    }

    public void setNote(String not) {
        this.note = not;
    }

    public int getNoPerson() {
        return noPerson;
    }

    public void setNoPerson(int noPerson) {
        this.noPerson = noPerson;
    }

    public int getNoUsingRoom() {
        return noUsingRoom;
    }

    public void setNoUsingRoom(int NoUsingRoom) {
        this.noUsingRoom = NoUsingRoom;
    }

    public int getNoNotUsingRoom() {
        return noNotUsingRoom;
    }

    public void setNoNotUsingRoom(int NoNotUsingRoom) {
        this.noNotUsingRoom = NoNotUsingRoom;
    }
    
}
