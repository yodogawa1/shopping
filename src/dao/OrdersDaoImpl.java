package dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import logic.Orders;

@Repository
public class OrdersDaoImpl implements OrdersDao {

	private SimpleJdbcTemplate template;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.template = new SimpleJdbcTemplate(dataSource);
	}

	private static final String SELECT_ALL_BY_PRIMARY_KEY = "SELECT saleline.update_time, saleline.item_id, item.item_name, (item.price * saleline.quantity) AS itemPrice, saleline.quantity"
			+ " FROM sale_line saleline"
			+ " INNER JOIN sale"
			+ " ON saleline.sale_id = sale.sale_id"
			+ " INNER JOIN item"
			+ " ON saleline.item_id = item.item_id"
			+ " WHERE sale.user_id = ?"
			+ " ORDER BY saleline.update_time DESC, saleline.item_id ASC";

	public List<Orders> findAllByPrimaryKey(String user_id) {
		RowMapper<Orders> mapper = new BeanPropertyRowMapper<Orders>(Orders.class);
		return this.template.query(OrdersDaoImpl.SELECT_ALL_BY_PRIMARY_KEY, mapper, user_id);
	}

}
