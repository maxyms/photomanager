package com.skotarenko.photomanager;

import java.util.Collection;

public class Duplicates {
    private Long totalSize;
    private Long savedSize;
    private Collection<DuplicateEntry> entries;

    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }

    public Long getSavedSize() {
        return savedSize;
    }

    public void setSavedSize(Long savedSize) {
        this.savedSize = savedSize;
    }

    public Collection<DuplicateEntry> getEntries() {
        return entries;
    }

    public void setEntries(Collection<DuplicateEntry> entries) {
        this.entries = entries;
    }
}
