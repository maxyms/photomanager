package com.skotarenko.photomanager.web;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skotarenko.photomanager.File;
import com.skotarenko.photomanager.web.data.FileRepository;

@RestController
@RequestMapping("/api/files")
public class FilesRestController {
    @Autowired
    private FileRepository repo;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<File> getAll() {
        //        return repo.get();
        return Collections.emptyList();
    }
    /*@RequestMapping(method = RequestMethod.GET, value = "{id}")
    public Item get(@PathVariable String id) {
        return repo.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Item create(@RequestBody Item contact) {
        return repo.save(contact);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable String id) {
        repo.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public Item update(@PathVariable String id, @RequestBody Item item) {
        Item update = repo.findOne(id);
        update.setName(item.getName());
        update.setPrice(item.getPrice());
        return repo.save(update);
    }*/
}