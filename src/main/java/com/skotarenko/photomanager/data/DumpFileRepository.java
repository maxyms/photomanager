package com.skotarenko.photomanager.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.skotarenko.photomanager.File;
import com.skotarenko.photomanager.PhotoFileManager;

@Service
public class DumpFileRepository {
    private static final Logger logger = LoggerFactory.getLogger(PhotoFileManager.class);
    private static final Charset CHARSET = Charset.forName("UTF-8");
    //TODO:remove
    private static Collection<File> memCache;
    private static final AtomicInteger counter = new AtomicInteger(0);

    public Collection<File> get() {
        if (memCache == null) {
            Path dumpFile = Paths.get("dumpFiles.json");
            memCache = readFilesFromDump(dumpFile);
        }
        return memCache;
    }

    public Collection<File> getNext(Integer page) {
        Collection<File> data = get().stream().skip(counter.get()).limit(page).collect(Collectors.toList());
        counter.addAndGet(page);
        return data;
    }

    private Collection<File> readFilesFromDump(Path dumpFile) {
        Collection<File> files = Collections.emptyList();
        if (Files.exists(dumpFile, new LinkOption[] {})) {
            try (BufferedReader reader = Files.newBufferedReader(dumpFile, CHARSET)) {
                String contents = "";
                String lineFromFile = "";
                logger.debug("Reading file: " + dumpFile);
                while ((lineFromFile = reader.readLine()) != null) {
                    contents += lineFromFile;
                }
                logger.debug("Content: {} ", contents.length());
                Type listType = new TypeToken<ArrayList<File>>() {
                }.getType();
                files = new GsonBuilder().create().fromJson(contents, listType);
                //            files = new GsonBuilder().create().fromJson(contents, Collection.class);
            } catch (IOException e) {
                throw new RuntimeException("Error reading dump file", e);
            }
        }
        logger.debug("Total files from dump: " + files.size());
        return files;
    }
}
