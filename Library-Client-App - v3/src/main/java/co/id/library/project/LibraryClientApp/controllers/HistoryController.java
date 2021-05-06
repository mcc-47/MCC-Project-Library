package co.id.library.project.LibraryClientApp.controllers;

import co.id.library.project.LibraryClientApp.models.History;
import co.id.library.project.LibraryClientApp.models.SearchProject;
import co.id.library.project.LibraryClientApp.services.HistoryService;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/history")
public class HistoryController {
    @Autowired
    HistoryService historyService;

    //=========mapping untuk history trainer ==============
    @GetMapping("/status")
    public String getAllStatus(Model model) {
        //model.addAttribute("status", historyService.getAllHistory());
        System.out.println(model);
        return "trainee/history";
    }

    @GetMapping("/trainee")
    public @ResponseBody List<History> getAllStatusProcess() {
        System.out.println("cetak trainee");
        return historyService.getAllHistory();
    }
    //========================================
    
    //############## mapping untuk history trainee #################
     @GetMapping("/myHistory")
    public @ResponseBody List<History>  getmyHistory() {
        System.out.println("ini get history trainee");
        return historyService.getHistoryByIdMcc();
    }
    
    @GetMapping("/my-history")
    public String getMyHistory(Model model) {
        model.addAttribute("history", historyService.getHistoryByIdMcc());
        System.out.println("apaan kek");
        return "trainee/myHistory";
    }
    //##################################################################
}
