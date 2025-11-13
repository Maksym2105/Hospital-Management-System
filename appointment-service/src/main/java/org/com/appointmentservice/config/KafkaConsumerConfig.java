package org.com.appointmentservice.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.com.appointmentservice.dto.DoctorResponseDTO;
import org.com.appointmentservice.dto.PatientResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServer;

    private Map<String, Object> baseConsumerConfig() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "appointment-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
        props.put(ErrorHandlingDeserializer.KEY_DESERIALIZER_CLASS, StringDeserializer.class);
        props.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        props.put(JsonDeserializer.USE_TYPE_INFO_HEADERS, false);

        return props;
    }

    @Bean
    public ConsumerFactory<String, PatientResponseDTO> patientConsumerFactory() {
        Map<String, Object> props = baseConsumerConfig();
        props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, PatientResponseDTO.class.getName());
        return new DefaultKafkaConsumerFactory<>(props,
                new StringDeserializer(),
                new JsonDeserializer<>(PatientResponseDTO.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, PatientResponseDTO> patientConcurrentKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, PatientResponseDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(patientConsumerFactory());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, DoctorResponseDTO> doctorConsumerFactory() {
        Map<String, Object> props = baseConsumerConfig();
        props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, DoctorResponseDTO.class.getName());
        return new DefaultKafkaConsumerFactory<>(props,
                new StringDeserializer(),
                new JsonDeserializer<>(DoctorResponseDTO.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, DoctorResponseDTO> doctorConcurrentKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, DoctorResponseDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(doctorConsumerFactory());
        return factory;
    }
}