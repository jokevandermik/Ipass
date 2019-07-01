package hu.webservices;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import hu.domain.PersoonsGegevens;
import hu.domain.*;
import hu.persistence.PersoonIDPostgresDaoImpl;
import hu.persistence.PersoonsGegevensPostgresDaoImpl;
import hu.persistence.ProfielPostgresDaoImpl;
import hu.persistence.ProfielService;
import hu.persistence.ServiceProvider;
import hu.persistence.VaardigheidPostgresDaoImpl;;

@Path("/WolfAndCherry")
public class ProfielResource {
	@GET
	@Path("/all")
	public Response getProfiel() {
		PersoonsGegevensPostgresDaoImpl pgdb = new PersoonsGegevensPostgresDaoImpl();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (PersoonsGegevens pg : pgdb.selectGegevens()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("id", pg.getId());
			job.add("naam", pg.getNaam());
			job.add("straatnaam", pg.getStraatnaam());
			job.add("huisnummer", pg.getHuisnummer());
			job.add("postcode", pg.getPostcode());
			job.add("woonplaats", pg.getWoonplaats());
			job.add("geboortedatum", pg.getGeboortedatum());
			job.add("geslacht", pg.getGeslacht());
			job.add("telefoonnummer", pg.getTelefoonnummer());
			job.add("email", pg.getEmail());
			job.add("linkedin", pg.getLinkedin());
			
			jab.add(job);
		}
		
		JsonArray jsonArray = jab.build();
		return Response.ok(jsonArray.toString()).build();
	}
	
	@GET
	@Path("/Idhalen")
	public Response getPersoonID() {
		PersoonIDPostgresDaoImpl db = new PersoonIDPostgresDaoImpl();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (PersoonID pid : db.selectID()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("id", pid.getPersoonID());
			
			jab.add(job);
		}
		
		JsonArray jsonArray = jab.build();
		return Response.ok(jsonArray.toString()).build();
	}
	
	@POST
	@Path("/save")
	public Response saveProfiel(@FormParam("id") int Id,@FormParam("naam") String nm, @FormParam("straatnaam") String strnm, @FormParam("huisnummer") int hsnr, @FormParam("postcode") String pc, @FormParam("woonplaats") String wp, @FormParam("geboortedatum") String gb, @FormParam("geslacht") String gs, @FormParam("telefoonnummer") String tfnr, @FormParam("email") String mail, @FormParam("linkedin") String lkin,
			@FormParam("eigenschappen") String es, @FormParam("spreektalen") String st, @FormParam("jarenErvaringIT") int jeIT, @FormParam("technischeVaardigheden") String tv, @FormParam("functioneleVaardigheden") String fv, @FormParam("werkervaring") String we, @FormParam("computertalen") String ct, @FormParam("platformen") String pt, @FormParam("pakketen") String pk) {
		ProfielService profielService = ServiceProvider.getProfielService();
		
		if(nm.isEmpty()) return Response.status(405).build();

		int id = Id;
		String naam = nm;
		String straatnaam = strnm;
		int huisnummer = hsnr;
		String postcode = pc;
		String woonplaats = wp;
		String geboortedatum = gb;
		String geslacht = gs;
		System.out.println("in resource: "+gs);
		String telefoonnummer = tfnr;
		String email = mail;
		String linkedin = lkin;
		
		String technischeVaardigheden = tv;
		String functioneleVaardigheden = fv;
		String werkervaring = we;
		String computertalen = ct;
		String platformen = pt;
		String pakketen = pk;
		
		int idPersoonsGegevens = Id;
		int idVaardigheid = Id;
		String eigenschappen = es;
		String spreektalen = st;
		int jarenErvaringIT = jeIT;
		
		//maakt de PersoonsGegevens obv de velden
		PersoonsGegevens deGegevens = new PersoonsGegevens(id, naam, straatnaam, huisnummer, postcode, woonplaats, geboortedatum, geslacht, telefoonnummer, email, linkedin);
		//maakt de Vaardigheid 
		Vaardigheid deVaardigheid = new Vaardigheid(id, technischeVaardigheden, functioneleVaardigheden, werkervaring, computertalen, platformen, pakketen);
		//maakt een profiel
		Profiel hetProfiel = new Profiel(id, idPersoonsGegevens, idVaardigheid, eigenschappen, spreektalen, jarenErvaringIT);
		
		if (deGegevens.getNaam().isEmpty()) return Response.status(406).build();
		
		
		
		hetProfiel.setGegevens(deGegevens);
		
		if(hetProfiel.getGegevens().getNaam().isEmpty()) return Response.status(410).build();
		
		
		hetProfiel.setVaardigheden(deVaardigheid);
		
		if(profielService.saveAlles(hetProfiel)) return Response.ok().build();
		return Response.status(402).build();
	}
}
