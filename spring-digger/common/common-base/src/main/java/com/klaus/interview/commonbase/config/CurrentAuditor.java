package com.klaus.interview.commonbase.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
public class CurrentAuditor implements AuditorAware<String> {

    /**
     * 给Bean中的 @CreatedBy  @LastModifiedBy 注入操作人
     *
     * @return
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Default");
    }
}