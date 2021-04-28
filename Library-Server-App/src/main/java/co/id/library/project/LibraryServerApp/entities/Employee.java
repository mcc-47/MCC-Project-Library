/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryServerApp.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mcc")
    private Integer idMcc;
    @Basic(optional = false)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "jabatan")
    private String jabatan;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Trainee trainee;
    @OneToMany(mappedBy = "idTrainer", fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Employee> employeeList;
    @JoinColumn(name = "id_trainer", referencedColumnName = "id_mcc")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Employee idTrainer;
    @JoinColumn(name = "id_kelas", referencedColumnName = "id_kelas")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Kelas idKelas;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    
    private User user;

    public Employee() {
    }

    public Employee(Integer idMcc) {
        this.idMcc = idMcc;
    }

    public Employee(Integer idMcc, String nama, String email, String jabatan, Kelas idKelas) {
        this.idMcc = idMcc;
        this.nama = nama;
        this.email = email;
        this.jabatan = jabatan;
        this.idKelas = idKelas;
    }

    public Integer getIdMcc() {
        return idMcc;
    }

    public void setIdMcc(Integer idMcc) {
        this.idMcc = idMcc;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    @XmlTransient
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Employee getIdTrainer() {
        return idTrainer;
    }

    public void setIdTrainer(Employee idTrainer) {
        this.idTrainer = idTrainer;
    }

    public Kelas getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(Kelas idKelas) {
        this.idKelas = idKelas;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMcc != null ? idMcc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.idMcc == null && other.idMcc != null) || (this.idMcc != null && !this.idMcc.equals(other.idMcc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.id.library.project.LibraryServerApp.entities.Employee[ idMcc=" + idMcc + " ]";
    }

    
}
