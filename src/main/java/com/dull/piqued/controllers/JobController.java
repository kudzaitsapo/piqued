package com.dull.piqued.controllers;


import com.dull.piqued.common.ResponseTemplate;
import com.dull.piqued.dto.JobRequestDTO;
import com.dull.piqued.dto.JobResponseDTO;
import com.dull.piqued.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    private JobService jobService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseTemplate createCompanyJob(@RequestBody JobRequestDTO job) {
        JobResponseDTO jobCreated = jobService.createJob(job);
        return new ResponseTemplate("Successfully created Job", jobCreated);
    }

    @GetMapping(produces = "application/json")
    public ResponseTemplate getAllJobs() {
        List<JobResponseDTO> jobs = jobService.getJobs();
        return new ResponseTemplate("Successfully retrieved jobs", jobs);
    }
}
