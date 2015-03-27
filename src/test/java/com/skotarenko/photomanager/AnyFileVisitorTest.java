package com.skotarenko.photomanager;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class AnyFileVisitorTest {

	public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
		return null;
	}

}
