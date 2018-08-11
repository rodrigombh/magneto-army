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
import com.rmbh.api.StatsResponse;
import com.rmbh.core.mutant.MutantServiceOrchestrator;
import com.rmbh.core.validator.DnaRequestValidator;
import com.rmbh.core.validator.DnaRequestValidatorImpl;

@Path("/magneto-army")
@Produces(MediaType.APPLICATION_JSON)
public class MagnetoArmyResource {
	
	private final MutantServiceOrchestrator mutantService;
	private final DnaRequestValidator dnaRequestValidator;
	 
	public MagnetoArmyResource(MutantServiceOrchestrator mutantService, DnaRequestValidator dnaRequestValidator) {
		this.mutantService = mutantService;
		this.dnaRequestValidator = dnaRequestValidator;
	}

	@GET
	@Timed
	@Path("/stats")
	public StatsResponse stats() {
		return mutantService.getStatistics();
	}
	
	@POST
	@Timed
	@Path("/mutant")
	public Response mutant(@NotNull DnaRequest dna) {
		
		Status status = Status.BAD_REQUEST;
		
		if (dnaRequestValidator.isValid(dna.getDna())) {
			
			status = mutantService.isMutant(dna.getDna()) ? Status.OK : Status.FORBIDDEN;
		}
		
		return Response.status(status).build();
	}
	
}
