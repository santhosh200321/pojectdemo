package com.example.pojectdemo.Job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceImpl implements JobService
{
    JobRepo jobRepo;

    public ServiceImpl(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }
    @Override
    public List<Job> findall() {
        return (List<Job>) jobRepo.findAll();
    }

    @Override
    public void createjob(Job job) {
        jobRepo.save(job);
    }

    @Override
    public boolean deleteidreq(Long id)
    {
        try
        {
          jobRepo.deleteById(id);
          return true;
        }
        catch(Exception e)
        {
            return  false;

        }
    }

    @Override
    public boolean updatejob(Long id, Job updatejob)
    {
       Optional<Job> opt = jobRepo.findById(id);
        if(opt.isPresent())
        {
                Job job = opt.get();
                job.setName(updatejob.getName());
                job.setSalary(updatejob.getSalary());
                job.setTitle(updatejob.getTitle());
                return true;
            }

        return false;
    }

    @Override
    public Job getId(Long id) {
        return jobRepo.findById(id).orElse(null);
    }

}
