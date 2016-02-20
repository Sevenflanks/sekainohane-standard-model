package tw.org.sekainoane.standardmodel.travel.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import tw.org.sekainoane.standardmodel.travel.factory.RepositoryFactoryBean;

/**
 * Spring的基本Config 掃過service package下的所有@Service
 * 
 * @author RHYS
 */
@Configuration
@Lazy
@EnableJpaRepositories(basePackages = "tw.org.sekainoane.standardmodel.travel.**.dao", repositoryFactoryBeanClass = RepositoryFactoryBean.class)
public class TravelDaoConfurigation {

	@Resource
	private Environment env;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty("mongodb.jdbc.MongoDriver"));
		dataSource.setUrl(env.getRequiredProperty("mongodb://skhn:sa12345as@ds011248.mongolab.com:11248/standardmodel"));
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception {
		final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//		vendorAdapter.setDatabase(Database.);
//		vendorAdapter.setGenerateDdl(false);
//		vendorAdapter.setShowSql(true);

		final LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("tw.org.sekainoane.standardmodel.travel.**.entity", "tw.com.softleader.data.jpa.converter");
		factory.setDataSource(dataSource());
		
		return factory;
	}

}
