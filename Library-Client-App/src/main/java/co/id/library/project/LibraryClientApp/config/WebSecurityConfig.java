
package co.id.library.project.LibraryClientApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

@Configuration

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/css/**", "/js/**").permitAll()
                .antMatchers("/login/**", "/**").permitAll()
                .antMatchers("/dashboard", "/trainee/**", "/trainer/**", "/admin/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/login").loginProcessingUrl("/login")
                .failureForwardUrl("/login?error")
                .successForwardUrl("/dashboard")
                .permitAll();
    }

    @Bean
    public SpringSecurityDialect securityDialect() {
        return new SpringSecurityDialect();
    }
}
