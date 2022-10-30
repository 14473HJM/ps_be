package ar.edu.utn.frc.tup.ps.psappbe.domain.user;

import ar.edu.utn.frc.tup.ps.psappbe.entities.user.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

@AllArgsConstructor
public class SecurityUser implements UserDetails {

    private UserEntity user;

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRoles()
                .stream()
                .map(role -> role.getName())
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        //return !user.getAccountExpired();
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //return !user.getAccountLocked();
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //return !user.getCredentialExpired();
        return true;
    }

    @Override
    public boolean isEnabled() {
        //return user.getEnabled();
        return true;
    }
}
