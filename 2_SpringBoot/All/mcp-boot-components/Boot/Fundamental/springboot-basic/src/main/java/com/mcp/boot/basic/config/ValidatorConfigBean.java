package com.mcp.boot.basic.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @author: KG
 * @description:
 * @date: Created in 17:12 2022/6/8
 * @modified by:
 */
@Configuration
public class ValidatorConfigBean {

    @Bean
    public ValidatorFactory validatorFactory() {
        return Validation.byProvider(HibernateValidator.class)
                .configure()
                .failFast(false)
                .buildValidatorFactory();
    }

    @Bean
    public Validator validator(ValidatorFactory validatorFactory) {
        return validatorFactory.getValidator();
    }
}


