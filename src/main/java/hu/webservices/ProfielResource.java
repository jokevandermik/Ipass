package hu.webservices;

import java.awt.PageAttributes.MediaType;

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
	public Response saveProfiel(@FormParam("id") int Id,@FormParam("naam") String nm, @FormParam("straatnaam") String strnm, @FormParam("huisnummer") int hsnr, @FormParam("postcode") String pc, @FormParam("woonplaats") String wp, @FormParam("geboortedatum") String gb, @FormParam("geslacht") String gs, @FormParam("telefoonnummer") int tfnr, @FormParam("email") String mail, @FormParam("linkedin") String lkin,
			@FormParam("eigenschappen") String es, @FormParam("spreektalen") String st, @FormParam("jarenErvaringIT") int jeIT, @FormParam("technischeVaardigheden") String tv, @FormParam("functioneleVaardigheden") String fv, @FormParam("werkervaring") String we, @FormParam("computertalen") String ct, @FormParam("platformen") String pt, @FormParam("pakketen") String pk) {
		ProfielService profielService = ServiceProvider.getProfielService();
		
//		if(nm.isEmpty()) return Response.status(405).build();
		if(nm == null) return Response.status(406).build();

		int id = Id;
		String naam = nm;
		String straatnaam = strnm;
		int huisnummer = hsnr;
		String postcode = pc;
		String woonplaats = wp;
		String geboortedatum = gb;
		String geslacht = gs;
		int telefoonnummer = tfnr;
		String email = mail;
		String linkedin = lkin;
		
//		System.out.println(id);
//		System.out.println(naam);
		
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
		
		hetProfiel.setGegevens(deGegevens);
		hetProfiel.setVaardigheden(deVaardigheid);
		
		if(profielService.saveAlles(hetProfiel)) return Response.ok(hetProfiel).build();
		return Response.status(402).build();
	}
//	@Consumes({ MediaType.MULTIPART_FORM_DATA })
//	public Response saveProfiel(@FormParam("id") int Id,@FormParam("naam") String nm, @FormParam("straatnaam") String strnm, @FormParam("huisnummer") int hsnr, @FormParam("postcode") String pc, @FormParam("woonplaats") String wp, @FormParam("geboortedatum") String gb, @FormParam("geslacht") String gs, @FormParam("telefoonnummer") int tfnr, @FormParam("email") String mail, @FormParam("linkedin") String lkin,
//			@FormParam("eigenschappen") String es, @FormParam("spreektalen") String st, @FormParam("jarenErvaringIT") int jeIT, @FormParam("technischeVaardigheden") String tv, @FormParam("functioneleVaardigheden") String fv, @FormParam("werkervaring") String we, @FormParam("computertalen") String ct, @FormParam("platformen") String pt, @FormParam("pakketen") String pk) {
//		ProfielService profielService = ServiceProvider.getProfielService();
//		//check of de parameters in orde zijn (verplichte velden)
//		if(nm.trim().isEmpty()&& strnm.trim().isEmpty() && pc.trim().isEmpty() && wp.trim().isEmpty() &&
//				gb.trim().isEmpty() && mail.trim().isEmpty() && lkin.trim().isEmpty()) return Response.noContent().build();
//		//vul alle parameters voor de save
//		int id = Id;
//		String naam = nm.trim();
//		String straatnaam = strnm.trim();
//		int huisnummer = hsnr;
//		String postcode = pc.trim();
//		String woonplaats = wp.trim();
//		String geboortedatum = gb.trim();
//		String geslacht = gs;
//		int telefoonnummer = tfnr;
//		String email = mail.trim();
//		String linkedin = lkin.trim();
//		
//		String technischeVaardigheden = tv.trim();
//		String functioneleVaardigheden = fv.trim();
//		String werkervaring = we.trim();
//		String computertalen = ct.trim();
//		String platformen = pt.trim();
//		String pakketen = pk.trim();
//		
//		int idPersoonsGegevens = Id;
//		int idVaardigheid = Id;
//		String eigenschappen = es.trim();
//		String spreektalen = st.trim();
//		int jarenErvaringIT = jeIT;
//		//maakt de PersoonsGegevens obv de velden
//		PersoonsGegevens deGegevens = new PersoonsGegevens(id, naam, straatnaam, huisnummer, postcode, woonplaats, geboortedatum, geslacht, telefoonnummer, email, linkedin);
//		//maakt de Vaardigheid 
//		Vaardigheid deVaardigheid = new Vaardigheid(id, technischeVaardigheden, functioneleVaardigheden, werkervaring, computertalen, platformen, pakketen);
//		//maakt een profiel
//		Profiel hetProfiel = new Profiel(id, idPersoonsGegevens, idVaardigheid, eigenschappen, spreektalen, jarenErvaringIT);
//		//stelt de gegevens in
//		hetProfiel.setGegevens(deGegevens);
//		hetProfiel.setVaardigheden(deVaardigheid);
//		//sla het profiel op
//		if(profielService.save(hetProfiel)) return Response.ok(hetProfiel).build();
//		return Response.status(Status.NOT_MODIFIED).build();
//		
//	}
}
