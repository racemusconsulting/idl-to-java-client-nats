package com.racemus.eurocontrol.idltojavaclientnats;


import com.racemus.eurocontrol.idltojava.generated.nats.service.consumer.INatsConsumerServiceace_fpg_event;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class NatsConsumer {

    private final INatsConsumerServiceace_fpg_event natsConsumerServiceaceFpgEvent;


    @PostConstruct
    public void consume() {
        natsConsumerServiceaceFpgEvent.consumeMessages(event -> log.info("Message event received %s".formatted(event))
        );
    }
}
