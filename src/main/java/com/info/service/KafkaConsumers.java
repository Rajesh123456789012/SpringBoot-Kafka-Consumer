package com.info.service;

import com.info.entity.UserEntity;
import com.info.model.User;
import com.info.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

/**
 * @author Rajesh
 */
@Slf4j
@Component
public class KafkaConsumers {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @KafkaListener(topics = "order", groupId = "groupId-1")
    public void listenGroupOrder(String message) {
        System.out.println("****** Received Message for order Topic in groupId-1:********** {} "+ message);
       com.info.model.User user =  objectMapper.readValue(message, User.class);

        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());

        userRepository.save(userEntity);


    }




}
