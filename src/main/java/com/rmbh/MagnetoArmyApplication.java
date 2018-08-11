package com.rmbh;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.rmbh.core.analyzer.DnaAnalyzer;
import com.rmbh.core.analyzer.DnaAnalyzerImpl;
import com.rmbh.core.mutant.MutantServiceOrchestrator;
import com.rmbh.core.mutant.MutantServiceOrchestratorImpl;
import com.rmbh.core.validator.DnaRequestValidator;
import com.rmbh.core.validator.DnaRequestValidatorImpl;
import com.rmbh.dao.DnaItemDAO;
import com.rmbh.dao.DnaItemDaoImpl;
import com.rmbh.health.ServerHealthCheck;
import com.rmbh.resources.MagnetoArmyResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MagnetoArmyApplication extends Application<MagnetoArmyConfiguration> {

	public static void main(final String[] args) throws Exception {
		new MagnetoArmyApplication().run(args);
	}

	@Override
	public String getName() {
		return "MagnetoArmy";
	}

	@Override
	public void initialize(final Bootstrap<MagnetoArmyConfiguration> bootstrap) {}

	@Override
	public void run(final MagnetoArmyConfiguration configuration, final Environment environment) {
		
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(configuration.getAccessKey(), configuration.getSecretKey());
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(awsCreds))
				.withRegion(Regions.US_EAST_2)
				.build();
		DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(client);
		
		final DnaItemDAO dnaItemDao = new DnaItemDaoImpl(dynamoDBMapper);
		final DnaAnalyzer dnaAnalyzer = new DnaAnalyzerImpl();
		final MutantServiceOrchestrator mutantService = new MutantServiceOrchestratorImpl(dnaAnalyzer, dnaItemDao);
		final DnaRequestValidator dnaRequestValidator = new DnaRequestValidatorImpl();
		
		final MagnetoArmyResource magnetoArmyResource = new MagnetoArmyResource(mutantService, dnaRequestValidator);
		environment.jersey().register(magnetoArmyResource);
		
		final ServerHealthCheck healthCheck = new ServerHealthCheck();
		environment.healthChecks().register("simpleServerHealthCheck", healthCheck);
	}

}
