package hu.webservices;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import hu.domain.PersoonsGegevens;
import hu.domain.*;
import hu.persistence.PersoonsGegevensPostgresDaoImpl;
import hu.persistence.ProfielPostgresDaoImpl;
import hu.persistence.ProfielService;
import hu.persistence.ServiceProvider;;

@Path("/WolfAndCherry")
public class ProfielResource {
	@GET
	@Path("/all")
	public Response getPersoonsGegevens() {
		PersoonsGegevensPostgresDaoImpl db = new PersoonsGegevensPostgresDaoImpl();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (PersoonsGegevens pg : db.selectGegevens()) {
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
	
//	@GET
//	@Path("/all")
//	public Response getProfiel() {
//		ProfielPostgresDaoImpl db = new ProfielPostgresDaoImpl();
//		JsonArrayBuilder jab = Json.createArrayBuilder();
//		
//		for (PersoonsGegevens pg : db.selectGegevens()) {
//			JsonObjectBuilder job = Json.createObjectBuilder();
//	}
	
	
	@POST
	@Path("/save")
	public Response savePersoonsgegevens(@FormParam("naam") String nm, @FormParam("straatnaam") String strnm, @FormParam("huisnummer") int hsnr, @FormParam("postcode") String pc, @FormParam("woonplaats") String wp, @FormParam("geboortedatum") String gb, @FormParam("geslacht") String gs, @FormParam("telefoonnummer") int tfnr, @FormParam("email") String mail, @FormParam("linkedin") String lkin) {
		ProfielService profielService = ServiceProvider.getProfielService();
		//check of de parameters in orde zijn (verplichte velden)
		if(nm.trim().isEmpty()) return Response.noContent().build();
		//vul alle parameters voor de save
		int id = (Integer) null;
		String naam = nm.trim();
		String straatnaam = strnm.trim();
		int huisnummer = hsnr;
		String postcode = pc.trim();
		String woonplaats = wp.trim();
		String geboortedatum = gb.trim();
		String geslacht = gs.trim();
		int telefoonnummer = tfnr;
		String email = mail.trim();
		String linkedin = lkin.trim();
		//maak de PersoonsGegevens obv de velden
		PersoonsGegevens deGegevens = new PersoonsGegevens(id, naam, straatnaam, huisnummer, postcode, woonplaats, geboortedatum, geslacht, telefoonnummer, email, linkedin);
		//maak een profiel aan
		Profiel hetProfiel = new Profiel();
		//stel de gegevens in
		hetProfiel.setGegevens(deGegevens);
		//sla het profiel op
		if(profielService.save(hetProfiel)) return Response.ok(hetProfiel).build();
		return Response.status(Status.NOT_MODIFIED).build();
		
	}
}
