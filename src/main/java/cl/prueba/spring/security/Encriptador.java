package cl.prueba.spring.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encriptador {	
		 
	    public static void main(String[] args) {
	        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        String encodedPassword = passwordEncoder.encode("123");
	         
	        System.out.println(encodedPassword);
	 
	    }

}
