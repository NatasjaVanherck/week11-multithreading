package be.pxl.multithreading.voorbeeld3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimerTask;

import javax.swing.JOptionPane;

public class AllesOnderControle extends TimerTask {
	private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("hh:mm");
	
	@Override
	public void run() {
		String infoMessage = FORMAT.format(LocalDateTime.now()) ;
		infoMessage += " en we hebben nog altijd alles onder controle";
		JOptionPane.showMessageDialog(null, infoMessage, "Boodschap" , JOptionPane.INFORMATION_MESSAGE);
	}

}
