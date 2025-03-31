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
        repo.save(jobPost);

    }

    public List<JobPost> getAllJobs(){
        return repo.findAll();

    }

    public  JobPost getJobById(int id){
        return repo.findById(id).orElse((new JobPost()));
    }

    public void updateJob(JobPost job) {
        repo.save(job);
    }

    public void deleteJob(int id) {
        repo.deleteById(id);
    }

    public List<JobPost> search(String keyword) {
       return  repo.findByPostProfileContainingOrPostDescContaining(keyword , keyword);
    }
}