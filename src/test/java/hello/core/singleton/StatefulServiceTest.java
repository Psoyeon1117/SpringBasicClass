package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class StatefulServiceTest {
@Test
@DisplayName("싱글톤 방식의 문제점: 상태유지")
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        //Thread1 : 유저A가 10000원 주문
        statefulService1.order("userA", 10000);
        //Thread2 : 유저B가 20000원 주문
        statefulService2.order("userB", 20000);

        //유저A가 주문금액을 조회한다.
        //유저A의 기대와는 다르게 금액이 20000원이 나온다.
        int price = statefulService1.getPrice();
        System.out.println("유저A의 price = " + price);
        assertThat(price).isEqualTo(20000);
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}
