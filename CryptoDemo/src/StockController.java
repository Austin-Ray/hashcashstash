/**
 * Author: Sam Pann
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.json.*;

public class StockController {

	private Connection connection;
	public static List<Stock> stocks = new ArrayList<Stock>();
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	public StockController() {
		connection = SqlConnect.connector();
		if (connection == null) {
			System.exit(1);
		}
	}
	
	public boolean isDbConnected() {
		try {
			return !connection.isClosed();
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void start() {
		try {
			this.populateStocks();
			this.getApi();
			this.populateHistory();
		} catch (Exception e) {
			System.out.println("Cannot complete update");
		}
		
		for (Stock stock : stocks) {
			stock.printDetails();
		}
	}
	
	private void populateStocks() {
		PreparedStatement ps = null;
		String query = "select distinct(stock_id),name,symbol from currency";
		
		
		try {
			ps = connection.prepareStatement(query);
			ResultSet result = ps.executeQuery();
			
			while (result.next()) {
				stocks.add(new Stock(result.getString("stock_id"),result.getString("name"),result.getString("symbol")));
				System.out.println("Added "+result.getString("name")+"to the stocks list.");
			}
		} catch (SQLException e) {
			System.out.println("Unable to populate stocks");
		}
	}
	
	public void getApi(String requestSymbol) {
		
		Timestamp current = new Timestamp(System.currentTimeMillis());
		String currentFormat = formatter.format(current);
		
		try {
			URL url = new URL("https://api.coinmarketcap.com/v1/ticker/"+requestSymbol+"/");
			URLConnection urlConn = url.openConnection();
			
			InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
			BufferedReader buff = new BufferedReader(inStream);
			
			String line = buff.readLine();
			String testString = "";
			while (line != null) {
				if (line.contains("[") || line.contains("]")) {
					line = buff.readLine();
					continue;
				}
				testString += line;
				line = buff.readLine();
			}
			
			JSONObject jsonObject = new JSONObject(testString);
			
			String id = jsonObject.get("id").toString();
			String name = jsonObject.get("name").toString();
			String symbol = jsonObject.get("symbol").toString();
			int rank = Integer.valueOf(jsonObject.get("rank").toString());
			Double end_price = Double.valueOf(jsonObject.get("price_usd").toString()); //end price ???
			Double start_price = end_price + (end_price * Double.valueOf(jsonObject.get("percent_change_24h").toString()));		// endprice + (endprice * this)????
			
//			System.out.println(id+"\t"+name+"\t"+symbol+"\t"+rank+"\t"+end_price+"\t"+start_price);
			
			if (insertDatabase(id, currentFormat, name, symbol, rank, start_price,end_price)) {
				System.out.println("Added "+id+" successfully on "+currentFormat);
			} else {
				System.out.println("Unable to put in data for "+requestSymbol);
			}
			
		} catch (Exception e) {
			System.out.println("Unable to get "+requestSymbol);
		}	
		
		System.out.println("Retrieval complete");
	}
	
	private boolean insertDatabase(String id, String date, String name, String symbol, int rank, double start_price, double end_price) throws SQLException{
		PreparedStatement ps = null;
		String query = "insert into currency values (?,?,?,?,?,?,?)";
		
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, date);
			ps.setString(3, name);
			ps.setString(4, symbol);
			ps.setInt(5, rank);
			ps.setDouble(6, start_price);
			ps.setDouble(7, end_price);
			ps.execute();
			
			return true;
		} catch (Exception e){
			System.out.println("Unable to add to database");
			return false;
		} finally {
			ps.close();
		}
		
		
	}
	
	private void getApi() {
		
		Timestamp current = new Timestamp(System.currentTimeMillis());
		String currentFormat = formatter.format(current);
		
		for (Stock stock : stocks) {
			try {
				URL url = new URL("https://api.coinmarketcap.com/v1/ticker/"+stock.getId()+"/");
				URLConnection urlConn = url.openConnection();
				
				InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
				BufferedReader buff = new BufferedReader(inStream);
				
				String line = buff.readLine();
				String testString = "";
				while (line != null) {
					if (line.contains("[") || line.contains("]")) {
						line = buff.readLine();
						continue;
					}
					testString += line;
					line = buff.readLine();
				}
				
				JSONObject jsonObject = new JSONObject(testString);
				
				String id = jsonObject.get("id").toString();
				String name = jsonObject.get("name").toString();
				String symbol = jsonObject.get("symbol").toString();
				int rank = Integer.valueOf(jsonObject.get("rank").toString());
				Double end_price = Double.valueOf(jsonObject.get("price_usd").toString()); //end price ???
				Double start_price = end_price + (end_price * (Double.valueOf(jsonObject.get("percent_change_24h").toString())/100));		// endprice + (endprice * this)????
				
	//			System.out.println(id+"\t"+name+"\t"+symbol+"\t"+rank+"\t"+end_price+"\t"+start_price);
				
				if (updateDatabase(id, currentFormat, name, symbol, rank, start_price,end_price)) {
					System.out.println("Added "+id+" successfully on "+currentFormat);
				} else {
					System.out.println(id +" already updated");
				}
				
			} catch (Exception e) {
				System.out.println("Unable to update "+stock.getName());
			}	
			
			System.out.println("Update complete");
		
		}
		
	}
	
	private boolean updateDatabase(String id, String date_time, String name, String symbol, int rank, double start_price, double end_price) throws SQLException {
		PreparedStatement ps = null;
		String query = "insert into currency values (?,?,?,?,?,?,?)";
		
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, date_time);
			ps.setString(3, name);
			ps.setString(4, symbol);
			ps.setInt(5, rank);
			ps.setDouble(6, start_price);
			ps.setDouble(7, end_price);
			ps.execute();
			
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			ps.close();
		}
	}
	
	private void populateHistory() throws SQLException {
		PreparedStatement ps = null;
		String query = "select date_time,rank,current_price,sod_price from currency where stock_id = ?";
		
		for (Stock stock : stocks) {
			try {
			
				ps = connection.prepareStatement(query);
				ps.setString(1, stock.getId());
				ResultSet result = ps.executeQuery();
				
				while (result.next()) {
					String date = result.getString("date_time");
					int rank = result.getInt("rank");
					double end_price = result.getDouble("current_price");
					double start_price = result.getDouble("sod_price");
					
					stock.setDetails(date, rank, start_price, end_price);
				}
			} catch (Exception e) {
				System.out.println("Unable to pull details from database");
			} finally {
				ps.close();
			}
		}
	}
}
