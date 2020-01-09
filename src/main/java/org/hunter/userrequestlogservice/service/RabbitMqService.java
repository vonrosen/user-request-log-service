package org.hunter.userrequestlogservice.service;

import org.hunter.userrequestlogservice.model.UserRequestLog;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqService {

    @Autowired
    private RabbitTemplate rabbitTempate;

    @Autowired
    private Queue queue;

    public void publish(UserRequestLog userRequestLog) {
        rabbitTempate.convertAndSend(queue.getName(), userRequestLog);
    }

}
