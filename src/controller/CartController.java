package controller;

import javax.servlet.http.HttpSession;

import logic.Cart;
import logic.Item;
import logic.ItemSet;
import logic.Shop;
import logic.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import utils.WebConstants;

@Controller
public class CartController {

	@Autowired
	private Shop shopService;

	@RequestMapping(value = "/cart/cartAdd")
	public ModelAndView add(Integer itemId, Integer quantity, HttpSession session) {

		// �ǉ����i�����擾
		Item selectedItem = this.shopService.getItemByItemId(itemId);

		// �J�[�g���擾
		Cart cart = (Cart) session.getAttribute(WebConstants.CART_KEY);
		if (cart == null) {
			cart = this.shopService.getCart();
			session.setAttribute(WebConstants.CART_KEY, cart);
		}

		// �J�[�g�ɏ��i��ǉ�
		cart.push(new ItemSet(selectedItem, quantity));

		// �J�[�g���ƃ��b�Z�[�W��ݒ�
		ModelAndView modelAndView = new ModelAndView("cart/cart");
		modelAndView.addObject("message", selectedItem.getItemName() + "��" + quantity + "�A�J�[�g�ɒǉ����܂����B");
		modelAndView.addObject("cart", cart);

		// ���O�C�����[�U���擾
		User loginUser = (User) session.getAttribute(WebConstants.USER_KEY);
		if (loginUser != null) {
			modelAndView.addObject("loginUser", loginUser);
		}
		return modelAndView;
	}

	@RequestMapping(value = "/cart/cartClear")
	public ModelAndView clear(HttpSession session) {

		// �J�[�g���擾
		Cart cart = (Cart) session.getAttribute(WebConstants.CART_KEY);
		if (cart == null) {
			cart = this.shopService.getCart();
			session.setAttribute(WebConstants.CART_KEY, cart);
		}

		// �J�[�g���N���A
		cart.clearAll();

		// ���b�Z�[�W��ݒ�
		ModelAndView modelAndView = new ModelAndView("cart/cart");
		modelAndView.addObject("message", "�J�[�g����ɂ��܂����B");

		// ���O�C�����[�U���擾
		User loginUser = (User) session.getAttribute(WebConstants.USER_KEY);
		if (loginUser != null) {
			modelAndView.addObject("loginUser", loginUser);
		}
		return modelAndView;
	}

	@RequestMapping(value = "/cart/cartConfirm")
	public ModelAndView confirm(HttpSession session) {

		// �J�[�g���擾
		Cart cart = (Cart) session.getAttribute(WebConstants.CART_KEY);
		if (cart == null) {
			cart = this.shopService.getCart();
			session.setAttribute(WebConstants.CART_KEY, cart);
		}

		// �J�[�g����ݒ�
		ModelAndView modelAndView = new ModelAndView("cart/cart");
		modelAndView.addObject("cart", cart);

		// ���O�C�����[�U���擾
		User loginUser = (User) session.getAttribute(WebConstants.USER_KEY);
		if (loginUser != null) {
			modelAndView.addObject("loginUser", loginUser);
		}
		return modelAndView;
	}
}