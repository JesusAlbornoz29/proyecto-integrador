package com.grupo3.digitalbook.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity

public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
// public class SecurityConfiguration {


    private AppUserService userService;


    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfiguration(AppUserService userService, BCryptPasswordEncoder passwordEncoder){
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure (HttpSecurity http) throws Exception{
        http
                .csrf()
                .disable()
                .authorizeRequests()
//                .antMatchers("/turno/**").hasAnyRole("USER", "ADMIN")
//                .antMatchers("/paciente/**", "/odontologo/**").hasRole("ADMIN")

                .anyRequest().permitAll()
                .and()
                .formLogin()
                .and()
                .rememberMe().key("uniqueAndSecret")
                .and()
                .logout().deleteCookies("JSEESSIONID")
        ;

        http
                .csrf().disable()
                .headers().frameOptions().disable();
    }

        // Este configure es de autorizacion
        @Override
    protected  void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(daoAuthenticationProvider());
        }


        @Bean
        public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userService);

        return provider;
        }

}
