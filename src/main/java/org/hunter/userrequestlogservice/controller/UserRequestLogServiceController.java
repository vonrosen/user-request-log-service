package org.hunter.userrequestlogservice.controller;

import org.hunter.model.UserView;
import org.hunter.userrequestlogservice.config.AppProperties;
import org.hunter.userrequestlogservice.model.UserRequestLog;
import org.hunter.userrequestlogservice.repository.UserRequestLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/userrequestlog")
public class UserRequestLogServiceController {

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private UserRequestLogRepository userRequestLogRepository;
    @Autowired
    private AppProperties appProperties;

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public UserRequestLog addUserRequestLog(@RequestBody UserRequestLog userRequestLog) {
        //will throw 404 if not found
        restTemplate.getForObject(appProperties.getUserServiceBaseUrl() + "/" + userRequestLog.getUserId().toString(),
                UserView.class);

        return userRequestLogRepository.save(userRequestLog);
    }

}
