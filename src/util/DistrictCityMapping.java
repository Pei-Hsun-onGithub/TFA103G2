package util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;

public class DistrictCityMapping {

	public static final String TAIPEI = "taipei";
	public static final String TAOYUAN = "taoyuan";

	private static Map<String, Set<String>> _maps1 = null;
	private static Map<String, Set<String>> _maps2 = null;

	static {

		Map<String, Set<String>> maps1 = new HashMap<>();
		Map<String, Set<String>> maps2 = new HashMap<>();
		
		String taipei = "�x�_��";
		String taoyuan = "��饫";

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
		taipeiCitys.add("��s��");

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

		maps1.put(taipei, taipeiCitys);
		maps1.put(taoyuan, touanCitys);

		// ��JSON�Ϊ�Maps�A��K�Hdistrict�W�٨���
		maps2.put(DistrictCityMapping.TAIPEI, taipeiCitys);
		maps2.put(DistrictCityMapping.TAOYUAN, touanCitys);

		_maps1 = maps1;
		_maps2 = maps2;

	}

	public static Set<String> getDistrcs() {
		return _maps1.keySet();
	}

	public static Set<String> getCitys(String district) {
		return _maps1.get(district);
	}

	public static String getJsonDistricsMappingToCitys() {

		Gson gson = new Gson();

		return gson.toJson(_maps2);
	}

	public static void main(String[] args) {
		Set<String> districs = DistrictCityMapping.getDistrcs();
		Set<String> citys = DistrictCityMapping.getCitys("���");
		Set<String> citys2 = DistrictCityMapping.getCitys("�x�_��");

		for (String dis : districs) {
			System.out.println(dis);
		}
		for (String city : citys) {
			System.out.println(city);
		}
		for (String city : citys2) {
			System.out.println(city);
		}

	}

}
