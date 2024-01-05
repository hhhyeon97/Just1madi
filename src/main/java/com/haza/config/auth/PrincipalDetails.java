package com.haza.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.haza.model.MemoUser;

public class PrincipalDetails implements UserDetails{

	
	private MemoUser user;

	public PrincipalDetails(MemoUser user) {
		this.user = user;
	}
	
	/*
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collect = new ArrayList<>();
		collect.add(new GrantedAuthority() {
			@Override
			public String getAuthority() {
				return user.getRole();
			}
		});
		return collect;
	}
	*/
	
	// 1/3 테스트중
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	    Collection<GrantedAuthority> authorities = new ArrayList<>();
	    authorities.add(new SimpleGrantedAuthority(user.getRole()));
	    return authorities;
	}
	
	
	
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
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

	
	//1/4테스트
	 public MemoUser getUser() {
	        return user;
	    }
	 
	 
	 // 1/5 
		public int getUserNo() {
			return user.getUserNo();
		}

		public int getMemoUser() {
			return user.getUserNo();
		}

	
	
}
