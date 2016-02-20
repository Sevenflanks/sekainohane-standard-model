package tw.org.sekainoane.standardmodel.common.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import tw.org.sekainoane.standardmodel.common.entity.GenericEntity;

public interface GenericDao<T extends GenericEntity> extends 

	JpaRepository<T, Long>,
	JpaSpecificationExecutor<T>{

}
