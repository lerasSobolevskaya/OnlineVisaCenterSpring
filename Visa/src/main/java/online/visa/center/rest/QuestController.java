package online.visa.center.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import online.visa.center.model.Questionnaire;
import online.visa.center.model.dto.QuestionnaireDto;
import online.visa.center.rest.exeption.BindingResultException;
import online.visa.center.rest.exeption.ThereIsNoSuchElementException;
import online.visa.center.service.QuestService;
import online.visa.center.service.mapper.QuestMapper;

@RestController
@RequestMapping(value = "/visa/center")
@Slf4j
public class QuestController {

	@Autowired
	private QuestMapper questMapper;
	
	private QuestService questService;
	
	@Autowired
	public QuestController(QuestService questService) {
		this.questService = questService;
	}

	@GetMapping(value = "/questionnaires")
	public ResponseEntity<List<QuestionnaireDto>> getAllQuest() {
		List<QuestionnaireDto> questionnaires = questMapper.toDtoList(questService.getAllQuest());
		if (questionnaires == null) {
			log.error("Error while retrieving questionnaires");
			throw new ThereIsNoSuchElementException("The list of questionnaires is empty");
		}
		return new ResponseEntity<>(questionnaires, HttpStatus.OK);
	}

	@GetMapping(value = "/questionnaires/{id}")
	public ResponseEntity<QuestionnaireDto> getQuest(@PathVariable Long id) {
		QuestionnaireDto quest = questMapper.toDto(questService.getQuest(id));
		if (quest == null) {
			log.error("Error while retrieving questionnaire with id: " + id);
			throw new ThereIsNoSuchElementException("Questionnaire with id: " + id + " not found");
		}
		return new ResponseEntity<>(quest, HttpStatus.OK);
	}

	@PostMapping(value = "/questionnaires")
	public ResponseEntity<Questionnaire> addQuest(@Valid @RequestBody QuestionnaireDto questDto,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			log.error("Error while creating questionnaire");
			throw new BindingResultException(bindingResult.getAllErrors());
		}
		Questionnaire quest = questMapper.toEntity(questDto);
		questService.createQuest(quest);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping(value = "/questionnaires/{id}")
	public ResponseEntity<Questionnaire> updateQuestionnaire(@Valid @RequestBody QuestionnaireDto questDto,
			@PathVariable Long id) {
		Questionnaire oldQuest = questService.getQuest(id);
		if (oldQuest == null) {
			log.error("Error while updating questionnaire with id: " + id);
			throw new ThereIsNoSuchElementException("Questionnaire with id: " + id + " not found");
		}
		Questionnaire quest = questMapper.toEntity(questDto);
		oldQuest.setStatus(quest.getStatus());
		oldQuest.setCustomerData(quest.getCustomerData());
		oldQuest.setVisa(quest.getVisa());
		questService.updateQuest(oldQuest);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/questionnaires/{id}")
	public ResponseEntity<Questionnaire> deleteQuest(@PathVariable Long id) {
		Questionnaire quest = questService.getQuest(id);
		if (quest == null) {
			log.error("Error while deleting questionnaire with id: " + id);
			throw new ThereIsNoSuchElementException("Questionnaire with id: " + id + " not found");
		}
		questService.deleteQuest(quest);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
