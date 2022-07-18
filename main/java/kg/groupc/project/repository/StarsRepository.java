package kg.groupc.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kg.groupc.project.entity.Stars;
import kg.groupc.project.entity.StarsId;

// Stars Table 복합키를 담는 IdClass
public interface StarsRepository extends JpaRepository<Stars, StarsId>{

}
