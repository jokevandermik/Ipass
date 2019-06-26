package hu.webservices;

import javax.annotation.security.RolesAllowed;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import hu.domain.*;
import hu.persistence.PersoonsGegevensPostgresDaoImpl;;

@Path("/WolfAndCherry")
public class ServiceProvider {
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
}
