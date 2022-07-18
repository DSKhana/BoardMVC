package kg.groupc.project.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 찜하기 복합키 Idclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StarsId implements Serializable {
	private String userId;
	private long restaurant;
}
