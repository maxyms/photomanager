package com.skotarenko.photomanager;

import java.util.Collection;

import com.skotarenko.photomanager.business.File;

public class DuplicateEntry {
    private String name;
    private Collection<File> files;

    public DuplicateEntry(String name, Collection<File> files) {
        super();
        this.name = name;
        this.files = files;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<File> getFiles() {
        return files;
    }

    public void setFiles(Collection<File> files) {
        this.files = files;
    }
}
