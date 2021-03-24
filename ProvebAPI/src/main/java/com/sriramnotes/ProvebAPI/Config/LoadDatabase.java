package com.sriramnotes.ProvebAPI.Config;

import com.sriramnotes.ProvebAPI.Data.Proverb;
import com.sriramnotes.ProvebAPI.Data.ProverbRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ProverbRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Proverb("The Best Way To Get Started Is To Quit Talking And Begin Doing.", "Walt Disney")));
            log.info("Preloading " + repository.save(new Proverb("The Pessimist Sees Difficulty In Every Opportunity. The Optimist Sees Opportunity In Every Difficulty.", "Winston Churchill")));
        };
    }
}
