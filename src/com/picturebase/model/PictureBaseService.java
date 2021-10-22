package com.picturebase.model;

import java.util.List;

public class PictureBaseService {
	
	private PictureBaseDAO_interface dao;
	
	public PictureBaseService() {
		dao = new PictureBaseJDBCDAO();
	}
	
	public PictureBaseVO  addPictureBase(Integer articleNo, byte[]  pic) {
		PictureBaseVO picVO = new PictureBaseVO();
		
		picVO.setArticleNo(articleNo);
		picVO.setPic(pic);
		dao.add(picVO);
		
		return picVO;
	}
	
	public PictureBaseVO updatePictureBase(Integer picNo, byte[]  pic) {
		PictureBaseVO picVO = new PictureBaseVO();
		
		picVO.setPicNo(picNo);
		picVO.setPic(pic);
		
		return picVO;
	}
	
	public void deletePictureBase(Integer picNo) {
		dao.delete(picNo);
	}
	
	public  List<PictureBaseVO> getPicturesOfAr(Integer articleNo) {
		return dao.findByFK(articleNo);
	}
	
	public List<PictureBaseVO> getall(){
		return dao.getall();
	}
	
	public PictureBaseVO OnePicOfAr(Integer articleNo) {		
		return dao.findOnePic(articleNo);		
	}
	
	
	

}
