package haha;

import org.aspectj.lang.JoinPoint;
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

    /**
     * 出錯才會執行
     */
    public void throwing() {
        System.out.println("I'm throwing");
    }

    /**
     * 不出錯才會執行
     */
    public void returning(JoinPoint jp, Object xxx) {
        System.out.println("I'm returning");
        System.out.println("回傳值為=" + xxx);

        // 切入點的類和方法名稱
        System.out.println("class name=" + jp.getTarget().getClass().getName());
        System.out.println("method name=" + jp.getSignature().getName());
    }
}
