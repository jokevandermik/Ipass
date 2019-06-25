package hu.persistence;

import hu.domain.PersoonsGegevens;

public interface PersoonsGegevensDao {
	public boolean save(PersoonsGegevens persoonsGegevens);
	public boolean update(PersoonsGegevens persoonsGegevens);
	public boolean delete(PersoonsGegevens persoonsGegevens);
}
