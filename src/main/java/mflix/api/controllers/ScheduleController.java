package mflix.api.controllers;

import mflix.api.models.FilmScheduleDTO;
import mflix.api.models.MovieSchedule;
import mflix.api.services.BookingService;
import mflix.api.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static mflix.api.daos.MovieDocumentMapper.parseDate;

import java.util.Date;
import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/schedule")
public class ScheduleController {

  @Autowired private ScheduleService scheduleService;

  public ScheduleController() {
    super();
  }

  @PostMapping("/addschedule")
  public ResponseEntity addFilmSchedule(@RequestBody FilmScheduleDTO filmSchedule) {
    //    System.out.println(filmSchedule);
    if (scheduleService.addMovieSchedule(
        filmSchedule.getMovieId(), filmSchedule.getDate(), filmSchedule.getTime())) {
      return ResponseEntity.ok(filmSchedule);
    }

    return ResponseEntity.badRequest().build();
  }

  @GetMapping("/getschedule")
  public ResponseEntity getFilmSchedule(
      @RequestParam(value = "date", required = true) @DateTimeFormat(pattern="yyyy-MM-dd") Date date,
      @RequestParam(value = "movieId", required = false) String movieId,
      @RequestParam(value = "startTime", required = false) String startTime,
      @RequestParam(value = "endTime", required = false) String endTime) {
    if (movieId == null) {

    } else if (startTime == null && endTime == null) {
      MovieSchedule movieSchedule =
          scheduleService.getMovieScheduleByDate(movieId, date);
      return ResponseEntity.ok(movieSchedule);
    }
    return ResponseEntity.badRequest().build();
  }
}
