//Dao implementatie van persoonID
package hu.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.domain.PersoonID;

public class PersoonIDPostgresDaoImpl extends PostgresBaseDao implements PersoonIDDao {
	//haalt id op uit database voor het aanmaken van een profiel
	public List<PersoonID> selectID() {
		List<PersoonID> result = new ArrayList<PersoonID>();
		String query = "select max(\"ID\") as ID from \"Persoonsgegevens\"";

		try (Connection con = super.getConnection()) {
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet dbResultSet = pstmt.executeQuery();

			while (dbResultSet.next()) {
				int persoonID = dbResultSet.getInt("id");

				PersoonID pID = new PersoonID(persoonID);
				result.add(pID);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return result;
	}
}
