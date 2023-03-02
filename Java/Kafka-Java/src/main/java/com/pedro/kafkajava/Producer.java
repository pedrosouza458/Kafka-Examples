package com.pedro.kafkajava;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092, localhost:9093, localhost:9093");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("acks", "all");

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);

        int numOfRecords = 100;

        for (int i = 0; i < numOfRecords; i++) {
            System.out.println("Message: " + i + " was jest produce");
            producer.send(new ProducerRecord<>("numbers", Integer.toString(i), Integer.toString(i)));
        }
        producer.close();
    }
}
