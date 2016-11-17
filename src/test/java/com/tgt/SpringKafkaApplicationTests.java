package com.tgt;

import com.tgt.consumer.KafkaConsumer;
import com.tgt.producer.KafkaProducer;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * Created by a522467 on 11/17/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringKafkaApplicationTests {

    @Autowired
    private KafkaProducer sender;

    @Autowired
    private KafkaConsumer receiver;

    @Test
    public void testReceiver() throws Exception {
       // sender.sendMessage("applepi", "Hello Spring Kafka!");
        sender.sendMessage("applepi", "{'id':1010,'name':'Siva','age':40,'salary':10000}");
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);

        Assertions.assertThat(receiver.getLatch().getCount()).isEqualTo(1);
    }
}
