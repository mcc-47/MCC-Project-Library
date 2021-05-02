
package co.id.library.project.LibraryClientApp.models;

import lombok.Data;


@Data
public class SubmitProject {
    private String judul;
    private String deskripsi;
    private Integer idMccSatu;
    private Integer idMccDua;
    private Integer idMccTiga;

    public SubmitProject() {
    }

    public SubmitProject(String judul, String deskripsi, Integer idMccSatu, Integer idMccDua, Integer idMccTiga) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.idMccSatu = idMccSatu;
        this.idMccDua = idMccDua;
        this.idMccTiga = idMccTiga;
    }
    
    
}

