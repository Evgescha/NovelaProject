package com.novelasgame.novelas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.novelasgame.novelas.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
 
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
          .csrf().disable()
          .authorizeRequests()
          .antMatchers("/admin/**").hasRole("ADMIN")
          .antMatchers("/login","/registration").anonymous()
          .antMatchers("/StartPage.jpg").permitAll()
          .anyRequest().authenticated()
          .and()
          .formLogin()
          .loginPage("/login")
          .loginProcessingUrl("/perform_login")
          .defaultSuccessUrl("/", true)
          .failureUrl("/login?error=true")
          .and()
          .logout()
          .logoutUrl("/logout")
          .logoutSuccessUrl("/login")
          .deleteCookies("JSESSIONID");
    }
     
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
