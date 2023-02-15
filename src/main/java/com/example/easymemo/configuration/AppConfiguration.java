package com.example.easymemo.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
 * @author erfan
 * @since 2/13/23
 */
@Configuration
public class AppConfiguration implements WebMvcConfigurer {

    @Bean("messageSource")
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("i18n/messages");
        messageSource.setDefaultLocale(Locale.US);
        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //todo: locale config
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
