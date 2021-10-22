package com.picturebase.model;

import java.util.List;





public interface PictureBaseDAO_interface {
	
	public void add(PictureBaseVO pictureBase);
	public void update(PictureBaseVO pictureBase);
	public void delete(Integer picNo);
	List<PictureBaseVO> findByFK(Integer articleNo);
	List<PictureBaseVO> getall();
	public PictureBaseVO findOnePic(Integer articleNo);
	
	public void insertWithArticle (PictureBaseVO pbVO , java.sql.Connection con);
}
