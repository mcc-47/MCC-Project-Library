/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryServerApp.services;

import co.id.library.project.LibraryServerApp.dto.HistoryDTO;
import co.id.library.project.LibraryServerApp.entities.Employee;
import co.id.library.project.LibraryServerApp.entities.History;
import co.id.library.project.LibraryServerApp.entities.Project;
import co.id.library.project.LibraryServerApp.entities.User;
import co.id.library.project.LibraryServerApp.repositories.EmployeeRepository;
import co.id.library.project.LibraryServerApp.repositories.HistoryRepository;
import co.id.library.project.LibraryServerApp.repositories.ProjectRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class HistoryService {
    
    @Autowired
    HistoryRepository historyRepository;
    
    @Autowired
    EmployeeRepository employeeRepository;
    
    @Autowired
    LoginService loginService;
    
    @Autowired
    ProjectRepository projectRepository;
    
    public List<HistoryDTO> getHistoryByIdProject(Integer idMcc) {
        Project idProject = employeeRepository.findById(idMcc).get().getTrainee().getIdProject();
        List<History> history = historyRepository.findAllByIdProject(idProject);
        List<HistoryDTO> pdds = new ArrayList<>();
        for (History e : history) {
            if (e.getIdProject() != null) {
                HistoryDTO td = new HistoryDTO(
                        e.getIdHistory(),
                        e.getIdProject().getIdProject(),
                        e.getInfo(),
                        e.getWaktu(),
                        e.getPesan(),
                        e.getIdStatus().getStatus()
                );
                pdds.add(td);
            }
        }
        return pdds;
    }
    
//    public List<HistoryDTO> getHistoryByIdMcc(Integer idMcc) {
//        Project idProject = employeeRepository.findById(idMcc).get().getTrainee().getIdProject();
//        List<History> history = historyRepository.findAllByIdProject(idProject);
//        List<HistoryDTO> pdds = new ArrayList<>();
//        for (History e : history) {
//            if (e.getIdProject() != null) {
//                HistoryDTO td = new HistoryDTO(
//                        e.getIdHistory(),
//                        e.getIdProject().getIdProject(),
//                        e.getInfo(),
//                        e.getWaktu(),
//                        e.getPesan(),
//                        e.getIdStatus().getStatus()
//                );
//                pdds.add(td);
//            }
//        }
//        return pdds;
//    }
//    
    public List<HistoryDTO> getHistoryByIdMcc(String userName) {
        User user = loginService.loadUserByUsername(userName);
        Project idProject = employeeRepository.findById(user.getIdUser()).get().getTrainee().getIdProject();
        List<History> history = historyRepository.findAllByIdProject(idProject);
        List<HistoryDTO> pdds = new ArrayList<>();
        for (History e : history) {
            if (e.getIdProject() != null) {
                HistoryDTO td = new HistoryDTO(
                        e.getIdHistory(),
                        e.getIdProject().getIdProject(),
                        e.getInfo(),
                        e.getWaktu(),
                        e.getPesan(),
                        e.getIdStatus().getStatus()
                );
                pdds.add(td);
            }
        }
        System.out.println("bebas apaan aja");
        return pdds;
    }
    
    public List<HistoryDTO> getAllHistory() {
        List<History> history = historyRepository.findAll();
        List<HistoryDTO> pdds = new ArrayList<>();
        for (History e : history) {
            if (e.getIdProject() != null) {
                HistoryDTO td = new HistoryDTO(
                        e.getIdHistory(),
                        e.getIdProject().getIdProject(),
                        e.getInfo(),
                        e.getWaktu(),
                        e.getPesan(),
                        e.getIdStatus().getStatus()
                );
                pdds.add(td);
            }
        }
        return pdds;
    }
    
}
