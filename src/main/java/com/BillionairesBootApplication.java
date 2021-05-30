package com;

import com.sunriseyonder.sb.h2repository.BillionairesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BillionairesBootApplication/* implements CommandLineRunner*/{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BillionairesRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(BillionairesBootApplication.class, args);
    }

  /*  @Override
    public void run(String... args) throws Exception {
        logger.info("All billionaires -> {}", repository.findAll());
    }*/
}
