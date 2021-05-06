package co.id.library.project.LibraryServerApp.services;

import co.id.library.project.LibraryServerApp.entities.Employee;
import co.id.library.project.LibraryServerApp.entities.Project;
import co.id.library.project.LibraryServerApp.entities.Trainee;
import co.id.library.project.LibraryServerApp.repositories.EmployeeRepository;
import co.id.library.project.LibraryServerApp.repositories.ProjectRepository;
import co.id.library.project.LibraryServerApp.repositories.TraineeRepository;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    
    JavaMailSender javaMailSender;
    EmployeeRepository employeeRepository;
    
    @Autowired
    TraineeRepository traineeRepository;
    
    @Autowired
    ProjectRepository projectRepository;
    
    @Value("${spring.mail.username")
    String sender;
    
    @Autowired
    public NotificationService(JavaMailSender javaMailSender, EmployeeRepository employeeRepository) {
        this.javaMailSender = javaMailSender;
        this.employeeRepository = employeeRepository;
    }
    
    public void notifRegisJudul (Integer idMcc) throws MessagingException{
        
        Trainee trainee = employeeRepository.findById(idMcc).get().getTrainee();
        Integer idTrainer = employeeRepository.findById(idMcc).get().getIdTrainer().getIdMcc();
        Employee trainer = employeeRepository.findById(idTrainer).get();
        Project project = projectRepository.findById(trainee.getIdProject().getIdProject()).get();
        System.out.println("trainee : "+trainee);
        System.out.println("idTrainer : "+idTrainer);
        System.out.println("trainer : "+trainer);
        System.out.println("project : "+project);
        System.out.println("judul : "+project.getJudul());

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(sender);
        helper.setTo(trainer.getEmail());
        helper.setSubject("Registrasi Judul");
        message.setText(String.format("Registrasi Judul : %s", project.getJudul()), "UTF-8", "html");
        helper.setSubject("[Registrasi Judul]");
        message.setText(String.format("Dear, kak %s"
                        +"<br>"
                        + "<br>"
                        +"Telah dilakukan registrasi Final Project dengan judul : <b>%s</b>"
                        + "<br>"
                        +"Mohon untuk lakukan pengecekan dan validasi terhadap judul tersebut di laman Title Submission."
                        + "<br>"
                        +"Terima kasih.", trainer.getNama(), project.getJudul()
                        ), "UTF-8", "html");
        
        javaMailSender.send(message);
        
    }
    
    public void notifUpdateProject (Integer idMcc) throws MessagingException{
        
        Employee employee = employeeRepository.findById(idMcc).get();
        
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(sender);
        helper.setTo(employee.getEmail());
        helper.setSubject("Update Project Akhir");
        message.setText(String.format("Update project akhir Trainee MCC"), "UTF-8", "html");
        
        javaMailSender.send(message);
        
    }
    
    public void notifUpdateJudul (Integer idMcc) throws MessagingException{
        
        Trainee trainee = employeeRepository.findById(idMcc).get().getTrainee();
        Integer idTrainer = employeeRepository.findById(idMcc).get().getIdTrainer().getIdMcc();
        Employee trainer = employeeRepository.findById(idTrainer).get();
        Project project = projectRepository.findById(trainee.getIdProject().getIdProject()).get();
//        Employee employee = employeeRepository.findById(idMcc).get();
        
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(sender);
        helper.setTo(trainer.getEmail());
        helper.setSubject("Update Judul Project Akhir");
        message.setText(String.format("Dear, kak %s"
                        +"<br>"
                        + "<br>"
                        +"Telah dilakukan update <b>judul</b> Final Project dengan judul : <b>%s</b>"
                        + "<br>"
                        +"Mohon untuk lakukan pengecekan dan validasi terhadap judul tersebut di laman Title Submission."
                        + "<br>"
                        +"Terima kasih.", trainer.getNama(), project.getJudul()
                        ), "UTF-8", "html");
        
        javaMailSender.send(message);
        
    }
    
    public void notifUpdateLink (Integer idMcc) throws MessagingException{
        
        Trainee trainee = employeeRepository.findById(idMcc).get().getTrainee();
        Integer idTrainer = employeeRepository.findById(idMcc).get().getIdTrainer().getIdMcc();
        Employee trainer = employeeRepository.findById(idTrainer).get();
        Project project = projectRepository.findById(trainee.getIdProject().getIdProject()).get();
//        Employee employee = employeeRepository.findById(idMcc).get();
        
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(sender);
        helper.setTo(trainer.getEmail());
        helper.setSubject("Update Link Project Akhir");
        message.setText(String.format("Dear, kak %s"
                        +"<br>"
                        + "<br>"
                        +"Telah dilakukan update <b>link</b> Final Project dengan judul : <b>%s</b>"
                        + "<br>"
                        +"Mohon untuk lakukan pengecekan dan validasi terhadap judul tersebut di laman Title Submission."
                        + "<br>"
                        +"Terima kasih.", trainer.getNama(), project.getJudul()
                        ), "UTF-8", "html");
        
        javaMailSender.send(message);
        
    }
    
    public void notifValidasiDitolak (Integer idMcc) throws MessagingException{
        Trainee trainee = employeeRepository.findById(idMcc).get().getTrainee();
        Integer idTrainer = employeeRepository.findById(idMcc).get().getIdTrainer().getIdMcc();
        Employee trainer = employeeRepository.findById(idTrainer).get();
        Project project = projectRepository.findById(trainee.getIdProject().getIdProject()).get();
        Employee employee = employeeRepository.findById(idMcc).get();
        
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(sender);
        helper.setTo(employee.getEmail());
        helper.setSubject("[DITOLAK] Progres Project Akhir");
        message.setText(String.format("Dear %s,"
                +"<br>"
                +"<br>"
                +"Progres project akhir kelompokmu dengan judul : %s ditolak."
                +"<br>"
                +"Untuk detail silakan mengunjungi laman history projectmu ya."
                +"<br>"
                +"Semangat!", employee.getNama(), project.getJudul()), "UTF-8", "html");
        
        javaMailSender.send(message);
        
    }
    
    public void notifValidasiDiterima (Integer idMcc) throws MessagingException{
        
        Trainee trainee = employeeRepository.findById(idMcc).get().getTrainee();
        Integer idTrainer = employeeRepository.findById(idMcc).get().getIdTrainer().getIdMcc();
        Employee trainer = employeeRepository.findById(idTrainer).get();
        Project project = projectRepository.findById(trainee.getIdProject().getIdProject()).get();
        Employee employee = employeeRepository.findById(idMcc).get();
        
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(sender);
        helper.setTo(employee.getEmail());
        helper.setSubject("[DITERIMA] Progres Project Akhir");
        message.setText(String.format("Dear %s,"
                +"<br>"
                +"<br>"
                +"Progres project akhir kelompokmu dengan judul : %s diterima."
                +"<br>"
                +"Silakan mengunjungi laman My History dan melanjutkan ke tahap berikutnya."
                +"<br>"
                +"Semangat!", employee.getNama(), project.getJudul()), "UTF-8", "html");
        
        javaMailSender.send(message);
        
    }
}
