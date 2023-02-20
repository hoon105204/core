package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationcontextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        System.out.println("memberService = " + memberService);
        System.out.println("memberService.getClass() = " + memberService.getClass());

        assertInstanceOf(MemberServiceImpl.class, memberService);
    }

    @Test
    @DisplayName("이름 없이 타입으로 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        assertInstanceOf(MemberServiceImpl.class, memberService);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertInstanceOf(MemberServiceImpl.class, memberService);
        // 구체적으로 적는 것은 좋지 않음, 역할에 의존해야 함
    }

    @Test
    @DisplayName("빈 이름으로 조회 X")
    void findBeanByNameX() {
        // 이름으로 조회시 예외 발생해야 할 경우
//        MemberService xxxx = ac.getBean("XXXX", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("XXXX", MemberService.class));
    }


}
