package com.my.hellospring;

import com.my.hellospring.repository.JdbcMemberRepository;
import com.my.hellospring.repository.JdbcTemplateMemberRepository;
import com.my.hellospring.repository.JpaMemberRepository;
import com.my.hellospring.repository.MemberRepository;
import com.my.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
@Configuration
public class SpringConfig {

    //private final DataSource dataSource;
    private EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
        // return new JdbcMemberRepository(dataSource); // 순수 Jdbc
        // return new JdbcTemplateMemberRepository(dataSource); // Spring Jdbc Template
        return new JpaMemberRepository(em);
    }
}