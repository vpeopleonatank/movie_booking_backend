package mflix.api.services;

import mflix.api.daos.MovieDao;
import mflix.api.daos.MovieDocumentMapper;
import mflix.api.daos.ScheduleDao;
import mflix.api.models.FilmSchedule;
import mflix.api.models.MovieSchedule;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import static mflix.api.daos.MovieDocumentMapper.mapToMovieSchedule;

@Service
@Configuration
public class ScheduleService {

  @Autowired private ScheduleDao scheduleDao;
  @Autowired private MovieDao movieDao;

  public ScheduleService() {
    super();
  }

  public boolean addMovieSchedule(String movieId, Date date, LinkedHashSet<String> timeList) {
    FilmSchedule filmSchedule = scheduleDao.getScheduleByMovieIdAndDate(movieId, date);

    if (filmSchedule == null) {
      filmSchedule = new FilmSchedule();
      filmSchedule.setOid(new ObjectId());
      filmSchedule.setMovieId(movieId);
      filmSchedule.setDate(date);
      filmSchedule.setTime(timeList);
      scheduleDao.addSchedule(filmSchedule);
    } else {
      filmSchedule.getTime().addAll(timeList);
      scheduleDao.updateSchedule(filmSchedule);
    }
    return true;
  }

  public MovieSchedule getMovieScheduleByDate(String movieId, Date date) {
    /* TODO pass only date to get list of schedule,
        then compare first date 's hour:minute with time array 's element
     *   */
    Document document = movieDao.getMovieAndScheduleByDate(movieId, date);
    MovieSchedule movieSchedule = mapToMovieSchedule(document);

    return movieSchedule;
  }


//  public MovieSchedule getMovieScheduleByDate(String movieId, Date date) {
//    /* TODO pass only date to get list of schedule,
//        then compare first date 's hour:minute with time array 's element
//     *   */
//    Document document = movieDao.getMovieAndScheduleByDate(movieId, date);
//    MovieSchedule movieSchedule = mapToMovieSchedule(document);
//
//    return movieSchedule;
//  }
}
