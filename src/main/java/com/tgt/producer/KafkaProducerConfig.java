package com.tgt.producer;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by a522467 on 11/17/16.
 * The creation of the KafkaTemplate and KafkaProducer is handled in the SenderConfig class.
 * The class is annotated with @Configuration which indicates that the class can be used by the Spring IoC container
 * as a source of bean definitions.
 */
@Configuration
public class KafkaProducerConfig {
   // @Value("${kafka.bootstrap.servers}")
   // private String bootstrapServers;

    @Bean
    public Map producerConfigs() {
        Map props = new HashMap();
        // list of host:port pairs used for establishing the initial connections
        // to the Kakfa cluster
       // props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        //TODO
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
//                IntegerSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        // value to block, after which it will throw a TimeoutException
        props.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, 5000);
        props.put("key.serializer", StringSerializer.class.getName());
       // props.put("value.serializer", StringSerializer.class.getName());

        return props;
    }

    @Bean
    public ProducerFactory producerFactory() {
        return new DefaultKafkaProducerFactory(producerConfigs());
    }

    @Bean
    public KafkaTemplate kafkaTemplate() {
        return new KafkaTemplate(producerFactory());
    }

    @Bean
    public KafkaProducer sender() {
        return new KafkaProducer();
    }
}
