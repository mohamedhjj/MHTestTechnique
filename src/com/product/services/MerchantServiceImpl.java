package com.product.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.Merchant;

public class MerchantServiceImpl {

	public String createMerchant(String name, String lastName, Date birthday) throws SQLException {

		Merchant newMerchant = new Merchant(name, lastName, birthday);

		String sql = "INSERT INTO merchant(create_date, lastname, name, birthdate) VALUES (current_date,?,?,?)";

		Connection con = Connexion.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		try {
			ps.setString(1, newMerchant.getLastName());
			ps.setString(2, newMerchant.getName());
			ps.setDate(3, newMerchant.getBirtdhay());
			ps.execute();
			return "endpoint Merchant / CreateMerchant avec succes " + newMerchant;

		} catch (SQLException e) {
			e.printStackTrace();
			return "endpoint Merchant / CreateMerchant avec erreur " + newMerchant;
		} finally {
			ps.close();
		}

		
	}

	public String deleteMerchant(int codeMerchant) throws SQLException {

		String sql = "DELETE FROM merchant WHERE id =?";

		Connection con = Connexion.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		try {
			ps.setInt(1, codeMerchant);
			ps.execute();
			return "endpoint Merchant / deleteMerchant avec succes " + codeMerchant;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ps.close();
		}

		return "endpoint Merchant / deleteMerchant avec erreur " + codeMerchant;
	}
	
	public String updateMerchant(int codeMerchant, String lastName, String name, Date birthday) throws SQLException {

		String sql = "UPDATE merchant SET create_date=current_date, lastname=?, name=?, birthdate=? WHERE id =?";

		Connection con = Connexion.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		try {
			ps.setString(1, lastName);
			ps.setString(2, name);
			ps.setDate(3, birthday);
			ps.setInt(4, codeMerchant);

			ps.execute();
			return "endpoint Merchant / updateMerchant avec succes " + codeMerchant;

		} catch (SQLException e) {
			e.printStackTrace();
			return "endpoint Merchant / updateMerchant avec erreur " + codeMerchant;
		} finally {
			ps.close();
		}

	}

}
