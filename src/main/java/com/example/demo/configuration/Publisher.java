package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;

@Service
public class Publisher {


    @Value("${aws.queueName}")
    private String queueName;

    private final AmazonSQS amazonSQSClient;

    public Publisher(AmazonSQS amazonSQSClient) {
        this.amazonSQSClient = amazonSQSClient;
    }

    public void publishMessage(String id) {
        try {
            GetQueueUrlResult queueUrl = amazonSQSClient.getQueueUrl(queueName);
            String message = "Sending message from producer-"+id;
            amazonSQSClient.sendMessage(queueUrl.getQueueUrl(), message);
            System.out.println("Message sent from producer - "+id);
        } catch (Exception e) {
            System.out.println("Queue Exception Message: {}"+ e.getMessage());
        }

    }

}