package com.rmbh;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.rmbh.core.analyzer.DnaAnalyzer;
import com.rmbh.core.analyzer.DnaAnalyzerImpl;
import com.rmbh.core.mutant.MutantService;
import com.rmbh.core.mutant.MutantServiceImpl;
import com.rmbh.health.ServerHealthCheck;
import com.rmbh.models.dao.DnaItemDAO;
import com.rmbh.models.dao.DnaItemDaoImpl;
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
		AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(awsCreds))
				.withRegion(Regions.US_EAST_2);
		AmazonDynamoDB client = builder.build();
		DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(client);
		
		final DnaItemDAO dnaItemDao = new DnaItemDaoImpl(dynamoDBMapper);
		final DnaAnalyzer dnaAnalyzer = new DnaAnalyzerImpl();
		final MutantService mutantService = new MutantServiceImpl(dnaAnalyzer, dnaItemDao);
		
		final MagnetoArmyResource magnetoArmyResource = new MagnetoArmyResource(mutantService);
		environment.jersey().register(magnetoArmyResource);
		
		final ServerHealthCheck healthCheck = new ServerHealthCheck();
		environment.healthChecks().register("simpleServerHealthCheck", healthCheck);
	}

}
