package com.example.reservations;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ReservationsConfig {

	@Bean
	public KafkaTemplate<String, String> kafkaTemplate() {
		return new KafkaTemplate<String, String>(new ProducerFactory<String, String>(){

			@Override
			public Producer<String, String> createProducer() {
				 Properties props = new Properties();
				 
				 props.put("bootstrap.servers", "localhost:9092");
				 props.put("acks", "all");
				 props.put("retries", 0);
				 props.put("linger.ms", 1);
				 props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
				 props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
				
				return new KafkaProducer<>(props);
			}});
	}
	
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.example.reservations"))              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
}
