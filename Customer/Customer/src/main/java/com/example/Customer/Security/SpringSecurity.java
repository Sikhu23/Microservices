package com.example.Customer.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
    @EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
    public class SpringSecurity extends WebSecurityConfigurerAdapter {
        //we have to overide some consutomized methods of websecurity

        //Basic Auth
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .csrf().disable()
                    //.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                    //.and()
                    //any request make it first authrnticated authorized
                    .authorizeRequests()
//                .antMatchers("/customer/id/{id}").permitAll()
                .antMatchers("/*").hasRole("Normal")
//                    .antMatchers("/customer/id/**").hasRole("Normal")

                    .anyRequest()
                    .authenticated()
                    .and()
                    .httpBasic();
//                .formLogin();
//                .loginPage("/signin");
        }




        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            // Basic Auth
            auth.inMemoryAuthentication().withUser("natsu").password("dragneel").roles("Normal");
            auth.inMemoryAuthentication().withUser("asta").password("yuno").roles("Admin");


            //bycrpt password
//          auth.inMemoryAuthentication().withUser("john").password(this.passwordEncoder().encode("durgesh")).roles("Normal");
//        auth.inMemoryAuthentication().withUser("miller").password(this.passwordEncoder().encode("millers")).roles("Admin");
        }


        //Encoding ur customized password
        @Bean
        public PasswordEncoder passwordEncoder(){
            return NoOpPasswordEncoder.getInstance();

            //bycrpt ->hashing function
            //return new BCryptPasswordEncoder(10);
        }
    }



