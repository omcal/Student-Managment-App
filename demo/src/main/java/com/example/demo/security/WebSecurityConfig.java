package com.example.demo.security;

import com.example.demo.service.Member.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private  final MemberService memberService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    //general accessibility setting

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers(HttpMethod.POST, "/registration").permitAll()
                .antMatchers("/student/**").hasAnyAuthority("STUDENT")
                .antMatchers("/assistant/**").hasAnyAuthority("ASSISTANT")
                .antMatchers(HttpMethod.POST,"/hw/**").hasAnyAuthority("ASSISTANT","ACADEMICIAN")
                .antMatchers(HttpMethod.POST,"/coursework/**").hasAnyAuthority("ASSISTANT","ACADEMICIAN")
                .antMatchers(HttpMethod.GET,"/hw/**").hasAnyAuthority("ASSISTANT","ACADEMICIAN","STUDENT")
                .antMatchers("/grade/**").hasAnyAuthority("ASSISTANT","ACADEMICIAN")
                .antMatchers(HttpMethod.POST,"/assistant/**").hasAnyAuthority("ASSISTANT")
                .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
                .antMatchers("/academician/**").hasAnyAuthority("ACADEMICIAN")
                .antMatchers(HttpMethod.POST,"/academician/**").hasAnyAuthority("ACADEMICIAN")
                .antMatchers("/login").permitAll()
                .antMatchers("/registration").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout().clearAuthentication(true).logoutSuccessUrl("/").permitAll()
                .and()
                .formLogin().and()
                .csrf().disable().httpBasic();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    // we need this for hashing to password
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(memberService);
        return provider;
    }
}
