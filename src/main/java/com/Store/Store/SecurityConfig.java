/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Store.Store;

import com.Store.Store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
/*import static org.springframework.security.authorization.AuthorityAuthorizationManager.hasAnyRole;*/
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


/**
 *
 * @author Jeffrey Mojica S
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private UserService userDetails;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public UserService getUserService(){
        return new UserService();
    }
    
    @Bean
    DaoAuthenticationProvider authenticationprovider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(getUserService());
        return daoAuthenticationProvider;
    }
    
    @Bean
    public AuthenticationSuccessHandler appAuthenticationSuccessHandler(){
        return new AppAuthenticationSuccessHandler();
    }
    
       public SecurityConfig(UserService userPrincipalDetailsService){
        this.userDetails = userPrincipalDetailsService;
    }
    
       
       @Override
       protected void configure(AuthenticationManagerBuilder auth){
           
           auth.authenticationProvider(authenticationprovider());
       }
       
       //El siguiente metodo funciona para hacer la autenticacion del usuario
       @Override
       protected void configure(HttpSecurity http) throws Exception {
           http.authorizeRequests()
                   .antMatchers("/persona","login")
                   .hasRole("ADMIN")
                   .antMatchers("/personaN", "/persona", "/","/login")
                   .hasAnyRole("USER", "vENDEDOR", "ADMIN")
                   .anyRequest().authenticated()
                   .and()
                   .formLogin()
                   .loginPage("/login").permitAll().defaultSuccessUrl("/", true).and().logout()
                   .logoutUrl("/logout")
                   .logoutSuccessUrl("/");
                   
                   
                   
           
       }

   
     
    
}
