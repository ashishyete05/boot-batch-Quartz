/**
 * 
 */
package app.springboot.registration.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import app.springboot.registration.entity.User;
import app.springboot.registration.service.UserRegistrationService;

/**
 * @author AC03582
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserRegistrationController {

	Logger log = LoggerFactory.getLogger(UserRegistrationController.class);

	@Autowired
	UserRegistrationService userService;

	@PostMapping("/user")
	public ResponseEntity<User> saveNewUser(@RequestBody User user) {
		log.info("UserRegistrationController : saveNewUser called");
		User savedUser = userService.saveNewUser(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getUserId()).toUri();
		return ResponseEntity.created(location).build();

	}

}
