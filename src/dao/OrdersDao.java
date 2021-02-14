package dao;

import java.util.List;

import logic.Orders;

public interface OrdersDao {

	List<Orders> findAllByPrimaryKey(String user_id);

}
