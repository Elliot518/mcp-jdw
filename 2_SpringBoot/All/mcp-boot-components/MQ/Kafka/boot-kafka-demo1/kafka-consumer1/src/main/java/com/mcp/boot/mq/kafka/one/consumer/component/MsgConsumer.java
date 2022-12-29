package com.mcp.boot.mq.kafka.one.consumer.component;

import com.mcp.boot.common.model.constants.ITopic;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author: KG
 * @description:
 * @date: Created in 20:30 2022/5/14
 * @modified by:
 */
@Slf4j
@Component
public class MsgConsumer {
    @KafkaListener(topics = ITopic.KG_DEMO_TOPIC)
    public void listenMsg (ConsumerRecord<?,String> record) {
        String value = record.value();
        log.info("########## Msg Consume: {}", value);
    }
}

