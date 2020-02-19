package online.visa.center.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.visa.center.dao.QuestDao;
import online.visa.center.model.Questionnaire;
import online.visa.center.service.QuestService;

@Service
@Transactional
public class QuestServiceImpl implements QuestService {

	private QuestDao questDao;

	@Autowired
	public QuestServiceImpl(QuestDao questDao) {
		this.questDao = questDao;
	}

	@Override
	public void createQuest(Questionnaire quest) {
		questDao.save(quest);
	}

	@Override
	public void updateQuest(Questionnaire quest) {
		questDao.update(quest);
	}

	@Override
	public List<Questionnaire> getAllQuest() {
		return questDao.getAll();
	}

	@Override
	public Questionnaire getQuest(Long id) {
		return questDao.getById(id);
	}

	@Override
	public void deleteQuest(Questionnaire quest) {
		questDao.delete(quest);

	}

}
