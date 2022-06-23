package com.dhybrid.admin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/*
	 * @Autowired private UserDetailsService userDetailsService;
	 * 
	 * @Bean public BCryptPasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 * 
	 * @Bean public DaoAuthenticationProvider authenticationProvider() {
	 * DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	 * authProvider.setUserDetailsService(userDetailsService);
	 * authProvider.setPasswordEncoder(passwordEncoder());
	 * authProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); return
	 * authProvider; }
	 */

	@Autowired
	private CustomAuthenticationProvider authProvider;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

//	@Bean
//    public UserDetailsService userDetailsService()
//    {
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
// 
//        User.UserBuilder userBuilder = User.builder().passwordEncoder(encoder::encode);
//        UserDetails user = userBuilder.username("user").password("password")
//                                    .roles("USER").build();
//        UserDetails admin = userBuilder.username("admin").password("password")
//                                    .roles("USER","ADMIN").build();
// 
//        return new InMemoryUserDetailsManager(user, admin);
//    }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login", "/**").permitAll()
				.antMatchers("/css/**", "/scripts/**", "/images/**").permitAll().anyRequest().authenticated().and()
				.formLogin().loginPage("/login").loginProcessingUrl("/postLogin").permitAll().and().logout().permitAll()
				.and().csrf().disable();
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.authorizeRequests() .antMatchers("/login").permitAll()
	 * .antMatchers("/admin/**").hasRole("ADMIN")
	 * .antMatchers("/**").hasAnyRole("ADMIN", "USER") .and().formLogin()
	 * .and().logout().logoutSuccessUrl("/login").permitAll()
	 * .and().csrf().disable(); }
	 */

}