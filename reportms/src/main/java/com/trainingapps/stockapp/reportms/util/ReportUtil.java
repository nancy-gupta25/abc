package com.trainingapps.stockapp.reportms.util;

import com.trainingapps.stockapp.reportms.dto.CreateReportRequest;
import com.trainingapps.stockapp.reportms.dto.ReportDetails;
import com.trainingapps.stockapp.reportms.entity.Report;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

@Component
public class ReportUtil {

    public Report createReportRequestToReport(CreateReportRequest obj){
        Report desired= new Report();

        LocalDate startPeriod=stringToDate(obj.getStartPeriod());
        LocalDate endPeriod=stringToDate(obj.getEndPeriod());

        desired.setStartPeriod(startPeriod);
        desired.setEndPeriod(endPeriod);

        return desired;
    }

    public ReportDetails ReportToReportDetails(Report obj){
        String startPeriod=dateToString(obj.getStartPeriod());
        String endPeriod=dateToString(obj.getEndPeriod());
        String createdDate=dateToString(obj.getCreatedDate());

        ReportDetails desired= new ReportDetails();

        desired.setId(obj.getId());
        desired.setStartPeriod(startPeriod);
        desired.setEndPeriod(endPeriod);
        desired.setCreatedDate(createdDate);
        desired.setTotalSaleAmount(obj.getTotalSaleAmount());
        desired.setOrdersCount(obj.getOrdersCount());

        return desired;
    }

    private String dateToString(LocalDate date){
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd-MM-yyy");
        //DateTimeFormatter formatter= DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        String str=date.format(formatter);

        return str;
    }

    private LocalDate stringToDate(String str){
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd-MM-yyy");
        LocalDate date = LocalDate.parse(str, formatter);

        return date;
    }
}
