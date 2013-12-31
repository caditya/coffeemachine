package machine.coffee.training.bpp;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class TimeLoggingMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        Object result = null;
        if (invocation.getMethod().getAnnotation(Timed.class) != null) {
            long start = System.currentTimeMillis();
            result = invocation.proceed();
            long stop = System.currentTimeMillis();
            System.out.println(invocation.getMethod().getName() + ": " + (stop - start) + "ms");
        } else {
            result = invocation.proceed();
        }
        return result;
    }
}