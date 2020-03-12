package haha;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class UpDown {
    public void up() {
        System.out.println("I'm up");
    }

    public void down() {
        System.out.println("I'm down");
    }

    public void two(ProceedingJoinPoint pjp) {
        System.out.println("I'm two");
        try {
            pjp.proceed(); // 沒有這行就不會執行切入點的方法
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }
}
