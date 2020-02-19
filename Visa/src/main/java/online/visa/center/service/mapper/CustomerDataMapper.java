package online.visa.center.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import online.visa.center.model.CustomerPersonalData;
import online.visa.center.model.dto.CustomerDataDto;

@Component
public class CustomerDataMapper extends BaseMapper<CustomerPersonalData, CustomerDataDto> {

	@Autowired
	private ModelMapper mapper;

	public CustomerDataMapper() {
		super(CustomerPersonalData.class, CustomerDataDto.class);
	}

}
