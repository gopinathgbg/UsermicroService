package com.hmis.userservice.UserController;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hmis.userservice.Model.CreateUserRequestModel;
import com.hmis.userservice.Model.CreateUserResponseModel;
import com.hmis.userservice.service.UserService;
import com.hmis.userservice.service.userShared.UserDto;
import com.netflix.discovery.converters.Auto;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private Environment env;
	
	@GetMapping("/status/check")
	public String status() {
		return "Working on port no " +env.getProperty("local.server.port");
	}
	@Autowired
	UserService userservice;
	
	
	@PostMapping
	public ResponseEntity<CreateUserResponseModel> createUser(@RequestBody CreateUserRequestModel userDetails) {
		
		System.out.println("In ,createUser method ");
		ModelMapper modelmapper = new ModelMapper();
		modelmapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userdto= modelmapper.map(userDetails, UserDto.class);
		
		UserDto createdUser= userservice.createuser(userdto);
		
		CreateUserResponseModel returnvalue=modelmapper.map(createdUser, CreateUserResponseModel.class);
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(returnvalue);
	}
	
}