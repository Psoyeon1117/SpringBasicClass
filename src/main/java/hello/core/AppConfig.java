package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig{
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(getMemberRepository());
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
    }

    @Bean
    public DiscountPolicy getDiscountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }


}







//only 자바만 사용해서 구현한 내용
//
//public class AppConfig {
//    //애플리케이션의 실제 동작에 필요한 구현 객체를 생성, 주입해준다.
//    public MemberService memberService(){
//        return new MemberServiceImpl(getMemberRepository());
//    }
//
//    public OrderService orderService(){
//        return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
//    }
//
//    private DiscountPolicy getDiscountPolicy() {
////        return new FixDiscountPolicy();
//        return new RateDiscountPolicy();
//    }
//
//    private MemberRepository getMemberRepository() {
//        return new MemoryMemberRepository();
//    }
//}
