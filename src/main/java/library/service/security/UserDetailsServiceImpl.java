package library.service.security;

import library.model.User;
import library.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UsersRepository usersRepository;

    @Autowired
    public UserDetailsServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = usersRepository.findByName(name);

        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new MyUserPrincipal(user);
    }

    public User currentUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return usersRepository.findByName(auth.getName());
    }


}
