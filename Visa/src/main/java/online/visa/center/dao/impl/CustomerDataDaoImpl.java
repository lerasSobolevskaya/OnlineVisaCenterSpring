package online.visa.center.dao.impl;

import org.springframework.stereotype.Repository;

import online.visa.center.dao.CustomerDataDao;
import online.visa.center.model.CustomerPersonalData;

@Repository
public class CustomerDataDaoImpl extends BaseDaoImpl<CustomerPersonalData, Long> implements CustomerDataDao {

	public CustomerDataDaoImpl() {
		super(CustomerPersonalData.class);
	}

}
