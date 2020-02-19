package online.visa.center.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.visa.center.dao.VisaDao;
import online.visa.center.model.SchengenVisa;
import online.visa.center.service.VisaService;

@Service
@Transactional
public class VisaServiceImpl implements VisaService {

	private VisaDao visaDao;

	@Autowired
	public VisaServiceImpl(VisaDao visaDao) {
		this.visaDao = visaDao;
	}

	@Override
	public void createVisa(SchengenVisa visa) {
		visaDao.save(visa);

	}

	@Override
	public void updateVisa(SchengenVisa visa) {
		visaDao.update(visa);
	}

	@Override
	public List<SchengenVisa> getAllVisas() {
		return visaDao.getAll();
	}

	@Override
	public SchengenVisa getVisa(Long id) {
		return visaDao.getById(id);
	}

	@Override
	public void deleteVisa(SchengenVisa visa) {
		visaDao.delete(visa);
	}

}
