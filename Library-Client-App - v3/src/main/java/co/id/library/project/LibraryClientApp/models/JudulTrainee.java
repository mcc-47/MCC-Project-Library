
package co.id.library.project.LibraryClientApp.models;

import java.util.List;
import lombok.Data;

@Data
public class JudulTrainee {
    private List<String> nama;
    private String trainer;
    private String judul;
    private String deskripsi;

    public JudulTrainee(List<String> nama, String trainer, String judul, String deskripsi) {
        this.nama = nama;
        this.trainer = trainer;
        this.judul = judul;
        this.deskripsi = deskripsi;
    }

    
    public JudulTrainee() {
    }
    
}
