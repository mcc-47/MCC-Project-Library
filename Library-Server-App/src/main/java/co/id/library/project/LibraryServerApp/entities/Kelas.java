/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryServerApp.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "kelas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kelas.findAll", query = "SELECT k FROM Kelas k")})
public class Kelas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_kelas")
    private Integer idKelas;
    @Basic(optional = false)
    @Column(name = "nama_kelas")
    private String namaKelas;
    @OneToMany(mappedBy = "idKelas", fetch = FetchType.LAZY)
    private List<Employee> employeeList;

    public Kelas() {
    }

    public Kelas(Integer idKelas) {
        this.idKelas = idKelas;
    }

    public Kelas(Integer idKelas, String namaKelas) {
        this.idKelas = idKelas;
        this.namaKelas = namaKelas;
    }

    public Integer getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(Integer idKelas) {
        this.idKelas = idKelas;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    @XmlTransient
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKelas != null ? idKelas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kelas)) {
            return false;
        }
        Kelas other = (Kelas) object;
        if ((this.idKelas == null && other.idKelas != null) || (this.idKelas != null && !this.idKelas.equals(other.idKelas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.id.library.project.LibraryServerApp.entities.Kelas[ idKelas=" + idKelas + " ]";
    }
    
}
