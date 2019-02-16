package com.te.config;

import com.te.extend.security.JwtAuthenticationFilter;
import com.te.extend.security.RestAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//@Configuration
@EnableWebSecurity
public class SecurityConfig{
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
//    step1
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth)
//            throws Exception {
//        auth.inMemoryAuthentication().withUser("user1")
//                .password("{noop}password").roles("REGISTERED_USER");
//    }
//
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin();
//    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{ //method
//        auth.inMemoryAuthentication().withUser("user1").password("{noop}password").roles("REGISTERED_USER");
//    }
//
//    protected void configure(HttpSecurity http) throws Exception{
//        http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().formLogin();
//    }

    //step2
    //@Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("user")
//                .password("{noop}password").roles("USER");
//    }
//
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeRequests().antMatchers("/api/users/login","/api/user/login","/api/users/signup","/api/user/login").permitAll()
//                .and()
//                .authorizeRequests().antMatchers("/api/**").hasAnyRole("REGISTERED_USER","ADMIN")
//                .and()
//                .formLogin();
////                .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint);
//    }

//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication().withUser("user").password("{noop}password").roles("user");
//    }
//
//    protected void configure(HttpSecurity http) throws Exception{
//        http.csrf().disable().authorizeRequests().antMatchers("/api/users/login","api/users/signup").permitAll()
//                .and()
//                .authorizeRequests().antMatchers("/api/**").hasAnyRole("REGISTERED_USER", "ADMIN")
////                .authenticated()
//                .and().formLogin()//;
//                .and().exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint);
//    }
//    @Configuration
//    public static class ResourcesWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
//        @Override
//        public void configure(WebSecurity web) throws Exception {
//            web.ignoring()
//                    .antMatchers("/resources/**","/swagger-ui.html","/webjar?**");
//        }
//    }


    @Configuration
    public static class RestWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        @Autowired
        private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
        //curl -i -X POST -d username=user -d password=password -c ./cookies.txt http://localhost:8080/login
        @Autowired
        private UserDetailsService userDetailsService;
        @Autowired
        private JwtAuthenticationFilter jwtAuthenticationFilter;

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            PasswordEncoder encoder = new BCryptPasswordEncoder();
//            auth.inMemoryAuthentication().withUser("user")
//                .password("{noop}password").roles("REGISTERED_USER");
            auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
        }

//        @Autowired
//        public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception{
//            PasswordEncoder encoder=new BCryptPasswordEncoder();
//            auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
//        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring()
                    .antMatchers("/resources/**");
        }

        @Bean(name= BeanIds.AUTHENTICATION_MANAGER) //allow AuthenticationManager to be autowired
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception{
            return super.authenticationManagerBean(); //super means its patents' bean
        }

//        @Bean(name=BeanIds.AUTHENTICATION_MANAGER)
//        @Override
//        public AuthenticationManager authenticationManagerBean() throws Exception{
//            return super.authenticationManagerBean();
//        }

        protected void configure(HttpSecurity http) throws Exception {
            //http://www.baeldung.com/securing-a-restful-web-service-with-spring-security
            http
                    .addFilterAt(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                    .csrf().disable().authorizeRequests().antMatchers("/api/users/login","/api/users/signup","/api/users/signUp","/api/users/login1","/api/users/username/sort").permitAll()
                    .and()
                    //api/admin ADMIN
                    .authorizeRequests().antMatchers("/api/admin").hasAnyRole("ADMIN")
                    //api/scenery/** GET
                    .and()
                    .authorizeRequests().antMatchers(HttpMethod.GET,"/api/scenery/**").permitAll()
                    //api/outdoor_recreation/** GET
                    .and()
                    .authorizeRequests().antMatchers(HttpMethod.GET,"/api/outdoor_recreation/**").permitAll()
                    //api/cultural_inheritance/** GET
                    .and()
                    .authorizeRequests().antMatchers(HttpMethod.GET,"/api/cultural_inheritance/**").permitAll()
                    .and()
                    .authorizeRequests().antMatchers("/api/**").hasAnyRole("REGISTERED_USER","ADMIN")
                    .and()
                    .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint)
                    .and()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//                    .and()
//                    .formLogin();
        }
    }
}