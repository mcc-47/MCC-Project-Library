/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryServerApp.dto;

import java.util.List;

/**
 *
 * @author ASUS
 */
public class AuthDTO {
    
    private String userName;
    private Integer userId;
    private List<String> authorities;

    public AuthDTO(String userName, Integer userId, List<String> authorities) {
        this.userName = userName;
        this.userId = userId;
        this.authorities = authorities;
    }

    public AuthDTO() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }
    
    
    
}
