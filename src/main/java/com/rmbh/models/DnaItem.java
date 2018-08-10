package com.rmbh.models;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="dna")
public class DnaItem {
	
	private String id;
	private List<String> sequence;
	private Boolean isMutant;
	
	public DnaItem() {}
	
	public DnaItem(String id, List<String> sequence, Boolean isMutant) {
		this.id = id;
		this.sequence = sequence;
		this.isMutant = isMutant;
	}

	@DynamoDBHashKey(attributeName="id") 
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@DynamoDBAttribute(attributeName="sequence")
	public List<String> getSequence() {
		return sequence;
	}
	
	public void setSequence(List<String> sequence) {
		this.sequence = sequence;
	}
	
	@DynamoDBAttribute(attributeName="isMutant")
	public Boolean getIsMutant() {
		return isMutant;
	}
	
	public void setIsMutant(Boolean isMutant) {
		this.isMutant = isMutant;
	}
	
}
