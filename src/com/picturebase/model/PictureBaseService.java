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
		
		PictureBaseVO picVO = this.dao.findOnePicByPK(picNo);
		
		picVO.setPic(pic);
		this.dao.update(picVO);
		return picVO;
	}
	
	public List<PictureBaseVO> updatePictureBaseByArticleNo(Integer articleNo, List<PictureBaseVO> pictureBases) {
		
		for(PictureBaseVO picBase : pictureBases) {
			Integer picNo = picBase.getPicNo();
			updatePictureBase(picNo, picBase.getPic());
		}
		
		return null;
	}
	
	public void deletePictureBase(Integer picNo) {
		this.dao.delete(picNo);
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
