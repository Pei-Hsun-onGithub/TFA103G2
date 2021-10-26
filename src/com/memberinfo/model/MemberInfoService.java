package com.memberinfo.model;

import java.sql.Date;
import java.util.List;

public class MemberInfoService {

	private MemberInfoDAO dao;

	public MemberInfoService() {
		dao = new MemberInfoDAOImpl();
	}

	public MemberInfo addMemberInfo(String email, String pwd, String userName, String gender, Date birthday,
			String phone, byte[] pic, Date registerDate, Integer gold, Integer feed, Integer monsterId,
			String monsterNickName, Integer lv, Integer exp, Integer sta) {

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

	public MemberInfo addMemberInfo(MemberInfo memberinfo) {
		dao.add(memberinfo);
		return memberinfo;
	}

	public MemberInfo updateMemberInfo(String email, String pwd, String userName, String gender, Date birthday,
			String phone, byte[] pic, Date registerDate, Integer gold, Integer feed, Integer monsterId,
			String monsterNickName, Integer lv, Integer exp, Integer sta) {

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

		memberinfo.setUserId(20210002);

		dao.update(memberinfo);

		return memberinfo;
	}

	public MemberInfo updateMemberInfo(Integer userId, String email, String pwd, String userName, String gender,
			Date birthday, String phone, byte[] pic, Date registerDate, Integer gold, Integer feed, Integer monsterId,
			String monsterNickName, Integer lv, Integer exp, Integer sta) {

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

		memberinfo.setUserId(userId);

		dao.update(memberinfo);

		return memberinfo;
	}

	public void deleteMemberInfo(Integer userId) {
		dao.delete(userId);
	}

	public MemberInfo getOneMemberInfo(Integer userId) {
		return dao.findByPK(userId);
	}

	public List<MemberInfo> getAll() {
		return dao.getAll();
	}

	public boolean findByEmail(String email) {
		return dao.selectEmail(email);
	}

	public MemberInfo findByEmail2(String email, String pwd) {
		return dao.selectEmail2(email, pwd);
	}

}
