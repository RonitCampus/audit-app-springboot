package com.audit.app.Admin_Services.ReviewNc.service;

import com.audit.app.Admin_Services.ReviewNc.model.NcInfo;
import com.audit.app.Admin_Services.ReviewNc.model.NcInfoUpdateForm;
import com.audit.app.Admin_Services.ReviewNc.repository.ReviewNcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Created by matth on 6/8/2017.
 */
@Service
public class ReviewNcService {

    private ReviewNcRepository reviewNcRepository;

    @Autowired
    public ReviewNcService(ReviewNcRepository reviewNcRepository) {
        this.reviewNcRepository = reviewNcRepository;
    }

    public NcInfo getNcInfo(int ncId) throws SQLException {
        return this.reviewNcRepository.getNcInfo(ncId);
    }

    public Boolean updateNc(NcInfoUpdateForm ncInfoUpdateForm) throws SQLException {
        return this.reviewNcRepository.updateNc(ncInfoUpdateForm);
    }
}
