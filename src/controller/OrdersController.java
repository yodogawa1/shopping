package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import exception.LoginRequiredException;
import logic.Orders;
import logic.Shop;
import logic.User;
import utils.WebConstants;

@Controller
public class OrdersController {
	@Autowired
	private Shop shopService;

	@RequestMapping
	public ModelAndView orders(HttpSession session) {
		// ログインを確認
		User loginUser = (User) session.getAttribute(WebConstants.USER_KEY);
		if (loginUser == null) {
			throw new LoginRequiredException("ログインしていません。");
		}
		// 商品一覧情報を取得
		List<Orders> ordersList = this.shopService.getOrdersList(loginUser.getUserId());
		// モデルの作成
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ordersList", ordersList);

		// 戻り値となるModelAndViewインスタンスを作成
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(model);


		modelAndView.addObject("loginUser", loginUser);


		return modelAndView;

	}

}
