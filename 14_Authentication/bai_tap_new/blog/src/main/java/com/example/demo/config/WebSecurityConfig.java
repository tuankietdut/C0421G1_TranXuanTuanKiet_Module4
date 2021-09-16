package com.example.demo.config;

import com.example.demo.model.service.MyUserDetailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailServiceImp myUserDetailServiceImp;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /*Cài đặt cách lấy thông tin UserDetail, cơ chế Encoder...*/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailServiceImp).passwordEncoder(passwordEncoder());
    }

    /*Cấu hình security bằng HTTP basic*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .formLogin()
//                    .loginPage("/login")
                /*Login thanh cong se chuyen huong ve URL man hinh hien tai,
                neu truy cap truc tiep /login thi login thanh cong se chuyen huong ve /student */
                .defaultSuccessUrl("/home").permitAll()
                .and()
                .authorizeRequests().antMatchers("/home").permitAll()
               .antMatchers("/manage").hasRole("")
                .antMatchers("/view").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                /* Tất cả request gởi lên server đều phải thực hiện xác thực*/
                    .authorizeRequests().anyRequest().authenticated();
                /* Tất cả request gởi lên server không cần thực hiện xác thực*/
//                .authorizeRequests().anyRequest().permitAll();
    }
}
