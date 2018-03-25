
public class Quote {

	private String date;
	private int rank;
	private double start_price;
	private double end_price;
	
	public Quote(String date, int rank, double start_price, double end_price) {
		this.date = date;
		this.rank = rank;
		this.start_price = start_price;
		this.end_price = end_price;
	}
	
	public String toString() {
		return "Date: "+date+"\nRank: "+rank+"\nStart Price: "+start_price+"\nEnd Price: "+end_price;
	}

}
