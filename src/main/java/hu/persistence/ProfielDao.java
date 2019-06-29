package hu.persistence;

import hu.domain.Profiel;;

public interface ProfielDao {
	public boolean save (Profiel profiel);
	public boolean update(Profiel profiel);
	public boolean delete(Profiel profiel);
}
