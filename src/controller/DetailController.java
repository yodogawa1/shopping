package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import logic.Item;
import logic.Shop;
import logic.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import utils.WebConstants;

@Controller
public class DetailController {

	@Autowired
	private Shop shopService;

	@RequestMapping
	public ModelAndView handleRequestInternal(Integer itemId, HttpSession session) {

		// �I�����ꂽ���iID���珤�i�����擾
		Item item = this.shopService.getItemByItemId(itemId);

		// ���f���̍쐬
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("item", item);

		// �߂�l�ƂȂ�ModelAndView�C���X�^���X���쐬
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(model);

		// ���O�C�����[�U���擾
		User loginUser = (User) session.getAttribute(WebConstants.USER_KEY);
		if (loginUser != null) {
			modelAndView.addObject("loginUser", loginUser);
		}
		return modelAndView;
	}
}