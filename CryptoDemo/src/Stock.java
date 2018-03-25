import java.util.ArrayList;
import java.util.List;

public class Stock {

	private String id;
	private String name;
	private String symbol;
	List <Quote> quotes = new ArrayList<Quote>();
	
	public Stock(String id, String name, String symbol) {
		this.id = id;
		this.name = name;
		this.symbol = symbol;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getSymbol() {
		return this.symbol;
	}
	
	public void setDetails(String date, int rank, double start_price, double end_price) {
		/**
		 * TODO: Create class to store history of this stock.
		 */
		quotes.add(new Quote(date, rank, start_price, end_price));
	}
	
	public void printDetails() {
		System.out.println("****"+this.name+"****");
		for (Quote quote : quotes) {
			System.out.println(quote);
		}
	}
	
	public String toString () {
		return this.name;
	}
	
}
