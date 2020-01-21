package org.hunter.userrequestlogservice.controller;

import org.hunter.userrequestlogservice.model.UserRequestLog;
import org.hunter.userrequestlogservice.service.RabbitMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/userrequestlog")
public class UserRequestLogServiceController {

    @Autowired
    RabbitMqService rabbitMqService;

    @PostMapping(consumes = "application/json")
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUserRequestLog(@RequestBody(required = true) UserRequestLog userRequestLog) {
        if (userRequestLog.getUserId() == null || userRequestLog.getMaxPaymentAmount() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "user request log missing userId or payment amount");
        }
        rabbitMqService.publish(userRequestLog);
    }

}
