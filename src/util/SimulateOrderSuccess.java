package util;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.achieve.model.Achieve;
import com.achieve.model.AchieveService;
import com.achieveprogress.model.AchieveProgress;
import com.achieveprogress.model.AchieveProgressService;
import com.foodarticle.model.FoodArticleService;
import com.foodarticle.model.FoodArticleVO;
import com.rsorder.model.RsOrderDAOService;
import com.rsorder.model.RsOrderVO;

@WebServlet("/SimulateOrder.do")
public class SimulateOrderSuccess extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doPost(req, res);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String action = req.getParameter("action");
		
		
		if ("makeOrderSuccess".equals(action)) {
			
			//TODO: 擷取前端資料
			
			
			RsOrderDAOService OrderItemSvc = new RsOrderDAOService();
			// 模擬一筆訂單成功送出
			RsOrderVO orderVO = OrderItemSvc.addRsOrderDAO(20210001, 7001, 1, 1, 0, Date.valueOf(LocalDate.of(2021, 4, 1)), Date.valueOf(LocalDate.of(2021, 4, 2)), Date.valueOf(LocalDate.of(2021, 4, 3)), Date.valueOf(LocalDate.of(2021, 4, 1)), Date.valueOf(LocalDate.of(2021, 4, 1)), 10, "很快送達", 1);
		
			
			// 使用到的Services
			AchieveService archieveSvc = new AchieveService();
			AchieveProgressService archieveProgressSvc = new AchieveProgressService();
			RsOrderDAOService rsOrderSvc = new RsOrderDAOService();
			FoodArticleService foodArticleSvc = new FoodArticleService();
			
			Integer userId = 20210001;
			
//			Achieve nowAchieve = archieveSvc.getOneAchieve(2003);
			
			// 先模擬放入ServletContext中一個Mission
			ServletContext servletContext = this.getServletContext();
//			servletContext.setAttribute("achieveMission", nowAchieve);
			
			Achieve achieveVO = archieveSvc.getAvailableAchieve(servletContext);
			Integer achieveId = achieveVO.getAchiId();
			
			List<RsOrderVO> orders = rsOrderSvc.getOrdersByUserId(userId);
			List<FoodArticleVO> articles = foodArticleSvc.getArticlesByUserId(userId);
			
			// 如果是第一次參加任務成就，就新增一筆成就進度
			if(archieveProgressSvc.getOneAchieveProgress(userId, achieveId) == null) {
				
				archieveProgressSvc.addAchieveProgress(userId, achieveId, articles.size(), orders.size(), achieveVO.getOpenDate(), 13);
			}
			
			// 將目前的成就任務與使用者訂單成立的狀態，更新到成就進度DB
			// 注意 :userId 與 AchieveId是「複合主鍵」
			AchieveProgress userAchieveProgress = archieveProgressSvc.updateAchieveProgress(userId, achieveVO.getAchiId(), articles.size(), orders.size(), achieveVO.getOpenDate(), 13);

			// 檢查達標
			ArchieveChecker archieveChecker = new ArchieveChecker();
			
			if(archieveChecker.isComplete(achieveVO, userAchieveProgress)) {
				
			}
			
			
			System.out.println("orders=" + orders);
			System.out.println("此使用者訂單總數=" + orders.size());
			System.out.println("AchiName = " + achieveVO.getAchiName());
		//	System.out.println("achieveProgressVO : " + "userId = " + achieveProgressVO.getUserId()+ " achieveId " + achieveProgressVO.getAchiId());
			
			//servletContext.removeAttribute("achieveMission");
			//System.out.println("servletContext的achieveMission = " + servletContext.getAttribute("achieveMission"));
			
			
		}
	}
}
