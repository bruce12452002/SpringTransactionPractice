package haha;

import haha.ccc.Tuv;
import haha.service.NoInterface;
import haha.service.UserService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Stream;

@ContextConfiguration(locations = {"classpath*:/applicationContext.xml"})
@RunWith(SpringRunner.class)
public class TestTransaction {
    @Autowired
    private UserService service;

    @Autowired
    private NoInterface noInterface;

    @Autowired
    private Tuv tuv;

    /**
     * 測試 spring 設定檔
     */
    @Test
    @Ignore
    public void testConfigXml() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        Stream.of(app.getBeanDefinitionNames()).forEach(System.out::println);
        app.close();
    }

    /**
     * 沒有 transaction
     */
    @Test
    @Ignore
    public void testTransaction1() {
        // 如果 IDE 沒設定自動 commit，要重整才看的到最新的結果
        System.out.println("成功筆數=" + service.updateName1(1001));
        // System.out.println("成功筆數=" + noInterface.updateName(1001));
    }

    /**
     * 自己手動增加 transaction
     */
    @Test
    @Ignore
    public void testTransaction2() {
        System.out.println("成功筆數=" + service.updateName2(1001));
    }

    /**
     * 測試 AOP
     * [Xlint:invalidAbsoluteTypeName] 為切點的表達式錯誤(最可能是方法沒寫)
     */
//    @Ignore
    @Test
    public void testSimpleAOP() {
        tuv.aaa();
    }

    /**
     * 自己寫 transaction
     */
    @Test
    @Ignore
    public void testTxAdviceSelf() {
        service.updateName1(1001);
    }

    /**
     * 使用 spring 的 transaction
     */
    @Ignore
    @Test
    public void testTxAdvice() {
        System.out.println("成功筆數=" + service.updateName1(1001));
    }

    /**
     * 測試 annotation 註解
     */
    @Ignore
    @Test
    public void testAnnotation() {
        service.updateName3(1001);
    }

    /**
     * 測試沒有介面的事務，沒問題的
     */
    @Ignore
    @Test
    public void testNoInterface() {
        noInterface.updateName(1001);
    }
}
