package com.optimagrowth.license;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
@RefreshScope
@EnableEurekaClient
public class LicenseServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LicenseServiceApplication.class, args);
    }

    /**
     * Устанавливает язык возвращаемого контента нашего приложения
     * @return US язык по умолчанию
     */
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.US);
        return sessionLocaleResolver;
    }

    /**
     * Метод настраивает ответ от контроллера на нужном языке, файлы с настройками лежат в resources/
     * @return настройки локализации (множество языков)
     */
    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        // Не генерирует ошибку, если сообщение не найдено, а возвращает код сообщения вместо этого
        messageSource.setUseCodeAsDefaultMessage(true);
        // Задаёт базовое имя файлов с переводами сообщений на разные языки, данные файлы лежат в папке resources
        messageSource.setBasename("messages");
        // Чтобы можно было работать с русским языком (но почему-то не работает)
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
