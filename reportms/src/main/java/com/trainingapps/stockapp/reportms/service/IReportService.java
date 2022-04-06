package com.trainingapps.stockapp.reportms.service;

import com.trainingapps.stockapp.reportms.Exceptions.ReportNotFoundException;
import com.trainingapps.stockapp.reportms.dto.CreateReportRequest;
import com.trainingapps.stockapp.reportms.dto.ReportDetails;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;

@Validated
public interface IReportService {

    ReportDetails generateReportInPeriod(CreateReportRequest request);

    ReportDetails findReportDetailsById(@Min(1) Long reportId) throws ReportNotFoundException;


}
