package edsontelesfontes.com.github.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO {
// public static final String url = "localhost:3306?useTimezone=true&amp;serverTimezone=UTC";
 //public static final String user = "root";
 //public static final String password = "" ;
 
	public Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection createConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testes?useTimezone=true&serverTimezone=UTC",
				      "root", "");	
			return createConnection;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	

	}

	public void closeResources (Connection createConnection,
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
