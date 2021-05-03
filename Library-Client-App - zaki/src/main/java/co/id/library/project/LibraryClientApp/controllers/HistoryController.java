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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/history")
public class HistoryController {
    @Autowired
    HistoryService historyService;

    //=========mapping untuk history trainee==============
    @GetMapping("/status")
    public String getAllStatus(Model model) {
        model.addAttribute("status", historyService.getAllHistory());
        System.out.println();
        return "trainee/history";
    }

    @GetMapping("/trainee")
    public @ResponseBody List<History> getAllStatusProcess() {
        System.out.println("cetak status trainee");
        return historyService.getAllHistory();
    }
}
