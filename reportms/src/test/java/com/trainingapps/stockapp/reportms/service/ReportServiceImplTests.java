package com.trainingapps.stockapp.reportms.service;

import com.trainingapps.stockapp.reportms.Exceptions.ReportNotFoundException;
import com.trainingapps.stockapp.reportms.dto.CreateReportRequest;
import com.trainingapps.stockapp.reportms.dto.ReportDetails;
import com.trainingapps.stockapp.reportms.entity.Report;
import com.trainingapps.stockapp.reportms.repository.IReportRepository;
import com.trainingapps.stockapp.reportms.util.ReportUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ReportServiceImplTests {

    @Mock
    IReportRepository repository;

    @Mock
    ReportUtil reportUtil;

    @InjectMocks
    @Spy
    ReportServiceImpl service;

    @Test
    public void Test_generateReportInPeriod(){
        CreateReportRequest request=mock(CreateReportRequest.class);
        Report report=mock(Report.class);
        when(reportUtil.createReportRequestToReport(request)).thenReturn(report);

        doReturn(report).when(service).mock2(report);
        when(repository.save(report)).thenReturn(report);

        ReportDetails reportDetails=mock(ReportDetails.class);
        when(reportUtil.ReportToReportDetails(report)).thenReturn(reportDetails);

        ReportDetails result=service.generateReportInPeriod(request);

        Assertions.assertSame( reportDetails, result);

    }

    //when method executed succesully
    @Test
    public void Test1_findReportDetailsById() throws ReportNotFoundException {
        //Long id=mock(Long.class);
        Report report=mock(Report.class);
        Optional<Report> optional=Optional.of(report);
        when(repository.findById(1L)).thenReturn(optional);

        ReportDetails reportDetails=mock(ReportDetails.class);
        when(reportUtil.ReportToReportDetails(report)).thenReturn(reportDetails);

        ReportDetails result=service.findReportDetailsById(1L);
        Assertions.assertSame(reportDetails, result);

    }

    //when method throws exception
    @Test
    public void Test2_findReportDetailsById(){
        Optional<Report> optional=Optional.empty();
        when(repository.findById(1L)).thenReturn(optional);

        Executable executable=()->service.findReportDetailsById(1L);
        Assertions.assertThrows(ReportNotFoundException.class, executable);

    }

}
