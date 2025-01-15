/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author admin1711
 */
public class TokenForgetPassword {

    private int id;
    private String token;
    private boolean isUsed;
    private Account acc;
    private LocalDateTime expireTime;

    public TokenForgetPassword() {
    }

    public int getId() {
        return id;
    }

    public TokenForgetPassword(String token, boolean isUsed, Account a, LocalDateTime expireTime) {
        this.token = token;
        this.isUsed = isUsed;
        this.acc = a;
        this.expireTime = expireTime;
    }

    public TokenForgetPassword(int id, String token, boolean isUsed, Account acc, LocalDateTime expireTime) {
        this.id = id;
        this.token = token;
        this.isUsed = isUsed;
        this.acc = acc;
        this.expireTime = expireTime;
    }

    @Override
    public String toString() {
        return "TokenForgetPassword{" + "id=" + id + ", token=" + token + ", isUsed=" + isUsed + ", acc=" + acc + ", expireTime=" + expireTime + '}';
    }
    
    

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account a) {
        this.acc = a;
    }
  
    public boolean isIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }

}
