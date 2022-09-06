package com.example.testproject.config;

import com.example.testproject.handler.CustomLogOutHandler;
import com.example.testproject.handler.CustomLoginFailureHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomLogOutHandler customLogOutHandler;
    @Autowired
    private CustomLoginFailureHandler customLoginFailureHandler;
    @Bean
    public UserDetailsService getUserDetailsService(){
        return new UserDetailsServiceImpl();
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(this.getUserDetailsService());
        auth.setPasswordEncoder(this.bCryptPasswordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
        // We need to tell which kind of authentication we are using.
        // Such as JDBC Authentication, Dao Authentication.
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/").permitAll().and().formLogin()
                .and().formLogin().loginPage("/login").loginProcessingUrl("/authenticate").defaultSuccessUrl("/admin/invoice", true).failureHandler(customLoginFailureHandler)
               // .and().formLogin()
                .and().logout().logoutUrl("/admin/logout").logoutSuccessUrl("/login").logoutSuccessHandler(customLogOutHandler)
                .and().csrf().disable();
    }
}
