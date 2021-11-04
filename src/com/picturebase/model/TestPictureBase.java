package com.picturebase.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class TestPictureBase {
	
	public static void main(String[] args) throws IOException {
		PictureBaseDAO_interface dao = new PictureBaseJDBCDAO();		
		

						
		PictureBaseVO pbd1 = new PictureBaseVO();
		byte[] pic1 = getPictureByteArray("C:\\TFA103_WebApp\\eclipse_WTP_workspace1\\TFA103G2\\WebContent\\article\\testImages\\FA1-1.JPG");
		pbd1.setArticleNo(1);
		pbd1.setPic(pic1);
		dao.add(pbd1);
		
		PictureBaseVO pbd2 = new PictureBaseVO();
		byte[] pic2 = getPictureByteArray("C:\\TFA103_WebApp\\eclipse_WTP_workspace1\\TFA103G2\\WebContent\\article\\testImages\\FA1-2.JPG");
		pbd2.setArticleNo(1);
		pbd2.setPic(pic2);
		dao.add(pbd2);
//		
		
		PictureBaseVO pbd3 = new PictureBaseVO();
		byte[] pic3 =getPictureByteArray("C:\\TFA103_WebApp\\eclipse_WTP_workspace1\\TFA103G2\\WebContent\\article\\testImages\\FA2-1.JPG");		
		pbd3.setPic(pic3);		
		pbd3.setArticleNo(2);
		dao.add(pbd3);
		
		PictureBaseVO pbd4 = new PictureBaseVO();
		byte[] pic4 =getPictureByteArray("C:\\TFA103_WebApp\\eclipse_WTP_workspace1\\TFA103G2\\WebContent\\article\\testImages\\FA2-2.JPG");		
		pbd4.setPic(pic4);		
		pbd4.setArticleNo(2);
		dao.add(pbd4);
//		
		PictureBaseVO pbd5 = new PictureBaseVO();
		byte[] pic5 =getPictureByteArray("C:\\TFA103_WebApp\\eclipse_WTP_workspace1\\TFA103G2\\WebContent\\article\\testImages\\FA3.JPG");		
		pbd5.setPic(pic5);		
		pbd5.setArticleNo(3);
		dao.add(pbd5);
		
		PictureBaseVO pbd6 = new PictureBaseVO();
		byte[] pic6 =getPictureByteArray("C:\\TFA103_WebApp\\eclipse_WTP_workspace1\\TFA103G2\\WebContent\\article\\testImages\\FA4.JPG");		
		pbd6.setPic(pic6);		
		pbd6.setArticleNo(4);
		dao.add(pbd6);
		
		PictureBaseVO pbd7 = new PictureBaseVO();
		byte[] pic7 =getPictureByteArray("C:\\TFA103_WebApp\\eclipse_WTP_workspace1\\TFA103G2\\WebContent\\article\\testImages\\FA5.JPG");		
		pbd7.setPic(pic7);		
		pbd7.setArticleNo(5);
		dao.add(pbd7);
		
		PictureBaseVO pbd8 = new PictureBaseVO();
		byte[] pic8 =getPictureByteArray("C:\\TFA103_WebApp\\eclipse_WTP_workspace1\\TFA103G2\\WebContent\\article\\testImages\\FA6-1.JPG");		
		pbd8.setPic(pic8);		
		pbd8.setArticleNo(6);
		dao.add(pbd8);
		
		PictureBaseVO pbd9 = new PictureBaseVO();
		byte[] pic9 =getPictureByteArray("C:\\TFA103_WebApp\\eclipse_WTP_workspace1\\TFA103G2\\WebContent\\article\\testImages\\FA6-2.JPG");		
		pbd9.setPic(pic9);		
		pbd9.setArticleNo(6);
		dao.add(pbd9);
		
		
		
		
		
		
		
		
//		byte[] pic3 =getPictureByteArray("C:\\Users\\Tibame_T14\\Desktop\\tomcat2.gif");		
//		pbd.setPic(pic3);		
//		pbd.setPicNo(1);
//		dao.update(pbd);
										
//		PictureBaseVO pb1 = new PictureBaseVO();
//		pb1 = dao.findOnePic(1);
//		System.out.println(pb1);
		
		
		
		
		
		
		
		
		
		//dao.delete(1);
		//dao.delete(3);	
		
		//FnidByFK
		
//		pbd = dao.findByFK(1);
//		System.out.println(pbd.toString());
		
		
		
		
		
		
		//getall
//		List<PictureBaseVO> List = dao.getall();
//		for(PictureBaseVO piB:List ) {
//			System.out.println(piB.toString());
//			System.out.println(piB.getPicNo());
//			System.out.println(piB.getArticleNo());
//			System.out.println(piB.getPic());
//		}
		
		
	}
	
	public static byte[] getPictureByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		return buffer;
	}

}
