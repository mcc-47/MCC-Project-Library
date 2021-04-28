
package co.id.library.project.LibraryServerApp.dto;


public class TraineeDTO {
    private Integer idMcc;
    private String nama;
    private String batch;
    private String email;
    private String jabatan;
    private String status;

    public TraineeDTO() {
        
    }

    public TraineeDTO(Integer idMcc, String nama, String batch, String email, String jabatan, String status) {
        this.idMcc = idMcc;
        this.nama = nama;
        this.batch = batch;
        this.email = email;
        this.jabatan = jabatan;
        this.status = status;
    }

    public Integer getIdMcc() {
        return idMcc;
    }

    public void setIdMcc(Integer idMcc) {
        this.idMcc = idMcc;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
