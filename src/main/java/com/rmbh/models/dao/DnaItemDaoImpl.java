package com.rmbh.models.dao;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.rmbh.models.DnaItem;

public class DnaItemDaoImpl implements DnaItemDAO {
	
	private final DynamoDBMapper mapper;

	public DnaItemDaoImpl(DynamoDBMapper dynamoDBMapper) {
		this.mapper = dynamoDBMapper;
	}

	@Override
	public void put(DnaItem dnaItem) {
		this.mapper.save(dnaItem);
	}

	@Override
	public DnaItem get(String id) {
		return this.mapper.load(DnaItem.class, id);
	}

	@Override
	public Integer getTotalDnaCount() {
		return mapper.count(DnaItem.class, new DynamoDBScanExpression());
	}

	@Override
	public Integer getMutantsDnaCount() {

		Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
    eav.put(":val1", new AttributeValue().withBOOL(true));
    
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
				.withFilterExpression("isMutant = :val1")
				.withExpressionAttributeValues(eav);
		
		return mapper.count(DnaItem.class, scanExpression);
	}

}
