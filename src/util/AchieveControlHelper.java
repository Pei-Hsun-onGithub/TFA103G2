package util;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.achieve.model.Achieve;
import com.achieve.model.AchieveService;
import com.achieveprogress.model.AchieveProgress;
import com.achieveprogress.model.AchieveProgressService;
import com.foodarticle.model.FoodArticleService;
import com.foodarticle.model.FoodArticleVO;
import com.levelexp.model.LevelExp;
import com.levelexp.model.LevelExpService;
import com.memberinfo.model.MemberInfo;
import com.memberinfo.model.MemberInfoService;
import com.monsterbook.model.MonsterBook;
import com.monsterbook.model.MonsterBookService;
import com.rsorder.model.RsOrderDAOService;
import com.rsorder.model.RsOrderVO;

public class AchieveControlHelper {

	private ServletContext servletContext;
	private HttpServletRequest req;
	private HttpServletResponse res;
	private AchieveService archieveSvc;
	private RsOrderDAOService rsOrderSvc;
	private FoodArticleService foodArticleSvc;
	private MemberInfoService memeInfoSvc;
	private AchieveProgressService archieveProgressSvc;
	private Integer userId;
	
	public AchieveControlHelper(HttpServletRequest req, HttpServletResponse res) {
		this.servletContext = this.req.getServletContext();
		this.req = req;
		this.res = res;
		this.archieveSvc = new AchieveService();
		this.rsOrderSvc = new RsOrderDAOService();
		this.foodArticleSvc = new FoodArticleService();
		this.memeInfoSvc = new MemberInfoService();
		this.archieveProgressSvc = new AchieveProgressService();
		HttpSession session = this.req.getSession();
		this.userId = (Integer) session.getAttribute("userId");
	}
	
	public void helpMeUpdateOrderAchieve() {
		
		
		Achieve achieveVO = archieveSvc.getAvailableAchieve(servletContext);
		//System.out.println("achieveVO=" + achieveVO);
		Integer achieveId = achieveVO.getAchiId();
		
		List<RsOrderVO> orders = rsOrderSvc.getOrdersByUserId(userId);
		List<FoodArticleVO> articles = foodArticleSvc.getArticlesByUserId(userId);
		List<MonsterBook> monsters = new MonsterBookService().getAll();
		
		MemberInfo memInfo = memeInfoSvc.getOneMemberInfo(userId);
		
		// 如果是第一次參加任務成就，就新增一筆成就進度
		if(archieveProgressSvc.getOneAchieveProgress(userId, achieveId) == null) {
			
			archieveProgressSvc.addAchieveProgress(userId, achieveId, articles.size(), orders.size(), achieveVO.getOpenDate(), 13);
		}
		
		// 將目前的成就任務與使用者訂單成立的狀態，更新到成就進度DB
		// 注意 :userId 與 AchieveId是「複合主鍵」
		AchieveProgress userAchieveProgress = archieveProgressSvc.updateAchieveProgress(userId, achieveVO.getAchiId(), articles.size(), orders.size(), achieveVO.getOpenDate(), 13);

		// 檢查達標
		ArchieveChecker archieveChecker = new ArchieveChecker();
		
		// 如果達成訂單或食記目標就更新金幣與經驗值到這位使用者
		if(archieveChecker.isComplete(achieveVO, userAchieveProgress)) {
			
			// 給予獎勵(金幣、飼料)
			Integer coinsFee = achieveVO.getGainGold();
			Integer feedFee = achieveVO.getGainFeed();
			memInfo = memeInfoSvc.getOneMemberInfo(userId);
			Integer exp = new Integer(memInfo.getExp()) + new Integer(feedFee);
			
			// 更新獎勵至這位使用者
			memeInfoSvc.updateMemberInfo(userId, memInfo.getEmail(), memInfo.getPwd(), memInfo.getUserName(), memInfo.getGender(), memInfo.getBirthday(), memInfo.getPhone(), memInfo.getPic(), memInfo.getRegisterDate(), coinsFee, feedFee, memInfo.getMonsterId(), memInfo.getMonsterNickName(), memInfo.getLv(), exp, memInfo.getSta());

		}
		
		//飼料等於經驗值
		
		
		LevelExpService levelExpSvc = new LevelExpService();
		List<LevelExp> levelExps = levelExpSvc.getAll();
		EvolutionChecker evolutionChecker = new EvolutionChecker(levelExps, monsters);
		
		//檢查怪獸是否可以升等
		if(evolutionChecker.isTimeToGrowup(memInfo)) {
			//System.out.println("升等進入");
			//如果可以升等就更新這位使用者的LV
			Integer newLv = evolutionChecker.getNewLevel(memInfo);
			// 升等之後，將Exp歸零(新等級重新開始累計經驗值)
			Integer newExp = new Integer(0);
			
			// 更新這位使用者的經驗值和等級
			MemberInfo m = memeInfoSvc.updateMemberInfo(userId, memInfo.getEmail(), memInfo.getPwd(), memInfo.getUserName(), memInfo.getGender(), memInfo.getBirthday(), memInfo.getPhone(), memInfo.getPic(), memInfo.getRegisterDate(), memInfo.getGold(), newExp, memInfo.getMonsterId(), memInfo.getMonsterNickName(), newLv, newExp, memInfo.getSta());
			//System.out.println("升等後的LV=" + m);
		}
		
		//檢查怪獸是否可以進化

		if(evolutionChecker.isTimeToEvolution(memInfo)) {
			
			
		}
	}
}
