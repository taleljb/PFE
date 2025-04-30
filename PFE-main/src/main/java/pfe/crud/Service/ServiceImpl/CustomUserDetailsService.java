package pfe.crud.Service.ServiceImpl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pfe.crud.Models.AffUsersDgaff;
import pfe.crud.Repository.AffUsersDgaffRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private AffUsersDgaffRepository userRepository;

  public CustomUserDetailsService(AffUsersDgaffRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

@Override
  public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
      AffUsersDgaff user = userRepository.findByEmail(usernameOrEmail)
              .orElseThrow(() -> new UsernameNotFoundException("User not exists by Username or Email"));

      Set<GrantedAuthority> authorities = user.getRoles().stream()
              .filter(role -> role.getName() != null && !role.getName().isBlank())
              .map(role -> new SimpleGrantedAuthority(role.getName()))
              .collect(Collectors.toSet());

      return new org.springframework.security.core.userdetails.User(
              usernameOrEmail,
              user.getPassword(),
              authorities
      );
  }
}
