import java.sql.Connection;
import java.sql.DriverManager;

public class SqlConnect {

	public static Connection connector() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:Latesco.sqlite");
			return conn;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
