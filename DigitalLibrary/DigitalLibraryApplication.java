package com.finalProject.DigitalLibrary;
import com.finalProject.DigitalLibrary.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class DigitalLibraryApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DigitalLibraryApplication.class, args);


    }


    @Override
    public void run(String... args) throws Exception {

    }
}
