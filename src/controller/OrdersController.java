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
		// ���O�C�����m�F
		User loginUser = (User) session.getAttribute(WebConstants.USER_KEY);
		if (loginUser == null) {
			throw new LoginRequiredException("���O�C�����Ă��܂���B");
		}
		// ���i�ꗗ�����擾
		List<Orders> ordersList = this.shopService.getOrdersList(loginUser.getUserId());
		// ���f���̍쐬
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ordersList", ordersList);

		// �߂�l�ƂȂ�ModelAndView�C���X�^���X���쐬
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(model);


		modelAndView.addObject("loginUser", loginUser);


		return modelAndView;

	}

}
