package online.visa.center.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import online.visa.center.model.SchengenVisa;
import online.visa.center.model.dto.SchengenVisaDto;

@Component
public class VisaMapper extends BaseMapper<SchengenVisa, SchengenVisaDto> {

	@Autowired
	private ModelMapper modelMapper;
	
	public VisaMapper() {
		super(SchengenVisa.class, SchengenVisaDto.class);

	}
}
