package libraryMangementApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import libraryMangementApi.entity.User;
import libraryMangementApi.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User findByUsername(String username) {
		return userRepository.findAll().stream().filter(user -> user.getUsername().equals(username)).findFirst()
				.orElse(null);
	}

}
