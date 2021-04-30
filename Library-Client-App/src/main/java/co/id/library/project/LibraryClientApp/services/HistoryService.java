/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryClientApp.services;

import co.id.library.project.LibraryClientApp.config.RequestFormat;
import co.id.library.project.LibraryClientApp.models.History;
import co.id.library.project.LibraryClientApp.models.Project;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HistoryService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.url}/history")
    private String url;

    //READ HistoryByIdProject
    public List<History> getHistoryByIdProject(Project id) {
        ResponseEntity<List<History>> response = restTemplate
                .exchange(url + id, HttpMethod.GET,
                        new HttpEntity(RequestFormat.createHeaders()),
                        new ParameterizedTypeReference<List<History>>() {
                });
        return response.getBody();
    }

    //READ HistoryByIdMcc
    public List<History> getHistoryByIdMcc(Integer id) {
        ResponseEntity<List<History>> response = restTemplate
                .exchange(url + "/employee" + id, HttpMethod.GET,
                        new HttpEntity(RequestFormat.createHeaders()),
                        new ParameterizedTypeReference<List<History>>() {
                });
        return response.getBody();
    }

    //READ AllHistory
    public List<History> getAllHistory() {
        ResponseEntity<List<History>> response = restTemplate
                .exchange(url + "/get-all", HttpMethod.GET,
                        new HttpEntity(RequestFormat.createHeaders()),
                        new ParameterizedTypeReference<List<History>>() {
                });
        return response.getBody();
    }
}
