
package co.id.library.project.LibraryClientApp.models;

import lombok.Data;


@Data
public class Trainer {
    private Integer idMcc;
    private String nama;
    private String email;
    private String namaKelas;

    public Trainer() {
    }
    
    
    public Trainer(Integer idMcc, String nama, String email, String namaKelas) {
        this.idMcc = idMcc;
        this.nama = nama;
        this.email = email;
        this.namaKelas = namaKelas;
    }
 
}
