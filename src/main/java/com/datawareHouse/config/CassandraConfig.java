//package com.datawareHouse.config;
//
//import com.datawareHouse.repository.CidadeRepository;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.cassandra.CassandraManagedTypes;
//import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
//import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext;
//import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
//
//@Configuration
//public class CassandraConfig extends AbstractCassandraConfiguration {
//
//    @Value("${spring.cassandra.keyspace-name}")
//    private String keySpaceName;
//
//    @Override
//    protected String getKeyspaceName() {
//        return keySpaceName;
//    }
//
//    @Override
//    public CassandraMappingContext cassandraMappingContext(CassandraManagedTypes cassandraManagedTypes) {
//        CassandraMappingContext mappingContext = new BasicCassandraMappingContext();
//        mappingContext.setUserTypeResolver(new CustomClassMapping()); // Configure your custom UserTypeResolver
//
//        // Define custom mapping for Product class
//        mappingContext.setCustomConversions(customConversions());
//
//        return mappingContext;
//    }
//}
