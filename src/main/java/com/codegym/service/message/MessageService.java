package com.codegym.service.message;

import com.codegym.model.entity.Message;
import com.codegym.repository.IMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MessageService implements IMessageService {
    @Autowired
    IMessageRepository messageRepository;
    @Override
    public Iterable<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public Optional<Message> findById(Long id) {
        return messageRepository.findById(id);
    }

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Iterable<Message> findAllBySenderId(Long id) {
        return messageRepository.findAllBySenderId(id);
    }

    @Override
    public Iterable<Message> findAllByReceiverId(Long id) {
        return messageRepository.findAllByReceiverId(id);
    }

    @Override
    public Iterable<Message> findAllByUser(Long id) {
        return messageRepository.findAllByUser(id);
    }

    @Override
    public Iterable<Message> findAllBySenderAndReceiver(Long id1, Long id2) {
        return messageRepository.findAllBySenderAndReceiver(id1, id2);
    }

    @Override
    public void deleteById(Long id) {
        messageRepository.deleteById(id);
    }
}
