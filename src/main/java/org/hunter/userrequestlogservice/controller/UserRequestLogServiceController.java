package org.hunter.userrequestlogservice.controller;

import org.hunter.userrequestlogservice.model.UserRequestLog;
import org.hunter.userrequestlogservice.repository.UserRequestLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userrequestlog")
public class UserRequestLogServiceController {

    @Autowired
    private UserRequestLogRepository userRequestLogRepository;

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public UserRequestLog addUserRequestLog(@RequestBody UserRequestLog userRequestLog) {
        return userRequestLogRepository.save(userRequestLog);
    }

}
