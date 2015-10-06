package com.skotarenko.photomanager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.GsonBuilder;

public class PhotoFileManager {
    private static final Logger logger = LoggerFactory.getLogger(PhotoFileManager.class);
    private static final Charset CHARSET = Charset.forName("UTF-8");

    private Collection<File> searchFiles(String path) {
        Collection<File> files = new ArrayList<>();
        List<Path> roots = Arrays.stream(path.split(";")).map(s -> Paths.get(s)).collect(Collectors.toList());
        roots.stream().forEach(p -> processFolder(p, files));
        logger.debug("Total files {}", files.size());
        return files;
    }

    private void dumpFiles(Collection<File> files, Path dumpFile) {
        String json = new GsonBuilder().create().toJson(files);
        try {
            Files.deleteIfExists(dumpFile);
            dumpFile = Files.createFile(dumpFile);
        } catch (IOException e) {
            throw new RuntimeException("Error creating dump file", e);
        }
        try (BufferedWriter writer = Files.newBufferedWriter(dumpFile, CHARSET)) {
            writer.append(json);
            writer.flush();
        } catch (IOException e) {
            logger.error("Error writing dump file", e);
        }
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
            files = new GsonBuilder().create().fromJson(contents, ArrayList.class);
        } catch (IOException e) {
            throw new RuntimeException("Error reading dump file", e);
        }
        logger.debug("Total files from dump: " + files.size());
        return files;
    }

    private void processFolder(Path root, Collection<File> files) {
        try {
            Files.walkFileTree(root, new ImageFileVisitor(files));
        } catch (AccessDeniedException e2) {
            logger.warn("Error reading file {}", root.getFileName(), e2);
        } catch (IOException e) {
            throw new RuntimeException("Error processing path " + root, e);
        }
        //        list.stream().forEach(f -> {
        //            if (files.get(f.getName()) == null) {
        //                files.put(f.getName(), new ArrayList<File>());
        //            }
        //            //            logger.debug("File name: " + p.getName());
        //                files.get(f.getName()).add(f);
        //            });
        //        logger.debug("Total files: " + list.size());
        // try (DirectoryStream<Path> stream = Files.newDirectoryStream(root,
        // "*.*");) { for (Path p : stream) { //
        // System.out.println(p.getFileName()); // if (Files.isDirectory(p)) {
        // // System.out.println("----Directory"); // } //
        // System.out.println(Files.readAttributes(p, "*")); //
        // System.out.println(Files.getOwner(p)); File f = new File();
        // f.setName(p.getFileName().toString()); f.setSize(Files.size(p)); //
        // System.out.println(Files.getAttribute(p, "creationTime") //
        // .getClass());
        //
        // FileTime fTime = (FileTime) Files.getAttribute(p, "creationTime"); //
        // f.setCreatedDate(Files.getAttribute(p, "creationTime"));
        // f.setCreatedDate(new Date(fTime.toMillis())); System.out.println(f);
        // if (files.get(f.getName()) == null) { files.put(f.getName(), new
        // ArrayList<>()); } files.get(f.getName()).add(f); Metadata metadata
        // = ImageMetadataReader .readMetadata(p.toFile()); for (Directory
        // directory : metadata.getDirectories()) { for (Tag tag :
        // directory.getTags()) { // System.out.println(tag); } } GpsDirectory
        // directory = metadata .getDirectory(GpsDirectory.class); if (directory
        // != null) { GeoLocation geo = directory.getGeoLocation();
        // System.out.println(geo); } else {
        // System.out.println("Directory is null"); }
        //
        // } }} catch (IOException e) { e.printStackTrace(); }
    }

    public static void main(String[] args) {
        ClassLoader classLoader = PhotoFileManager.class.getClassLoader();
        Properties properties = new Properties();
        try {
            properties.load(classLoader.getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        PhotoFileManager _this = new PhotoFileManager();
        Path dumpFile = Paths.get("dumpFiles.json");
        Collection<File> files = null;
        if (false) {
            files = _this.searchFiles(properties.getProperty("scan-path"));
            _this.dumpFiles(files, dumpFile);
        } else {
            files = _this.readFilesFromDump(dumpFile);
        }
        new DuplicatesFinder().findDuplicates(files);
        logger.debug("Total files {}", files.size());
    }
}
