package be.pxl.wordcount;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WordCount {

	public static void main(String[] args) {
		Path myHomeDir = Paths.get(System.getProperty("user.home"));
		Path dir = myHomeDir.resolve("Desktop/Informatica/Java advanced/oefeningen/week 11/wordcount");
		List<Thread> runningThreads = new ArrayList<>();
		
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)){
			for (Path file : stream) {
				OneFileWordCounter thread = new OneFileWordCounter(file);
				thread.start();
				runningThreads.add(thread);
			}
		} catch (IOException | DirectoryIteratorException x){
			System.err.println(x);
		}
		
		int totalWordCount = 0;
		for(Thread aRunningThread : runningThreads){
			try{
				aRunningThread.join();
				totalWordCount += ((OneFileWordCounter)aRunningThread).getResult();
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		System.out.println("De totale woorden: " + totalWordCount);
	}
}
