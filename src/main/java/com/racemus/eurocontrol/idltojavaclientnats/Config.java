package com.racemus.eurocontrol.idltojavaclientnats;

import com.racemus.eurocontrol.idltojava.generated.nats.NatsClientBuilder;
import com.racemus.eurocontrol.idltojava.generated.nats.service.consumer.INatsConsumerServiceace_fpg_event;
import com.racemus.eurocontrol.idltojava.generated.nats.service.consumer.NatsConsumerServiceace_fpg_event;
import com.racemus.eurocontrol.idltojava.generated.nats.service.publisher.INatsPublisherServiceace_fpg_event;
import com.racemus.eurocontrol.idltojava.generated.nats.service.publisher.NatsPublisherServiceace_fpg_event;
import io.nats.client.Connection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.time.Duration;

@Configuration
public class Config {


    @Bean
    public Connection aa() throws IOException, InterruptedException {
        return new NatsClientBuilder()
                .natsUrl("nats://localhost:4222")
                .maxReconnects(5)
                .reconnectWait(Duration.ofSeconds(5L))
                .build();
    }

    @Bean
    public INatsConsumerServiceace_fpg_event natsConsumerServiceaceFpgEvent(Connection connection) {
        return new NatsConsumerServiceace_fpg_event(connection);
    }

    @Bean
    public INatsPublisherServiceace_fpg_event natsPublisherServiceaceFpgEvent(Connection connection) {
        return new NatsPublisherServiceace_fpg_event(connection);
    }


}
