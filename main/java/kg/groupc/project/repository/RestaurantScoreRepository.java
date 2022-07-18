package kg.groupc.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kg.groupc.project.entity.RestaurantScore;

public interface RestaurantScoreRepository extends JpaRepository<RestaurantScore, Long>{

}
