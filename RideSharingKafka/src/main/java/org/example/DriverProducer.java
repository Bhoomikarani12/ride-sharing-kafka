package org.example;

import org.apache.kafka.clients.producer.KafkaProducer;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.Random;

public class DriverProducer {
    public static void main(String[] args){
        Properties properties= new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        String[] drivers = {"driver-1", "driver-2", "driver-3"};
        Random random = new Random();
        for(int i=0;i<10;i++){
            String driverId=drivers[random.nextInt(drivers.length)];
            String location = "lat:"+(40.0+random.nextDouble())+", lon:"+(-73.0+ random.nextDouble());

            producer.send(new ProducerRecord<>("driver-locations",driverId,location));
            System.out.printf("Sent location update for %s:%s/n", driverId,location);
            try{
                Thread.sleep(1000);

            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        producer.close();

    }
}
