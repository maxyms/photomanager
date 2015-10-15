package com.skotarenko.photomanager.web.data;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skotarenko.photomanager.File;
import com.skotarenko.photomanager.data.DumpFileRepository;
import com.skotarenko.photomanager.data.FilesRepository;

@Service
public class FilesDataService {
    @Autowired
    private FilesRepository repository;
    @Autowired
    private DumpFileRepository dumpRepository;

    public Collection<File> get() {
        return repository.findAll();
    }

    public Collection<File> getNext(Integer page) {
        return dumpRepository.getNext(page);
    }
}
