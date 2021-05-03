/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryServerApp.controllers;

import co.id.library.project.LibraryServerApp.dto.AuthDTO;
import co.id.library.project.LibraryServerApp.dto.GetJudulDTO;
import co.id.library.project.LibraryServerApp.dto.ProjectDTO;
import co.id.library.project.LibraryServerApp.dto.ProjectTrainee;
import co.id.library.project.LibraryServerApp.dto.SearchTraineeDTO;
import co.id.library.project.LibraryServerApp.dto.ValidasiDTO;
import co.id.library.project.LibraryServerApp.entities.Project;
import co.id.library.project.LibraryServerApp.services.NotificationService;
import co.id.library.project.LibraryServerApp.services.ProjectService;
import co.id.library.project.LibraryServerApp.services.ProjectTraineeService;
import java.util.List;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectTraineeService projectTraineeService;

    @Autowired
    NotificationService notificationService;

    @GetMapping("/get-all")
    public List<ProjectDTO> getProjectDTO(Authentication auth) {
        return projectService.getProject();
    }

    @GetMapping("/search")
    public List<SearchTraineeDTO> getSearchProjectDTO(Authentication auth) {
        System.out.println(auth.getName());
        return projectService.getSearchProject();
    }

    @GetMapping("/get-all-judul")
    public List<GetJudulDTO> getJudulDTO(Authentication auth) {
        return projectService.getAllJudul();
    }

//    @GetMapping("{id}")
//    public Project getOneProject(@PathVariable Integer id){
//        return projectService.getById(id);
//    }
//    @GetMapping("/get-one")
//    public Project getOneProject(Authentication auth){
//        return projectService.getById(Integer.parseInt(auth.getName()));
//    }
    @GetMapping("{id}")
    public GetJudulDTO getOneProject(Authentication auth, @PathVariable("id") Integer id) {
        return projectService.getByIdProject(id);
    }

    @GetMapping("/judul/{id}")
    public GetJudulDTO getJudulByIdMcc(@PathVariable Integer id){
        System.out.println(id);
        return projectService.getByIdMcc(id);
    }
    
//    @GetMapping("/judul")
//    public GetJudulDTO getJudulByIdMcc(Authentication auth) {
//        return projectService.getByIdMcc(Integer.parseInt(auth.getName()));
//    }

//    @GetMapping("/project/{id}")
//    public ProjectDTO getProjectByIdMcc(@PathVariable Integer id){
//        return projectService.getProjectByIdMcc(id);
//    }
    @PostMapping("/project")
    public ProjectDTO getProjectByIdMcc(@RequestBody AuthDTO auth) {
        //Integer id = Integer.parseInt(auth.getUserName());
        ProjectDTO projectDTO = projectService.getProjectByIdMcc(auth.getUserName());
        return projectDTO;
    }

//    @PutMapping("{id}") 
//    public Project updateProject(@PathVariable Integer id, @RequestBody Project project)throws MessagingException{
//        return projectService.update(id, project);
//    }
//    @PutMapping("/update-judul/{id}")
//    public Project updateJudul(@PathVariable Integer id, String judul, String deskripsi)throws MessagingException{
//        return projectService.updateJudul(id, judul, deskripsi);
//    }
    @PutMapping("/update-judul")
    public Project updateJudul(Authentication auth, @RequestBody Project project) throws MessagingException {
        System.out.println(auth.getName());
        System.out.println(project.getJudul());
        System.out.println(project.getDeskripsi());
        return projectService.updateJudul(Integer.parseInt(auth.getName()), project);
    }
    
    
    @PutMapping("/update-link")
    public Project updateLink(Authentication auth, @RequestBody Project project) throws MessagingException {
        return projectService.updateLink(Integer.parseInt(auth.getName()), project);
    }
    
//    @PutMapping("/update-link/{id}")
//    public Project updateLink(@PathVariable Integer id, String erd, String uml, String skema, String link)throws MessagingException{
//        return projectService.updateLink(id, erd, uml, skema, link);
//    }

//    @PutMapping("/update-link")
//    public Project updateLink(Authentication auth, String erd, String uml, String skema, String link) throws MessagingException {
//        return projectService.updateLink(Integer.parseInt(auth.getName()), erd, uml, skema, link);
//    }

    @PutMapping("/validasi-judul/{id}")
    public Project validasiJudul(@PathVariable Integer id, ValidasiDTO validasiDTO)throws MessagingException{
        return projectService.updateStatusJudul(id, validasiDTO);
    }
//    @PutMapping("/validasi-judul")
//    public Project validasiJudul(Authentication auth, boolean status, String pesan) throws MessagingException {
//        return projectService.updateStatusJudul(Integer.parseInt(auth.getName()), status, pesan);
//    }
    
    @PutMapping("/validasi-link/{id}")
    public Project validasiLink (@PathVariable Integer id, ValidasiDTO validasiDTO)throws MessagingException{
        return projectService.updateStatusLink(id, validasiDTO);
    }

   
//    @PutMapping("/validasi-link")
//    public Project validasiLink(Authentication auth, boolean status, String pesan) throws MessagingException {
//        return projectService.updateStatusLink(Integer.parseInt(auth.getName()), status, pesan);
//    }

//    @PostMapping
//    public Project createProject(@RequestBody Project project){
//        return projectService.create(project);
//    }
    @PostMapping("/trainee")
    public String createProjectTrainee(Authentication auth, @RequestBody ProjectTrainee projectTrainee) throws MessagingException {
        return projectTraineeService.registerJudul(projectTrainee);
    }
}
