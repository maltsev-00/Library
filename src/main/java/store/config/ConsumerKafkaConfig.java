package store.config;//package com.library.library.config;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import store.model.Book;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class ConsumerKafkaConfig {

    @ConditionalOnMissingBean(ConsumerFactory.class)
    public ConsumerFactory<String, Book> bookConsumerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_json");
        config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(config, new org.apache.kafka.common.serialization.StringDeserializer(),
                new org.springframework.kafka.support.serializer.JsonDeserializer<>(Book.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Book> bookKafkaListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Book> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(bookConsumerFactory());
        return factory;
    }
}
