package com.auth.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auth.service.entity.UserRole;
import com.auth.service.service.AuthService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AuthService authService;

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
