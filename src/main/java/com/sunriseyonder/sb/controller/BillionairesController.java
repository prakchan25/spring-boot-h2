package com.sunriseyonder.sb.controller;

import com.sunriseyonder.sb.entity.Billionaires;
import com.sunriseyonder.sb.h2repository.BillionairesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BillionairesController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BillionairesRepository repository;

    @GetMapping("/getBillionaires")
    public List<Billionaires> getAll(){
        logger.info("Fetching all Billionaires from DB..");
        return repository.findAll();
    }

    @GetMapping("/getBillionairesById/{id}")
    @ResponseBody
    public Billionaires findById(@PathVariable("id") int id){
        logger.info("Fetching Billionaire for Id : "+id);
        return repository.findById(id);
    }
}
