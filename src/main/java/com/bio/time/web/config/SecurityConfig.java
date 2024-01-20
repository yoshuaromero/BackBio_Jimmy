package com.bio.time.web.config;

import com.bio.time.domain.service.CustomUserDetailService;
import com.bio.time.web.filter.JwtAuthenticationFilter;
import com.bio.time.web.filter.JwtAuthorizationFilter;
import com.bio.time.web.security.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig implements WebMvcConfigurer{

    @Autowired JwtUtil jwtUtil;
    @Bean
    public JwtAuthorizationFilter jwtFilter() {
        return new JwtAuthorizationFilter();
    }
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailService();
    }
    @Bean
    public DefaultSecurityFilterChain filterChain(HttpSecurity httpSecurity, AuthenticationManager authenticationManager) throws  Exception{

        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(jwtUtil);
        jwtAuthenticationFilter.setAuthenticationManager(authenticationManager);
        jwtAuthenticationFilter.setFilterProcessesUrl("/login");

        return httpSecurity
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(antMatcher(HttpMethod.POST,"/auth/login")).permitAll();
                    auth.requestMatchers(antMatcher("/auth/login")).permitAll();
                    auth.requestMatchers(antMatcher("/auth/login1")).permitAll();
                    auth.requestMatchers(antMatcher("/sendMail/v1")).permitAll();
                    auth.requestMatchers(antMatcher("/recovery/password")).permitAll();
                    auth.requestMatchers(antMatcher("/**")).permitAll();
                    //auth.requestMatchers(HttpMethod.POST)
                    auth.anyRequest().authenticated();
                })
                .sessionManagement(sessions -> {
                    sessions.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                .addFilter(jwtAuthenticationFilter)
                .addFilterBefore(this.jwtFilter(), UsernamePasswordAuthenticationFilter.class)
                .build();

    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173") // Replace with the actual origin of your frontend application
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("Origin", "Content-Type", "Accept", "Authorization")
                .allowCredentials(true); // Allow credentials (cookies, authentication headers)
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

}
