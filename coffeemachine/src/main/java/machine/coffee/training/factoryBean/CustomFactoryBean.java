package machine.coffee.training.factoryBean;

import javax.naming.NamingException;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.jndi.JndiObjectFactoryBean;

public class CustomFactoryBean {
	
	public CustomFactoryBean() throws IllegalArgumentException, NamingException{
		JndiObjectFactoryBean jFactoryBean = new JndiObjectFactoryBean();
		jFactoryBean.setJndiName("java:comp/env/dbc/DatabaseName");
		jFactoryBean.afterPropertiesSet();
	}

}
