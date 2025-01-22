package com.example.Learn_Java.service.implement;

import com.example.Learn_Java.domain.Person;
import com.example.Learn_Java.domain.User;
import com.example.Learn_Java.dto.UserDto;
import com.example.Learn_Java.dto.request.UserRequest;
import com.example.Learn_Java.exception.ResourceNotFoundException;
import com.example.Learn_Java.repository.PersonRepository;
import com.example.Learn_Java.repository.UserRepository;
import com.example.Learn_Java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplement implements UserService {
    @Autowired
    private UserRepository userRepository;
    private PersonRepository personRepository;

    public UserServiceImplement(UserRepository userRepository, PersonRepository personRepository) {
        this.userRepository = userRepository;
        this.personRepository = personRepository;
    }

    @Override
    public long create (UserRequest userRequest) {
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            throw new ResourceNotFoundException("Email already exists");
        }
        if (personRepository.existsByPhoneNumber(userRequest.getPerson().getPhoneNumber())) {
            throw new ResourceNotFoundException("Phone number already exists");
        }
        User user = toUserEntity(userRequest);
        userRepository.save(user);
        return user.getId();
    }

    @Override
    public long update(long id, UserRequest userRequest) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found with id: " + id));
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setIsActive(userRequest.getIsActive());
        Person person = user.getPerson();
        if (person == null) {
            person = new Person();
        }
        person.setFullName(userRequest.getPerson().getFullName());
        person.setGender(userRequest.getPerson().getGender());
        person.setBirthdate(userRequest.getPerson().getBirthdate());
        person.setAddress(userRequest.getPerson().getAddress());

        user.setPerson(person);
        userRepository.save(user);
        return user.getId();
    }

    @Override
    public List<UserDto> getAllUsers() {
//        return userRepository.getAll();
        List<User> users = userRepository.findAll();
        return users.stream().map(UserDto::new).collect(Collectors.toList());
    }

    @Override
    public UserDto getById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found with id: " + id));
        return new UserDto(user);
    }

    @Override
    public void deleteById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found with id: " + id));
        userRepository.delete(user);
    }

    private User toUserEntity(UserRequest userRequest) {
        Person person = new Person();
        person.setFullName(userRequest.getPerson().getFullName());
        person.setGender(userRequest.getPerson().getGender());
        person.setBirthdate(userRequest.getPerson().getBirthdate());
        person.setPhoneNumber(userRequest.getPerson().getPhoneNumber());
        person.setAddress(userRequest.getPerson().getAddress());

        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setIsActive(userRequest.getIsActive());
        user.setPerson(person);

        return user;
    }

//    private Response toUserResponse(User user){
//        Response response = new Response();
//        response.setId(user.getId());
//        response.setEmail(user.getEmail());
//        response.setPassword(user.getPassword());
//        response.setActive(user.getActive());
//        response.setPerson(user.getPerson());
//        return response;
//    }

}
