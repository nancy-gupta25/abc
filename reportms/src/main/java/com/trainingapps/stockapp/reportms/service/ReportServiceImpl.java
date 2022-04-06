package com.trainingapps.stockapp.reportms.service;

import com.trainingapps.stockapp.reportms.Exceptions.ReportNotFoundException;
import com.trainingapps.stockapp.reportms.MockOrderDetails;
import com.trainingapps.stockapp.reportms.util.ReportUtil;
import com.trainingapps.stockapp.reportms.dto.CreateReportRequest;
import com.trainingapps.stockapp.reportms.dto.ReportDetails;
import com.trainingapps.stockapp.reportms.entity.Report;
import com.trainingapps.stockapp.reportms.repository.IReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ReportServiceImpl implements  IReportService{
    @Autowired
    private IReportRepository repository;
    @Autowired
    private ReportUtil reportUtil;

    @Override
    public ReportDetails generateReportInPeriod(CreateReportRequest request) {
        Report record= reportUtil.createReportRequestToReport(request);

        //////////////
        record=mock2(record);
        /////////////

        record=repository.save(record);
        ReportDetails response=reportUtil.ReportToReportDetails(record);
        return response;
    }

    @Override
    public ReportDetails findReportDetailsById(Long reportId) throws ReportNotFoundException{
        Optional<Report> optional= repository.findById(reportId);
        if(optional.isEmpty()){
            throw new ReportNotFoundException("report not found in database");
        }
        Report record= optional.get();
        ReportDetails response=reportUtil.ReportToReportDetails(record);
        return response;
    }

    //////////////
    public List<MockOrderDetails> mock(){
        MockOrderDetails order1=new MockOrderDetails(10);
        MockOrderDetails order2=new MockOrderDetails(20);
        MockOrderDetails order3=new MockOrderDetails(30);
        List<MockOrderDetails> list=new ArrayList<>();
        list.add(order1);
        list.add(order2);
        list.add(order3);

        return list;
    }

    public Report mock2(Report record){
        List<MockOrderDetails> list= mock();
        Long count= Long.valueOf(0);
        double totalSalePrice=0;
        for(MockOrderDetails it: list){

            totalSalePrice+= it.orderPrice;
            ++count;
        }
        record.setOrdersCount(count);
        record.setTotalSaleAmount(totalSalePrice);
        return record;
    }
    /////////////////

}
