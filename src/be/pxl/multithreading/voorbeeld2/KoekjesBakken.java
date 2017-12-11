package be.pxl.multithreading.voorbeeld2;

public class KoekjesBakken {
	public static void main(String[] args) {
		Koekjesdoos koekjesdoos = new Koekjesdoos();
		Bakker bakker = new Bakker(koekjesdoos);
		new Thread(bakker).start();
		new Kind("Bram", koekjesdoos).start();
		new Kind("Ann", koekjesdoos).start();
		new Kind("Sofie", koekjesdoos).start();
		new Kind("Tom", koekjesdoos).start();			
	}
}
