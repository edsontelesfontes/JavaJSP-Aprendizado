package edsontelesfontes.com.github.filters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import edsontelesfontes.com.github.dao.AbstractDAO;
@WebFilter("/*")

public class FilterConnection extends AbstractDAO implements javax.servlet.Filter{
	private static Connection doFilterConnection;
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
		chain.doFilter(request, response);
		doFilterConnection.commit();
		}
		catch (Exception e){
			try {
				doFilterConnection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		try {
			doFilterConnection = getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
