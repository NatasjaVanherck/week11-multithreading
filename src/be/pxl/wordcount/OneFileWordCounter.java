package be.pxl.wordcount;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class OneFileWordCounter extends Thread {

	private Path filePath;
	private int result;

	public OneFileWordCounter(Path file) {
		this.filePath = file;
	}

	@Override
	public void run() {
		int count = 0;
		try (BufferedReader reader = Files.newBufferedReader(filePath)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (line.toUpperCase().contains("SLEEP")) {
					try {
						Thread.sleep(1000);
						System.out.println("We gaan slapen");
					} catch (InterruptedException e) {
						System.out.println("Cannot count words in file " + filePath.getFileName());
					}
				}
				String[] splitLine = line.split("[\\s+]"); // negeert meerdere
															// spaties en tabs
				count = splitLine.length;
			}
			result = count;
			System.out.println("Er zijn " + count + " woorden geteld in " + filePath.getFileName());
		} catch (IOException ex) {
			System.out.println("Cannot count words in file " + filePath.getFileName());
		}
	}

	public int getResult() {
		return result;
	}
}
