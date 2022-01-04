package com.example.contactsbackend.security;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

/**
 * FileName : AuditorAwareImpl
 * CreatTime : 2022/1/4
 * Author : Frank.Chang
 * Description : 使用 security 登入為資料建立名稱
 * 2. 實作 AuditorAware，並把資料轉型為 UserDetails 的 name
 */
public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Authentication::getPrincipal)
                .filter(UserDetails.class::isInstance)
                .map(UserDetails.class::cast)
                .map(UserDetails::getUsername);
    }
}
