package com.product.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Associate {

	public String createAssociate(int idMerchant, int idProduct, Date associateDate) throws SQLException {

		String sql = "INSERT INTO associatemp (idmerch, idprod, dateaff) VALUES (?, ?, ?)";

		Connection con = Connexion.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		try {
			ps.setInt(1, idMerchant);
			ps.setInt(2, idProduct);
			ps.setDate(3, associateDate);

			ps.execute();
			return "endpoint AssociateMerchantProduct / AssociateMerchantProductMeth avec succes";

		} catch (SQLException e) {
			e.printStackTrace();
			return "endpoint AssociateMerchantProduct / AssociateMerchantProductMeth avec erreur";
		} finally {
			ps.close();
		}
	}
}
