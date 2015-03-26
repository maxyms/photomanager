package com.skotarenko.photomanager;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Collection;
import java.util.Date;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;

public class AnyFileVisitor extends SimpleFileVisitor<Path> {

	private Collection<File> collection;

	public AnyFileVisitor(Collection<File> collection) {
		this.collection = collection;
	}

	@Override
	public FileVisitResult visitFile(Path path, BasicFileAttributes attrs)
			throws IOException {
		if (Files.isDirectory(path)) {
			Files.walkFileTree(path, this);
		} else {
			File f = new File();
			f.setName(path.getFileName().toString());
			f.setPath(path.toAbsolutePath().toString());
			f.setSize(Files.size(path));
			FileTime fTime = (FileTime) Files
					.getAttribute(path, "creationTime");
			f.setCreatedDate(new Date(fTime.toMillis()));
			calculateColorSchema(path);
			collection.add(f);
		}
		return FileVisitResult.CONTINUE;
	}

	private Point[] getPattern() {
		final int distribution = 2;
		final int size = 300;
		// Point[] points = new Point[distribution*distribution];
		// int offset = size/(distribution*2);
		// for (int i=0;i<distribution*distribution;i++){
		// int x = ((i%2)+1)*offset < size ? i*offset : ;
		// points[i] = new Point(offset, offset);
		// }
		Point[] points = new Point[] { new Point(75, 75), new Point(75, 225),
				new Point(225, 75), new Point(225, 225) };
		return points;
	}

	private int[] calculateColorSchema(Path p) throws IOException {
		BufferedImage image = scale(p);
		Point[] pattern = getPattern();
		int[] rgbs = new int[pattern.length];

		for (int i = 0; i < pattern.length; i++) {
			Point point = pattern[i];
			rgbs[i] = image.getRGB(point.x, point.y);

		}
		return rgbs;
	}

	private BufferedImage scale(Path p) throws IOException {

		BufferedImage image = ImageIO.read(p.toFile());
		System.out.println("Before scaling :" + image.getHeight() + " "
				+ image.getWidth());

		BufferedImage scaled = Scalr.resize(image, Scalr.Mode.FIT_EXACT, 300,
				300);
		System.out.println("After scaling :" + scaled.getHeight() + " "
				+ scaled.getWidth());

		return scaled;
	}

	// private Color averageAround(BufferedImage image, double px, double py) {
	//
	//
	//
	//
	// // Get an iterator for the image.
	// RandomIter iterator = RandomIterFactory.create(i, null);
	// // Get memory for a pixel and for the accumulator.
	// double[] pixel = new double[3];
	// double[] accum = new double[3];
	// // The size of the sampling area.
	// int sampleSize = 15;
	// int numPixels = 0;
	// // Sample the pixels.
	// for (double x = px * baseSize - sampleSize; x < px * baseSize
	// + sampleSize; x++) {
	// for (double y = py * baseSize - sampleSize; y < py * baseSize
	// + sampleSize; y++) {
	// iterator.getPixel((int) x, (int) y, pixel);
	// accum[0] += pixel[0];
	// accum[1] += pixel[1];
	// accum[2] += pixel[2];
	// numPixels++;
	// }
	// }
	// // Average the accumulated values.
	// accum[0] /= numPixels;
	// accum[1] /= numPixels;
	// accum[2] /= numPixels;
	// return new Color((int) accum[0], (int) accum[1], (int) accum[2]);
	// }

}
