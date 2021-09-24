package com.elasticdayoff.model;

import java.util.List;


public interface ElasticDayoffDAO_interface {
	
	public void insert(ElasticDayoffVO elasticDayoffVO);
	public void update(ElasticDayoffVO elasticDayoffVO);
	public void delete(Integer dayoffId);
	public ElasticDayoffVO findByPrimaryKey(Integer dayoffId);
	public List<ElasticDayoffVO> getAll();
}
