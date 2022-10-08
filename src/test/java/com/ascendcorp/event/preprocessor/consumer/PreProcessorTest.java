package com.ascendcorp.event.preprocessor.consumer;

import com.ascendcorp.event.preprocessor.model.BaseMessage;
import com.ascendcorp.event.preprocessor.model.TagMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig(PreProcessor.class)
class PreProcessorTest {
    @Autowired
    PreProcessor preProcessor;

    @Test
    void processCustomerTagChangeTest() {
        BaseMessage<TagMessage> messaage = BaseMessage.<TagMessage>builder()
                .eventData(TagMessage.builder().tagName("tagName").tagValue("tagValue").build())
                .build();

        BaseMessage result = preProcessor.preProcessorMessage().apply("test");
        assertNotNull(result);
    }
}