package com.vizer.plasticube.configurations;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.vizer.plasticube.security.UrlUserService;
import com.vizer.plasticube.utils.MD5Util;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UrlUserService urlUserService;
    @Autowired
    SessionRegistry sessionRegistry;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/logout").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/build/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/src/**").permitAll()
                .antMatchers("/vendors/**").permitAll()
                .antMatchers("/fonts/**").permitAll()
                .antMatchers("/favicon.ico").permitAll()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement().maximumSessions(1).sessionRegistry(sessionRegistry)
                .and()
                .and()
                .formLogin()
                    .loginPage("/login")    //自定义登录页面
                    .defaultSuccessUrl("/plasticube")
                    .permitAll()            //允许所有人访问该路由
                .and()
                .logout()                    //自定义登出操作
                .logoutUrl("/logout")                                                 
                .logoutSuccessUrl("/login")                                           
                .logoutSuccessHandler((req,resp,auth)->{
                    //登出成功处理函数
                    System.out.println("logout success");
                    resp.sendRedirect("/login?logout");
                })                              
                .invalidateHttpSession(true)   
                .clearAuthentication(true)                                          
                .addLogoutHandler((req,resp,auth)->{
                    //登出处理函数
                    System.out.println("logout------");
                })  
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(urlUserService).passwordEncoder(new PasswordEncoder() {

            @Override
            public String encode(CharSequence rawPassword) {
                return MD5Util.encode((String) rawPassword);
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encodedPassword.equals(MD5Util.encode((String) rawPassword));
            }
        });
    }

    @Bean
    public SessionRegistry getSessionRegistry(){
        SessionRegistry sessionRegistry=new SessionRegistryImpl();
        return sessionRegistry;
    }
}