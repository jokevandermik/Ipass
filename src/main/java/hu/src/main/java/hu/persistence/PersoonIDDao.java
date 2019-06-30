package hu.persistence;

import java.util.List;

import hu.domain.PersoonID;

public interface PersoonIDDao {
	public List<PersoonID> selectID();
}