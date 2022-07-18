package kg.groupc.project.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import kg.groupc.project.service.AccountService;
import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@RequiredArgsConstructor
@Configuration(proxyBeanMethods = false)
@ConditionalOnDefaultWebSecurity
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class SecurityConfig {	
	@Bean
	@Order(SecurityProperties.BASIC_AUTH_ORDER)
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
			.csrf().disable()
			.headers().frameOptions().disable()
			.and()
				.authorizeRequests()
					.antMatchers("/", "/nav", "/login", "/signin", "/css/**", "/images/**", "/js/**").permitAll()
					.antMatchers("/admin")
						.hasRole("ADMIN")
					.anyRequest().permitAll()
			.and()
				.formLogin()
					.loginPage("/login")
					.loginProcessingUrl("/login/loginProc")
					.defaultSuccessUrl("/")
					.usernameParameter("userId")
			.and()
				.logout()
					.logoutSuccessUrl("/")
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.invalidateHttpSession(true)
			.and()
				.exceptionHandling()
				.accessDeniedHandler(new CustomAccessDeniedHandler())
				.authenticationEntryPoint(new CustomAuthenticationEntryPoint());
		;
		http.sessionManagement()
			.maximumSessions(1)
			.maxSessionsPreventsLogin(false);
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
