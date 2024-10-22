package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.s3.model.Bucket;
import com.example.demo.configuration.Publisher;
import com.example.demo.service.BucketService;

@RestController
public class AmazeKartController {

	@Autowired
	private Publisher publisher;

	@Autowired
	BucketService bucketService;

	@GetMapping("/test")
	public String testAPI() {
		return "success";
	}
    
	@GetMapping("publish/{message}")
	public String publish(@PathVariable String message) {
		publisher.publishMessage(message);
		return "message sent successfully";
	}

	@GetMapping("/bucket-list")
	public List<Bucket> getBucketList() {
		return bucketService.getBucketList();
	}

	@GetMapping("/downloadObj")
	public void downloadObject(@RequestParam("bucketName") String bucketName, @RequestParam("objName") String objName)
			throws Exception {
		bucketService.getObjectFromBucket(bucketName, objName);
	}

	@PostMapping("/uploadObj")
	public void uploadObject(@RequestParam("bucketName") String bucketName, @RequestParam("objName") String objName)
			throws Exception {
		bucketService.putObjectIntoBucket(bucketName, objName, "C:/New folder/ngoProjects/amaze-kart/src/main/resources/uml_diagram.png");
	}

	@PostMapping("/createBucket")
	public String createBucket(@RequestParam("bucketName") String bucketName) {
		bucketService.createBucket(bucketName);
		return "done";
	}
}
