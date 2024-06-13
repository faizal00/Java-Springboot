package com.dosen.latihan.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dosen.latihan.model.dosen;
import com.dosen.latihan.repository.dosenRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
@RequestMapping("/dosen")
public class dosenController {

    @Autowired
    private dosenRepository dr;

    @GetMapping("/kampus")
    @ResponseBody
    public Object getKampus(){
        Map<String,Object> obj = new HashMap<>();
        obj.put("Fakultas","FTI");
        obj.put("Universitas","UKSW");
        return obj;
    }

    @PostMapping("/add")
    public @ResponseBody String addNewDosen(@RequestParam String nama,@RequestParam String jabatan){
        dosen ds = new dosen();
        ds.setNama(nama);
        ds.setJabatan(jabatan);
        dr.save(ds);
        return "saved";
    }

    @GetMapping("/get")
    public @ResponseBody Iterable<dosen> getAllDosen(){
        return dr.findAll();
    }

    @PostMapping("/add2")
    public @ResponseBody String addNewDosen2(@RequestBody dosen dos) {
        dr.save(dos);
        return "Saved";
    }

    @DeleteMapping("/delete")
    public @ResponseBody boolean deleteById(@RequestParam Integer id){
        if (dr.existsById(id)) {
            dr.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @PutMapping("/{id}/update")
    public boolean updateDosen(@PathVariable Integer id, @RequestBody dosen dos) {
        if (dr.existsById(id)) {
            dosen doslam =  dr.findById(id).get();
            doslam.setId(id);
            doslam.setNama(dos.getNama());
            doslam.setJabatan(dos.getJabatan());
            dr.save(doslam);
            return true;
        }else{
            return false;
        }
    }

    @PostMapping("/getbynama")
    public @ResponseBody Iterable<dosen> getbynama(@RequestParam String nama) {
        
        
        return dr.findByNama(nama);
    }

    @PostMapping("/getbyjabatan")
    public @ResponseBody Iterable<dosen> getbyjabatan(@RequestParam String jabatan) {
        
        
        return dr.findByJabatan(jabatan);
    }
    
    @PostMapping("/getbykeyword")
    public @ResponseBody Iterable<dosen> getbykeyword(@RequestParam String nama) {
        
        return dr.findByKeyword(nama);
    }
    
    @PostMapping("/getdouble")
    public @ResponseBody Iterable<dosen> getdouble(@RequestParam String nama, String jabatan) {
        
        return dr.findDouble(nama,jabatan);
    }
}
