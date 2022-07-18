package kg.groupc.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kg.groupc.project.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
