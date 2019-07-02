//Dao interface van de persoonsgegevens
package hu.persistence;

import java.util.List;

import hu.domain.PersoonsGegevens;

public interface PersoonsGegevensDao {
	public List<PersoonsGegevens> selectGegevens();
	public boolean save(PersoonsGegevens persoonsGegevens);
	public boolean update(PersoonsGegevens persoonsGegevens);
	public boolean delete(PersoonsGegevens persoonsGegevens);
}
