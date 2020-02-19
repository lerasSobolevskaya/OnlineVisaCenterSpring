package online.visa.center.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import online.visa.center.model.Questionnaire;
import online.visa.center.model.dto.QuestionnaireDto;

@Component
public class QuestMapper extends BaseMapper<Questionnaire, QuestionnaireDto>{

	@Autowired
	private ModelMapper mapper;
	
	public QuestMapper() {
		super(Questionnaire.class, QuestionnaireDto.class);
	}

}
