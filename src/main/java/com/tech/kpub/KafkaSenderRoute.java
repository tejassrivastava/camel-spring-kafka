package com.tech.kpub;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaSenderRoute extends RouteBuilder {

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
   
        
        from("direct:kafkapublish")
       
        .log("Reading File: ${body}");
        //   .to("kafka:foo?brokers=localhost:29092");
   
        
    }
    
}
