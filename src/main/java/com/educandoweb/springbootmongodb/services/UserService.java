package com.educandoweb.springbootmongodb.services;

import com.educandoweb.springbootmongodb.domain.User;
import com.educandoweb.springbootmongodb.dto.UserDTO;
import com.educandoweb.springbootmongodb.repository.UserRepository;
import com.educandoweb.springbootmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
    
    public User insertUser(User user){
        return userRepository.insert(user);
    }

    public void deleteById(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public User updateUser(User user){
        User newUser = findById(user.getId());
        updateData(newUser,user);

        return userRepository.save(newUser);
    }

    private void updateData(User newUser, User user) {
        newUser.setId(user.getId());
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());

    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(),userDTO.getName(),userDTO.getEmail());
    }
}
