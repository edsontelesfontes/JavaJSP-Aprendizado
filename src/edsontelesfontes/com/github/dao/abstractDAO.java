package edsontelesfontes.com.github.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class abstractDAO {
 public static final String url = "\"jdbc:mysql://localhost:3306/";
 public static final String user = "";
 public static final String password = "" ;
 
	protected Connection getConnection() throws SQLException {
		
		Connection createConnection = DriverManager.getConnection(url, user, password);
		return createConnection;
		
	}

	protected void closeResources (Connection createConnection,
		      Statement doPreparedStatement, ResultSet doResultSet) {
		if(createConnection != null) {
			try {
				createConnection.close();
			} catch (Exception e) {
				System.out.println("Falha ao fechar a conexão!");
			}
		}
		if(doPreparedStatement != null) {
			try {
				doPreparedStatement.close();
			} catch (Exception e) {
				System.out.println("Falha ao fechar a Statement");
			}
		}
		if(doResultSet != null) {
			try {
				doResultSet.close();
			} catch (Exception e) {
				System.out.println("Falha ao fechar o resultset");
			}
		}
	}
}
