package com.hmis.userservice.service;

import java.util.UUID;

import com.hmis.userservice.data.UserEntity;
import com.hmis.userservice.data.UsersRepository;
import com.hmis.userservice.service.userShared.UserDto;
import org.modelmapper.*;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServceImpl implements UserService{
	UsersRepository userRepository;
	
	@Autowired
	public UserServceImpl(UsersRepository userRepository){
		this.userRepository=userRepository;
	}
	
	@Override
	public UserDto createuser(UserDto userDetails) {
		userDetails.setUserId(UUID.randomUUID().toString());
		ModelMapper mapper= new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity= mapper.map(userDetails, UserEntity.class);
		
		userEntity.setEncryptedPassword("test123567");
		
		userRepository.save(userEntity);
		
		UserDto returnVa=mapper.map(userEntity, UserDto.class);
		return returnVa;
	}

}
