package com.product.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductServiceImpl {

	public String createProduct(String label, Double unitPrice, String currency, Double weight, Double height)
			throws SQLException {

		String sql = "INSERT INTO product (create_date, label, unit_price, currency, weight, height) VALUES (current_date, ?, ?, ?, ?, ?)";

		Connection con = Connexion.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		try {
			ps.setString(1, label);
			ps.setDouble(2, unitPrice);
			ps.setString(3, currency);
			ps.setDouble(4, weight);
			ps.setDouble(5, height);
			ps.execute();
			return "endpoint Product / CreateProduct avec succes";

		} catch (SQLException e) {
			e.printStackTrace();
			return "endpoint Product / CreateProduct avec erreur";
		} finally {
			ps.close();
		}

	}

	public String deleteProduct(int codeProduct) throws SQLException {

		String sql = "DELETE FROM product WHERE id =?";

		Connection con = Connexion.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		try {
			ps.setInt(1, codeProduct);
			ps.execute();
			return "endpoint Product / deleteProduct avec succes " + codeProduct;

		} catch (SQLException e) {
			e.printStackTrace();
			return "endpoint Product / deleteProduct avec erreur " + codeProduct;
		} finally {
			ps.close();
		}

		
	}

	public String updateProduct(int codeProduct, String label, Double unitPrice, String currency, Double weight,
			Double height) throws SQLException {

		String sql = "UPDATE product SET create_date=current_date, label=?, unit_price=?, currency=?, weight=?, height=? WHERE id =?";

		Connection con = Connexion.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		try {
			ps.setString(1, label);
			ps.setDouble(2, unitPrice);
			ps.setString(3, currency);
			ps.setDouble(4, weight);
			ps.setDouble(5, height);
			ps.setInt(6, codeProduct);

			ps.execute();
			return "endpoint Product / updateMProduct avec succes " + codeProduct;

		} catch (SQLException e) {
			e.printStackTrace();
			return "endpoint Product / updateMProduct avec erreur " + codeProduct;
		} finally {
			ps.close();
		}

	}

}
