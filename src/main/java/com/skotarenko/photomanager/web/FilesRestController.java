package com.skotarenko.photomanager.web;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestBody;
=======
import org.springframework.web.bind.annotation.PathVariable;
>>>>>>> 9af75599fa4fcd71f7ccda9eac422fa766402a80
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.skotarenko.photomanager.business.File;
import com.skotarenko.photomanager.business.Payload;
import com.skotarenko.photomanager.web.data.FileRepository;
=======
import com.skotarenko.photomanager.File;
import com.skotarenko.photomanager.data.DumpFileRepository;
import com.skotarenko.photomanager.data.FilesRepository;
>>>>>>> 9af75599fa4fcd71f7ccda9eac422fa766402a80

@RestController
@RequestMapping("/api")
public class FilesRestController {
    @Autowired
    private FilesRepository repository;
    @Autowired
    private DumpFileRepository dumpRepository;

    @RequestMapping(value = "files", method = RequestMethod.GET)
    public Collection<File> getAll(@RequestParam(value = "_limit", defaultValue = "50") Long _limit) {
        Comparator<File> cmp = (f1, f2) -> f1.getPath().compareToIgnoreCase(f2.getPath());
<<<<<<< HEAD
        return repo.get().stream().sorted(cmp)/*.limit(_limit)*/.collect(Collectors.toList());
    }

    /*@RequestMapping(method = RequestMethod.GET, value = "{id}")
    public Item get(@PathVariable String id) {
        return repo.findOne(id);
    }
    */
    @RequestMapping(value = "receive", method = RequestMethod.POST)
    public void receive(@RequestBody Payload payload) {
        System.out.println(payload);
        repo.get().addAll(payload.getFiles());
        //        return repo.save(contact);
    }
    /*
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
=======
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
>>>>>>> 9af75599fa4fcd71f7ccda9eac422fa766402a80
}