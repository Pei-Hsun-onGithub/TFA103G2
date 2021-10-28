package com.memberinfo.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class TestJDBCDAO {
	
	public static void main(String[] args) throws IOException {
		MemberInfoDAO dao = new MemberInfoDAOImpl();
		
		System.out.println(dao.selectEmail("Edwardwkins@teleworm.us"));
		
		
		//�s�W
		MemberInfo mem1 = new MemberInfo();
//		byte[] data1 = getPictureByteArray("C:\\TFA103_WebApp\\eclipse_WTP_workspace1\\TFA103G2\\WebContent\\pictest\\heart.png");
		mem1.setUserId(20210015);
		mem1.setEmail("5678@gmail.com");
		mem1.setPwd("223456");
		mem1.setUserName("小朋友");
		mem1.setGender("女");
		mem1.setBirthday(java.sql.Date.valueOf("2016-01-01"));
		mem1.setPhone("0912345679");
//		mem1.setPic(data1);
		mem1.setRegisterDate(java.sql.Date.valueOf("2021-09-13"));
		mem1.setGold(500);
		mem1.setFeed(100);
		mem1.setMonsterId(1002);
		mem1.setMonsterNickName("小屁孩");
		mem1.setLv(1);
		mem1.setExp(0);
		mem1.setSta(2);
		dao.add(mem1);
		
		//�ק�
//		MemberInfo mem2 = new MemberInfo();
//		byte[] data2 = getPictureByteArray("pictest/heart.png");
//		mem2.setUserId(20210002);
//		mem2.setEmail("5678@gmail.com");
//		mem2.setPwd("223456");
//		mem2.setUserName("�p��");
//		mem2.setGender("�k");
//		mem2.setBirthday(java.sql.Date.valueOf("2016-01-01"));
//		mem2.setPhone("0912345679");
//		mem2.setPic(data2);
//		mem2.setRegisterDate(java.sql.Date.valueOf("2021-09-13"));
//		mem2.setGold(500);
//		mem2.setFeed(100);
//		mem2.setMonsterId(1002);
//		mem2.setMonsterNickName("�p��");
//		mem2.setLv(1);
//		mem2.setExp(0);
//		mem2.setSta(2);
//		dao.update(mem2);

		//�R��
//		dao.delete(20210003);
		
		//�d��
//		MemberInfo mem3 = dao.findByPK(20210001);
//		System.out.println(mem3.getUserId() + ",");
//		System.out.println(mem3.getEmail() + ",");
//		System.out.println(mem3.getPwd() + ",");
//		System.out.println(mem3.getUserName() + ",");
//		System.out.println(mem3.getGender() + ",");
//		System.out.println(mem3.getBirthday() + ",");
//		System.out.println(mem3.getPhone() + ",");
//		System.out.println(mem3.getPic() + ",");
//		System.out.println(mem3.getRegisterDate() + ",");
//		System.out.println(mem3.getGold() + ",");
//		System.out.println(mem3.getFeed() + ",");
//		System.out.println(mem3.getMonsterId() + ",");
//		System.out.println(mem3.getMonsterNickName() + ",");
//		System.out.println(mem3.getLv() + ",");
//		System.out.println(mem3.getExp() + ",");
//		System.out.println(mem3.getSta());
//		System.out.println("---------------------");
		
		//�d��
//		List<MemberInfo> list = dao.getAll();
//		for (MemberInfo mem : list) {
//			System.out.println(mem.getUserId() + ",");
//			System.out.println(mem.getEmail() + ",");
//			System.out.println(mem.getPwd() + ",");
//			System.out.println(mem.getUserName() + ",");
//			System.out.println(mem.getGender() + ",");
//			System.out.println(mem.getBirthday() + ",");
//			System.out.println(mem.getPhone() + ",");
//			System.out.println(mem.getPic() + ",");
//			System.out.println(mem.getRegisterDate() + ",");
//			System.out.println(mem.getGold() + ",");
//			System.out.println(mem.getFeed() + ",");
//			System.out.println(mem.getMonsterId() + ",");
//			System.out.println(mem.getMonsterNickName() + ",");
//			System.out.println(mem.getLv() + ",");
//			System.out.println(mem.getExp() + ",");
//			System.out.println(mem.getSta());
//			System.out.println();
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
