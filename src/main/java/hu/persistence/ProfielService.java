//Dit is een service die er voor zorgt dat je 3 dao's tegelijk kan aanroepen
package hu.persistence;

import java.util.List;

import hu.domain.PersoonsGegevens;
import hu.domain.Profiel;
import hu.domain.Vaardigheid;;

public class ProfielService {
	//roept de save in de dao's aan
	public boolean saveAlles (Profiel p) {
		PersoonsGegevensDao persoonsGegevensDao = new PersoonsGegevensPostgresDaoImpl();
		System.out.println("in service:"+p.getGegevens());
		boolean gegevensOK = persoonsGegevensDao.save(p.getGegevens());
		VaardigheidDao vaardigheidDao = new VaardigheidPostgresDaoImpl();
		boolean vaardigheidOK = vaardigheidDao.save(p.getVaardigheden());
		ProfielDao profielDao = new ProfielPostgresDaoImpl();
		boolean profielOK = profielDao.save(p);
		return gegevensOK && vaardigheidOK && profielOK;
	}
	
	//roept de update in de dao's aan
	public boolean updateAlles (Profiel p) {
		PersoonsGegevensDao persoonsGegevensDao = new PersoonsGegevensPostgresDaoImpl();
		System.out.println("in service:"+p.getGegevens());
		boolean gegevensOK = persoonsGegevensDao.update(p.getGegevens());
		VaardigheidDao vaardigheidDao = new VaardigheidPostgresDaoImpl();
		boolean vaardigheidOK = vaardigheidDao.update(p.getVaardigheden());
		ProfielDao profielDao = new ProfielPostgresDaoImpl();
		boolean profielOK = profielDao.update(p);
		return gegevensOK && vaardigheidOK && profielOK;
	}
	
	//roept de delete in de dao's aan
	public boolean deleteAlles(Profiel p) {
		ProfielDao profielDao = new ProfielPostgresDaoImpl();
		boolean profielOK = profielDao.delete(p);
		PersoonsGegevensDao persoonsGegevensDao = new PersoonsGegevensPostgresDaoImpl();
		System.out.println("in service:"+p.getGegevens());
		boolean gegevensOK = persoonsGegevensDao.delete(p.getGegevens());
		VaardigheidDao vaardigheidDao = new VaardigheidPostgresDaoImpl();
		boolean vaardigheidOK = vaardigheidDao.delete(p.getVaardigheden());
		return gegevensOK && vaardigheidOK && profielOK;
	}
}
