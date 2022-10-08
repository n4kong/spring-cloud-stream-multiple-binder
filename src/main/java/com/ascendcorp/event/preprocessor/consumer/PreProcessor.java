package com.ascendcorp.event.preprocessor.consumer;

import com.ascendcorp.event.preprocessor.model.BaseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
@Slf4j
public class PreProcessor {

    @Bean
    public Function<String, BaseMessage> preProcessorMessage() {
        return message -> {
            log.info("Received: " + message );

            return BaseMessage.builder().eventType("TEST_TYPE").build();
        };
    }
}