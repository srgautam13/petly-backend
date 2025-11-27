package com.petly.backend.repository;

import com.petly.backend.model.Booking;
import com.petly.backend.model.User;
import com.petly.backend.model.enums.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByOwner(User owner);

    List<Booking> findByOwnerId(Long ownerId);

    List<Booking> findBySitter(User sitter);

    List<Booking> findBySitterId(Long sitterId);

    List<Booking> findByStatus(BookingStatus status);

    List<Booking> findBySitterIdAndStatusAndStartDateTimeBetween(
            Long sitterId,
            BookingStatus status,
            LocalDateTime start,
            LocalDateTime end
    );
}
