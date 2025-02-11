/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author thanh
 */
public class CategoryService {
//    [Id] [varchar](10) NOT NULL,
//	[Name] [nvarchar](255) NOT NULL,
//	[Detail] [varchar](4000) NOT NULL,
    private String id,name,detail;

    public CategoryService() {
    }

    public CategoryService(String id, String name, String detail) {
        this.id = id;
        this.name = name;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
    
    
}
