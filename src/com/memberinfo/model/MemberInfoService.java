package com.memberinfo.model;

import java.sql.Date;
import java.util.List;

public class MemberInfoService {
	
	private MemberInfoDAO dao;
	
	public MemberInfoService() {
		dao = new MemberInfoDAOImpl();
	}
	
	public MemberInfo addMemberInfo	(String email, String pwd, String userName, String gender, Date birthday, String phone,byte[] pic, Date registerDate, int gold, int feed, int monsterId, String monsterNickName, int lv, int exp, int sta) {
		
		MemberInfo memberinfo = new MemberInfo();
		
		memberinfo.setEmail(email);
		memberinfo.setPwd(pwd);
		memberinfo.setUserName(userName);
		memberinfo.setGender(gender);
		memberinfo.setBirthday(birthday);
		memberinfo.setPhone(phone);
		memberinfo.setPic(pic);
		memberinfo.setRegisterDate(registerDate);
		memberinfo.setGold(gold);
		memberinfo.setFeed(feed);
		memberinfo.setMonsterId(monsterId);
		memberinfo.setMonsterNickName(monsterNickName);
		memberinfo.setLv(lv);
		memberinfo.setExp(exp);
		memberinfo.setSta(sta);
		dao.add(memberinfo);
		
		return memberinfo;
	}
	
	public MemberInfo updateMemberInfo	(String email, String pwd, String userName, String gender, Date birthday, String phone,byte[] pic, Date registerDate, int gold, int feed, int monsterId, String monsterNickName, int lv, int exp, int sta) {
		
		MemberInfo memberinfo = new MemberInfo();
		
		memberinfo.setEmail(email);
		memberinfo.setPwd(pwd);
		memberinfo.setUserName(userName);
		memberinfo.setGender(gender);
		memberinfo.setBirthday(birthday);
		memberinfo.setPhone(phone);
		memberinfo.setPic(pic);
		memberinfo.setRegisterDate(registerDate);
		memberinfo.setGold(gold);
		memberinfo.setFeed(feed);
		memberinfo.setMonsterId(monsterId);
		memberinfo.setMonsterNickName(monsterNickName);
		memberinfo.setLv(lv);
		memberinfo.setExp(exp);
		memberinfo.setSta(sta);
		dao.update(memberinfo);
		
		return memberinfo;
	}
	
	public void deleteMemberInfo(int userId) {
		dao.delete(userId);
	}
	
	public MemberInfo getOneMemberInfo(int userId) {
		return dao.findByPK(userId);
	}
	
	public List<MemberInfo> getAll() {
		return dao.getAll();
	}
}
