package Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import DTO.LoginRequest;
import DTO.SignUpRequest;
import Entity.User;
import Repo.UserRepo;

@RestController
public class UserController {
	@Autowired
	UserRepo userRepo;

	@PostMapping("/api/user")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return new ResponseEntity<>(userRepo.save(user), HttpStatus.CREATED);
	}

	@GetMapping("/api/user")
	public ResponseEntity<List<User>> getusers() {
		return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK);
	}

	@GetMapping("/api/user/username/{userName}")
	public ResponseEntity<User> getUserByName(@PathVariable String userName) {
		Optional<User> user = userRepo.findByUserName(userName);
		if (user.isPresent()) {
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/api/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		Optional<User> user = userRepo.findById(id);
		if (user.isPresent()) {
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/api/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User userdata) {
		Optional<User> user = userRepo.findById(id);
		if (user.isPresent()) {
			user.get().setUserId(userdata.getUserId());
			user.get().setEmail(userdata.getEmail());
			user.get().setPassword(userdata.getPassword());
			user.get().setUserName(userdata.getUserName());
			return new ResponseEntity<>(userRepo.save(user.get()), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/api/user/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable int id) {
		Optional<User> user = userRepo.findById(id);
		if (user.isPresent()) {
			userRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/api/login")
	public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
		Optional<User> user = userRepo.findByUserName(loginRequest.getUserName());
		if (user.isPresent() && user.get().getPassword().equals(loginRequest.getPassword())) {
			return ResponseEntity.status(HttpStatus.OK).body("Login Successful");
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	}

	@PostMapping("/api/signUp")
	public ResponseEntity<String> SignUp(@RequestBody SignUpRequest signUpRequest) {
		Optional<User> existingUser = userRepo.findByUserName(signUpRequest.getUserName());

		if (existingUser.isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists.");
		} else {
			User newUser = new User();
			newUser.setUserName(signUpRequest.getUserName());
			newUser.setEmail(signUpRequest.getEmail());
			newUser.setPassword(signUpRequest.getPassword());
			userRepo.save(newUser);
			return ResponseEntity.status(HttpStatus.OK).body("You are successfully signed up");
		}

	}

}
