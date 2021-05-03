package co.id.library.project.LibraryClientApp.controllers;

import co.id.library.project.LibraryClientApp.models.JudulTrainee;
import co.id.library.project.LibraryClientApp.models.Project;
import co.id.library.project.LibraryClientApp.models.SearchProject;
import co.id.library.project.LibraryClientApp.models.SubmitProject;
import co.id.library.project.LibraryClientApp.models.TitleTrainer;
import co.id.library.project.LibraryClientApp.models.Validasi;
import co.id.library.project.LibraryClientApp.services.ProjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    //mapping untuk data project
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("project", projectService.getAll());
        return "admin/data-project";
    }

    @GetMapping("/get-all")
    public @ResponseBody
    List<Project> getAllProcess() {
        System.out.println("ini get all");
        return projectService.getAll();
    }

    //=========mapping untuk search trainee==============
    @GetMapping("/search-trainee")
    public String getAllSearch(Model model) {
        model.addAttribute("searchProject", projectService.getAllSearch());
        System.out.println("cetak search project");
        return "trainee/search-project";
    }

    @GetMapping("/cari")
    public @ResponseBody
    List<SearchProject> getAllSearchProcess() {
        System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
        return projectService.getAllSearch();
    }
    //====================================

    //------mapping untuk title submission (trainer) -------------------
    @GetMapping("/title-submission")
    public String getTitleSubmission(Model model) {
        model.addAttribute("titleSubmission", projectService.getTitleTrainer());
        System.out.println("cetak search project");
        return "trainer/title-submission";
    }

    @GetMapping("/title")
    public @ResponseBody
    List<TitleTrainer> getTitle() {
        System.out.println("cetakaja");
        return projectService.getTitleTrainer();
    }
    //-------------------------------------------------------
    
    //===============mapping untuk full project submission (trainer)==============
    @GetMapping("/project-submission")
    public String getProjectSubmission(Model model) {
        model.addAttribute("project", projectService.getAll());
        return "trainer/project-submission";
    }

    @GetMapping("/full-project")
    public @ResponseBody
    List<Project> getFullProject() {
        System.out.println("ini get all");
        return projectService.getAll();
    }
    //===============================================================================
    
    //================= LINK PROJECT ==========================
    //GET BY ID
    @GetMapping("/{id}")
    public @ResponseBody
    Project getById(@PathVariable("id") Integer id) {
        System.out.println(id);
        return projectService.getById(id);
    }
    
    //UPDATE LINK
    @PutMapping("/update-link/{id}")
    public @ResponseBody
    Project updateLink(@PathVariable("id") Integer id, @RequestBody Project project) {
        System.out.println("Update link dungss");
        return projectService.updateLink(id, project);
    }
    //======================================================
    
    
    //============== UPDATE JUDUL PROJECT =============================
    @GetMapping("/judul/{id}")
    public @ResponseBody
    JudulTrainee getJudulById(@PathVariable("id") Integer id) {
        System.out.println(id);
        return projectService.getJudulById(id);
    }
    
    @PutMapping("/update-judul/{id}")
    public @ResponseBody
    JudulTrainee updateJudul(@PathVariable("id") Integer id, @RequestBody JudulTrainee judulTrainee) {
        System.out.println("Update judul dungs");
        return projectService.updateJudul(id, judulTrainee);
    }
    //==================================================================================
    
    
    @PostMapping
    public @ResponseBody
    String create(@RequestBody Project project) {
        System.out.println(project);
        return projectService.create(project);
    }
    
    //############CREATE PROJECT TRAINEE ###############
    @PostMapping("/trainee")
    public @ResponseBody
    String createProjectTrainee(@RequestBody SubmitProject submitProject) {
        System.out.println("telah diproses");
        return projectService.createProjectTrainee(submitProject);
    }
    
    @GetMapping("/coba")
    public String getSubmit() {
        System.out.println("ini mau submit judul");
        return "/trainee/submit-judul";
    }
    //####################################
    
    //===================== get data by traineee ====================
    @GetMapping("/myProject")
    public @ResponseBody List<Project> getmyProject() {
        System.out.println("ini get all");
        return projectService.getProjectTrainee();
    }
    
    @GetMapping("/my-project")
    public String getMyProject(Model model) {
        //model.addAttribute("project", projectService.getProjectTrainee());
        return "trainee/myProject";
    }
    //=====================================
    
    //UPDATE PROJECT
    @PutMapping("/{id}")
    public @ResponseBody
    String update(@PathVariable("id") Integer id, @RequestBody Project project) {
        System.out.println(project);
        return projectService.update(id, project);

    }
    
  

    //VALIDASI JUDUL
    @PutMapping("/validasi-judul/{id}")
    public @ResponseBody
    Validasi validasiJudul(@PathVariable("id") Integer id, @RequestBody Validasi validasi) {
        System.out.println("ini sout validasi" + validasi);
        return projectService.validasiJudul(id, validasi);

    }
//    
    //VALIDASI LINK
    @PutMapping("/validasi-link/{id}")
    public @ResponseBody
    Validasi validasiLink(@PathVariable("id") Integer id, @RequestBody Validasi validasi) {
        System.out.println("stringggggggggg aja");
        return projectService.validasiLink(id, validasi);

    }
}