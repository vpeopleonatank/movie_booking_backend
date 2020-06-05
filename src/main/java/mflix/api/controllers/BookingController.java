package mflix.api.controllers;

import mflix.api.models.BookingDTO;
import mflix.api.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/booking")
public class BookingController extends ApiController {
  //  public class BookingController  {
  @Autowired private BookingService bookingService;
  public BookingController() {
    super();
  }

  @Override
  ResponseEntity<Map> index() {
    return ResponseEntity.ok(Collections.emptyMap());
  }

  @GetMapping(value = "/booking/{id}/{showing}")
  ResponseEntity getBookings(
      @PathVariable(value = "id") String id, @PathVariable(value = "showing") String showingTime) {

    return ResponseEntity.ok("");
  }

  @PostMapping("/booking")
  public ResponseEntity addBooking(@RequestBody BookingDTO bookingDTO) {
    System.out.println(bookingDTO);
    bookingService.addBooking(bookingDTO);

    return ResponseEntity.ok(bookingDTO);
  }
}
