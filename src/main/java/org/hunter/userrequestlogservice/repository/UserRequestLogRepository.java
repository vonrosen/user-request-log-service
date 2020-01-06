package org.hunter.userrequestlogservice.repository;

import java.util.UUID;

import org.hunter.userrequestlogservice.model.UserRequestLog;
import org.springframework.data.repository.CrudRepository;

public interface UserRequestLogRepository extends CrudRepository<UserRequestLog, UUID> { }
