package com.pay.gateway.service;

import com.pay.gateway.entity.User;

public interface UserService {
	User findUserByuserId(String userId);
}
