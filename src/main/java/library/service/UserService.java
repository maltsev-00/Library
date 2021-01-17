package library.service;

import library.model.User;
import library.repository.UsersRepository;
import library.service.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UsersRepository usersRepository;
    private final UserDetailsServiceImpl userDetailsService;

    @Autowired
    public UserService(UsersRepository usersRepository, UserDetailsServiceImpl userDetailsService) {
        this.usersRepository = usersRepository;
        this.userDetailsService = userDetailsService;
    }

    public void addNewUserInDatabase(User user){
        if(userDetailsService.currentUser().getName().equals("admin"))
            usersRepository.save(user);

    }
}
