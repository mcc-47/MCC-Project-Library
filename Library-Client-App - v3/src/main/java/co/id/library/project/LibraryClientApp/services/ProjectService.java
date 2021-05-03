package co.id.library.project.LibraryClientApp.services;

import co.id.library.project.LibraryClientApp.config.RequestFormat;
import co.id.library.project.LibraryClientApp.models.AuthResponse;
import co.id.library.project.LibraryClientApp.models.JudulTrainee;
import co.id.library.project.LibraryClientApp.models.Project;
import co.id.library.project.LibraryClientApp.models.SearchProject;
import co.id.library.project.LibraryClientApp.models.SubmitProject;
import co.id.library.project.LibraryClientApp.models.TitleTrainer;
import co.id.library.project.LibraryClientApp.models.Validasi;
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

    //READ SEARCH PROJECT
    public List<SearchProject> getAllSearch() {
        ResponseEntity<List<SearchProject>> response = restTemplate
                .exchange(url + "/search", HttpMethod.GET,
                        new HttpEntity(RequestFormat.createHeaders()),
                        new ParameterizedTypeReference<List<SearchProject>>() {
                });
        return response.getBody();
    }

    //get all title submission trainer
    public List<TitleTrainer> getTitleTrainer() {
        ResponseEntity<List<TitleTrainer>> response = restTemplate
                .exchange(url + "/get-all-judul", HttpMethod.GET,
                        new HttpEntity(RequestFormat.createHeaders()),
                        new ParameterizedTypeReference<List<TitleTrainer>>() {
                });
        return response.getBody();
    }

    //get project berdasarkan yang input data
    public List<Project> getProjectTrainee() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AuthResponse a = new AuthResponse(auth.getName());
        HttpEntity entity = new HttpEntity(a, RequestFormat.createHeaders());
        ResponseEntity<Project> response = restTemplate
                .exchange(url + "/project", HttpMethod.POST,
                        entity,
                        new ParameterizedTypeReference<Project>() {
                });
        List<Project> lala = new ArrayList<>();
        lala.add(response.getBody());
        System.out.println("cetak get all project");
        return lala;
    }

    //GET BY ID
    public Project getById(Integer id) {
        System.out.println("cetak id myProject");
        return restTemplate.getForEntity(url + "/" + id, Project.class).getBody();
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
    public String createProjectTrainee(SubmitProject submitProject) {
        HttpEntity entity = new HttpEntity(submitProject, RequestFormat.createHeaders());
        ResponseEntity<String> res = restTemplate.exchange(url + "/trainee", HttpMethod.POST, entity,
                new ParameterizedTypeReference<String>() {
        });
        System.out.println(res.getBody());
        return res.getBody();
    }

    //UPDATE PROJECT
    public String update(Integer id, Project project) {
        HttpEntity entity = new HttpEntity(project, RequestFormat.createHeaders());
        ResponseEntity<String> res = restTemplate.exchange(url + "/" + id, HttpMethod.PUT, entity,
                new ParameterizedTypeReference<String>() {
        });
        return res.getBody();
    }

    //GET JUDUL
    public JudulTrainee getJudulById(Integer id) {
        System.out.println("tulisan yang lain");
        System.out.println(id);
        return restTemplate.getForEntity(url + "/judul/" + id, JudulTrainee.class).getBody();
    }
   
    //UPDATE JUDUL
    public JudulTrainee updateJudul(Integer id, JudulTrainee judulTrainee) {
        HttpEntity entity = new HttpEntity(RequestFormat.createHeaders());
        //HttpEntity entity = new HttpEntity(project, RequestFormat.createHeaders());
        ResponseEntity<JudulTrainee> res = restTemplate.exchange(url + "/update-judul/" + id, HttpMethod.PUT, entity,
                new ParameterizedTypeReference<JudulTrainee>() {
        });
        
        return res.getBody();
    }
    

    //UPDATE LINK
    public Project updateLink(Integer id, Project project) {
        HttpEntity entity = new HttpEntity(project, RequestFormat.createHeaders());
       
        System.out.println("cetak update link");
        ResponseEntity<Project> res = restTemplate.exchange(url + "/update-link", HttpMethod.PUT, entity,
                new ParameterizedTypeReference<Project>() {
        });
        System.out.println(res.getBody());
        return res.getBody();
    }
    
    //VALIDASI JUDUL
    public Validasi validasiJudul(Integer id, Validasi validasi) {
        HttpEntity entity = new HttpEntity(RequestFormat.createHeaders());
        //HttpEntity entity = new HttpEntity(project, RequestFormat.createHeaders());
        ResponseEntity<Validasi> res = restTemplate.exchange(url + "/validasi-judul/" + id, HttpMethod.PUT, entity,
                new ParameterizedTypeReference<Validasi>() {
        });
        return res.getBody();
    }
    
    //VALIDASI LINK
    public Validasi validasiLink(Integer id, Validasi validasi) {
        HttpEntity entity = new HttpEntity(RequestFormat.createHeaders());
        //HttpEntity entity = new HttpEntity(project, RequestFormat.createHeaders());
        ResponseEntity<Validasi> res = restTemplate.exchange(url + "/validasi-link/" + id, HttpMethod.PUT, entity,
                new ParameterizedTypeReference<Validasi>() {
        });
        System.out.println(res.getBody());
        return res.getBody();
    }

}
