package com.metatron.workshopmongo.services;

import com.metatron.workshopmongo.domain.User;
import com.metatron.workshopmongo.dto.UserDTO;
import com.metatron.workshopmongo.repository.UserRepository;
import com.metatron.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();

    }

    public User findById(String id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("objeto não encontrado"));
    }
    public User insert(User obj) {
        return userRepository.insert(obj);

    }
    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }


    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());

    }

}