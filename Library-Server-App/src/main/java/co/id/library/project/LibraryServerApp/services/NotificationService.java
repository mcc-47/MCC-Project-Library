/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryServerApp.services;

import co.id.library.project.LibraryServerApp.entities.Employee;
import co.id.library.project.LibraryServerApp.repositories.EmployeeRepository;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class NotificationService {
    
    JavaMailSender javaMailSender;
    EmployeeRepository employeeRepository;
    
    @Value("${spring.mail.username")
    String sender;
    
    @Autowired
    public NotificationService(JavaMailSender javaMailSender, EmployeeRepository employeeRepository) {
        this.javaMailSender = javaMailSender;
        this.employeeRepository = employeeRepository;
    }
    
    public void notifRegisJudul (Integer idMcc) throws MessagingException{
        
        Employee employee = employeeRepository.findById(idMcc).get();
        
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(sender);
        helper.setTo(employee.getEmail());
        helper.setSubject("Registrasi Judul");
//        message.setText(String.format("ID: %d, Name: %s, Province %s", employee.getEmployeeId(),employee.getEmployeeName(),province), "UTF-8", "html");
        message.setText(String.format("Registrasi Judul Oleh Saya"), "UTF-8", "html");
        
        javaMailSender.send(message);
        
    }
    
    public void notifUpdateProject (Integer idMcc) throws MessagingException{
        
        Employee employee = employeeRepository.findById(idMcc).get();
        
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(sender);
        helper.setTo(employee.getEmail());
        helper.setSubject("Update Project Akhir");
//        message.setText(String.format("ID: %d, Name: %s, Province %s", employee.getEmployeeId(),employee.getEmployeeName(),province), "UTF-8", "html");
        message.setText(String.format("Update project akhir Saya"), "UTF-8", "html");
        
        javaMailSender.send(message);
        
    }
    
    public void notifUpdateJudul (Integer idMcc) throws MessagingException{
        
        Employee employee = employeeRepository.findById(idMcc).get();
        
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(sender);
        helper.setTo(employee.getEmail());
        helper.setSubject("Update Judul Project Akhir");
//        message.setText(String.format("ID: %d, Name: %s, Province %s", employee.getEmployeeId(),employee.getEmployeeName(),province), "UTF-8", "html");
        message.setText(String.format("Update judul proyek akhir Saya"), "UTF-8", "html");
        
        javaMailSender.send(message);
        
    }
    
    public void notifUpdateLink (Integer idMcc) throws MessagingException{
        
        Employee employee = employeeRepository.findById(idMcc).get();
        
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(sender);
        helper.setTo(employee.getEmail());
        helper.setSubject("Update Link Project Akhir");
//        message.setText(String.format("ID: %d, Name: %s, Province %s", employee.getEmployeeId(),employee.getEmployeeName(),province), "UTF-8", "html");
        message.setText(String.format("Update link project akhir Saya"), "UTF-8", "html");
        
        javaMailSender.send(message);
        
    }
    
    public void notifValidasiDitolak (Integer idMcc) throws MessagingException{
        
        Employee employee = employeeRepository.findById(idMcc).get();
        
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(sender);
        helper.setTo(employee.getEmail());
        helper.setSubject("[DITOLAK] Progres Project Akhir");
//        message.setText(String.format("ID: %d, Name: %s, Province %s", employee.getEmployeeId(),employee.getEmployeeName(),province), "UTF-8", "html");
        message.setText(String.format("Progres project akhir kelompokmu ditolak. Untuke detail silakan mengunjungi laman history projectmu ya. Semangat!"), "UTF-8", "html");
        
        javaMailSender.send(message);
        
    }
    
    public void notifValidasiDiterima (Integer idMcc) throws MessagingException{
        
        Employee employee = employeeRepository.findById(idMcc).get();
        
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(sender);
        helper.setTo(employee.getEmail());
        helper.setSubject("[DITERIMA] Progres Project Akhir");
//        message.setText(String.format("ID: %d, Name: %s, Province %s", employee.getEmployeeId(),employee.getEmployeeName(),province), "UTF-8", "html");
        message.setText(String.format("Progres project akhir kelompokmu diterima. Silahkan lanjutkan progresnya. Semangat!"), "UTF-8", "html");
        
        javaMailSender.send(message);
        
    }
}

