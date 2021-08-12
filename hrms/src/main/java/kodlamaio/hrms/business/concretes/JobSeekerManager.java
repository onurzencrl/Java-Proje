package kodlamaio.hrms.business.concretes;


import kodlamaio.hrms.business.abstracts.JobSeekerCheckService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeekers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerCheckService jobSeekerCheckService;
    private JobSeekerDao jobSeekerDao;

    @Autowired
    public JobSeekerManager(JobSeekerCheckService jobSeekerCheckService, JobSeekerDao jobSeekerDao) {
        super();
        this.jobSeekerCheckService = jobSeekerCheckService;
        this.jobSeekerDao = jobSeekerDao;
    }


    @Override
    public Result add(JobSeekers jobSeekers) {
        return null;
    }

    @Override
    public DataResult<List<JobSeekers>> findAll() {
        return null;
    }
}
