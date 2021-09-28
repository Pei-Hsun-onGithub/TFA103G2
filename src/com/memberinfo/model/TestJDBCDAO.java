package com.memberinfo.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class TestJDBCDAO {
	
	public static void main(String[] args) throws IOException {
		MemberInfoDAO dao = new MemberInfoDAOImpl();
		
		//新增
//		MemberInfo mem1 = new MemberInfo();
//		byte[] data1 = getPictureByteArray("pictest/heart.png");
////		mem1.setUserId(20210002);
//		mem1.setEmail("5678@gmail.com");
//		mem1.setPwd("223456");
//		mem1.setUserName("小美");
//		mem1.setGender("女");
//		mem1.setBirthday(java.sql.Date.valueOf("2016-01-01"));
//		mem1.setPhone("0912345679");
//		mem1.setPic(data1);
//		mem1.setRegisterDate(java.sql.Date.valueOf("2021-09-13"));
//		mem1.setGold(500);
//		mem1.setFeed(100);
//		mem1.setMonsterId(1002);
//		mem1.setMonsterNickName("小花");
//		mem1.setLv(1);
//		mem1.setExp(0);
//		mem1.setSta(2);
//		dao.add(mem1);
		
		//修改
//		MemberInfo mem2 = new MemberInfo();
//		byte[] data2 = getPictureByteArray("pictest/heart.png");
//		mem2.setUserId(20210002);
//		mem2.setEmail("5678@gmail.com");
//		mem2.setPwd("223456");
//		mem2.setUserName("小美");
//		mem2.setGender("女");
//		mem2.setBirthday(java.sql.Date.valueOf("2016-01-01"));
//		mem2.setPhone("0912345679");
//		mem2.setPic(data2);
//		mem2.setRegisterDate(java.sql.Date.valueOf("2021-09-13"));
//		mem2.setGold(500);
//		mem2.setFeed(100);
//		mem2.setMonsterId(1002);
//		mem2.setMonsterNickName("小花");
//		mem2.setLv(1);
//		mem2.setExp(0);
//		mem2.setSta(2);
//		dao.update(mem2);

		//刪除
//		dao.delete(20210003);
		
		//查詢
//		MemberInfo mem3 = dao.findByPK(20210001);
//		System.out.print(mem3.getUserId() + ",");
//		System.out.print(mem3.getEmail() + ",");
//		System.out.print(mem3.getPwd() + ",");
//		System.out.print(mem3.getUserName() + ",");
//		System.out.print(mem3.getGender() + ",");
//		System.out.print(mem3.getBirthday() + ",");
//		System.out.print(mem3.getPhone() + ",");
//		System.out.print(mem3.getPic() + ",");
//		System.out.print(mem3.getRegisterDate() + ",");
//		System.out.print(mem3.getGold() + ",");
//		System.out.print(mem3.getFeed() + ",");
//		System.out.print(mem3.getMonsterId() + ",");
//		System.out.print(mem3.getMonsterNickName() + ",");
//		System.out.print(mem3.getLv() + ",");
//		System.out.print(mem3.getExp() + ",");
//		System.out.println(mem3.getSta());
//		System.out.println("---------------------");
		
		//查詢
		List<MemberInfo> list = dao.getAll();
		for (MemberInfo mem : list) {
			System.out.print(mem.getUserId() + ",");
			System.out.print(mem.getEmail() + ",");
			System.out.print(mem.getPwd() + ",");
			System.out.print(mem.getUserName() + ",");
			System.out.print(mem.getGender() + ",");
			System.out.print(mem.getBirthday() + ",");
			System.out.print(mem.getPhone() + ",");
			System.out.print(mem.getPic() + ",");
			System.out.print(mem.getRegisterDate() + ",");
			System.out.print(mem.getGold() + ",");
			System.out.print(mem.getFeed() + ",");
			System.out.print(mem.getMonsterId() + ",");
			System.out.print(mem.getMonsterNickName() + ",");
			System.out.print(mem.getLv() + ",");
			System.out.print(mem.getExp() + ",");
			System.out.print(mem.getSta());
			System.out.println();
		}
		
	}
	public static byte[] getPictureByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		return buffer;
	}

}
