package com.codegym.service.user;


import com.codegym.model.entity.User;
import com.codegym.repository.IUserRepository;
import com.codegym.security.userprincal.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findUserByUserName(username);
        if (!userOptional.isPresent()){
            throw new UsernameNotFoundException(username);
        }
        return (UserDetails) UserPrinciple.build(userOptional.get());
    }


    @Override
    public Optional<User> findByUserName(String username) {
        return userRepository.findUserByUserName(username);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public Boolean existsByEmail(String email) {
      return userRepository.existsByEmail(email);
    }

    @Override
    public Boolean existsByUserName(String username) {
        return userRepository.existsByUserName(username);
    }

    @Override
    public Iterable<User> findAllByStatusCCDV() {
        return userRepository.findAllByStatusCCDV();
    }

    @Override
    public Optional<User> findCCDVById(Long id) {
        return userRepository.findCCDVById(id);
    }

    @Override
    public Iterable<User> find12NewCCDV() {
        return userRepository.find12NewCCDV();
    }

    @Override
    public Iterable<User> findAllByNameContaining(String username) {
        return userRepository.findAllByNameContaining(username);
    }

    @Override
    public Iterable<User> findAllByGenderContaining(String gender) {
        return userRepository.findAllByGenderContaining(gender);
    }

    @Override
    public Iterable<User> findAllByCityContaining(String city) {
        return userRepository.findAllByCityContaining(city);
    }

    @Override
    public Iterable<User> findUserByMessage(Long id) {
        return userRepository.findUserByMessage(id);
    }

    @Override
    public Iterable<User> findAllByStatus3() {
        return userRepository.findAllByStatus3();
    }

    @Override
    public Iterable<User> findAllByStatusSDDV() {
        return userRepository.findAllByUserSDDV();
    }



    @Override
    public Iterable<User> findAllUserCCDV() {
        return userRepository.findAllByCCDV();
    }

    @Override
    public Iterable<User> findAllUserCCDVByGender(String gender) {
        return userRepository.findAllUserCCDVByGender(gender);
    }

    @Override
    public Iterable<User> findAllByCity(String city) {
        return userRepository.findAllByCity(city);
    }

    @Override
    public Iterable<User> findAllByName(String name) {
        return userRepository.findAllByName(name);
    }

    @Override
    public Iterable<User> findAllTest(String gender, String city, String name) {
        return userRepository.findAllTest(gender, city, name);
    }


}
