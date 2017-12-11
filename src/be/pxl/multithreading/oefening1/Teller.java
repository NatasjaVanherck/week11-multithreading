package be.pxl.multithreading.oefening1;

public class Teller extends Thread{
	private String name;
	private BankLine theLine;
	
	public Teller (BankLine line, String name){
		this.name = name;
		this.theLine = line;
	}
	
	public void run(){
		while(true){
			try {
				Customer customer = theLine.provideCustomer();
				if (customer == null){
					Thread.sleep(2000);
				} else {
					System.out.println("Customer " + customer.getName() 
					+ " is being helped by " + name);
					Thread.sleep(customer.getTransactionTime());
					System.out.println(name + " finished helping customer "
					+ customer.getName());
				}
			} catch( InterruptedException ex) {
				// just continue on
			}
		}
	}
}
