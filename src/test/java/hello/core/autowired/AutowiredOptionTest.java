package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredOptionTest {

    @Test
    void autowiredOptionTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);


    }

    static class TestBean{
        @Autowired(required = false)
        //주입할 대상이 없으면 메소드 호출이 안된다.
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1 = "+noBean1);
        }

        @Autowired
        //호출이 되고 null값이 들어와있다.
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = "+noBean2);
        }
        @Autowired
        //호출이 되고 null이 Optional에 감싸져있다.
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("noBean3 = "+noBean3);
        }

    }

}
