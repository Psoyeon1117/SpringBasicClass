package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AutoAppConfigTest {
    @Test
    void basicScan(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean("memberServiceImpl",MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);

        OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);
        MemberRepository memberRepository = bean.getMemberRepository();
        assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }
        /**
    @Test
    void notComponentAutowired(){
        //스프링 빈이 아닌 클래스에서 @Autowired가 적용되는지 테스트해봄
        //Member클래스는 순수 자바 클래스이다.(@Component나 @bean이 아닌)
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        Member member = new Member(3L, "name", Grade.BASIC);
        MemberRepository memberofRepository = member.getMemberRepository();
        System.out.println("member's memberRepository" + memberofRepository);
        assertThat(memberofRepository).isNull();
    }
    **/
}
