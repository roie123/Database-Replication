package com.System_Design._Alex_Xu.Database.Replication.USER;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;



    public User createUser(User user){
        return  userRepository.save(user);
    }




}
