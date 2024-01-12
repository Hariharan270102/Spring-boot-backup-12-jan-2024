package edu.capstone_project.UserRegisterQuoting.service;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.capstone_project.UserRegisterQuoting.dto.UserRegisterRequest;
import edu.capstone_project.UserRegisterQuoting.model.LoginCredentials;
import edu.capstone_project.UserRegisterQuoting.model.UserRegister;
import edu.capstone_project.UserRegisterQuoting.repository.UserRegisterRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserRegisterService 
{
	
	private final UserRegisterRepository userRegisterRepo;

	public String addToUserRegisterDb(UserRegisterRequest userRegReq) {
		UserRegister userRegister=UserRegister.builder().
				firstname(userRegReq.getFirstname()).
				lastname(userRegReq.getLastname()).
				username(userRegReq.getUsername()).
				password(userRegReq.getPassword()).
				email(userRegReq.getEmail()).
				phonenumber(userRegReq.getPhonenumber()).
				address(userRegReq.getAddress()).
				state(userRegReq.getState()).
				district(userRegReq.getDistrict()).
				build();
//				country(userRegReq.getCountry()).build();
		 userRegisterRepo.save(userRegister);
				
		return "User registered successfully";
	}

	public LoginCredentials getCredentials(String credentials) throws Exception {
//		System.out.println(clientIpAddr);
		UserRegister userObj=new UserRegister();
		if(credentials.contains("@")) {
			userObj = userRegisterRepo.findByEmail(credentials);

		}
		else {
			userObj = userRegisterRepo.findByPhonenumber(credentials);

		}
		String ipRegion=findLocationByIP();
		System.out.println("after getting state from ip");
		LoginCredentials loginCredentials=LoginCredentials.builder().firstname(userObj.getFirstname()).
				email(userObj.getEmail()).password(userObj.getPassword()).phonenumber(userObj.getPhonenumber()).state(ipRegion).
				build();
		System.out.println(loginCredentials);
		
		// TODO Auto-generated method stub
		return loginCredentials;
	}

	private String findLocationByIP() throws Exception{
		
            // Create an HTTP client
            CloseableHttpClient httpClient = HttpClients.createDefault();

            // Make an HTTP GET request to the API
            HttpGet httpGet = new HttpGet("https://ipapi.co/json/");
            String response = EntityUtils.toString(httpClient.execute(httpGet).getEntity());

            // Parse the JSON response
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response);

            // Extract and display geolocation data
            String ipAddress = jsonNode.get("ip").asText();
            String state = jsonNode.get("region").asText();

            String isp = jsonNode.get("org").asText();
            String country = jsonNode.get("country_name").asText();
            String city = jsonNode.get("region").asText();

            System.out.println("IP Address: " + ipAddress);
            System.out.println("ISP: " + isp);
            System.out.println("Country: " + country);
            System.out.println("City: " + city);

            // Close the HTTP client
            httpClient.close();
            return state;
       
		
	}

	

}
