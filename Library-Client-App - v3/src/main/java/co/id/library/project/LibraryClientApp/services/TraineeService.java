
package co.id.library.project.LibraryClientApp.services;

import co.id.library.project.LibraryClientApp.config.RequestFormat;
import co.id.library.project.LibraryClientApp.models.Trainee;
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
public class TraineeService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.url}/trainee")
    private String url;
    
    //GET ALL TRAINEE
    public List<Trainee> getAll() {
        ResponseEntity<List<Trainee>> response = restTemplate
                .exchange(url + "/get-all", HttpMethod.GET,
                        new HttpEntity(RequestFormat.createHeaders()),
                        new ParameterizedTypeReference<List<Trainee>>() {
                });
        return response.getBody();
    }
    
    //GET ALL ALUMNI
    public List<Trainee> getAlumni() {
        ResponseEntity<List<Trainee>> response = restTemplate
                .exchange(url + "/get-alumni", HttpMethod.GET,
                        new HttpEntity(RequestFormat.createHeaders()),
                        new ParameterizedTypeReference<List<Trainee>>() {
                });
        return response.getBody();
    }
    
    //GET BY ID
    public Trainee getById(Integer id) {
        return restTemplate.getForEntity(url + "/" + id, Trainee.class).getBody();
    }

    //UPDATE
    public String update(Integer id, Trainee trainee) {
        HttpEntity entity = new HttpEntity(trainee, RequestFormat.createHeaders());
        ResponseEntity<String> res = restTemplate.exchange(url + "/" + id, HttpMethod.PUT, entity,
                new ParameterizedTypeReference<String>() {
        });
        return res.getBody();
    }
    
    //DELETE
    public String delete(Integer id) {
        HttpEntity entity = new HttpEntity(id, RequestFormat.createHeaders());
        ResponseEntity<String> res = restTemplate.exchange(url + "/" + id, HttpMethod.DELETE, entity,
                new ParameterizedTypeReference<String>() {
        });
        return res.getBody();
    }
}



    

    

    

  

