package com.novelasgame.novelas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.novelasgame.novelas.service.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    protected void configure(final HttpSecurity http) throws Exception {

//        http.csrf().disable()
//        .authorizeRequests()
//        //Доступ только для не зарегистрированных пользователей
//        .antMatchers("/registration").not().fullyAuthenticated()
//        //Доступ только для пользователей с ролью Администратор
//        .antMatchers("/admin/**").hasRole("ADMIN")
//        .antMatchers("/news").hasRole("USER")
//        //Доступ разрешен всем пользователей
//        .antMatchers("/", "/resources/**").permitAll();
        
//        http.formLogin()
//        .loginPage("/login");
    }
}
