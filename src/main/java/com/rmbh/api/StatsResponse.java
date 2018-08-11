package com.rmbh.api;

import java.math.BigDecimal;

import io.dropwizard.jackson.JsonSnakeCase;

@JsonSnakeCase
public class StatsResponse {
	
	private BigDecimal countMutantDna;
	private BigDecimal countHumanDna;
	private BigDecimal ratio;
	
	public StatsResponse(Integer countMutantDna, Integer countHumanDna) {
		this.countMutantDna = new BigDecimal(countMutantDna);
		this.countHumanDna = new BigDecimal(countHumanDna);
		this.ratio = calculateRatio(this.countMutantDna, this.countHumanDna);
	}
	
	private BigDecimal calculateRatio(BigDecimal a, BigDecimal b) {
		return b.compareTo(BigDecimal.ZERO) == 0 ? null : a.divide(b, 1, BigDecimal.ROUND_HALF_EVEN);
	}

	public BigDecimal getCountMutantDna() {
		return countMutantDna;
	}
	
	public BigDecimal getCountHumanDna() {
		return countHumanDna;
	}
	
	public BigDecimal getRatio() {
		return ratio;
	}
	
}
