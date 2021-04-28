/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryClientApp.models;

import lombok.Data;


@Data
public class AuthRequest {
    private String userName;
    private String userPassword;

    public AuthRequest(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public AuthRequest() {
    }
}
