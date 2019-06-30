package hu.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.domain.Profiel;;

public class ProfielPostgresDaoImpl extends PostgresBaseDao implements ProfielDao{
	public List<Profiel> selectProfiel(){
		List<Profiel> result = new ArrayList<Profiel>();
		String query = "Select * from \"Profiel\"";
		 
		try(Connection con = super.getConnection()){
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet dbResultSet = pstmt.executeQuery();
			
			while(dbResultSet.next()) {
				int id = dbResultSet.getInt("id");
				int idPersoonsGegevens = dbResultSet.getInt("id");
				int idVaardigheid = dbResultSet.getInt("idVaardigheden");
				String eigenschappen = dbResultSet.getString("eigenschappen");
				String spreektalen	= dbResultSet.getString("spreektalen");
				int jarenErvaringIT = dbResultSet.getInt("jarenErvaringIT");
				
				Profiel pf = new Profiel(id, idPersoonsGegevens, idVaardigheid, eigenschappen, spreektalen, jarenErvaringIT);
				result.add(pf);
			}
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		return result;
	}
	
	public boolean save(Profiel profiel) {
		try(Connection con = super.getConnection()){
			String q = "insert into \"Profiel\" (\"ID\", \"Eigenschappen\", \"Spreektalen\", \"Jaren_Ervaring_IT\")values (?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, profiel.getId());
			pstmt.setString(2, profiel.getEigenschappen());
			pstmt.setString(3, profiel.getSpreektalen());
			pstmt.setInt(4, profiel.getJarenErvaringIT());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}
	
	public boolean update(Profiel profiel) {
		try (Connection con = super.getConnection()){
			String q = "update \"Profiel\" set \"Eigenschappen\" = ? , \"Spreektalen\" = ? , \"Jaren_Ervaring_IT\" = ?";
			System.out.println(q);
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, profiel.getEigenschappen());
			pstmt.setString(2, profiel.getSpreektalen());
			pstmt.setInt(3, profiel.getJarenErvaringIT());
			ResultSet dbResultSet = pstmt.executeQuery();
		} catch(Exception exc) {
			exc.printStackTrace();
		}
		return true;
	}
	
	public boolean delete(Profiel profiel) {
		try(Connection con = super.getConnection()){
			String q = "delete from \"Profiel\" where \"id\" = ?";
			System.out.println(q);
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, profiel.getId());
			ResultSet dbResultSet = pstmt.executeQuery();
			return true;
		} catch (Exception exc) {
			exc.printStackTrace();
			return false;
		}
	}
}
