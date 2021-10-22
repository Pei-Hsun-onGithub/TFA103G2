package com.picturebase.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class TestPictureBase {
	
	public static void main(String[] args) throws IOException {
		PictureBaseDAO_interface dao = new PictureBaseJDBCDAO();		
		

		//�憓�				
//		PictureBaseVO pbd1 = new PictureBaseVO();
//		byte[] pic1 = getPictureByteArray("C:/Users/Tibame_T14/Desktop/testFA1.JPG");
//		pbd1.setArticleNo(1);
//		pbd1.setPic(pic1);
//		dao.add(pbd1);
//		
//		PictureBaseVO pbd2 = new PictureBaseVO();
//		byte[] pic2 = getPictureByteArray("C:\\Users\\Tibame_T14\\Desktop\\testFA2.JPG");
//		pbd2.setArticleNo(2);
//		pbd2.setPic(pic2);
//		dao.add(pbd2);
//		
		//��
//		PictureBaseVO pbd3 = new PictureBaseVO();
//		byte[] pic3 =getPictureByteArray("C:\\Users\\Tibame_T14\\Desktop\\testFA3.JPG");		
//		pbd3.setPic(pic3);		
//		pbd3.setArticleNo(3);
//		dao.add(pbd3);
//		
//		PictureBaseVO pbd4 = new PictureBaseVO();
//		byte[] pic4 =getPictureByteArray("C:\\Users\\Tibame_T14\\Desktop\\testFA4.JPG");		
//		pbd4.setPic(pic4);		
//		pbd4.setArticleNo(4);
//		dao.add(pbd4);
//		
//		PictureBaseVO pbd5 = new PictureBaseVO();
//		byte[] pic5 =getPictureByteArray("C:\\Users\\Tibame_T14\\Desktop\\testFA5.JPG");		
//		pbd5.setPic(pic5);		
//		pbd5.setArticleNo(5);
//		dao.add(pbd5);
		
//		byte[] pic3 =getPictureByteArray("C:\\Users\\Tibame_T14\\Desktop\\tomcat2.gif");		
//		pbd.setPic(pic3);		
//		pbd.setPicNo(1);
//		dao.update(pbd);
										
		PictureBaseVO pb1 = new PictureBaseVO();
		pb1 = dao.findOnePic(1);
		System.out.println(pb1);
		
		
		
		
		
		
		
		
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
