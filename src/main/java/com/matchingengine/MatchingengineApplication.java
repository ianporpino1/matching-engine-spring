package com.matchingengine;

import com.matchingengine.model.Role;
import com.matchingengine.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MatchingengineApplication {

    public static void main(String[] args) {
        SpringApplication.run(MatchingengineApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(RoleRepository roleRepository) {
        return args -> {
            if (roleRepository.findByName("ROLE_ADMIN") == null) {
                roleRepository.save(new Role("ROLE_ADMIN"));
            }
            if (roleRepository.findByName("ROLE_USER") == null) {
                roleRepository.save(new Role("ROLE_USER"));
            }
        };
    }


}
