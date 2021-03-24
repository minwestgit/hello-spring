package com.my.hellospring;

import com.my.hellospring.aop.TimeTraceAop;
import com.my.hellospring.repository.MemberRepository;
import com.my.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }


//    private final DataSource dataSource;
//    private EntityManager em;

//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

//    @Bean
//    public MemberRepository memberRepository() {
//        // return new MemoryMemberRepository();
//        // return new JdbcMemberRepository(dataSource); // 순수 Jdbc
//        // return new JdbcTemplateMemberRepository(dataSource); // Spring Jdbc Template
//        return new JpaMemberRepository(em);
//    }

}