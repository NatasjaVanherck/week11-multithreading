package be.pxl.multithreading.voorbeeld2;

import be.pxl.multithreading.voorbeeld1.OutputColor;

public class Kind extends Thread {
	
	private Koekjesdoos koekjesdoos;
	private String naam;

	public Kind(String naam, Koekjesdoos koekjesdoos) {
		this.koekjesdoos = koekjesdoos;
		this.naam = naam;
	}

	@Override
	public void run() {
		int totaalKoekjes = 5;
		while(totaalKoekjes > 0) {
			if (koekjesdoos.neemKoekje(this)) {
				totaalKoekjes--;
			}
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		print(naam + "heeft buikpijn");
	}

	private void print(String text) {
		System.out.println(OutputColor.GREEN.getColorCode() + " " + text + " " + OutputColor.BLACK.getColorCode());

	}
	
	public String getNaam() {
		return naam;
	}
}
