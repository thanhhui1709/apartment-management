/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author thanh
 */
public class RequestType {
    private String id;
    private String name;
    private Role destination;
    private String detail;

    public RequestType() {
    }

    public RequestType(String id, String name, Role destination, String detail) {
        this.id = id;
        this.name = name;
        this.destination = destination;
        this.detail = detail;
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

    public Role getDestination() {
        return destination;
    }

    public void setDestination(Role destination) {
        this.destination = destination;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
    
}
