
package co.id.library.project.LibraryServerApp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private PasswordConfig passwordConfig;
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
    
     @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(passwordConfig.authenticationProvider());
    }
    
    @Override
    public void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeRequests()
//                .antMatchers("/trainer").hasRole("TRAINER")
//                .antMatchers("/admin").hasRole("ADMIN")
//                .antMatchers("/api/employees/create").hasAnyRole("ADMIN","TRAINER","TRAINEE")
//                .antMatchers("/api/employees/list-all").hasAnyRole("ADMIN","TRAINER","TRAINEE")
//                .antMatchers("/api/employees/update/{id}").hasAnyRole("ADMIN","TRAINEE")
//                .antMatchers("/api/employees/delete/{id}").hasAnyRole("ADMIN")
//                .antMatchers("/trainee").hasAnyRole("TRAINER", "TRAINEE")
//                .antMatchers("/login","/registrationMail","/loginuser").permitAll()
////                .antMatchers("/**/","/logout").authenticated()
                .antMatchers("/login","/**").permitAll()
                .antMatchers("/project/**").authenticated()
                .antMatchers("/history/**").authenticated()
                .antMatchers("/trainee/**").authenticated()
                .antMatchers("/trainer/**").authenticated()
                .and()
                .logout().disable()
                .formLogin().disable()
                .httpBasic();
    }
}
