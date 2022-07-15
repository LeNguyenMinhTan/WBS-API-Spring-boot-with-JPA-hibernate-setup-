package io.company.wbs;

import io.company.wbs.domain.Role;
import io.company.wbs.domain.User;
import io.company.wbs.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class WbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WbsApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Minh Tan","Alexrole","1234",new ArrayList<>()));
			userService.saveUser(new User(null, "Lê Tan","Tan","1234",new ArrayList<>()));
			userService.saveUser(new User(null, "Tan All mid","MidTan","1234",new ArrayList<>()));
			userService.saveUser(new User(null, "Tan alo","IamTan","1234",new ArrayList<>()));
			userService.saveUser(new User(null, "TanTan","Bean","1234",new ArrayList<>()));

			userService.addRoleToUser("IamTan","ROLE_USER");
			userService.addRoleToUser("Tan","ROLE_USER");
			userService.addRoleToUser("MidTan","ROLE_USER");
			userService.addRoleToUser("IamTan","ROLE_ADMIN");
			userService.addRoleToUser("Bean","ROLE_MANAGER");
			userService.addRoleToUser("Alexrole","ROLE_ADMIN");
			userService.addRoleToUser("Alexrole","ROLE_MANAGER");
			userService.addRoleToUser("Alexrole","ROLE_SUPER_ADMIN");

		};
	}
}
