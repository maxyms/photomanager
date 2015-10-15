package com.skotarenko.photomanager.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skotarenko.photomanager.Duplicates;
import com.skotarenko.photomanager.DuplicatesFinder;
import com.skotarenko.photomanager.File;
import com.skotarenko.photomanager.web.data.FilesDataService;

@RestController
@RequestMapping("/api/duplicate")
public class DuplicateFilesRestController {
    @Autowired
    private FilesDataService service;

    //    @RequestMapping(method = RequestMethod.GET)
    //    public Collection<File> getAll(@RequestParam(value = "path") String path) {
    //        Collection<File> duplicates = Collections.emptyList();
    //        Collection<File> allFiles = repo.get();
    //        Optional<File> optionalFile = allFiles.stream().filter(f -> f.getPath().equalsIgnoreCase(path)).findFirst();
    //        if (optionalFile.isPresent()) {
    //            File file = optionalFile.get();
    //            duplicates = allFiles.stream().filter(f -> f.getName().equalsIgnoreCase(file.getName()) && f.getSize() == file.getSize()).collect(Collectors.toList());
    //        }
    //        return duplicates;
    //    }
    @RequestMapping(method = RequestMethod.GET)
    public Duplicates getAll() {
        Collection<File> allFiles = service.get();
        Duplicates duplicates = new DuplicatesFinder().findDuplicates(allFiles);
        return duplicates;
    }
}