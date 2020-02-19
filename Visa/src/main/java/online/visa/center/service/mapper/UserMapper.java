package online.visa.center.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import online.visa.center.model.User;
import online.visa.center.model.dto.UserDto;

@Component
public class UserMapper extends BaseMapper<User, UserDto> {

	@Autowired
	private ModelMapper mapper;

	public UserMapper() {
		super(User.class, UserDto.class);
	}

}
