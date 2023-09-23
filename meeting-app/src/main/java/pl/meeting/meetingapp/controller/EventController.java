package pl.meeting.meetingapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.meeting.meetingapp.api.EventApi;
import pl.meeting.meetingapp.entity.Event;
import pl.meeting.meetingapp.models.EventGetModelApi;
import pl.meeting.meetingapp.models.EventModelApi;
import pl.meeting.meetingapp.models.EventPostModelApi;
import pl.meeting.meetingapp.service.EventService;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventController implements EventApi
{

    private final EventService eventService;

    @Override
    public ResponseEntity<Void> createEvent(EventPostModelApi body) {
        Event createdEvent = eventService.createEvent(body);

        String uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdEvent.getId())
                .toUriString();

        return ResponseEntity.created(URI.create(uri)).build();
    }

    @Override
    public ResponseEntity<List<EventModelApi>> getAllEvents() {
        return ResponseEntity.ok()
                        .body( eventService.getEvents());
    }

    @Override
    public ResponseEntity<EventGetModelApi> getEventById(Long id) {
        return ResponseEntity.ok()
                .body(eventService.getEvent(id));
    }


}
