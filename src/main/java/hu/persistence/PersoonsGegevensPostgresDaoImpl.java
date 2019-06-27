package hu.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import hu.domain.PersoonsGegevens;

public class PersoonsGegevensPostgresDaoImpl extends PostgresBaseDao implements PersoonsGegevensDao{
	public List<PersoonsGegevens> selectGegevens() {
		List<PersoonsGegevens> result = new ArrayList<PersoonsGegevens>();
		String query = "Select * from \"Persoonsgegevens\"";

		try (Connection con = super.getConnection()) {
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet dbResultSet = pstmt.executeQuery();

			while (dbResultSet.next()) {
				int id = dbResultSet.getInt("id");
				String naam = dbResultSet.getString("naam");
				String straatnaam = dbResultSet.getString("straatnaam");
				int huisnummer = dbResultSet.getInt("huisnummer");
				String postcode = dbResultSet.getString("postcode");
				String woonplaats = dbResultSet.getString("woonplaats");
				String geboortedatum = dbResultSet.getString("geboortedatum");
				String geslacht = dbResultSet.getString("geslacht");
				int telefoonnummer = dbResultSet.getInt("telefoonnummer");
				String email = dbResultSet.getString("email");
				String linkedin = dbResultSet.getString("linkedin");

				PersoonsGegevens pg = new PersoonsGegevens(id, naam, straatnaam, huisnummer, postcode, woonplaats,
						geboortedatum, geslacht, telefoonnummer, email, linkedin);
				result.add(pg);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return result;
	}

	public boolean save(PersoonsGegevens persoonsGegevens) {
		try (Connection con = super.getConnection()) {
			String q = "insert into Persoonsgegevens(Straatnaam, Huisnummer, Postcode, Woonplaats, Geboortedatum, Geslacht, Telefoonnummer, Email, Linkedin, Naam) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, persoonsGegevens.getStraatnaam());
			pstmt.setInt(2, persoonsGegevens.getHuisnummer());
			pstmt.setString(3, persoonsGegevens.getPostcode());
			pstmt.setString(4, persoonsGegevens.getWoonplaats());
			pstmt.setString(5, persoonsGegevens.getGeboortedatum());
			pstmt.setString(6, persoonsGegevens.getGeslacht());
			pstmt.setInt(7, persoonsGegevens.getTelefoonnummer());
			pstmt.setString(8, persoonsGegevens.getEmail());
			pstmt.setString(9, persoonsGegevens.getLinkedin());
			pstmt.setString(10, persoonsGegevens.getNaam());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}

	public boolean update(PersoonsGegevens persoonsGegevens) {
		try (Connection con = super.getConnection()) {
			String q = "Update Persoonsgegevens SET Straatnaam = ? , huisnumer = ?, Postcode = ?, Woonplaats = ?,"
					+ " Geboortedatum = ?, Geslacht = ?, Telefoonnummer = ?, Email = ?, Naam = ? where ID = ?";
			System.out.println(q);
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, persoonsGegevens.getStraatnaam());
			pstmt.setInt(2, persoonsGegevens.getHuisnummer());
			pstmt.setString(3, persoonsGegevens.getPostcode());
			pstmt.setString(4, persoonsGegevens.getWoonplaats());
			pstmt.setString(5, persoonsGegevens.getGeboortedatum());
			pstmt.setString(6, persoonsGegevens.getGeslacht());
			pstmt.setInt(7, persoonsGegevens.getTelefoonnummer());
			pstmt.setString(8, persoonsGegevens.getEmail());
			pstmt.setString(9, persoonsGegevens.getLinkedin());
			pstmt.setString(10, persoonsGegevens.getNaam());
			ResultSet dbResultSet = pstmt.executeQuery();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return true;
	}
	
	public boolean delete(PersoonsGegevens persoonsGegevens) {
		try(Connection con = super.getConnection()){
			String q = "delete from Persoonsgegevens where id = ?";
			System.out.println(q);
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, persoonsGegevens.getId());
			ResultSet dbResultSet = pstmt.executeQuery();
			return true;
		} catch (Exception exc) {
			exc.printStackTrace();
			return false;
		}
	}

}
