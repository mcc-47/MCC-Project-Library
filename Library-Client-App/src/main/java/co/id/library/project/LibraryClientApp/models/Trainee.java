
package co.id.library.project.LibraryClientApp.models;

import lombok.Data;

@Data
public class Trainee {
    private Integer idMcc;
    private String nama;
    private String batch;
    private String email;
    private String jabatan;
    private String status;

    public Trainee() {
    }

    
    public Trainee(Integer idMcc, String nama, String batch, String email, String jabatan, String status) {
        this.idMcc = idMcc;
        this.nama = nama;
        this.batch = batch;
        this.email = email;
        this.jabatan = jabatan;
        this.status = status;
    }
}
