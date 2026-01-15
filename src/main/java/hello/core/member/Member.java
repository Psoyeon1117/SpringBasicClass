package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;

public class Member {
    private Long id;
    private String name;
    private Grade grade;
    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
    /**
     * //스프링 빈이 아닌 클래스에서 @Autowired가 적용되는지 테스트해봄
    private MemberRepository memberRepository;
    @Autowired
    public Member(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
    **/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

}
