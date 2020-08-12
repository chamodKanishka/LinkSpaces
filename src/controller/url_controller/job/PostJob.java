package controller.url_controller.job;

import controller.db_controller.JobController;
import model.JobDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/post_job")
public class PostJob extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JobDTO jobDTO = new JobDTO();
        jobDTO.setPosterId(Integer.parseInt(request.getParameter("poster_id")));
        jobDTO.setJobTitle(request.getParameter("job_title"));
        jobDTO.setOfferedBy(request.getParameter("offered_by"));
        jobDTO.setJobType(request.getParameter("job_type"));
        jobDTO.setDescription(request.getParameter("description"));
        JobController jobController = new JobController();
        if (jobController.addJob(jobDTO)) {
            response.sendRedirect("/views/job/post_job.jsp?path=post_job&upload=success");
        } else {
            response.sendRedirect("/views/job/post_job.jsp?path=post_job&upload=failed");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
