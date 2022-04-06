package com.trainingapps.stockapp.reportms.repository;

import com.trainingapps.stockapp.reportms.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReportRepository extends JpaRepository<Report, Long> {

}
