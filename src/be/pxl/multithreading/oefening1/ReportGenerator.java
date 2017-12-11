package be.pxl.multithreading.oefening1;

public class ReportGenerator extends Thread {
	private BankLine line;
	private int reportWait;
	
	public ReportGenerator(BankLine line, int reportWait){
		this.line = line;
		this.reportWait = reportWait;
	}
	
	public void run(){
		while(true){
			try {
				Thread.sleep(reportWait);
				System.out.println(line.toString());
			} catch( InterruptedException ex) {
				// just continue on
			}
		}
	}

}
