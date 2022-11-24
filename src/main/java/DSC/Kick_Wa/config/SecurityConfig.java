//package DSC.Kick_Wa.config;
//
//import DSC.Kick_Wa.service.user.CustomOAuth2UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.autoconfigure.security.SecurityProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.stereotype.Component;
//
//@RequiredArgsConstructor
//@EnableWebSecurity //활성화 시키면 스프링 시큐리티 필터가 스프링 필터체인에 등록이 된다.
//public class SecurityConfig {
//
//    private final CustomOAuth2UserService customOAuth2UserService;
//
//    @Bean
//    @Order(SecurityProperties.BASIC_AUTH_ORDER)
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        http.csrf().disable()//crsf는 위조요청을 방지한다.
//                .headers().frameOptions().disable()
//                .and()
//                    .authorizeHttpRequests()
//                    .antMatchers("/user/**").permitAll()
//                    .anyRequest().authenticated()
//                .and()
//                    .logout()
//                        .logoutSuccessUrl("/")
//                .and()
//                    .oauth2Login()
//                        .userInfoEndpoint()
//                            .userService(customOAuth2UserService);
//        return http.build();
//    }
//}
