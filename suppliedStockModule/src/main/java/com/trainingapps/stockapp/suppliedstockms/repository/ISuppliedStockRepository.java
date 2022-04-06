package com.trainingapps.stockapp.suppliedstockms.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainingapps.stockapp.suppliedstockms.entity.SuppliedStock;
@Repository
public interface ISuppliedStockRepository  extends JpaRepository<SuppliedStock,Long>{

	Optional<SuppliedStock> findByStockId(Long stockId);

}
