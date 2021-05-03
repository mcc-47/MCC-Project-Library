
package co.id.library.project.LibraryClientApp.models;

import lombok.Data;


@Data
public class Validasi {
    private boolean status;
    private String pesan;

    public Validasi(boolean status, String pesan) {
        this.status = status;
        this.pesan = pesan;
    }

    public Validasi() {
    }
    
    
}
