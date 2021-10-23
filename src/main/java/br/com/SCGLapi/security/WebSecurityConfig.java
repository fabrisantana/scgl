package br.com.SCGLapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private ImplementsUserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests()
		
		//Permitido para todos
		.antMatchers("/").hasAnyRole("FIS", "ADM", "CLI")
		.antMatchers("/menu").hasAnyRole("FIS", "ADM", "CLI")
		.antMatchers("/login").permitAll()
				
		//Páginas autorizadas para o perfil Fisioterapeuta
		.antMatchers("/sessaoRegistraParticipacao").hasAnyRole("FIS", "ADM")	
		
		//Páginas autorizadas para o perfil Cliente
		
		
		//Páginas autorizadas para o perfil Administrador
		.antMatchers("/*").hasRole("ADM")
		
		//Usu�rio inativo
		.antMatchers("/inativo").hasAnyRole("INA")
		
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").loginProcessingUrl("/login").permitAll()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		
		//Direciona para a tela de acesso negado! Error 403 forbiden
		.and()
		.exceptionHandling().accessDeniedPage("/inativo");
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder()); 
	}

	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/js/**", "/css/**");
	}
}
