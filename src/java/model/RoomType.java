/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author quang
 */
public class RoomType {

    private String id, name;
    private int limitPerson, bedroom, livingRoom, bathRoom, balcony;
    private float square;

    public RoomType(String id, String name, int limitPerson, int bedroom, int livingRoom, int bathRoom, int balcony, float square) {
        this.id = id;
        this.name = name;
        this.limitPerson = limitPerson;
        this.bedroom = bedroom;
        this.livingRoom = livingRoom;
        this.bathRoom = bathRoom;
        this.balcony = balcony;
        this.square = square;
    }

    public RoomType(String name, int limitPerson, int bedroom, int livingRoom, int bathRoom, int balcony, float square) {
        this.name = name;
        this.limitPerson = limitPerson;
        this.bedroom = bedroom;
        this.livingRoom = livingRoom;
        this.bathRoom = bathRoom;
        this.balcony = balcony;
        this.square = square;
    }

   

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLimitPerson() {
        return limitPerson;
    }

    public void setLimitPerson(int limitPerson) {
        this.limitPerson = limitPerson;
    }

    public int getBedroom() {
        return bedroom;
    }

    public void setBedroom(int bedroom) {
        this.bedroom = bedroom;
    }

    public int getLivingRoom() {
        return livingRoom;
    }

    public void setLivingRoom(int livingRoom) {
        this.livingRoom = livingRoom;
    }
   
    public int getBathRoom() {
        return bathRoom;
    }

    public void setBathRoom(int bathRoom) {
        this.bathRoom = bathRoom;
    }

    public int getBalcony() {
        return balcony;
    }

    public void setBalcony(int balcony) {
        this.balcony = balcony;
    }

    public float getSquare() {
        return square;
    }

    public void setSquare(float square) {
        this.square = square;
    }
}
