package com.skotarenko.photomanager.data;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.skotarenko.photomanager.business.File;

public interface FilesRepository extends MongoRepository<File, Long> {
    public File findById(String id);
}
