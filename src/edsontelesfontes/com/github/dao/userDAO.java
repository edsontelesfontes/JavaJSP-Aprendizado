package edsontelesfontes.com.github.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edsontelesfontes.com.github.beans.userBeans;

public class userDAO extends abstractDAO {

	//BLOCO DE CRIAÇÃO DE UM NOVO USUÁRIO
	public void newUser(userBeans userBeans) {
		Connection doConnection = null;
		PreparedStatement doStatement = null;
		
		try {
			doConnection = getConnection();
			doStatement = doConnection.prepareStatement("INSERT INTO user (username, userlogin, password) VALUES (?,?,?)");
			
			doStatement.setString(1, userBeans.getuserName());
			doStatement.setString(2, userBeans.getuserLogin());
			doStatement.setString(3, userBeans.getuserPassword());
			doStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Falha na realização da query");
			e.printStackTrace();
		} finally {
			closeResources(doConnection, doStatement, null);
		}
		
	}
	
	// VALIDAÇÃO DE LOGIN
	public boolean validLogin (userBeans userBeans) throws Exception {
		Connection doConnection = null;
		PreparedStatement doStatement = null;
		ResultSet doResultSet = null;
		
		doConnection = getConnection();
		doStatement = doConnection.prepareStatement("SELECT * FROM user where userlogin= '"+userBeans.getuserLogin()+"' AND password= '"+userBeans.getuserPassword()+"'");
		doResultSet = doStatement.executeQuery();
	
			if(doResultSet.next()) {
				return true;
			} else {
				return false;
			}
	}
}
