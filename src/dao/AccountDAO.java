package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import connect.DBConnect;
import model.Account;


public class AccountDAO {
	// kt username
	
	 public static boolean checkUserName(String username) throws SQLException{
		    Connection connection = DBConnect.getConnection();
		    String sql = "SELECT * FROM Account WHERE UserName = '" + username + "'";
		    PreparedStatement ps;
		    try {
		        ps = connection.prepareCall(sql);
		        ResultSet rs = ps.executeQuery();
		        while(rs.next()){
		            connection.close();
		            return true;
		        }
		    } catch (SQLException ex) {
		        Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE,null, ex);
		    }
		    return false;
		    }
	 // add account
	 public static boolean insertAcc(Account ac) {
	        Connection connection = DBConnect.getConnection();
	        String sql = "INSERT INTO Account VALUES(?,?,?)";
	        try {
	            PreparedStatement ps = connection.prepareCall(sql);
	            ps.setString(1, ac.getUserName());
	            ps.setString(2, ac.getUserPassword());
	            ps.setInt(3, ac.getUserRole());
	            ps.executeUpdate();
	            return true;
	        } catch (SQLException ex) {
	            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return false;
	    }
	 
	 // id tang
	public static int LayIdTang(){
			Connection connection = DBConnect.getConnection();
			int i = 0;
			try {
				Statement stm = connection.createStatement();
				String sql = "Select MAX(Account_ID) FROM Account";
				ResultSet rs = stm.executeQuery(sql);
				while(rs.next()){
					i = rs.getInt(1);			
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return i;
		}
	
	//kt dang nhap
	public static boolean CheckLogin(String username, String password) {
		Connection con = DBConnect.getConnection();
		String sql = "select * from Account where UserName='" + username + "' and User_Password='" + password + "'";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				con.close();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public static Account getAccByUsername(String username)
	{
		Connection con = DBConnect.getConnection();
		try {
			Statement stm = con.createStatement();
			String sql = "select * from Account where UserName='"+username+"'";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				Account ac = new Account();
				ac.setAccountID(rs.getInt("Account_ID"));
				ac.setUserName(rs.getString("UserName"));
				ac.setUserPassword(rs.getString("User_Password"));
				ac.setUserRole(rs.getInt("User_Role"));
				return ac;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		System.out.println(getAccByUsername("phuong")); 
	}
	
}
