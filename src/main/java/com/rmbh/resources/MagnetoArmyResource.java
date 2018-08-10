package com.rmbh.resources;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.codahale.metrics.annotation.Timed;
import com.rmbh.api.DnaRequest;
import com.rmbh.core.mutant.MutantService;
import com.rmbh.core.utils.DnaRequestValidator;

@Path("/magneto-army")
@Produces(MediaType.APPLICATION_JSON)
public class MagnetoArmyResource {
	
	private final MutantService mutantService;
	 
	public MagnetoArmyResource(MutantService mutantService) {
		this.mutantService = mutantService;
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
		if (DnaRequestValidator.isValid(dna.getDna())) {
			if (mutantService.isMutant(dna.getDna())) {
				return Response.status(Status.OK).build();
			} else {
				return Response.status(Status.FORBIDDEN).build();
			}
		} else {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
	
}
