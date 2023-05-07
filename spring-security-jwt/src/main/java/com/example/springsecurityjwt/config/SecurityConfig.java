package com.example.springsecurityjwt.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtRequestFilter jwtRequestFilter;



protected void configure(HttpSecurity http) throws Exception{
    http
            //отключаем если нет генерации фронта на бэке
            .csrf().disable()

            //настройка доступов к эндпоинтам
            .authorizeRequests()
//            .antMatchers("/api/v1/orders/**").authenticated()
//            .antMatchers("/jdbc/h2-console/**").permitAll()
            .antMatchers("/user/**").hasRole("ADMIN")
            .antMatchers("/demo/**").hasRole("USER")
//            .antMatchers("/user/**").fullyAuthenticated()
            .anyRequest().permitAll()
            .and()

            //отключение хранения сессий - у контекста не будет привязки к сессии
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .headers().frameOptions().disable()
            .and()
            .exceptionHandling()
            .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));

    http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
}

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean () throws Exception {
        return super.authenticationManagerBean();
    }
}
