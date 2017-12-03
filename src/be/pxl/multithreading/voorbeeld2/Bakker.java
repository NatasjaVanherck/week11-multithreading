package be.pxl.multithreading.voorbeeld2;

import be.pxl.multithreading.voorbeeld1.OutputColor;

public class Bakker implements Runnable {

	private Koekjesdoos koekjesdoos;

	public Bakker(Koekjesdoos koekjesdoos) {
		this.koekjesdoos = koekjesdoos;
	}

	@Override
	public void run() {
		while (true) {
			print("Maak deeg");
			sleep();
			print("Koekjes in oven");
			sleep();
			koekjesdoos.voegKoekjesToe(5);
		}
	}

	private void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void print(String text) {
		System.out.println(OutputColor.CYAN.getColorCode() + " " + text + " " + OutputColor.BLACK.getColorCode());

	}

}
