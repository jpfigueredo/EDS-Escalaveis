package com.edu.infnet.DR3TP3.config;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;

@Configuration
public class R2dbcConfig extends AbstractR2dbcConfiguration {

    @Bean
    public ConnectionFactory connectionFactory() {
        return ConnectionFactories.get(ConnectionFactoryOptions.builder()
                .option(ConnectionFactoryOptions.DRIVER, "postgresql")
                .option(ConnectionFactoryOptions.PROTOCOL, "tcp")
                .option(ConnectionFactoryOptions.HOST, "localhost")
                .option(ConnectionFactoryOptions.PORT, 5432)
                .option(ConnectionFactoryOptions.DATABASE, "seu_banco_de_dados")
                .option(ConnectionFactoryOptions.USER, "seu_usuario")
                .option(ConnectionFactoryOptions.PASSWORD, "sua_senha")
                .build());
    }

    @Bean
    public R2dbcEntityTemplate r2dbcEntityTemplate() {
        return new R2dbcEntityTemplate(connectionFactory());
    }

    @Bean
    public R2dbcTransactionManager transactionManager() {
        return new R2dbcTransactionManager(connectionFactory());
    }
}
