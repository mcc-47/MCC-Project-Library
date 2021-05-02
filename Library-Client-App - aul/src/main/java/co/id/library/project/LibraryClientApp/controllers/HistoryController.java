package co.id.library.project.LibraryClientApp.controllers;

import co.id.library.project.LibraryClientApp.models.History;
import co.id.library.project.LibraryClientApp.models.Project;
import co.id.library.project.LibraryClientApp.services.HistoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    HistoryService historyService;

//    //============mapping untuk history by id project =============
//    @GetMapping("/byIdProject")
//    public String getHistoryByIdMcc(Model model, Project id) {
//        model.addAttribute("history", historyService.getHistoryByIdProject(id));
//        System.out.println("cetak history by project");
//        return "trainer/title-submission";
//    }
//
//    @GetMapping("/history")
//    public @ResponseBody
//    List<History> getHistoryMcc(Project id) {
//        return historyService.getHistoryByIdProject(id);
//    }
//    //=================================================

    //------mapping untuk history by id mcc -------------------
    @GetMapping("/byIdMcc")
    public String getHistoryByIdMcc(Model model, Integer id) {
        model.addAttribute("history", historyService.getHistoryByIdMcc(id));
        System.out.println("cetak history by id");
        return "trainee/history-project";
    }

    @GetMapping("/mcc")
    public @ResponseBody
    List<History> getHistoryMcc(Integer id) {
        System.out.println("cetakaja");
        return historyService.getHistoryByIdMcc(id);
    }
    //-------------------------------------------------------

//    //getAllHistory
//    @GetMapping("/get-history")
//    public @ResponseBody
//    List<History> getAllHistory() {
//        System.out.println("ini getAllHistory");
//        return historyService.getAllHistory();
//    }
}
