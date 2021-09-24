package com.style.model;

public class StyleVO implements java.io.Serializable {

	private Integer styleId;
	private String styleType;
	
	public StyleVO() {}

	public Integer getStyleId() {
		return styleId;
	}

	public void setStyleId(Integer styleId) {
		this.styleId = styleId;
	}

	public String getStyleType() {
		return styleType;
	}

	public void setStyleType(String styleType) {
		this.styleType = styleType;
	}

	@Override
	public String toString() {
		return "StyleVO [styleId=" + styleId + ", styleType=" + styleType + "]";
	}
	
	
}
