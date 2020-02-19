package online.visa.center.dao.impl;

import org.springframework.stereotype.Repository;

import online.visa.center.dao.VisaDao;
import online.visa.center.model.SchengenVisa;

@Repository
public class VisaDaoImpl extends BaseDaoImpl<SchengenVisa, Long> implements VisaDao {

	public VisaDaoImpl() {
		super(SchengenVisa.class);
	}

}
