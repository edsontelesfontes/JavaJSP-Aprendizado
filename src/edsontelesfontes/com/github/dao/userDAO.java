package edsontelesfontes.com.github.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edsontelesfontes.com.github.beans.User;

public class UserDAO extends AbstractDAO {

	//BLOCO DE CRIAÇÃO DE UM NOVO USUÁRIO
	public void newUser(User User) {
		Connection doConnection = null;
		PreparedStatement doStatement = null;
		
		try {
			doConnection = getConnection();
			doStatement = doConnection.prepareStatement("INSERT INTO user (username, userlogin, password) VALUES (?,?,?)");
			
			doStatement.setString(1, User.getuserName());
			doStatement.setString(2, User.getuserLogin());
			doStatement.setString(3, User.getuserPassword());
			doStatement.executeUpdate();
			
		} catch (SQLException e) {
			try {
				doConnection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Falha na realização da query");
		} finally {
			closeResources(doConnection, doStatement, null);
		}
		
	}
	
	// VALIDAÇÃO DE LOGIN
	public boolean validLogin (String UserName, String Password) throws Exception {
		Connection doConnection = null;
		PreparedStatement doStatement = null;
		ResultSet doResultSet = null;
		
		doConnection = getConnection();
		doStatement = doConnection.prepareStatement("SELECT * FROM user where userlogin= '"+UserName+"' AND password= '"+Password+"'");
		doResultSet = doStatement.executeQuery();
	
			if(doResultSet.next()) {
				return true;
			} else {
				return false;
			}
			
	}
}
