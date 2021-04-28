package co.id.library.project.LibraryClientApp.services;

import co.id.library.project.LibraryClientApp.config.RequestFormat;
import co.id.library.project.LibraryClientApp.models.Project;
import co.id.library.project.LibraryClientApp.models.ProjectTrainee;
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
public class ProjectService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.url}/project")
    private String url;

    //READ
    public List<Project> getAll() {
        ResponseEntity<List<Project>> response = restTemplate
                .exchange(url + "/get-all", HttpMethod.GET,
                        new HttpEntity(RequestFormat.createHeaders()),
                        new ParameterizedTypeReference<List<Project>>() {
                });
        return response.getBody();
    }

    //GET BY ID
    public Project getById(Integer id) {
        return restTemplate.getForEntity(url + id, Project.class).getBody();
    }
    
    //CREATE project 
    public String create(Project project) {
        HttpEntity entity = new HttpEntity(project, RequestFormat.createHeaders());
        ResponseEntity<String> res = restTemplate.exchange(url, HttpMethod.POST, entity,
                new ParameterizedTypeReference<String>() {
        });
        return res.getBody();
    }
    
    //CREATE project trainee
    public String createProjectTrainee(ProjectTrainee projectTrainee) {
        HttpEntity entity = new HttpEntity(projectTrainee, RequestFormat.createHeaders());
        ResponseEntity<String> res = restTemplate.exchange(url + "/trainee", HttpMethod.POST, entity,
                new ParameterizedTypeReference<String>() {
        });
        return res.getBody();
    }

    //UPDATE
    public String update(Integer id, Project project) {
        HttpEntity entity = new HttpEntity(project, RequestFormat.createHeaders());
        ResponseEntity<String> res = restTemplate.exchange(url + id, HttpMethod.PUT, entity,
                new ParameterizedTypeReference<String>() {
        });
        return res.getBody();
    }

   
}
