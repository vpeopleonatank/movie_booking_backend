package mflix.api.models;

import java.util.List;

public class BookingDTO {
  private Movie1 movie;
  private Region region;
  private String showing;
  private List<String> seats = null;
  private Person person;

  public Movie1 getMovie() {
    return movie;
  }

  public void setMovie(Movie1 movie) {
    this.movie = movie;
  }

  public Region getRegion() {
    return region;
  }

  public void setRegion(Region region) {
    this.region = region;
  }

  public String getShowing() {
    return showing;
  }

  public void setShowing(String showing) {
    this.showing = showing;
  }

  public List<String> getSeats() {
    return seats;
  }

  public void setSeats(List<String> seats) {
    this.seats = seats;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  @Override
  public String toString() {
    return "Booking{"
        + "movie="
        + movie
        + ", region="
        + region
        + ", showing='"
        + showing
        + '\''
        + ", seats="
        + seats
        + ", person="
        + person
        + '}';
  }
}



