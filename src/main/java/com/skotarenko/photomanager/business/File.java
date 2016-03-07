package com.skotarenko.photomanager.business;

import java.util.Arrays;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class File {
    @Id
    private String id;
    private long size;
    private String name;
    private String path;
    private Date createdDate;
    private String status;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "File [size=" + size + ", name=" + name + ", path=" + path + ", createdDate=" + createdDate + ", colorSchema=" + Arrays.toString(colorSchema) + "]";
    }
}
