
package co.id.library.project.LibraryServerApp.dto;

import java.util.List;

public class GetJudulDTO {
    private Integer idProject;
    private String judul;
    private String batch;
    private List<String> nama;
    private String trainer;
    private String deskripsi;

    public GetJudulDTO(Integer idProject, String judul, String batch, List<String> nama, String trainer, String deskripsi) {
        this.idProject = idProject;
        this.judul = judul;
        this.batch = batch;
        this.nama = nama;
        this.trainer = trainer;
        this.deskripsi = deskripsi;
    }

    public GetJudulDTO() {
    }

    public Integer getIdProject() {
        return idProject;
    }

    public void setIdProject(Integer idProject) {
        this.idProject = idProject;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public List<String> getNama() {
        return nama;
    }

    public void setNama(List<String> nama) {
        this.nama = nama;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    
    
}
