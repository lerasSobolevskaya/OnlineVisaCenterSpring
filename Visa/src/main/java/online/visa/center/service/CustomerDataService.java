package online.visa.center.service;

import java.util.List;

import online.visa.center.model.CustomerPersonalData;

public interface CustomerDataService {

	void createCustomerData(CustomerPersonalData customer);

	void updateCustomerData(CustomerPersonalData customer);

	List<CustomerPersonalData> getAllCustomerDatas();

	CustomerPersonalData getCustomerData(Long id);

	void deleteCustomerData(CustomerPersonalData customer);
}
