package com.skotarenko.photomanager;

import java.util.List;
import java.util.Map.Entry;

public class Comparision {
	private String name;
	private List<File> files;
	private String type;
	private Double accuracy;

	public Comparision(Entry<String, List<File>> t, String type) {
		name = t.getKey();
		files = t.getValue();
		this.type = type;
		accuracy = 1.0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(Double accuracy) {
		this.accuracy = accuracy;
	}

	@Override
	public String toString() {
		return "Comparision [name=" + name + ", files=" + files + ", type="
				+ type + ", accuracy=" + accuracy + "]";
	}

}
