package com.codegym.service.message;

import com.codegym.model.entity.Message;
import com.codegym.service.IGeneralService;
import org.springframework.data.jpa.repository.Query;

public interface IMessageService extends IGeneralService<Message> {
    Iterable<Message> findAllBySenderId(Long id);
    Iterable<Message> findAllByReceiverId(Long id);
    Iterable<Message> findAllByUser(Long id);
    Iterable<Message> findAllBySenderAndReceiver(Long id1, Long id2);
    void deleteById(Long id);
}
