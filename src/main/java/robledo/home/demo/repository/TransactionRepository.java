package robledo.home.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import robledo.home.demo.model.Customer;
import robledo.home.demo.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value = "SELECT * FROM transaction WHERE customer_id = :id", nativeQuery = true)
    Optional<List<Transaction>> findByCustomerId(@Param("id") long id);
}
