package mflix.api.services;

import mflix.api.daos.BookingDao;
import mflix.api.models.BookingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
@Configuration
public class BookingService {
    @Autowired private BookingDao bookingDao;

    public BookingService() {super();}

    public BookingDTO addBooking(BookingDTO bookingDTO) {
        bookingDao.addBooking(bookingDTO);
        return bookingDTO;
    }
}
