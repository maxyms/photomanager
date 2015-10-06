package com.skotarenko.photomanager.web.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.GsonBuilder;
import com.skotarenko.photomanager.File;
import com.skotarenko.photomanager.PhotoFileManager;

@Service
public class FileRepository {
    private static final Logger logger = LoggerFactory.getLogger(PhotoFileManager.class);
    private static final Charset CHARSET = Charset.forName("UTF-8");

    public Collection<File> get() {
        Path dumpFile = Paths.get("dumpFiles.json");
        Collection<File> files = readFilesFromDump(dumpFile);
        return files;
    }

    private Collection<File> readFilesFromDump(Path dumpFile) {
        Collection<File> files = Collections.emptyList();
        try (BufferedReader reader = Files.newBufferedReader(dumpFile, CHARSET)) {
            String contents = "";
            String lineFromFile = "";
            logger.debug("Reading file: " + dumpFile);
            while ((lineFromFile = reader.readLine()) != null) {
                contents += lineFromFile;
            }
            logger.debug("Content: {} ", contents.length());
            files = new GsonBuilder().create().fromJson(contents, Collection.class);
        } catch (IOException e) {
            throw new RuntimeException("Error reading dump file", e);
        }
        logger.debug("Total files from dump: " + files.size());
        return files;
    }
}
