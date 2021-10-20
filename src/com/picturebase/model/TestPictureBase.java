package com.picturebase.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class TestPictureBase {
	
	public static void main(String[] args) throws IOException {
		PictureBaseDAO_interface dao = new PictureBaseJDBCDAO();
		
		PictureBaseVO pbd1 = new PictureBaseVO();

		//�憓�				
		
		byte[] pic = getPictureByteArray("C:/Users/Tibame_T14/Desktop/test1.jpg");
		pbd1.setArticleNo(1);
		pbd1.setPic(pic);
		dao.add(pbd1);
		
		PictureBaseVO pbd2 = new PictureBaseVO();
		byte[] pic2 = getPictureByteArray("C:\\Users\\Tibame_T14\\Desktop\\test2.jpg");
		pbd2.setArticleNo(1);
		pbd2.setPic(pic2);
		dao.add(pbd2);
//		
		//��
		
//		byte[] pic3 =getPictureByteArray("C:\\Users\\Tibame_T14\\Desktop\\tomcat2.gif");		
//		pbd.setPic(pic3);		
//		pbd.setPicNo(1);
//		dao.update(pbd);
										
		//��
		
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
