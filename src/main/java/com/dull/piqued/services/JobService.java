package com.dull.piqued.services;

import com.dull.piqued.dto.JobRequestDTO;
import com.dull.piqued.dto.JobResponseDTO;
import com.dull.piqued.models.Job;
import com.dull.piqued.repositories.JobRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<JobResponseDTO> getJobs() {
        List<Job> jobs = jobRepository.findAll();
        return jobs
                .stream()
                .map(job -> modelMapper.map(job, JobResponseDTO.class))
                .collect(Collectors.toList());
    }

    public JobResponseDTO createJob(JobRequestDTO jobRequest) {
        Job job = modelMapper.map(jobRequest, Job.class);
        Job savedJob = jobRepository.save(job);
        return modelMapper.map(savedJob, JobResponseDTO.class);
    }

}
