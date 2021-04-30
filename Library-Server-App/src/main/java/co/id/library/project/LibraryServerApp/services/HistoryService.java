/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryServerApp.services;

import co.id.library.project.LibraryServerApp.dto.HistoryDTO;
import co.id.library.project.LibraryServerApp.dto.TraineeDTO;
import co.id.library.project.LibraryServerApp.entities.Employee;
import co.id.library.project.LibraryServerApp.entities.History;
import co.id.library.project.LibraryServerApp.entities.Project;
import co.id.library.project.LibraryServerApp.repositories.HistoryRepository;
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
    
//    public List<History> getHistoryByIdProject(Project idProject){
//        return historyRepository.findAllByIdProject(idProject);
//    }
    
    public List<HistoryDTO> getHistoryByIdProject(Project idProject) {
        List<History> history = historyRepository.findAllByIdProject(idProject);
        List<HistoryDTO> pdds = new ArrayList<>();
        for (History e : history) {
            if (e.getIdProject() != null) {
                HistoryDTO td = new HistoryDTO(
                        e.getIdHistory(),
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
    
    public List<HistoryDTO> getAllHistory() {
        List<History> history = historyRepository.findAll();
        List<HistoryDTO> pdds = new ArrayList<>();
        for (History e : history) {
            if (e.getIdProject() != null) {
                HistoryDTO td = new HistoryDTO(
                        e.getIdHistory(),
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
