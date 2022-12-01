package DSC.Kick_Wa.filter;

import DSC.Kick_Wa.config.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.filter.OncePerRequestFilter;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;


}
