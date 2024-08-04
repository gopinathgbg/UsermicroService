package com.hmis.userservice.service;

import com.hmis.userservice.service.userShared.UserDto;

public interface UserService {
	UserDto createuser(UserDto userDetails);
}
