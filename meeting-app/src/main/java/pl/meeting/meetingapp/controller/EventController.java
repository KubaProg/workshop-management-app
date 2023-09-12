package pl.meeting.meetingapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pl.meeting.meetingapp.api.EventApi;
import pl.meeting.meetingapp.mapper.EventMapper;
import pl.meeting.meetingapp.models.EventModelApi;
import pl.meeting.meetingapp.service.EventService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventController implements EventApi
{

    private final EventService eventService;

    @Override
    public ResponseEntity<List<EventModelApi>> getAllEvents() {
        return ResponseEntity.ok()
                        .body( eventService.getEvents());
    }


}
