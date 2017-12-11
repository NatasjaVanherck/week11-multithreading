package be.pxl.multithreading.voorbeeld3;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class MessageTimer {

	public static void main(String[] args) {
		Timer timer = new Timer(true);
		
		ZonedDateTime dateTime = ZonedDateTime.now().plusSeconds(5);
		long period = TimeUnit.MILLISECONDS.convert(30, TimeUnit.SECONDS);
		
		timer.schedule(new AllesOnderControle(), Date.from(dateTime.toInstant()), period);
		
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
