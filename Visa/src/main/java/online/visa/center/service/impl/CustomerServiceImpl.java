package online.visa.center.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.visa.center.dao.CustomerDataDao;
import online.visa.center.model.CustomerPersonalData;
import online.visa.center.service.CustomerDataService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerDataService {

	private CustomerDataDao customerDataDao;

	@Autowired
	public CustomerServiceImpl(CustomerDataDao customerDataDao) {
		this.customerDataDao = customerDataDao;
	}

	@Override
	public void createCustomerData(CustomerPersonalData customer) {
		customerDataDao.save(customer);

	}

	@Override
	public void updateCustomerData(CustomerPersonalData customer) {
		customerDataDao.update(customer);

	}

	@Override
	public List<CustomerPersonalData> getAllCustomerDatas() {
		return customerDataDao.getAll();
	}

	@Override
	public CustomerPersonalData getCustomerData(Long id) {
		return customerDataDao.getById(id);
	}

	@Override
	public void deleteCustomerData(CustomerPersonalData customer) {
		customerDataDao.delete(customer);
	}

}
