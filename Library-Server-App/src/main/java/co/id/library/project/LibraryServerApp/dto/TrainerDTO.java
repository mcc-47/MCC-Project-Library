package co.id.library.project.LibraryServerApp.dto;


public class TrainerDTO {

    private Integer idMcc;
    private String nama;
    private String email;
    private String namaKelas;

    public TrainerDTO() {
        
    }

    public TrainerDTO(Integer idMcc, String nama, String email, String namaKelas) {
        this.idMcc = idMcc;
        this.nama = nama;
        this.email = email;
        this.namaKelas = namaKelas;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

  
   
}
