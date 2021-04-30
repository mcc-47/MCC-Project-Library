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
    
    @GetMapping("{id}")
    public List<HistoryDTO> getHistoryByIdProject(@PathVariable Project id){
        return historyService.getHistoryByIdProject(id);
    }
    
    @GetMapping("employee/{id}")
    public List<HistoryDTO> getHistoryByIdProject(@PathVariable Integer id){
        return historyService.getHistoryByIdMcc(id);
    }
    
    @GetMapping("/get-all")
    public List<HistoryDTO> getHistoryByIdProject(){
        return historyService.getAllHistory();
    }
}
