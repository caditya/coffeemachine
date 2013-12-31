package machine.coffee.training.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Simple BPP that automatically adds logging functionality to all objects that implement
 * {@link com.joshlong.spring.walkingtour.ioc.manybeans.Timed}
 */
@Component
public class MethodTimeLoggingBeanPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        /*ProxyFactory factory = new ProxyFactory();
        factory.addAdvice(new TimeLoggingMethodInterceptor());
        factory.setTarget(bean); */
        //return (Object) factory.getProxy();
    	System.out.println("In here...");
    	return bean;
    }


    /**
     * logs the method invocation times
     */
    
}
