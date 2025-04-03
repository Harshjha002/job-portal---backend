package com.harsh.jobportal.controller;

import com.harsh.jobportal.modal.JobPost;
import com.harsh.jobportal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "frontend-url")
public class JobRestController {

    @Autowired
    private JobService jobService;

    @GetMapping("/jobposts")
    public List<JobPost> getAllJobs() {
        return jobService.getAllJobs();
    }

    @PostMapping("/addjob")
    public JobPost addJob(@RequestBody JobPost jobPost) {
        jobService.addJob(jobPost);
        return jobService.getJobById(jobPost.getPostId());
    }

    @GetMapping("/job/{id}")
    public JobPost getJobById(@PathVariable int id) {
        return jobService.getJobById(id);
    }

    @GetMapping("/job/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable String keyword) {
        return jobService.search(keyword);
    }

    @PutMapping("/addjob")
    public void updateJob(@RequestBody JobPost job) {
        jobService.updateJob(job);
    }

    @DeleteMapping("/job/{id}")
    public String deleteJob(@PathVariable int id) {
        jobService.deleteJob(id);
        return "Deleted";
    }
}
