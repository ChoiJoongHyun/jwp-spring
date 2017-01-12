package next.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);
	@Before("within(next.dao..*)")	//.. 은 dao 밑 모든 패키지.
	public void logging(JoinPoint jp) {
		Object[] args = jp.getArgs();	//메소드에 인자로 전달되는 아규먼트의 배열. 이걸 디버깅으로 찍는다.
		for(Object arg : args) {
			log.debug(jp.toShortString() + " , arg : " + arg);
		}
	}
}
