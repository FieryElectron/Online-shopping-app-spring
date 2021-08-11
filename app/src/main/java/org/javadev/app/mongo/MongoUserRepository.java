package org.javadev.app.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoUserRepository extends MongoRepository<mongoUser, String> {
}
