package tw.org.sekainoane.standardmodel.travel.factory;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import tw.org.sekainoane.standardmodel.common.dao.GenericDao;
import tw.org.sekainoane.standardmodel.common.entity.GenericEntity;

public class RepositoryFactoryBean<R extends JpaRepository<T, Long>, T extends GenericEntity>
		extends JpaRepositoryFactoryBean<R, T, Long> {

	protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
		return new MyRepositoryFactory<T>(entityManager);
	}

	private static class MyRepositoryFactory<T extends GenericEntity> extends JpaRepositoryFactory {

		private EntityManager entityManager;

		public MyRepositoryFactory(EntityManager entityManager) {
			super(entityManager);
			this.entityManager = entityManager;
		}

		@SuppressWarnings("unchecked")
		protected Object getTargetRepository(RepositoryMetadata metadata) {
			return new SimpleJpaRepository<T, Long>((Class<T>) metadata.getDomainType(), entityManager);
		}

		protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
			return GenericDao.class;
		}
	}

}
