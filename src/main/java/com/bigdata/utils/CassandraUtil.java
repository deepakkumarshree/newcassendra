package com.bigdata.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.convert.CassandraConverter;
import org.springframework.data.cassandra.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ProtocolVersion;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
@ComponentScan
@Configuration
@PropertySource(value = { "classpath:cassandra.properties" })
public class CassandraUtil {
	/**
     * Constant String for Keyspace
     */
    private static final String KEYSPACE = "cassandra.keyspace";
    /**
     * Constant String for ContactPoints
     */
    private static final String CONTACTPOINTS = "cassandra.contactpoints";
    /**
     * Constant String for Port 
     */
    private static final String PORT = "cassandra.port";
    
    @Autowired
    private Environment environment;

    public CassandraUtil() {
        System.out.println("CassandraUtil()");
    }
    
    private String getKeyspaceName() {
        return environment.getProperty(KEYSPACE);       
    }
    
    private String getContactPoints() {
        return environment
                .getProperty(CONTACTPOINTS);        
    }
    
    private int getPortNumber() {
        return Integer.parseInt(environment.getProperty(PORT));        
    }

   @Bean
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        cluster.setContactPoints(getContactPoints());
        cluster.setPort(getPortNumber());
        cluster.setUsername("cassandra");
        cluster.setPassword("cassandra");
        return cluster;
    }

    @Bean
    public CassandraMappingContext mappingContext() {
        return new BasicCassandraMappingContext();
    }

    @Bean
    public CassandraConverter converter() {
        return new MappingCassandraConverter(mappingContext());
    }

    @Bean
    public CassandraSessionFactoryBean session() throws Exception {
        CassandraSessionFactoryBean cassandraSessionFactoryBean = new CassandraSessionFactoryBean();
        cassandraSessionFactoryBean.setCluster(cluster().getObject());
        cassandraSessionFactoryBean.setKeyspaceName(getKeyspaceName());
        cassandraSessionFactoryBean.setConverter(converter());
        cassandraSessionFactoryBean.setSchemaAction(SchemaAction.NONE);
        return cassandraSessionFactoryBean;
    }

    @Bean
    public CassandraOperations cassandraTemplate() throws Exception {
    	
    	Cluster cluster = Cluster.builder().withPort(9042).withProtocolVersion(ProtocolVersion.V3)
				.withCredentials("cassandra", "cassandra")
				.addContactPoint("13.56.105.107").build();
		Session session = cluster.connect();

		 System.out.println("Cluster and Session created with SSL");
		 ResultSet results = session.execute("SELECT * from test_validated.employee ");
		 for (Row row : results) {
		 System.out.println("data==> "+row.getString("name"));
		 }
        return new CassandraTemplate(session().getObject());
    }

}
