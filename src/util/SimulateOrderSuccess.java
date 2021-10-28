package util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orderlist.model.OrderListDAOService;

public class SimulateOrderSuccess extends HttpServlet {

	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doPost(req, res);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String action = req.getParameter("action");
		
		
		if("simulateOrder".equals(action)) {
			
			
			
			OrderListDAOService orderSvc = new OrderListDAOService();
			
		}
	}
}
