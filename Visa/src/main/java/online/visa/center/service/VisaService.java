package online.visa.center.service;

import java.util.List;

import online.visa.center.model.SchengenVisa;

public interface VisaService {

	void createVisa(SchengenVisa visa);

	void updateVisa(SchengenVisa visa);

	List<SchengenVisa> getAllVisas();

	SchengenVisa getVisa(Long id);

	void deleteVisa(SchengenVisa visa);
}
