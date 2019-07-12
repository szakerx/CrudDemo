package com.example.shop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


//Klasa odpowiedzialna za ustawienia ochrony, jest w budowie, skończyłem na 18 odcinku


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Będzie przerobione na pobieranie z bazy danych, lista autoryzowanych użytkowników
        auth
                .inMemoryAuthentication().
                withUser("admin")
                .password(passwordEncoder().encode("admin123")).roles("ADMIN")
                .and()
                .withUser("szymon")
                .password(passwordEncoder().encode("szymon123")).roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Kto do czego ma dostęp lub jest też blokowany
        http
                .authorizeRequests()
                .antMatchers("/products").authenticated()
                .antMatchers("/users").hasRole("ADMIN")
                .and()
                .httpBasic();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        //Kodowanie hasła potrzebne do logowania, bez tego nie da się logować
        return new BCryptPasswordEncoder();
    }
}
