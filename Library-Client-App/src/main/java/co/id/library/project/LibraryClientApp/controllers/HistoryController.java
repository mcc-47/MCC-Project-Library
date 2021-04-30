package co.id.library.project.LibraryClientApp.controllers;

import co.id.library.project.LibraryClientApp.models.History;
import co.id.library.project.LibraryClientApp.models.Project;
import co.id.library.project.LibraryClientApp.services.HistoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/project")
public class HistoryController {

    @Autowired
    HistoryService historyService;

//    //getHistoryByIdProject
//    @GetMapping("/{id}")
//    public @ResponseBody List<History> getHistoryByIdProject(@PathVariable Project id) {
//        System.out.println("ini getHistoryByIdProject");
//        return historyService.getHistoryByIdProject(id);
//    }
//    
//     //getHistoryByIdProject
//    @GetMapping("/employee/{id}")
//    public @ResponseBody List<History> getHistoryByIdMcc(@PathVariable Integer id) {
//        System.out.println("ini getHistoryByIdProject");
//        return historyService.getHistoryByIdMcc(id);
//    }
//
//    //getAllHistory
//    @GetMapping("/get-all")
//    public @ResponseBody List<History> getAllHistory() {
//        System.out.println("ini getAllHistory");
//        return historyService.getAllHistory();
//    }
}
