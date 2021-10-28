package util;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.rsorder.model.RsOrderDAOService;
import com.rsorder.model.RsOrderVO;

@WebServlet("/SimulateOrder.do")
public class SimulateOrder extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doPost(req, res);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String action = req.getParameter("action");
		
		
		if ("makeOrderSuccess".equals(action)) {
			
		
			RsOrderDAOService OrderItemSvc = new RsOrderDAOService();
			// 模擬一筆訂單成功送出
			RsOrderVO orderVO = OrderItemSvc.addRsOrderDAO(20210001, 7001, 1, 1, 0, Date.valueOf(LocalDate.of(2021, 4, 1)), Date.valueOf(LocalDate.of(2021, 4, 2)), Date.valueOf(LocalDate.of(2021, 4, 3)), Date.valueOf(LocalDate.of(2021, 4, 1)), Date.valueOf(LocalDate.of(2021, 4, 1)), 10, "很快送達", 1);
			
		}
	}
}
