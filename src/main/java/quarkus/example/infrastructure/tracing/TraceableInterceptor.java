package quarkus.example.infrastructure.tracing;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Traceable
public class TraceableInterceptor {

    @AroundInvoke
    public Object aroundInvoke(InvocationContext context) throws Exception {
        System.out.println("intercepting...");
        return context.proceed();
    }

}
