//Dao interface van het profiel
package hu.persistence;

import java.util.List;

import hu.domain.Profiel;;

public interface ProfielDao {
	public List<Profiel> selectProfiel();
	public List<Profiel> selectProfielRelevantie(String relevantie);
	public List<Profiel> selectProfielZoekterm(String zoekterm);
	public List<Profiel> selectProfielPostcode(String pcode);
	public List<Profiel> selectProfielID(int ID);
	public boolean save (Profiel profiel);
	public boolean update(Profiel profiel);
	public boolean delete(Profiel profiel);
}
