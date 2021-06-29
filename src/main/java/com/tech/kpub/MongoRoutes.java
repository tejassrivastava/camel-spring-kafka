package com.tech.kpub;

import java.util.ArrayList;
import java.util.Map;

import com.mongodb.DBObject;
import com.mongodb.client.model.Filters;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mongodb.MongoDbConstants;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

@Component
public class MongoRoutes extends RouteBuilder {
    @Override
    public void configure() throws Exception {

     //mongodb+srv://magicpanda:<password>@tv.eyjut.mongodb.net/myFirstDatabase?retryWrites=true&w=majority
    //  mongo "mongodb+srv://cluster0.ymlsa.mongodb.net/myFirstDatabase" --username admin 

     from("direct:dbconsume")
     .log("Prev ${body}")
     .log("IDDDD ${body}")
     .setHeader(MongoDbConstants.CRITERIA, constant(Filters.eq("name", "y")))
    //  .to("mongodb:myDb?username=admin&password=magicpanda&hosts=cluster0.ymlsa.mongodb.net&database=testdb&collection=test&operation=getDbStats")
    .to("mongodb:connectionBean?hosts=localhost:27017&database=camel&collection=test&operation=findOneByQuery")
    
     .log("From Mongo ${body}")
     .log("From Mongo ${headers}");
        
     
   
        
    }
}
