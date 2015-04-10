package com.skotarenko.photomanager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PhotoFileManager {
    private static final Logger logger = LoggerFactory.getLogger(PhotoFileManager.class);

    private void scanFiles() {
        Collection<File> files = new ArrayList<>();
        List<Path> roots = Arrays.asList(new Path[] {
        //				Paths.get("C:/Users/maxyms/documents/photos"),
        //				Paths.get("C:/Users/maxyms/documents/photos2")
        //                Paths.get("E:/data/photo"), Paths.get("E:/data/photo_mom") });
        Paths.get("E:/data/photo/test") });
        roots.stream().forEach(p -> processFolder(p, files));
        logger.debug("Total files: " + files.size());
        logger.debug("Find duplicates...");
        Map<IKey, Collection<File>> duplicates = compareFiles(files);
        logger.debug("Total duplicates: " + duplicates.size());
        printDuplicates(duplicates);
        files.stream().forEach(f -> logger.debug("\t" + f.getName() + " " + Arrays.toString(f.getColorSchema())));
        ///
        File orig = new File();
        orig.setColorSchema(new int[] { -5199195, -5274514, -8951457, -14014425 });
        compareFiles2(orig, files);
        logger.debug("Total files: " + files.size());
        logger.debug("Total duplicates: " + duplicates.size());
        logger.debug("End duplicates...");
    }

    private void processFolder(Path root, Collection<File> files) {
        List<File> list = new ArrayList<>(/*
                                          * new Comparator<File>() {
                                          * 
                                          * @Override public int compare(File o1,
                                          * File o2) { return
                                          * o1.getName().compareTo(o2.getName());
                                          * } }
                                          */);
        try {
            Files.walkFileTree(root, new AnyFileVisitor(files));
        } catch (IOException e) {
            logger.error("Error processing path: " + root, e);
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

    private Map<IKey, Collection<File>> compareFiles(Collection<File> files) {
        final Map<IKey, Collection<File>> result = new HashMap<IKey, Collection<File>>();
        files.stream().forEach(f -> {
            IKey key = new NameSizeKey(f);
            if (result.get(key) == null) {
                result.put(key, new ArrayList<File>());
            }
            result.get(key).add(f);
        });
        return result.entrySet().stream().filter(new Predicate<Entry<IKey, Collection<File>>>() {
            @Override
            public boolean test(Entry<IKey, Collection<File>> t) {
                return t.getValue().size() > 1;
            }
        }).collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
    }

    private void compareFiles2(File orig, Collection<File> files) {
        final Map<IKey, Collection<File>> result = new HashMap<IKey, Collection<File>>();
        files.stream().forEach(f -> calculateDistance(orig.getColorSchema(), f.getColorSchema()));
    }

    private long calculateDistance(int[] r1, int[] r2) {
        long res = 0;
        for (int i = 0; i < r1.length; i++) {
            logger.debug("r1=" + r1[i] + ", r2=" + r2[i] + ": " + (r1[i] - r2[i]) * (r1[i] - r2[i]));
            res += (r1[i] - r2[i]) * (r1[i] - r2[i]);
        }
        logger.debug("" + res);
        res = Math.round(Math.sqrt(res));
        logger.debug("Distance: " + res);
        return res;
    }

    private void printDuplicates(Map<IKey, Collection<File>> duplicates) {
        duplicates.entrySet().stream().forEach(e -> {
            logger.debug("Duplicate entry: " + e.getKey());
            e.getValue().stream().forEach(f -> logger.debug("\t" + f.getPath()));
        });
    }

    public static void main(String[] args) {
        new PhotoFileManager().scanFiles();
    }
}
