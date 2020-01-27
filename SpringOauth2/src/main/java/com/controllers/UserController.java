package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DaoUser;
import com.example.demo.User;


@RestController
public class UserController {

	@Autowired
	DaoUser dao;

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping("api/userById/{id}")
	public List<User> singleInfo(@PathVariable("id") Long id) {
		List<User> User = dao.singleData(id);
		return User;
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping("api/userByUsername/{bookname}")
	public List<User> bookInformationByname(@PathVariable("bookname") String bookname) {
		List<User> User = dao.getUserByName(bookname);
		return User;
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping("api/getAllUserInfo")
	public List<User> bookInformation() {
		List<User> User = dao.isData();
		return User;
	}

	@RequestMapping("api/signUp/{username}/{password}/{firstname}/{lastname}/{role}")
	public String signUp(@PathVariable("username") String username, @PathVariable("password") String password,
			@PathVariable("firstname") String firstname, @PathVariable("lastname") String lastname,
			@PathVariable("role") String role) {
		User u = new User();
		// b.setId(id);
		u.setUsername(username);
		u.setPassword(password);
		u.setFirstname(firstname);
		u.setLastname(lastname);
		u.setRole(role);
		if (dao.saveUser(u) == 1) {
			return "Successfully added to db";
		}
		return "failed to add";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping("api/del/user/{username}")
	public String deleteUserByName(@PathVariable("username") String username) {

		if (dao.deleteUserByName(username) == 1) {
			return "deleted successfully";
		}

		return "no record found";
	}

	/*
	 * // @PreAuthorize("hasAuthority('USER')")
	 * 
	 * @RequestMapping("/api/welcome")
	 * 
	 * @ResponseBody public String home() { return "Welcome home!"; }
	 * 
	 * @RequestMapping("/api/hello") public ResponseEntity<String> sayhello() {
	 * return ResponseEntity.ok("hello"); }
	 * 
	 * @RequestMapping("/user") public String p(Principal principal) { return
	 * "hello " + principal.getName(); }
	 * 
	 * @PreAuthorize("hasAuthority('ADMIN')")
	 * 
	 * @RequestMapping("/api/user")
	 * 
	 * @ResponseBody public String userAthority(Principal principal) { return
	 * "Welcome home ADMIN !" + principal.getName(); }
	 * 
	 * @RequestMapping("/api/logout")
	 * 
	 * @ResponseBody public String userLogout() { return
	 * "visit again..Logged out !"; }
	 */

}
