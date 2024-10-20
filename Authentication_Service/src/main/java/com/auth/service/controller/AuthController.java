package com.auth.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auth.service.dto.LoginRequest;
import com.auth.service.entity.UserRegister;
import com.auth.service.entity.UserRole;
import com.auth.service.service.AuthService;
import com.auth.service.service.LoginService;
import com.auth.service.service.UserRegisterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/authenticate")
public class AuthController {

	@Autowired
	private UserRegisterService userRegisterService;
	@Autowired
	private AuthService authService;
	@Autowired
	private LoginService loginService;

	@PostMapping("/userregister")
	public ResponseEntity<?> addUserData(@RequestBody @Valid UserRegister user, BindingResult bindingResult) {
		userRegisterService.addUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body("added");
	}

	@PostMapping("/login")
	public ResponseEntity<?> addUserData(@RequestBody LoginRequest user) throws Exception {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(loginService.loginUser(user.getUsername(), user.getPassword()));
	}

	@PostMapping("/addRole")
	public ResponseEntity<?> getUserDetails(@RequestBody @Valid UserRole userRole, BindingResult bindingResult) {

		return ResponseEntity.status(HttpStatus.OK).body(authService.addUserRole(userRole));
	}

	@PostMapping("/assign-role")
	public ResponseEntity<String> assignRoleToUser(@RequestParam Long userId, @RequestParam Long roleId) {
		authService.assignRoleToUser(userId, roleId);
		return ResponseEntity.ok("Role assigned successfully");
	}
}
