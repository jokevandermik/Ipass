package hu.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.domain.Vaardigheid;

public class VaardigheidPostgresDaoImpl extends PostgresBaseDao implements VaardigheidDao{
	public List<Vaardigheid> selectVaarigheden(){
		List<Vaardigheid> result = new ArrayList<Vaardigheid>();
		String query = "select * from \"Vaardigheden\"";
		
		try (Connection con = super.getConnection()){
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet dbResultSet = pstmt.executeQuery();
			
			while (dbResultSet.next()) {
				int id = dbResultSet.getInt("id");
				String technischeVaardigheden = dbResultSet.getString("technische_vaardigheden");
				String functioneleVaardigheden = dbResultSet.getString("functionele_vaardigheden");
				String werkervaring = dbResultSet.getString("werkervaring");
				String computertalen = dbResultSet.getString("comptertalen");
				String platformen = dbResultSet.getString("platformen");
				String pakketen = dbResultSet.getString("pakketen");
				
				Vaardigheid vh = new Vaardigheid(id, technischeVaardigheden, functioneleVaardigheden, werkervaring, computertalen, platformen, pakketen);
				result.add(vh);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return result;
	}
	
	public boolean save(Vaardigheid vaardigheid) {
		try(Connection con = super.getConnection()){
			String q = "insert into \"Vaardigheden\"(\"ID\", \"Technische_vaardigheden\", \"Functionele_vaardigheden\", \"Werkervaring\", \"Computertalen\", \"Platformen\", \"Pakketen\") values(?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, vaardigheid.getId());
			pstmt.setString(2, vaardigheid.GetTechnischeVaardigheden());
			pstmt.setString(3, vaardigheid.GetFunctioneleVaardigheden());
			pstmt.setString(4, vaardigheid.GetWerkervaring());
			pstmt.setString(5, vaardigheid.GetComputertalen());
			pstmt.setString(6, vaardigheid.GetPlatform());
			pstmt.setString(7, vaardigheid.GetPakketen());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException sqle){
			sqle.printStackTrace();
			return false;
		}
	}
	
	public boolean update(Vaardigheid vaardigheid) {
		try(Connection con = super.getConnection()){
			String q = "Update \"Vaardigheden\" set \"Technische_vaardigheden\" = ? , \"Functionele_vaardigheden\" = ? , \"Werkervaring\" = ? ,\"Computertalen\" = ? , \"Platformen\" = ? , \"Pakketen\"= ? where \"ID\" = ?;";
			System.out.println(q);
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, vaardigheid.GetTechnischeVaardigheden());
			pstmt.setString(2, vaardigheid.GetFunctioneleVaardigheden());
			pstmt.setString(3, vaardigheid.GetWerkervaring());
			pstmt.setString(4, vaardigheid.GetComputertalen());
			pstmt.setString(5, vaardigheid.GetPlatform());
			pstmt.setString(6, vaardigheid.GetPakketen());
			pstmt.setInt(7, vaardigheid.getId());
			ResultSet dbResultSet = pstmt.executeQuery();
		} catch(Exception exc) {
			exc.printStackTrace();
		}
		return true;
	}
	
	public boolean delete(Vaardigheid vaardigheid) {
		try(Connection con = super.getConnection()){
			String q = "delete from \"Vaardigheden\" where \"ID\" = ?";
			System.out.println(q);
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, vaardigheid.getId());
			ResultSet dbResultSet = pstmt.executeQuery();
			return true;
		} catch (Exception exc) {
			exc.printStackTrace();
			return false;
		}
	}
}
