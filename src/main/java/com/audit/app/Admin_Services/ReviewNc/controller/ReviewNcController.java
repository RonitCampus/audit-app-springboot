package com.audit.app.Admin_Services.ReviewNc.controller;

import com.audit.app.Admin_Services.ReviewNc.model.NcInfo;
import com.audit.app.Admin_Services.ReviewNc.model.NcInfoUpdateForm;
import com.audit.app.Admin_Services.ReviewNc.service.ReviewNcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

/**
 * Created by matth on 6/8/2017.
 */
@RestController
@CrossOrigin
@RequestMapping("/Admin_Services/ReviewNc")
public class ReviewNcController {

    private ReviewNcService reviewNcService;

    @Autowired
    public ReviewNcController(ReviewNcService reviewNcService) {
        this.reviewNcService = reviewNcService;
    }

    @GetMapping("ncInfo/{ncId}")
    public ResponseEntity< NcInfo> getNcInfo(@PathVariable("ncId") final int ncId ) throws SQLException {
        return new ResponseEntity<NcInfo>( this.reviewNcService.getNcInfo(ncId) , HttpStatus.OK );
    }

    @PostMapping("/updateNc")
    public ResponseEntity<Boolean> updateNc(@RequestBody NcInfoUpdateForm ncInfoUpdateForm) throws SQLException {
        return new ResponseEntity<Boolean>( this.reviewNcService.updateNc(ncInfoUpdateForm) , HttpStatus.OK);
    }

}
