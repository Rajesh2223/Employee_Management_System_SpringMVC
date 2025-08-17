package com.Employee.Config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.Employee")
@EnableJpaRepositories("com.Employee.Repository")
public class EmployeeConfiguration {
		@Bean
		public InternalResourceViewResolver viewResolver() {
			System.out.println("Sending request for path an extension");
			InternalResourceViewResolver internalResourceViewResolver=new InternalResourceViewResolver();
			internalResourceViewResolver.setPrefix("/");
			internalResourceViewResolver.setSuffix(".jsp");
			return internalResourceViewResolver;
			
		}
		@Bean(name = "entityManagerFactory")
		public LocalEntityManagerFactoryBean localentityManagerFactory() {
			System.out.println("Entity Manager Bean is Created");
			LocalEntityManagerFactoryBean localEntityManagerFactoryBean = new LocalEntityManagerFactoryBean();
			localEntityManagerFactoryBean.setPersistenceUnitName("EmployeeManagementSystemMVC");
			return localEntityManagerFactoryBean;
		}

		@Bean(name = "transactionManager")
		public JpaTransactionManager jpaTransactionManagerBean(EntityManagerFactory emf) {
			System.out.println("Transaction Manager Bean is Created");
			JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
			jpaTransactionManager.setEntityManagerFactory(emf);
			return jpaTransactionManager;
		}


}
