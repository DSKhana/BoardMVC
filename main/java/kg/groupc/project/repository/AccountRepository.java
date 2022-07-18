package kg.groupc.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kg.groupc.project.entity.Account;

public interface AccountRepository extends JpaRepository<Account, String> {
	Account findByUserId(String userId);
}
