package app.springboot.registration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.springboot.registration.dao.UserRegistrationRepository;
import app.springboot.registration.entity.User;

@Service
public class UserRegistrationService {

	Logger log = LoggerFactory.getLogger(UserRegistrationService.class);

	@Autowired
	UserRegistrationRepository userRepo;

	public User saveNewUser(User user) {
		log.info("UserRegistrationService : saveNewUser called");
		return userRepo.save(user);
	}

}
