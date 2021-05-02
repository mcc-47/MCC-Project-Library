/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryServerApp.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "History.findAll", query = "SELECT h FROM History h")})
public class History implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_history")
    private Integer idHistory;
    @Basic(optional = false)
    @Column(name = "info")
    private String info;
    @Basic(optional = false)
    @Column(name = "waktu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktu;
    @Lob
    @Column(name = "pesan")
    private String pesan;
    @JoinColumn(name = "id_project", referencedColumnName = "id_project")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Project idProject;
    @JoinColumn(name = "id_status", referencedColumnName = "id_status")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Status idStatus;

    public History() {
    }

    public History(Integer idHistory) {
        this.idHistory = idHistory;
    }

    public History(Integer idHistory, String info, Date waktu) {
        this.idHistory = idHistory;
        this.info = info;
        this.waktu = waktu;
    }

    public History(String info, Date waktu, String pesan, Project idProject, Status idStatus) {
        this.info = info;
        this.waktu = waktu;
        this.pesan = pesan;
        this.idProject = idProject;
        this.idStatus = idStatus;
    }

    public History(String info, Date waktu, Project idProject, Status idStatus) {
        this.info = info;
        this.waktu = waktu;
        this.idProject = idProject;
        this.idStatus = idStatus;
    }
    
    

    public Integer getIdHistory() {
        return idHistory;
    }

    public void setIdHistory(Integer idHistory) {
        this.idHistory = idHistory;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getWaktu() {
        return waktu;
    }

    public void setWaktu(Date waktu) {
        this.waktu = waktu;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public Project getIdProject() {
        return idProject;
    }

    public void setIdProject(Project idProject) {
        this.idProject = idProject;
    }

    public Status getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Status idStatus) {
        this.idStatus = idStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistory != null ? idHistory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof History)) {
            return false;
        }
        History other = (History) object;
        if ((this.idHistory == null && other.idHistory != null) || (this.idHistory != null && !this.idHistory.equals(other.idHistory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.id.library.project.LibraryServerApp.entities.History[ idHistory=" + idHistory + " ]";
    }
    
}
