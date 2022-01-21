package com.sifan.mp_api.model;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class SpringSecurityAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor(){
        return Optional.ofNullable("").filter(s->!s.isEmpty());
    }
}
