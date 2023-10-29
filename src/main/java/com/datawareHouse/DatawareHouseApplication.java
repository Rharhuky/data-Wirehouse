package com.datawareHouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;



//@SpringBootApplication
@SpringBootApplication(exclude = { HibernateJpaAutoConfiguration.class, DataSourceAutoConfiguration.class, CassandraDataAutoConfiguration.class,})
public class DatawareHouseApplication{

	public static void main(String[] args) {
		SpringApplication.run(DatawareHouseApplication.class, args);
	}

}
