package com.monsterbook.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class TestJDBCDAO {
	
	public static void main(String[] args) throws IOException {
		MonsterBookDAO dao = new MonsterBookDAOImpl();
		
		//新增
//		MonsterBook mon1 = new MonsterBook();
//		byte[] data1 = getPictureByteArray("pictest/heart.png");
////		mon1.setMonsterId(1004);
//		mon1.setMinDemandLevel(10);
//		mon1.setMonsterName("小鴨鴨");
//		mon1.setMonsterAbility("訂餐加成");
//		mon1.setMonsterPic(data1);
//		dao.add(mon1);
		
		//修改
//		MonsterBook mon2 = new MonsterBook();
//		byte[] data2 = getPictureByteArray("pictest/heart.png");
//		mon2.setMonsterId(1003);
//		mon2.setMinDemandLevel(20);
//		mon2.setMonsterName("小狗狗");
//		mon2.setMonsterAbility("文章加成");
//		mon2.setMonsterPic(data2);
//		dao.update(mon2);
		
		//刪除
//		dao.delete(1004);
		
		//查詢
//		MonsterBook mon3 = dao.findByPK(1001);
//		System.out.print(mon3.getMonsterId() + ",");
//		System.out.print(mon3.getMinDemandLevel() + ",");
//		System.out.print(mon3.getMonsterName() + ",");
//		System.out.print(mon3.getMonsterAbility() + ",");
//		System.out.println(mon3.getMonsterPic());
//		System.out.println("---------------------");
		
		//查詢
		List<MonsterBook> list = dao.getAll();
		for	(MonsterBook mon : list) {
			System.out.print(mon.getMonsterId() + ",");
			System.out.print(mon.getMinDemandLevel() + ",");
			System.out.print(mon.getMonsterName() + ",");
			System.out.print(mon.getMonsterAbility() + ",");
			System.out.print(mon.getMonsterPic());
			System.out.println();
		}
		
	}
	// 使用byte[]方式
	public static byte[] getPictureByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		return buffer;
	}

}
