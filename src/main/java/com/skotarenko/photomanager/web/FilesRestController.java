package com.skotarenko.photomanager.web;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skotarenko.photomanager.File;
import com.skotarenko.photomanager.data.DumpFileRepository;
import com.skotarenko.photomanager.data.FilesRepository;

@RestController
@RequestMapping("/api/files")
public class FilesRestController {
    @Autowired
    private FilesRepository repository;
    @Autowired
    private DumpFileRepository dumpRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<File> getAll(@RequestParam(value = "_limit", defaultValue = "50") Long _limit) {
        Comparator<File> cmp = (f1, f2) -> f1.getPath().compareToIgnoreCase(f2.getPath());
        return repository.findAll().stream().sorted(cmp).limit(_limit).collect(Collectors.toList());
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public Integer get() {
        Collection<File> nextFromDump = dumpRepository.getNext(10);
        repository.save(nextFromDump);
        return nextFromDump.size();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public File get(@PathVariable String id) {
        return repository.findById(id);
    }

    /*
    @RequestMapping(method = RequestMethod.POST)
    public Item create(@RequestBody Item contact) {
        return repo.save(contact);
    }
    */
    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable String id) {
        File file = repository.findById(id);
        file.setStatus("marked_for_deletion");
        repository.save(file);
    }
    /*
    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public Item update(@PathVariable String id, @RequestBody Item item) {
        Item update = repo.findOne(id);
        update.setName(item.getName());
        update.setPrice(item.getPrice());
        return repo.save(update);
    }*/
}