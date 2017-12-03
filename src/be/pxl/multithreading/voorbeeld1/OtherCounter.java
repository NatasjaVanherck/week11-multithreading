package be.pxl.multithreading.voorbeeld1;

public class OtherCounter implements Runnable {
	private OutputColor outputColor;
	private int value;

	public OtherCounter(OutputColor outputColor, int value) {
		this.outputColor = outputColor;
		this.value = value;
	}

	@Override
	public void run() {
		try {
			for (int i = value; i >= 0; i--) {
				print("Printing the count " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			print("My thread interrupted");
		}
		print("My thread run is over");

	}

	private void print(String text) {
		System.out.println(outputColor.getColorCode() + " " + text + " " + OutputColor.BLACK.getColorCode());

	}
}
