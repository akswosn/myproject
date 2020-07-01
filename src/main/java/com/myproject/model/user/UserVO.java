package com.myproject.model.user;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import lombok.*;

/**
 * <pre>
* 간략 : 
* 상세 :
 * </pre>
 * 
 * @Author : Keun-su(akswosn@gmail)
 * @Date : 2020. 6. 23.
 * @Version : 1.0 ----------------------------------- 1.0 : 신규작성
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "tb_user")
public class UserVO implements UserDetails {

    /**
     *
     */
    private static final long serialVersionUID = -6427655961640583087L;
    @Id
    @Column(name = "NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long no;
    @Column(name = "USER_ID")
    private String userId;
    @Column(name = "USER_PWD")
    private String userPwd;
    private String name;
    private int roll;

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    public String getRoleName() {
        if (this.roll == 1) {
            return "ADMIN";
        } else {
            return "USER";
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return userPwd;
    }

    @Override
    public String getUsername() {
        return userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}