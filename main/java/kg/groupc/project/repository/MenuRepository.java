package kg.groupc.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import kg.groupc.project.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {

}
