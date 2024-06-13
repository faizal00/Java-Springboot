package com.dosen.latihan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dosen.latihan.model.dosen;

public interface dosenRepository extends CrudRepository<dosen, Integer> {

    public List<dosen> findByNama(String nama);
    
    public List<dosen> findByJabatan(String jabatan);
    
    @Query("SELECT d FROM dosen d WHERE d.nama LIKE %?1%")
    List<dosen> findByKeyword(String nama);

    @Query("SELECT d FROM dosen d WHERE d.nama=?1 and d.jabatan=?2")
    List<dosen> findDouble(String nama, String jabatan);

}
