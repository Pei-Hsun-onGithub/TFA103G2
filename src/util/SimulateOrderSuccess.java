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
import com.levelexp.model.LevelExp;
import com.levelexp.model.LevelExpService;
import com.memberinfo.model.MemberInfo;
import com.memberinfo.model.MemberInfoService;
import com.monsterbook.model.MonsterBook;
import com.monsterbook.model.MonsterBookService;
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
			Integer userId = 20210023;
			// 模擬一筆訂單成功送出
			RsOrderVO orderVO = OrderItemSvc.addRsOrderDAO(20210023, 7001, 1, 1, 0, Date.valueOf(LocalDate.of(2021, 4, 1)), Date.valueOf(LocalDate.of(2021, 4, 2)), Date.valueOf(LocalDate.of(2021, 4, 3)), Date.valueOf(LocalDate.of(2021, 4, 1)), Date.valueOf(LocalDate.of(2021, 4, 1)), 10, "很快送達", 1);

			
			/******* 更新訂單成就進度  **********/
			OrderAchieveHelper orderAchieveHelper = new OrderAchieveHelper(this.getServletContext());
			orderAchieveHelper.updateOrderAchieve(userId);
			
		}
	}
}
