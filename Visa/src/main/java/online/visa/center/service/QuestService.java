package online.visa.center.service;

import java.util.List;

import online.visa.center.model.Questionnaire;

public interface QuestService {

	void createQuest(Questionnaire quest);

	void updateQuest(Questionnaire quest);

	List<Questionnaire> getAllQuest();

	Questionnaire getQuest(Long id);

	void deleteQuest(Questionnaire quest);
}
