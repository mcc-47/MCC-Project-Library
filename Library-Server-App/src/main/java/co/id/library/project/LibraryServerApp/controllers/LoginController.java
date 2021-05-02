/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryServerApp.controllers;

import co.id.library.project.LibraryServerApp.dto.AuthDTO;
import co.id.library.project.LibraryServerApp.dto.LoginDTO;
import co.id.library.project.LibraryServerApp.services.LoginService;
import co.id.library.project.LibraryServerApp.services.NotificationService;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
public class LoginController {
    
    @Autowired
    LoginService loginService;
    
    @PostMapping("/login")
    public AuthDTO login(@RequestBody LoginDTO loginDTO)throws Exception{
        return loginService.loginUserByUserPassword(loginDTO);
    }
    
}
