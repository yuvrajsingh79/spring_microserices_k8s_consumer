package com.scorp.consumeservice.web;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@ControllerAdvice
@RestController
@RequestMapping("/v1")
public class consumer {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment environment;
	
	@GetMapping
	public ResponseEntity<String> getServerIp(HttpServletRequest request) {
		InetAddress ip;
//		JSONObject json = new JSONObject();
		try {
			ip = InetAddress.getLocalHost();
			System.out.println("Current IP address of consumer : " + ip.getHostAddress());
			String str = ip.toString();
			//			  json.put("msg", ip);
			log.info("service url is :- "+ environment.getProperty("SVC_URL"));
			return ResponseEntity.ok().body(str);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().body("Bad Request");

	}
}