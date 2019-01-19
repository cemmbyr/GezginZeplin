package denemeler;

public class Zeplin {
	int passengers; //yolcusayýsý
	double fuelCost; //yakýtmasrafý
	double profit; //kar
	double ticketPrice; //biletfiyatý
	public Zeplin(int incomingPassengers){
		this.fuelCost = 0.0;
		this.profit = 0.0;
		this.passengers = incomingPassengers;
		this.ticketPrice = 0.0;
	}
	public void setfuelCost(double distance){
		this.fuelCost = distance * 10;
	}
	public void setTicketPrice(){
		this.ticketPrice = (this.fuelCost / this.passengers)*1.5;
	}
	public void setProfit(int preSetTicketPrice){
		this.ticketPrice = preSetTicketPrice;
		this.profit = (this.ticketPrice * this.passengers) - this.fuelCost;
	}
}
