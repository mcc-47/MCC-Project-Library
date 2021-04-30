/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.library.project.LibraryServerApp.dto;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class HistoryDTO {
    
    private Integer idHistory;
    private String info;
    private Date waktu;
    private String pesan;
    private String status;

    public HistoryDTO() {
    }

    public HistoryDTO(Integer idHistory, String info, Date waktu, String pesan, String status) {
        this.idHistory = idHistory;
        this.info = info;
        this.waktu = waktu;
        this.pesan = pesan;
        this.status = status;
    }

    public Integer getIdHistory() {
        return idHistory;
    }

    public void setIdHistory(Integer idHistory) {
        this.idHistory = idHistory;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getWaktu() {
        return waktu;
    }

    public void setWaktu(Date waktu) {
        this.waktu = waktu;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
