package com.harsh.jobportal.service;

import com.harsh.jobportal.modal.JobPost;
import com.harsh.jobportal.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public  void  addJob(JobPost jobPost){
        repo.addJob(jobPost);

    }

    public List<JobPost> getAllJobs(){
        return repo.getAllJobs();

    }

    public  JobPost getJobById(int id){
        return repo.jobById(id);
    }

    public void updateJob(JobPost job) {
        repo.updateJob(job);
    }

    public void deleteJob(int id) {
        repo.deleteJob(id);
    }
}