package com.skotarenko.photomanager;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Predicate;

public class PhotoFileManager {
	private void scanFiles() {
		Map<String, List<File>> files = new HashMap<>();
		List<Path> roots = Arrays.asList(new Path[] {
				Paths.get("C:/Users/maxyms/documents/photos"),
				Paths.get("C:/Users/maxyms/documents/photos2")
		// Paths.get("E:/data/photo"), Paths.get("E:/data/photo_mom")
				});
		roots.stream().forEach(p -> processFolder(p, files));
		System.out.println("Find duplicates...");
		compareFiles(files);
		System.out.println("End duplicates...");
		// System.out.println(files);
	}

	private void processFolder(Path root, Map<String, List<File>> files) {
		List<File> list = new ArrayList<>(/*
										 * new Comparator<File>() {
										 * 
										 * @Override public int compare(File o1,
										 * File o2) { return
										 * o1.getName().compareTo(o2.getName());
										 * } }
										 */);
		try {
			Files.walkFileTree(root, new AnyFileVisitor(list));
		} catch (IOException e) {
			e.printStackTrace();
		}
		list.stream().forEach(p -> {
			if (files.get(p.getName()) == null) {
				files.put(p.getName(), new ArrayList<File>());
			}
			files.get(p.getName()).add(p);
		});
		System.out.println("Total files: " + list.size());
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

	private void compareFiles(Map<String, List<File>> files) {

		files.entrySet().stream()
				.filter(new Predicate<Entry<String, List<File>>>() {
					@Override
					public boolean test(Entry<String, List<File>> t) {
						boolean byName = t.getValue().size() > 1;
						Set<File> duplicates = new HashSet<>();
						if (byName) {
							t.getValue().stream()
									.forEach(f -> duplicates.add(f));
						}
						return byName
								&& duplicates.size() < t.getValue().size();
					}
				}).forEach(p -> printDuplicates(p));
	}

	private void printDuplicates(Entry<String, List<File>> entry) {
		System.out.println("Duplicate: " + entry.getKey());
		PrintStream ps = new PrintStream(System.out, true);
		entry.getValue().stream().forEach(f -> ps.println("\t" + f.getPath()));
	}

	public static void main(String[] args) {
		new PhotoFileManager().scanFiles();
	}
}
