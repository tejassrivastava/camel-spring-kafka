package com.tech.kpub;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaReceiverRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        String topicName = "test";
        String kafkaServer = "kafka:localhost:29092";
        String zooKeperHost = "zookeeperHost=localhost&zookeeperPort=2181";
        String serializerClass = "serializerClass=kafka.serializer.StringEncoder";
        String toKafka = new StringBuilder().append(kafkaServer).append("?").append(topicName).append("&").append(zooKeperHost).append("&").append(serializerClass).toString();
        
        // from("file:files/input?noop=true")
       
        // .log("Reading File: ${body}")
        //   .to(toKafka);
   
        
        // from("direct:kafkaconsume")
        
        // .log("Reading File: ${body}")
    //       from("kafka:foo?brokers=localhost:29092")
    //     //   .process(new Processor() {

    //     //     @Override
    //     //     public void process(Exchange exchange) throws Exception {
            
    //     //     Message message = exchange.getIn();
    //     //     Object data = message.getBody();
            
    //     //     System.out.println(data);
    //     //     }
    //     //     })
            
    //       .log("Message received from Kafka : ${body}")
    //       .log("Headers received from Kafka : ${headers}")
    // .log("    on the topic ${headers[kafka.TOPIC]}")
    // .log("    on the partition ${headers[kafka.PARTITION]}")
    // .log("    with the offset ${headers[kafka.OFFSET]}")
    // .log("    with the key ${headers[kafka.KEY]}");
   
        
    }
    
}
