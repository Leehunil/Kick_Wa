package DSC.Kick_Wa.config;

import DSC.Kick_Wa.filter.CustomAuthenticationEntryPoint;
import DSC.Kick_Wa.filter.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity //활성화 시키면 스프링 시큐리티 필터가 스프링 필터체인에 등록이 된다.
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;

    public SecurityConfig(JwtTokenProvider jwtTokenProvider){
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf().disable()//crsf는 위조요청을 방지한다.
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // jwt는 토킅 방식이기 때문에 session을 사용하지 않는다
                .and()
                .authorizeRequests()
                .antMatchers("/user/signup","/user/signin","/user/checkunique").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic().disable() //rest api 이므로 기본설정 사용안함. 기본설정은 비인증시 로그인 폼 화면으로 리다이렉트 된다.
                .formLogin().disable() //폼 로그인 방식 끄기
                .exceptionHandling()
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint())
                .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
                        UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
