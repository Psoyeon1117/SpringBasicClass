package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import
        org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.assertj.core.api.Assertions.*;
public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new
                AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService1 = ac.getBean("memberService", MemberServiceImpl.class);
        MemberServiceImpl memberService2 = ac.getBean("memberService", MemberServiceImpl.class);
        //@bean만 사용해도 스프링 빈으론 저장된다. (getbean을 할 때마다 bean을 생성하는 것은 아니다.)
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
        //모두 같은 인스턴스를 참고하고 있다.
        System.out.println("memberService1 -> memberRepository = " + memberService1.getMemberRepository());
        System.out.println("memberService2 -> memberRepository = " + memberService2.getMemberRepository());
        System.out.println("orderService -> memberRepository  = " + orderService.getMemberRepository());
        System.out.println("memberRepository = " + memberRepository);
        //모두 같은 인스턴스를 참고하고 있다.
        assertThat(memberService1.getMemberRepository()).isSameAs(memberRepository);
        assertThat(memberService2.getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }
}
