package Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping("/api/user/{user_name}")
	public ResponseEntity<User> getUserByName(@PathVariable String userName) {
		Optional<User> user = userRepo.findByUsername(userName);
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
			user.get().setEmail(userdata.getEmail());
			user.get().setIsAdmin(userdata.getIsAdmin());
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
}
