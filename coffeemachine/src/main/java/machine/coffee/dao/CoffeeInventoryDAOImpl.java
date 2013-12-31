package machine.coffee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import machine.coffee.bean.CoffeeXML;

@Repository
public class CoffeeInventoryDAOImpl extends CoffeeDAO implements
		CoffeeInventoryDAO {
	
	public CoffeeXML One_getCoffeeAvailability(String coffeeName) {
		String sql = null;
		CoffeeXML coffeeXML = new CoffeeXML();
		try { // Only to see if there are any exceptions thrown. Not needed as these are unchecked.
			sql = "SELECT name FROM COFFEEMACHINE.COFFEE_DETAILS WHERE NAME=?";
			coffeeXML = getJdbcTemplate().queryForObject(sql,
					new Object[] { coffeeName }, new CoffeeRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return coffeeXML;
	}
	public CoffeeXML getCoffeeAvailability(String coffeeName) {
		String sql = null;
		CoffeeXML coffeeXML = new CoffeeXML();
		try { // Only to see if there are any exceptions thrown. Not needed as these are unchecked.
			sql = "SELECT name FROM COFFEEMACHINE.COFFEE_DETAILS WHERE NAME=?";
			coffeeXML = getJdbcTemplate().queryForObject(sql,
					new String[] { coffeeName }, new BeanPropertyRowMapper<CoffeeXML>(CoffeeXML.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return coffeeXML;
	}

	private class CoffeeRowMapper implements RowMapper<CoffeeXML> {
		@Override
		public CoffeeXML mapRow(ResultSet rs, int rowNum) throws SQLException {
			CoffeeXML coffeeXML = new CoffeeXML();
			coffeeXML.setName(rs.getString("name"));
			return coffeeXML;
		}
	}
}