package com.rmbh.resources;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codahale.metrics.annotation.Timed;
import com.rmbh.api.DnaRequest;

@Path("/magneto-army")
@Produces(MediaType.APPLICATION_JSON)
public class MagnetoArmyResource {

	@GET
	@Timed
	@Path("/hola")
	public String sayHello() {
		return "Hola Mundo";
	}
	
	@GET
	@Timed
	@Path("/stats")
	public String stats() {
		return "TBD";
	}
	
	@POST
	@Timed
	@Path("/mutant")
	public Response mutant(@NotNull DnaRequest dna) {
		
		
		
		return Response.ok().build();
	}
	
}
