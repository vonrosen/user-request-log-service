package org.hunter.userrequestlogservice.service;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hunter.model.UserRequestLogView;

@Service
public class RabbitMqService {

    @Autowired
    private RabbitTemplate rabbitTempate;

    @Autowired
    private Queue queue;

    public void publish(UserRequestLogView userRequestLogView) {
        rabbitTempate.convertAndSend(queue.getName(), userRequestLogView);
    }

}
