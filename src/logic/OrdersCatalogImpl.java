package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.OrdersDao;

@Service
public class OrdersCatalogImpl implements OrdersCatalog {

	@Autowired
	private OrdersDao ordersDao;

	public List<Orders> getOrdersList(String user_id){
		return this.ordersDao.findAllByPrimaryKey(user_id);
	}
}
