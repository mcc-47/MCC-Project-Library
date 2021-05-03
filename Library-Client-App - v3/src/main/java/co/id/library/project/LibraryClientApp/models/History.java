
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
    //private Integer idStatus;

    public History(Integer idHistory, Integer idProject, String info, Date waktu, String pesan, String status) {
        this.idHistory = idHistory;
        this.idProject = idProject;
        this.info = info;
        this.waktu = waktu;
        this.pesan = pesan;
        this.status = status;
    }

//    public History(Integer idHistory, Integer idProject, String info, Date waktu, String pesan, Integer idStatus) {
//        this.idHistory = idHistory;
//        this.idProject = idProject;
//        this.info = info;
//        this.waktu = waktu;
//        this.pesan = pesan;
//        this.idStatus = idStatus;
//    }

   

    
    public History() {
    }
    
    
}
