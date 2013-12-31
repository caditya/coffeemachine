package machine.coffee.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
public class CoffeeDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	protected int update(String sql){
		return jdbcTemplate.update(sql);
	}

	protected int add(String sql){
		return jdbcTemplate.update(sql);
	}

	protected int delete(String sql){
		return jdbcTemplate.update(sql);
	}

}
