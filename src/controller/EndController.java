package controller;

import javax.servlet.http.HttpSession;

import logic.Cart;
import logic.Shop;
import logic.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import utils.WebConstants;
import exception.CartEmptyException;
import exception.LoginRequiredException;

@Controller
public class EndController {

	@Autowired
	private Shop shopService;

	@RequestMapping
	public ModelAndView end(HttpSession session) {

		// ���O�C�����m�F
		User loginUser = (User) session.getAttribute(WebConstants.USER_KEY);
		if (loginUser == null) {
			throw new LoginRequiredException("���O�C�����Ă��܂���B");
		}

		// �J�[�g�̏�Ԃ��m�F
		Cart cart = (Cart) session.getAttribute(WebConstants.CART_KEY);
		if (cart == null || cart.isEmpty()) {
			throw new CartEmptyException("�J�[�g����ł��B");
		}

		// ����f�[�^�L�^
		this.shopService.checkout(loginUser, cart);

		// �J�[�g���폜
		cart.clearAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("loginUser", loginUser);
		return modelAndView;
	}
}