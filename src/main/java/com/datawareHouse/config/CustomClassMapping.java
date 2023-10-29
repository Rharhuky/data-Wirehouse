//package com.datawareHouse.config;
//
//import com.datastax.oss.driver.api.core.CqlIdentifier;
//import com.datastax.oss.driver.api.core.type.UserDefinedType;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.cassandra.core.convert.CassandraCustomConversions;
//import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
//import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
//import org.springframework.data.cassandra.core.mapping.UserTypeResolver;
//
//import java.util.Collections;
//
//public class CustomClassMapping implements UserTypeResolver {
//
//    @Value("${spring.cassandra.keyspace-name}")
//    private String keySpaceName;
//
//    public CassandraCustomConversions getCustomConversions() {
//        return new CassandraCustomConversions(Collections.emptyList());
//    }
//
//    public CreateKeyspaceSpecification getCreateKeyspaceSpecification() {
//        return CreateKeyspaceSpecification.createKeyspace(getKeyspaceName())
//                .ifNotExists()
//                .with(KeyspaceOption.DURABLE_WRITES, true)
//                .withSimpleReplication(1L);
//    }
//
//    public String getKeyspaceName() {
//        return this.keySpaceName;
//    }
//
//    @Override
//    public UserDefinedType resolveType(CqlIdentifier typeName) {
//        return null;
//    }
//}
