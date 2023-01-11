package com.example.security.configs;

import com.example.security.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Для работы безопасности необходим UserDetailsService и мы его инжектим
     */
    private final UserService userService;


    /**
     * .antMatchers - настройка доступов к эндпоинтам
     * .authenticated() - аутентифицированный пользователь, роль не важна
     * .hasAnyRole - любая роль из списка
     * .anyRequest().permitAll() - остальные эндпоинты доступны всем
     * .formLogin() - предоставление стандартной формы логина можно использовать .httpBasic() - стандартная форма
     * .logout().invalidateHttpSession(true).deleteCookies("JSESSIONID") - при логауте затереть JSESSIONID
     * можно настроить редирект на другие страницы при логине и т.п.
     *
     * */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("Dao Authentication Provider");
        http.authorizeRequests()
                .antMatchers("/auth_page/**").authenticated()
                .antMatchers("/user_info").authenticated()
                .antMatchers("/admin/**").hasAnyRole("ADMIN", "SUPERADMIN") // ROLE_ADMIN, ROLE_SUPERADMIN
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");
//                .and()
//                .sessionManagement()
//                .maximumSessions(1)
//                .maxSessionsPreventsLogin(true);
    }


    /**
     * Создаём бин для хэширования, можем хранить без хэширования или использовать другие варианты
     * */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * DaoAuthenticationProvider - преднастроенный провайдер для хранения юзеров в БД, если хотим другой источник данных,
     * надо изменить на другой провайдер
     * Устанавливаем энкодер
     * Устанавливаем юзерсервис
     *
     * */
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userService);
        return authenticationProvider;
    }
}