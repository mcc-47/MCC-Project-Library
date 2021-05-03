
package co.id.library.project.LibraryClientApp.services;

import co.id.library.project.LibraryClientApp.config.RequestFormat;
import co.id.library.project.LibraryClientApp.models.Trainer;
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
public class TrainerService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.url}/trainer")
    private String url;
    
    //READ
    public List<Trainer> getAll() {
        ResponseEntity<List<Trainer>> response = restTemplate
                .exchange(url + "/get-all", HttpMethod.GET,
                        new HttpEntity(RequestFormat.createHeaders()),
                        new ParameterizedTypeReference<List<Trainer>>() {
                });
        return response.getBody();
    }
    
    //GET BY ID
    public Trainer getById(Integer id) {
        return restTemplate.getForEntity(url + "/" + id, Trainer.class).getBody();
    }

    //UPDATE
    public String update(Integer id, Trainer trainer) {
        HttpEntity entity = new HttpEntity(trainer, RequestFormat.createHeaders());
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
