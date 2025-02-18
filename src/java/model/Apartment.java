/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lenovo
 */
public class Apartment {
    private String id;
    private int numberOfPerson;
    private Floor floor;
    private String infor;
    private RoomType roomtype;
    private int status;

    public Apartment(String id, int numberOfPerson, Floor floor, String infor, RoomType roomtype) {
        this.id = id;
        this.numberOfPerson = numberOfPerson;
        this.floor = floor;
        this.infor = infor;
        this.roomtype = roomtype;

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public void setNumberOfPerson(int numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public String getInfor() {
        return infor;
    }

    public void setInfor(String infor) {
        this.infor = infor;
    }

    public RoomType getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(RoomType roomtype) {
        this.roomtype = roomtype;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Apartment() {
    }

    public Apartment(String id, int numberOfPerson, Floor floor, String infor, RoomType roomtype, int status) {
        this.id = id;
        this.numberOfPerson = numberOfPerson;
        this.floor = floor;
        this.infor = infor;
        this.roomtype = roomtype;
        this.status = status;
    }
    
    
    
}
