package kg.groupc.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kg.groupc.project.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{

}
