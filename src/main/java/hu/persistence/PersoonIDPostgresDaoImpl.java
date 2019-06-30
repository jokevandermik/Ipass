package hu.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.domain.PersoonID;

public class PersoonIDPostgresDaoImpl extends PostgresBaseDao implements PersoonIDDao {
	public List<PersoonID> selectID() {
		List<PersoonID> result = new ArrayList<PersoonID>();
		String query = "select max(\"ID\") from \"Persoonsgegevens\"";

		try (Connection con = super.getConnection()) {
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet dbResultSet = pstmt.executeQuery();

			while (dbResultSet.next()) {
				int id = dbResultSet.getInt("id");

				PersoonID pID = new PersoonID(id);
				result.add(pID);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return result;
	}
}
