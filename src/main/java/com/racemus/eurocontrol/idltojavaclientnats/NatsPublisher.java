package com.racemus.eurocontrol.idltojavaclientnats;

import com.racemus.eurocontrol.idltojava.generated.dto.AceFpgEvents.FlightPlanEvents.Event;
import com.racemus.eurocontrol.idltojava.generated.dto.AceFpgEvents.FlightPlanEvents.EventData;
import com.racemus.eurocontrol.idltojava.generated.nats.service.publisher.INatsPublisherServiceace_fpg_event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NatsPublisher {

    private final INatsPublisherServiceace_fpg_event iNatsPublisherServiceAceFpgEvent;

    public void publisher() {
        final Event event = new Event();
        final EventData eventData = new EventData();
        eventData.setPfl_level(1);
        eventData.setStar_name("APG".toCharArray());
        event.setData(eventData);
        iNatsPublisherServiceAceFpgEvent.publishEvent(event);
        log.info("Message sent %s".formatted(event));
    }
}
