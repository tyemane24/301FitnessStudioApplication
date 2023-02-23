//package com.yemane.fitness.securityconfig;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.yemane.fitness.model.Role;
//import com.yemane.fitness.model.User;
//import com.yemane.fitness.repository.UserRepository;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//	@Autowired
//	private UserRepository user_repo;
//	
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		User user = user_repo.findByEmail(email);
//        if (user == null) {
//            throw new UsernameNotFoundException("Invalid email or password");
//        }
//        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority(user));
//    }
//	private List<GrantedAuthority> getAuthority(User user) {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        for (Role role : user.getRoles()) {
//            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
//        }
//        return authorities;
//    }
//	}


