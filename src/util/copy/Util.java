package util.copy;

public class Util {
	
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	// MySQL 8.0.13隞亙���靽�erverTimezone閮剖��
	public static final String URL = 
			"jdbc:mysql://localhost:3306/fm01?"
//			+ "useSSL=false&"                   // 銝蝙������蝺� (���������)
//			+ "rewriteBatchedStatements=true&"  // �甈⊥���閬迨鞈��
			+ "serverTimezone=Asia/Taipei";     // 閮剖���鞈��
//			+ "allowPublicKeyRetrieval=true&"   // ���ySQL 8隞亙��撠�Ⅳ�摮���身摰�
//			+ "useUnicode=true&"                // 雿輻Unicode蝺函Ⅳ (銝剜�����Ⅳ)
//			+ "characterEncoding=utf-8";        // 摮��UTF-8閮剖��
	
	public static final String USER = "root";
	
	public static final String PASSWORD = "password";
}
