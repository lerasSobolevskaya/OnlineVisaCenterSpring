package online.visa.center.dao.impl;

import org.springframework.stereotype.Repository;
import online.visa.center.dao.QuestDao;
import online.visa.center.model.Questionnaire;

@Repository
public class QuestDaoImpl extends BaseDaoImpl<Questionnaire, Long> implements QuestDao {

	public QuestDaoImpl() {
		super(Questionnaire.class);
	}

}
