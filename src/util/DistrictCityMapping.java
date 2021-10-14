package util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class DistrictCityMapping {

	private static Map<String, Set<String>> maps1 = null;
	static {
		
		Map<String, Set<String>> maps = new HashMap<>();
		String taipei = "�x�_��";
		String touan = "���";
		
		Set<String> taipeiCitys = new HashSet<>();
		
		
		taipeiCitys.add("������");
		taipeiCitys.add("�j�P��");
		taipeiCitys.add("���s��");
		taipeiCitys.add("�Q�s��");
		taipeiCitys.add("�j�w��");
		taipeiCitys.add("�U�ذ�");
		taipeiCitys.add("�H�q��");
		taipeiCitys.add("�h�L��");
		taipeiCitys.add("�_���");
		taipeiCitys.add("�����");
		taipeiCitys.add("�n���");
		taipeiCitys.add("��s");
		
		Set<String> touanCitys = new HashSet<>();
		
		touanCitys.add("����");
		touanCitys.add("�t�s��");
		touanCitys.add("�K�w��");
		touanCitys.add("�j�˰�");
		touanCitys.add("Ī�˰�");
		touanCitys.add("�j���");
		touanCitys.add("�s���");
		touanCitys.add("�����");
		touanCitys.add("������");
		touanCitys.add("�s�ΰ�");
		touanCitys.add("�[����");
		touanCitys.add("������");
		
		maps.put(taipei, taipeiCitys);
		maps.put(touan, touanCitys);
		maps1 = maps;
	}
	public static Set<String> getDistrcs() {
		return maps1.keySet();
	}
	public static Set<String> getCitys(String district){
		return maps1.get(district);
	}
	public static void main(String[] args) {
		Set<String> districs = DistrictCityMapping.getDistrcs();
		Set<String> citys = DistrictCityMapping.getCitys("���");
		Set<String> citys2 = DistrictCityMapping.getCitys("�x�_��");
		
		
		for(String dis : districs) {
			System.out.println(dis);
		}
		for(String city : citys) {
			System.out.println(city);
		}
		for(String city : citys2) {
			System.out.println(city);
		}
		
		
	}

}
