package org.java.spring_boot_test4.db.service;

import java.util.List;
import java.util.Optional;

import org.java.spring_boot_test4.db.pojo.ContoBancario;
import org.java.spring_boot_test4.db.repo.ContoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class ContoService {

    @Autowired
    private ContoRepo contoRepo;

    public List<ContoBancario> getAllConti(){
        return contoRepo.findAll();
    }

    public Optional<ContoBancario> getContoById(int id){
        return contoRepo.findById(id);
    }

    public void save (ContoBancario e){
        contoRepo.save(e);
    }

    public void delete(ContoBancario e){
        contoRepo.delete(e);
    }

}
