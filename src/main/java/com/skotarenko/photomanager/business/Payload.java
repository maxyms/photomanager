package com.skotarenko.photomanager.business;

import java.util.Collection;

public class Payload {
    private Client client;
    private Collection<File> files;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Collection<File> getFiles() {
        return files;
    }

    public void setFiles(Collection<File> files) {
        this.files = files;
    }
}
