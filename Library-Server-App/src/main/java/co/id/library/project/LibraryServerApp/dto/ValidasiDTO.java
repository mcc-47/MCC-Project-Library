/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryServerApp.dto;

public class ValidasiDTO {
    private boolean status;
    private String pesan;

    public ValidasiDTO() {
    }

    
    
    public ValidasiDTO(boolean status, String pesan) {
        this.status = status;
        this.pesan = pesan;
    }

   
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }
    
    
}
