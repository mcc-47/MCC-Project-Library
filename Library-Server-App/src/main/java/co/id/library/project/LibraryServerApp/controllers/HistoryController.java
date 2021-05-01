/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryServerApp.controllers;

import co.id.library.project.LibraryServerApp.dto.HistoryDTO;
import co.id.library.project.LibraryServerApp.entities.History;
import co.id.library.project.LibraryServerApp.entities.Project;
import co.id.library.project.LibraryServerApp.services.HistoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/history")
public class HistoryController {
    
    @Autowired
    HistoryService historyService;
    
    @GetMapping("/project")
    public List<HistoryDTO> getHistoryByIdProject(Authentication auth){
        return historyService.getHistoryByIdProject(Integer.parseInt(auth.getName()));
    }
    
    @GetMapping("employee")
    public List<HistoryDTO> getHistoryByIdMcc(Authentication auth){
        return historyService.getHistoryByIdMcc(Integer.parseInt(auth.getName()));
    }
    
    @GetMapping("/get-all")
    public List<HistoryDTO> getAllHistory(Authentication auth){
        return historyService.getAllHistory();
    }
}
