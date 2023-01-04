package Pack.config;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import Pack.dto.ProductRequest;

@Configuration
public class ProductProducerConfig {

    @Value("${spring.kafka.producer.bootstrap-servers}")
    private String bootstrapServer;

    @Bean
    public Map<String,Object> postViewProducerConfigs() {
        return CommonJsonSerializer.getStringObjectMap(bootstrapServer);
    }

    @Bean
    public ProducerFactory<String, ProductRequest> postViewCountDTOProducerFactory() {
        return new DefaultKafkaProducerFactory<>(postViewProducerConfigs());
    }

    @Bean
    public KafkaTemplate<String, ProductRequest> postViewDTOKafkaTemplate() {
        return new KafkaTemplate<>(postViewCountDTOProducerFactory());
    }
}