package com.skotarenko.photomanager.business;

import java.util.Arrays;
import java.util.Date;

public class File {
    private long size;
    private String name;
    private String path;
    private Date createdDate;
    private int[] colorSchema;

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int[] getColorSchema() {
        return colorSchema;
    }

    public void setColorSchema(int[] colorSchema) {
        this.colorSchema = colorSchema;
    }

    @Override
    public String toString() {
        return "File [size=" + size + ", name=" + name + ", path=" + path + ", createdDate=" + createdDate + ", colorSchema="
                + Arrays.toString(colorSchema) + "]";
    }
}
