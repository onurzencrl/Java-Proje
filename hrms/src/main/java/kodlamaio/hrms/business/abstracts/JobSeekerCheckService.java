package kodlamaio.hrms.business.abstracts;


import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekers;



public interface JobSeekerCheckService {

    Result checkFirstName(JobSeekers jobSeeker);

    Result checkLastName(JobSeekers jobSeeker);

    Result checkNationalityId(JobSeekers jobSeeker);

    Result checkBirthYear(JobSeekers jobSeeker);

    Result checkEmail(JobSeekers jobSeeker);

    Result checkPassword(JobSeekers jobSeeker);

    Result checkRepeatPassword(JobSeekers jobSeeker);

    kodlamaio.hrms.core.results.Result uniqueEmail(JobSeekers jobSeeker);

    kodlamaio.hrms.core.results.Result uniqueNationalityId(JobSeekers jobSeeker);
}
