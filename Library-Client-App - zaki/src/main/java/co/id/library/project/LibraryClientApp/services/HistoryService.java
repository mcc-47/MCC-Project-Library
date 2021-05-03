
package co.id.library.project.LibraryClientApp.services;

import co.id.library.project.LibraryClientApp.config.RequestFormat;
import co.id.library.project.LibraryClientApp.models.AuthResponse;
import co.id.library.project.LibraryClientApp.models.History;
import co.id.library.project.LibraryClientApp.models.Project;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HistoryService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.url}/history")
    private String url;
    
    
    public List<History> getHistoryByIdMcc() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AuthResponse a = new AuthResponse(auth.getName());
        HttpEntity entity = new HttpEntity(a, RequestFormat.createHeaders());
        ResponseEntity<History> response = restTemplate
                .exchange(url + "/employee", HttpMethod.POST,
                        entity,
                        new ParameterizedTypeReference<History>() {
                });
        List<History> lala = new ArrayList<>();
        lala.add(response.getBody());
        System.out.println(a);
        //System.out.println(response.getBody());
        return lala;
    }
    
    
    public List<History> getAllHistory() {
        ResponseEntity<List<History>> response = restTemplate
                .exchange(url + "/get-all", HttpMethod.GET,
                        new HttpEntity(RequestFormat.createHeaders()),
                        new ParameterizedTypeReference<List<History>>() {
                });
        System.out.println(response.getBody());
        return response.getBody();
    }
}

 