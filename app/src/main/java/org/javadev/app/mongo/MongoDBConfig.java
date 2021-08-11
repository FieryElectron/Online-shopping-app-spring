package org.javadev.app.mongo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = MongoUserRepository.class)
@Configuration
public class MongoDBConfig {


    // @Bean
    // CommandLineRunner commandLineRunner(UserRepository userRepository) {
    //     return strings -> {
    //         userRepository.save(new Users("aden", "Development"));
    //         userRepository.save(new Users("pown", "Operations"));
    //     };
    // }

}
