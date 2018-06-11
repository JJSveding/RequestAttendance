package com.kea.attendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    private static final String SIMPLE_QUEUE = "formatRequestQueue";


    private final JmsTemplate jmsTemplate;

    @Autowired
    public Producer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(String message) {

        jmsTemplate.convertAndSend(SIMPLE_QUEUE, message);
    }



}
