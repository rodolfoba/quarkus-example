package quarkus.example.infrastructure.tracing;

import quarkus.example.library.UseCaseException;
import quarkus.example.library.DomainException;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.Arrays;

@Interceptor
@Traceable
public class TraceableInterceptor {

    @AroundInvoke
    public Object aroundInvoke(InvocationContext context) throws Exception {
        String useCase = context.getMethod().getDeclaringClass().getSuperclass().getSimpleName();
        Object[] parameters = context.getParameters();

        System.out.println(useCase + " requested with values: " + Arrays.toString(parameters));
        Object object;
        try {
            object = context.proceed();
        } catch (UseCaseException | DomainException e) {
            System.out.println(useCase + " refused: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            System.out.println(useCase + " failed: " + e.getMessage());
            throw e;
        }

        System.out.println(useCase + " accomplished with output: " + object);
        return object;
    }

}
