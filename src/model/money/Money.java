package model.money;

/* Classe per la gestione del denaro TODO*/
public abstract class Money {
	private double amount;
	
	public Money(double amount){
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public abstract String toString();
}