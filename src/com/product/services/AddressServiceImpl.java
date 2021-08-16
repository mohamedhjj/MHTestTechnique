package com.product.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddressServiceImpl {

	public String createAddress(int addNum, String street, String zipcode, int merchantcode) throws SQLException {

		String sql = "INSERT INTO address (addnumber, street, zipcode, merchantcode) VALUES (?, ?, ?, ?)";

		Connection con = Connexion.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		try {
			ps.setInt(1, addNum);
			ps.setString(2, street);
			ps.setString(3, zipcode);
			ps.setInt(4, merchantcode);

			ps.execute();
			return "endpoint Address / CreateAddress avec succes";

		} catch (SQLException e) {
			e.printStackTrace();
			return "endpoint Address / CreateAddress avec erreur";
		} finally {
			ps.close();
		}

		
	}

	public String deleteAddress(int codeAddress) throws SQLException {

		String sql = "DELETE FROM address WHERE id =?";

		Connection con = Connexion.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		try {
			ps.setInt(1, codeAddress);
			ps.execute();
			return "endpoint Address / deleteAddress avec succes " + codeAddress;

		} catch (SQLException e) {
			e.printStackTrace();
			return "endpoint Address / deleteAddress avec erreur " + codeAddress;
		} finally {
			ps.close();
		}

		
	}

	public String updateAddress( int codeAddress,int addNum, String street, String zipcode, int merchantcode) throws SQLException {

		String sql = "UPDATE address SET addnumber=?, street=?, zipcode=?, merchantcode=? WHERE id =?";

		Connection con = Connexion.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		try {
			ps.setInt(1, addNum);
			ps.setString(2, street);
			ps.setString(3, zipcode);
			ps.setInt(4, merchantcode);
			ps.setInt(5, codeAddress);

			ps.execute();
			return "endpoint Address / updateAddress avec succes " + codeAddress;

		} catch (SQLException e) {
			e.printStackTrace();
			return "endpoint Address / updateAddress avec erreur " + codeAddress;
		} finally {
			ps.close();
		}

		
	}

}
