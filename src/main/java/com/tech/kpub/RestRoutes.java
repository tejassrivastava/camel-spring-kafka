package com.tech.kpub;
import java.util.HashMap;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestRoutes {
    
    @Autowired
    ProducerTemplate producerTemplate;

    // private static Map<String, Product> productRepo = new HashMap<>();
    
   
    @RequestMapping(value = "/kafkapublish", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Object productBody) {
        System.out.println("Product Body : "+productBody);
        Object map = new HashMap<>();
        map = producerTemplate.sendBody("direct:kafkapublish",ExchangePattern.InOut,productBody);
        System.out.println("Map : "+map);

       // producerTemplate.sendBodyAndHeader("direct:firstRoute","HI", "city", city);
     
       return new ResponseEntity<Object>(map,HttpStatus.OK);
    //    return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/kafkaconsume", method = RequestMethod.GET)
    public ResponseEntity<Object> getProduct() {
        System.out.println("In getProduct");
        Object map = new HashMap<>();
         producerTemplate.send("direct:kafkaconsume", ExchangePattern.InOut, null);
        // map = producerTemplate.sendBody("direct:kafkaconsume",ExchangePattern.InOut,"From Rest /kafkaconsume");
        System.out.println("Map : "+map);

       // producerTemplate.sendBodyAndHeader("direct:firstRoute","HI", "city", city);
     
       return new ResponseEntity<Object>(map,HttpStatus.OK);
    //    return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/dbconsume", method = RequestMethod.POST)
    public ResponseEntity<Object> getdbdata(@RequestBody Object id) {
        System.out.println("In getdbdata"+id);
        Object map = new HashMap<>();
        JSONObject jo = new JSONObject();
jo.put("name", "jon doe");
jo.put("age", "22");
jo.put("city", "chicago");
         
        map = producerTemplate.sendBody("direct:dbconsume", ExchangePattern.InOut, id);
        // map = producerTemplate.sendBody("direct:kafkaconsume",ExchangePattern.InOut,"From Rest /kafkaconsume");
        System.out.println("Map : "+map);

       // producerTemplate.sendBodyAndHeader("direct:firstRoute","HI", "city", city);
     
       return new ResponseEntity<Object>(map,HttpStatus.OK);
    //    return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    // @RequestMapping(value = "/kafkapublish",method = RequestMethod.POST)
    // public ResponseEntity<Object> startCamel() {
    //     System.out.println("In start");
        
    //     Object map = new HashMap<>();
    //      map = producerTemplate.sendBodyAndHeader("direct:firstRoute",ExchangePattern.InOut,"HI", "city", city);
    //      System.out.println("Map : "+map);

    //     // producerTemplate.sendBodyAndHeader("direct:firstRoute","HI", "city", city);
      
    //     return new ResponseEntity<Object>(map,HttpStatus.OK);
        
    // //  producerTemplate.sendBody("direct:firstRoute", "Calling via Spring Boot Rest Controller !!");
    // }
}






