package ar.edu.unq.desapp.grupoa.aspectos;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggerAspectExceptionsService {

    Logger logger;
    @AfterThrowing(pointcut = "execution( * ar.edu.unq.desapp.grupoa.services..*(..))",throwing = "exception")
    public void logException(JoinPoint jp,Exception exception) throws Throwable {
        System.out.println("Hola");
        logger = Logger.getLogger(jp.getTarget().getClass());
        logger.error(exception);
    }
}
