
package co.id.library.project.LibraryClientApp.models;

import java.util.Date;
import lombok.Data;

@Data
public class History {
    private Integer idHistory;
    private Integer idProject;
    private String info;
    private Date waktu;
    private String pesan;
    private String status;

    public History() {
    }

    public History(Integer idHistory, Integer idProject, String info, Date waktu, String pesan, String status) {
        this.idHistory = idHistory;
        this.idProject = idProject;
        this.info = info;
        this.waktu = waktu;
        this.pesan = pesan;
        this.status = status;
    }
    
}
