package com.dosen.latihan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class dosen {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer nip;

    private String nama;
    private String jabatan;

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getJabatan() {
        return jabatan;
    }
    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }
    public Integer getId(){
        return nip;
    }
    public void setId(Integer id){
        this.nip=id;
    }
}
