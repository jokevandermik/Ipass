package hu.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.domain.PersoonsGegevens;
import hu.domain.Profiel;
import hu.domain.Vaardigheid;

public class ProfielPostgresDaoImpl extends PostgresBaseDao implements ProfielDao{
	public List<Profiel> selectProfiel(){
		List<Profiel> result = new ArrayList<Profiel>();
		String query = "select \"Profiel\".* , \"Naam\", \"Straatnaam\", \"Huisnummer\", \"Postcode\", \"Woonplaats\", \"Geboortedatum\", \"Geslacht\", \"Telefoonnummer\", \"Email\", \"Linkedin\", \"Technische_vaardigheden\", \"Functionele_vaardigheden\", \"Werkervaring\", \"Computertalen\", \"Platformen\", \"Pakketen\" from \"Persoonsgegevens\",  \"Profiel\", \"Vaardigheden\" where \"Persoonsgegevens\".\"ID\" = \"Profiel\".\"Persoonsgegevens_ID\" and \"Vaardigheden\".\"ID\" = \"Profiel\".\"Vaardigheden_ID\";";
		 System.out.println("voor db connectie");
		try(Connection con = super.getConnection()){
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet dbResultSet = pstmt.executeQuery();
			System.out.println("na db connectie");
			while(dbResultSet.next()) {
				int id = dbResultSet.getInt("id");
				System.out.println("Dao: "+ dbResultSet.getInt("id"));
				int idPersoonsGegevens = dbResultSet.getInt("Persoonsgegevens_ID");
				int idVaardigheid = dbResultSet.getInt("Vaardigheden_ID");
				String eigenschappen = dbResultSet.getString("eigenschappen");
				String spreektalen	= dbResultSet.getString("spreektalen");
				int jarenErvaringIT = dbResultSet.getInt("jaren_Ervaring_IT");
				
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
				
				String technischeVaardigheden = dbResultSet.getString("Technische_vaardigheden");
				System.out.println("dao" + dbResultSet.getString("technische_vaardigheden"));
				String functioneleVaardigheden = dbResultSet.getString("functionele_vaardigheden");
				String werkervaring = dbResultSet.getString("werkervaring");
				String computertalen = dbResultSet.getString("computertalen");
				String platformen = dbResultSet.getString("platformen");
				String pakketen = dbResultSet.getString("pakketen");
				
				PersoonsGegevens pg = new PersoonsGegevens(id, naam, straatnaam, huisnummer, postcode, woonplaats,
						geboortedatum, geslacht, telefoonnummer, email, linkedin);
				
				Vaardigheid vh = new Vaardigheid(id, technischeVaardigheden, functioneleVaardigheden, werkervaring, computertalen, platformen, pakketen);
				
				Profiel pf = new Profiel(id, idPersoonsGegevens, idVaardigheid, eigenschappen, spreektalen, jarenErvaringIT);
				
				pf.setGegevens(pg);
				pf.setVaardigheden(vh);
				
				result.add(pf);
			}
		} catch(SQLException sqle) {
			sqle.printStackTrace();
			System.err.println(sqle.toString());
			System.err.println(sqle.getMessage());
		}
		return result;
	}
	
	public List<Profiel> selectProfielRelevantie(String relevantie){
		List<Profiel> result = new ArrayList<Profiel>();
		String query = "select \"Profiel\".* , \"Naam\", \"Straatnaam\", \"Huisnummer\", \"Postcode\", \"Woonplaats\", \"Geboortedatum\", \"Geslacht\", \"Telefoonnummer\", \"Email\", \"Linkedin\", \"Technische_vaardigheden\", \"Functionele_vaardigheden\", \"Werkervaring\", \"Computertalen\", \"Platformen\", \"Pakketen\" from \"Persoonsgegevens\",  \"Profiel\", \"Vaardigheden\" where \"Persoonsgegevens\".\"ID\" = \"Profiel\".\"Persoonsgegevens_ID\" and \"Vaardigheden\".\"ID\" = \"Profiel\".\"Vaardigheden_ID\" and\r\n" + 
				"	(lower(\"Technische_vaardigheden\") LIKE lower('%"+ relevantie + "%') or lower(\"Functionele_vaardigheden\") like lower('%" + relevantie + "%') or lower(\"Computertalen\") like lower('%" + relevantie + "%') or lower(\"Platformen\") like lower('%" + relevantie + "%') or lower(\"Pakketen\") like lower('%" + relevantie + "%'));";
		 System.out.println("voor db connectie");
		try(Connection con = super.getConnection()){
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet dbResultSet = pstmt.executeQuery();
			System.out.println("na db connectie");
			while(dbResultSet.next()) {
				int id = dbResultSet.getInt("id");
				System.out.println("Dao: "+ dbResultSet.getInt("id"));
				int idPersoonsGegevens = dbResultSet.getInt("Persoonsgegevens_ID");
				int idVaardigheid = dbResultSet.getInt("Vaardigheden_ID");
				String eigenschappen = dbResultSet.getString("eigenschappen");
				String spreektalen	= dbResultSet.getString("spreektalen");
				int jarenErvaringIT = dbResultSet.getInt("jaren_Ervaring_IT");
				
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
				
				String technischeVaardigheden = dbResultSet.getString("Technische_vaardigheden");
				System.out.println("dao" + dbResultSet.getString("technische_vaardigheden"));
				String functioneleVaardigheden = dbResultSet.getString("functionele_vaardigheden");
				String werkervaring = dbResultSet.getString("werkervaring");
				String computertalen = dbResultSet.getString("computertalen");
				String platformen = dbResultSet.getString("platformen");
				String pakketen = dbResultSet.getString("pakketen");
				
				PersoonsGegevens pg = new PersoonsGegevens(id, naam, straatnaam, huisnummer, postcode, woonplaats,
						geboortedatum, geslacht, telefoonnummer, email, linkedin);
				
				Vaardigheid vh = new Vaardigheid(id, technischeVaardigheden, functioneleVaardigheden, werkervaring, computertalen, platformen, pakketen);
				
				Profiel pf = new Profiel(id, idPersoonsGegevens, idVaardigheid, eigenschappen, spreektalen, jarenErvaringIT);
				
				pf.setGegevens(pg);
				pf.setVaardigheden(vh);
				
				result.add(pf);
			}
		} catch(SQLException sqle) {
			sqle.printStackTrace();
			System.err.println(sqle.toString());
			System.err.println(sqle.getMessage());
		}
		return result;
	}
	
	public List<Profiel> selectProfielZoekterm(String zoekterm){
		List<Profiel> result = new ArrayList<Profiel>();
		String query = "select \"Profiel\".* , \"Naam\", \"Straatnaam\", \"Huisnummer\", \"Postcode\", \"Woonplaats\", \"Geboortedatum\", \"Geslacht\", \"Telefoonnummer\", \"Email\", \"Linkedin\", \"Technische_vaardigheden\", \"Functionele_vaardigheden\", \"Werkervaring\", \"Computertalen\", \"Platformen\", \"Pakketen\" from \"Persoonsgegevens\",  \"Profiel\", \"Vaardigheden\" where \"Persoonsgegevens\".\"ID\" = \"Profiel\".\"Persoonsgegevens_ID\" and \"Vaardigheden\".\"ID\" = \"Profiel\".\"Vaardigheden_ID\" and\r\n" + 
				"	(lower(\"Technische_vaardigheden\") LIKE lower('%"+ zoekterm + "%') or lower(\"Functionele_vaardigheden\") like lower('%" + zoekterm + "%') or lower(\"Computertalen\") like lower('%" + zoekterm + "%') or lower(\"Platformen\") like lower('%" + zoekterm + "%') or lower(\"Pakketen\") like lower('%" + zoekterm + "%'));";
		 System.out.println("voor db connectie");
		try(Connection con = super.getConnection()){
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet dbResultSet = pstmt.executeQuery();
			System.out.println("na db connectie");
			while(dbResultSet.next()) {
				int id = dbResultSet.getInt("id");
				System.out.println("Dao: "+ dbResultSet.getInt("id"));
				int idPersoonsGegevens = dbResultSet.getInt("Persoonsgegevens_ID");
				int idVaardigheid = dbResultSet.getInt("Vaardigheden_ID");
				String eigenschappen = dbResultSet.getString("eigenschappen");
				String spreektalen	= dbResultSet.getString("spreektalen");
				int jarenErvaringIT = dbResultSet.getInt("jaren_Ervaring_IT");
				
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
				
				String technischeVaardigheden = dbResultSet.getString("Technische_vaardigheden");
				System.out.println("dao" + dbResultSet.getString("technische_vaardigheden"));
				String functioneleVaardigheden = dbResultSet.getString("functionele_vaardigheden");
				String werkervaring = dbResultSet.getString("werkervaring");
				String computertalen = dbResultSet.getString("computertalen");
				String platformen = dbResultSet.getString("platformen");
				String pakketen = dbResultSet.getString("pakketen");
				
				PersoonsGegevens pg = new PersoonsGegevens(id, naam, straatnaam, huisnummer, postcode, woonplaats,
						geboortedatum, geslacht, telefoonnummer, email, linkedin);
				
				Vaardigheid vh = new Vaardigheid(id, technischeVaardigheden, functioneleVaardigheden, werkervaring, computertalen, platformen, pakketen);
				
				Profiel pf = new Profiel(id, idPersoonsGegevens, idVaardigheid, eigenschappen, spreektalen, jarenErvaringIT);
				
				pf.setGegevens(pg);
				pf.setVaardigheden(vh);
				
				result.add(pf);
			}
		} catch(SQLException sqle) {
			sqle.printStackTrace();
			System.err.println(sqle.toString());
			System.err.println(sqle.getMessage());
		}
		return result;
	}
	
	public List<Profiel> selectProfielPostcode(String pcode){
		List<Profiel> result = new ArrayList<Profiel>();
		String query = "select \"Profiel\".* , \"Naam\", \"Straatnaam\", \"Huisnummer\", \"Postcode\", \"Woonplaats\", \"Geboortedatum\", \"Geslacht\", \"Telefoonnummer\", \"Email\", \"Linkedin\", \"Technische_vaardigheden\", \"Functionele_vaardigheden\", \"Werkervaring\", \"Computertalen\", \"Platformen\", \"Pakketen\" from \"Persoonsgegevens\", \"Profiel\", \"Vaardigheden\" where \"Persoonsgegevens\".\"ID\" = \"Profiel\".\"Persoonsgegevens_ID\" and \"Vaardigheden\".\"ID\" = \"Profiel\".\"Vaardigheden_ID\" and lower(\"Postcode\") = lower('"+ pcode + "');";
		 System.out.println("voor db connectie");
		try(Connection con = super.getConnection()){
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet dbResultSet = pstmt.executeQuery();
			System.out.println("na db connectie");
			while(dbResultSet.next()) {
				int id = dbResultSet.getInt("id");
				System.out.println("Dao: "+ dbResultSet.getInt("id"));
				int idPersoonsGegevens = dbResultSet.getInt("Persoonsgegevens_ID");
				int idVaardigheid = dbResultSet.getInt("Vaardigheden_ID");
				String eigenschappen = dbResultSet.getString("eigenschappen");
				String spreektalen	= dbResultSet.getString("spreektalen");
				int jarenErvaringIT = dbResultSet.getInt("jaren_Ervaring_IT");
				
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
				
				String technischeVaardigheden = dbResultSet.getString("Technische_vaardigheden");
				System.out.println("dao" + dbResultSet.getString("technische_vaardigheden"));
				String functioneleVaardigheden = dbResultSet.getString("functionele_vaardigheden");
				String werkervaring = dbResultSet.getString("werkervaring");
				String computertalen = dbResultSet.getString("computertalen");
				String platformen = dbResultSet.getString("platformen");
				String pakketen = dbResultSet.getString("pakketen");
				
				PersoonsGegevens pg = new PersoonsGegevens(id, naam, straatnaam, huisnummer, postcode, woonplaats,
						geboortedatum, geslacht, telefoonnummer, email, linkedin);
				
				Vaardigheid vh = new Vaardigheid(id, technischeVaardigheden, functioneleVaardigheden, werkervaring, computertalen, platformen, pakketen);
				
				Profiel pf = new Profiel(id, idPersoonsGegevens, idVaardigheid, eigenschappen, spreektalen, jarenErvaringIT);
				
				pf.setGegevens(pg);
				pf.setVaardigheden(vh);
				
				result.add(pf);
			}
		} catch(SQLException sqle) {
			sqle.printStackTrace();
			System.err.println(sqle.toString());
			System.err.println(sqle.getMessage());
		}
		return result;
	}
	
	public List<Profiel> selectProfielID(int ID){
		List<Profiel> result = new ArrayList<Profiel>();
		String query = "select \"Profiel\".* , \"Naam\", \"Straatnaam\", \"Huisnummer\", \"Postcode\", \"Woonplaats\", \"Geboortedatum\", \"Geslacht\", \"Telefoonnummer\", \"Email\", \"Linkedin\", \"Technische_vaardigheden\", \"Functionele_vaardigheden\", \"Werkervaring\", \"Computertalen\", \"Platformen\", \"Pakketen\" from \"Persoonsgegevens\",  \"Profiel\", \"Vaardigheden\" where \"Persoonsgegevens\".\"ID\" = \"Profiel\".\"Persoonsgegevens_ID\" and \"Vaardigheden\".\"ID\" = \"Profiel\".\"Vaardigheden_ID\" and \r\n" + 
				"	\"Profiel\".\"ID\" = " + ID + ";";
		 System.out.println("voor db connectie");
		try(Connection con = super.getConnection()){
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet dbResultSet = pstmt.executeQuery();
			System.out.println("na db connectie");
			while(dbResultSet.next()) {
				int id = dbResultSet.getInt("id");
				System.out.println("Dao: "+ dbResultSet.getInt("id"));
				int idPersoonsGegevens = dbResultSet.getInt("Persoonsgegevens_ID");
				int idVaardigheid = dbResultSet.getInt("Vaardigheden_ID");
				String eigenschappen = dbResultSet.getString("eigenschappen");
				String spreektalen	= dbResultSet.getString("spreektalen");
				int jarenErvaringIT = dbResultSet.getInt("jaren_Ervaring_IT");
				
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
				
				String technischeVaardigheden = dbResultSet.getString("Technische_vaardigheden");
				System.out.println("dao" + dbResultSet.getString("technische_vaardigheden"));
				String functioneleVaardigheden = dbResultSet.getString("functionele_vaardigheden");
				String werkervaring = dbResultSet.getString("werkervaring");
				String computertalen = dbResultSet.getString("computertalen");
				String platformen = dbResultSet.getString("platformen");
				String pakketen = dbResultSet.getString("pakketen");
				
				PersoonsGegevens pg = new PersoonsGegevens(id, naam, straatnaam, huisnummer, postcode, woonplaats,
						geboortedatum, geslacht, telefoonnummer, email, linkedin);
				
				Vaardigheid vh = new Vaardigheid(id, technischeVaardigheden, functioneleVaardigheden, werkervaring, computertalen, platformen, pakketen);
				
				Profiel pf = new Profiel(id, idPersoonsGegevens, idVaardigheid, eigenschappen, spreektalen, jarenErvaringIT);
				
				pf.setGegevens(pg);
				pf.setVaardigheden(vh);
				
				result.add(pf);
			}
		} catch(SQLException sqle) {
			sqle.printStackTrace();
			System.err.println(sqle.toString());
			System.err.println(sqle.getMessage());
		}
		return result;
	}
	
	public boolean save(Profiel profiel) {
		try(Connection con = super.getConnection()){
			String q = "insert into \"Profiel\"(\"ID\", \"Persoonsgegevens_ID\", \"Vaardigheden_ID\", \"Eigenschappen\", \"Spreektalen\", \"Jaren_Ervaring_IT\") values (?, ?, ?, ?, ?, ?);";
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, profiel.getId());
			pstmt.setInt(2, profiel.getId());
			pstmt.setInt(3, profiel.getId());
			pstmt.setString(4, profiel.getEigenschappen());
			pstmt.setString(5, profiel.getSpreektalen());
			pstmt.setInt(6, profiel.getJarenErvaringIT());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}
	
	public boolean update(Profiel profiel) {
		try (Connection con = super.getConnection()){
			String q = "update \"Profiel\" set \"Eigenschappen\" = ? , \"Spreektalen\" = ? , \"Jaren_Ervaring_IT\" = ? where \"ID\" = ? ;";
			System.out.println(q);
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, profiel.getEigenschappen());
			pstmt.setString(2, profiel.getSpreektalen());
			pstmt.setInt(3, profiel.getJarenErvaringIT());
			pstmt.setInt(4, profiel.getId());
			pstmt.executeUpdate();
			System.out.println("Dao: " + profiel.getJarenErvaringIT());
//			ResultSet dbResultSet = pstmt.executeQuery();
			return true;
		} catch(Exception exc) {
			exc.printStackTrace();
			System.err.println(exc.toString());
			System.err.println(exc.getMessage());
			return false;
		}
	}
	
	public boolean delete(Profiel profiel) {
		try(Connection con = super.getConnection()){
			String q = "delete from \"Profiel\" where \"ID\" = ?";
			System.out.println(q);
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, profiel.getId());
			pstmt.executeUpdate();
			//ResultSet dbResultSet = pstmt.executeQuery();
			return true;
		} catch (Exception exc) {
			exc.printStackTrace();
			System.err.println(exc.toString());
			System.err.println(exc.getMessage());
			return false;
		}
	}
}
