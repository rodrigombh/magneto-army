package com.rmbh.core.extractor;

import java.util.List;

public interface MatrixExtractor {
	
	public List<String> getVerticalLines();

	public List<String> getHorizontalLines();
	
	public List<String> getDiagonalLines();
}
