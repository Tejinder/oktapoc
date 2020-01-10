package com.example.okta;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class OktaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OktaApplication.class, args);
	}
	
	/**
     * This example controller has endpoints for displaying the user profile info on {code}/{code} and "you have been
     * logged out page" on {code}/post-logout{code}.
     */
    @Controller
    public class ExampleController {

        @GetMapping("/")
        public String home() {
            System.out.println("Inside");
            
           // final String uri = "https://outlooktejinder.okta.com/api/v1/users";
            try
	            {
	            final String uri = "https://outlooktejinder.okta.com/api/v1/logs?filter=target.id eq \"0oamjgbtQ7EUO0h964x5\" and target.type eq \"AppInstance\"&fromTime=2020-01-02";
	            
	            RestTemplate restTemplate = new RestTemplate();
	            
	            HttpHeaders headers = new HttpHeaders();
	            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	            headers.add("Content-Type","application/json");
	            headers.add("Authorization","SSWS 00pXkaCe5eCxXPAs8EPczopmksGFkRn9FXVpgoPZhF");
	            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	             
	            ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
	            
	            ObjectMapper mapper = new ObjectMapper();
	           
	            System.out.println("Body"+result.getBody());
	            String json = mapper.writeValueAsString(result.getBody());
	            System.out.println("json"+json);
	            
	       /*     JsonParser springParser = JsonParserFactory.getJsonParser();
	            Map<String, Object> map = springParser.parseMap(result.toString());
	
	            String mapArray[] = new String[map.size()];
	            System.out.println("Items found: " + mapArray.length);
	
	            int i = 0;
	            for (Map.Entry<String, Object> entry : map.entrySet()) {
	            		System.out.println(entry.getKey() + " = " + entry.getValue());
	            		i++;
	            }
	            */
	            }
            catch(Exception e)
            {
            	
            }
        	return "home";
        }

        
    }

}
