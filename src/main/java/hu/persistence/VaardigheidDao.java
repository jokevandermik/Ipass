package hu.persistence;

import hu.domain.Vaardigheid;;

public interface VaardigheidDao {
	public boolean save(Vaardigheid vaardigheid);
	public boolean update(Vaardigheid vaardigheid);
	public boolean delete(Vaardigheid vaardigheid);
}
