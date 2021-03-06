//Dao implementatie van persoongegevens
package hu.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.domain.PersoonsGegevens;

public class PersoonsGegevensPostgresDaoImpl extends PostgresBaseDao implements PersoonsGegevensDao{
	// haalt persoonsgegevens uit database
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
				String telefoonnummer = dbResultSet.getString("telefoonnummer");
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
	
	
//slaat persoonsgegevens op in database
	public boolean save(PersoonsGegevens persoonsGegevens) {
		try (Connection con = super.getConnection()) {
			String q = "insert into \"Persoonsgegevens\"(\"ID\", \"Straatnaam\", \"Huisnummer\", \"Postcode\", \"Woonplaats\", \"Geboortedatum\", \"Geslacht\", \"Telefoonnummer\", \"Email\", \"Linkedin\", \"Naam\") values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, persoonsGegevens.getId());
			pstmt.setString(2, persoonsGegevens.getStraatnaam());
			pstmt.setInt(3, persoonsGegevens.getHuisnummer());
			pstmt.setString(4, persoonsGegevens.getPostcode());
			pstmt.setString(5, persoonsGegevens.getWoonplaats());
			pstmt.setString(6, persoonsGegevens.getGeboortedatum());
			System.out.println("in dao: "+persoonsGegevens.getGeslacht());
			pstmt.setString(7, persoonsGegevens.getGeslacht());
			pstmt.setString(8, persoonsGegevens.getTelefoonnummer());
			pstmt.setString(9, persoonsGegevens.getEmail());
			pstmt.setString(10, persoonsGegevens.getLinkedin());
			pstmt.setString(11, persoonsGegevens.getNaam());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}

// update persoonsgegevens in de database
	public boolean update(PersoonsGegevens persoonsGegevens) {
		try (Connection con = super.getConnection()) {
			String q = "Update \"Persoonsgegevens\" SET \"Straatnaam\" = ? , \"Huisnummer\" = ?, \"Postcode\" = ?, \"Woonplaats\" = ?,"
					+ " \"Geboortedatum\" = ?, \"Geslacht\" = ?, \"Telefoonnummer\" = ?, \"Email\" = ?, \"Linkedin\" = ? , \"Naam\" = ? where \"ID\" = ?;";
			System.out.println(q);
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, persoonsGegevens.getStraatnaam());
			pstmt.setInt(2, persoonsGegevens.getHuisnummer());
			pstmt.setString(3, persoonsGegevens.getPostcode());
			pstmt.setString(4, persoonsGegevens.getWoonplaats());
			pstmt.setString(5, persoonsGegevens.getGeboortedatum());
			pstmt.setString(6, persoonsGegevens.getGeslacht());
			pstmt.setString(7, persoonsGegevens.getTelefoonnummer());
			pstmt.setString(8, persoonsGegevens.getEmail());
			pstmt.setString(9, persoonsGegevens.getLinkedin());
			pstmt.setString(10, persoonsGegevens.getNaam());
			pstmt.setInt(11, persoonsGegevens.getId());
			pstmt.executeUpdate();
			return true;
		} catch (Exception exc) {
			exc.printStackTrace();
			System.err.println(exc.toString());
			System.err.println(exc.getMessage());
			return false;
		}
	}
	
// verwijdert persoonsgegevens uit database
	public boolean delete(PersoonsGegevens persoonsGegevens) {
		try(Connection con = super.getConnection()){
			String q = "delete from \"Persoonsgegevens\" where \"ID\" = ?";
			System.out.println(q);
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, persoonsGegevens.getId());
			pstmt.executeUpdate();
			return true;
		} catch (Exception exc) {
			exc.printStackTrace();
			System.err.println(exc.toString());
			System.err.println(exc.getMessage());
			return false;
		}
	}

}
