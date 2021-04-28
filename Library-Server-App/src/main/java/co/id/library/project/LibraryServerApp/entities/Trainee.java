/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryServerApp.entities;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "trainee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trainee.findAll", query = "SELECT t FROM Trainee t")})
public class Trainee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mcc")
    private Integer idMcc;
    @Column(name = "batch")
    private String batch;
    @Basic(optional = false)
    @Column(name = "status_mcc")
    private String statusMcc;
    @JoinColumn(name = "id_project", referencedColumnName = "id_project")
    @ManyToOne(fetch = FetchType.LAZY)
    private Project idProject;
    @JoinColumn(name = "id_mcc", referencedColumnName = "id_mcc", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee;

    public Trainee() {
    }

    public Trainee(Integer idMcc) {
        this.idMcc = idMcc;
    }

    public Trainee(Integer idMcc, String statusMcc) {
        this.idMcc = idMcc;
        this.statusMcc = statusMcc;
    }

    public Integer getIdMcc() {
        return idMcc;
    }

    public void setIdMcc(Integer idMcc) {
        this.idMcc = idMcc;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getStatusMcc() {
        return statusMcc;
    }

    public void setStatusMcc(String statusMcc) {
        this.statusMcc = statusMcc;
    }

    public Project getIdProject() {
        return idProject;
    }

    public void setIdProject(Project idProject) {
        this.idProject = idProject;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
        if (!(object instanceof Trainee)) {
            return false;
        }
        Trainee other = (Trainee) object;
        if ((this.idMcc == null && other.idMcc != null) || (this.idMcc != null && !this.idMcc.equals(other.idMcc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.id.library.project.LibraryServerApp.entities.Trainee[ idMcc=" + idMcc + " ]";
    }
    
}
