package cl.prueba.spring.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;



@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser("user1").password(encoder.encode("123456")).roles("ADMINISTRATIVO")
                .and()
                .withUser("user2").password(encoder.encode("123456")).roles("CLIENTE")
                .and()
                .withUser("user3").password(encoder.encode("123456")).roles("PROFESIONAL");
    }
        
    
 


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/lista-usuarios", "/crear-usuario", "/editar-usuario/{idusuario}", "/guardar-usuario", "/eliminar-usuario").hasRole("ADMINISTRATIVO")
                .antMatchers("/", "/contacto", "/guardar-contacto", "/lista-capacitaciones", "/crear-capacitacion", "/guardar-capacitacion", "/editar-capacitacion/{idcapacitaciones}", "/eliminar-capacitacion").hasRole("CLIENTE")
                .antMatchers("/").hasRole("PROFESIONAL")
                .and()
                .formLogin().loginPage("/login").permitAll()
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/inicio")
        		.and()
        		.exceptionHandling().accessDeniedPage("/errores/403");
        		
    }
}