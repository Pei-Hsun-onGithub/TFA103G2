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
		
		String taipei = "台北市";
		String taoyuan = "桃園市";

		Set<String> taipeiCitys = new HashSet<>();

		taipeiCitys.add("中正區");
		taipeiCitys.add("大同區");
		taipeiCitys.add("中山區");
		taipeiCitys.add("松山區");
		taipeiCitys.add("大安區");
		taipeiCitys.add("萬華區");
		taipeiCitys.add("信義區");
		taipeiCitys.add("士林區");
		taipeiCitys.add("北投區");
		taipeiCitys.add("內湖區");
		taipeiCitys.add("南港區");
		taipeiCitys.add("文山區");

		Set<String> touanCitys = new HashSet<>();

		touanCitys.add("桃園區");
		touanCitys.add("龜山區");
		touanCitys.add("八德區");
		touanCitys.add("大溪區");
		touanCitys.add("蘆竹區");
		touanCitys.add("大園區");
		touanCitys.add("龍潭區");
		touanCitys.add("平鎮區");
		touanCitys.add("楊梅區");
		touanCitys.add("新屋區");
		touanCitys.add("觀音區");
		touanCitys.add("原住民區");

		maps1.put(taipei, taipeiCitys);
		maps1.put(taoyuan, touanCitys);

		// 給JSON用的Maps，方便以district名稱取值
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
		Set<String> citys = DistrictCityMapping.getCitys("桃園");
		Set<String> citys2 = DistrictCityMapping.getCitys("台北市");

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
