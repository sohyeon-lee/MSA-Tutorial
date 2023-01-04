package Pack.config;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

import Pack.dto.ProductOrderDTO;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ProductConsumerConfig {

    @Bean
    public Map<String,Object> postViewConsumerConfigs() {
        return CommonJsonDeserializer.getStringObjectMap("192.168.0.211:9092");
    }

    @Bean
    public ConsumerFactory<String, ProductOrderDTO> postViewCountDTO_ConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(postViewConsumerConfigs());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, ProductOrderDTO> postViewCountListener() {
        ConcurrentKafkaListenerContainerFactory<String, ProductOrderDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(postViewCountDTO_ConsumerFactory());
        return factory;
    }

    @Bean
    public StringJsonMessageConverter jsonConverter() {
        return new StringJsonMessageConverter();
    }
}
