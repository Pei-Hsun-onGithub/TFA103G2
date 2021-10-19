package com.style.model;

import java.util.List;

public class StyleService {

	private StyleDAO_interface dao;
	
	public StyleService() {
		this.dao = new StyleJDBCDAO();
	}
	
	public StyleService(StyleDAO_interface dao) {
		this.dao = dao;
	}
	
	public List<StyleVO> getAllStyle() {
		return this.dao.getAll();
	}
	
	public String getStyleTypeByPrimaryKey(Integer styleId) {
		return this.dao.findByPrimaryKey(styleId).getStyleType();
	}
}
