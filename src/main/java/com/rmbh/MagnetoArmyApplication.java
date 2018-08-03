package com.rmbh;

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
	public void initialize(final Bootstrap<MagnetoArmyConfiguration> bootstrap) {
		// TODO: application initialization
	}

	@Override
	public void run(final MagnetoArmyConfiguration configuration, final Environment environment) {
		final ServerHealthCheck healthCheck = new ServerHealthCheck();
		System.out.println(configuration.getTemplate());
		final MagnetoArmyResource magnetoArmyResource = new MagnetoArmyResource();
		environment.jersey().register(magnetoArmyResource);
		environment.jersey().register(healthCheck);
	}

}
