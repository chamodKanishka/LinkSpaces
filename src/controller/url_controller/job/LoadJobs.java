package controller.url_controller.job;

import controller.db_controller.JobController;
import model.JobDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/load_jobs")
public class LoadJobs extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("job_title") != null) {
            PrintWriter writer = response.getWriter();
            JSONObject obj = new JSONObject();
            JSONArray eventsJson = new JSONArray();
            JobController jobController = new JobController();
            ArrayList<JobDTO> jobs = jobController.getJobs(request.getParameter("job_title"));
            for (JobDTO jobDTO : jobs) {
                JSONObject eventJson = new JSONObject();
                eventJson.put("Description", jobDTO.getDescription());
                eventJson.put("Offered_By", jobDTO.getOfferedBy());
                eventJson.put("Job_Type", jobDTO.getJobType());
                eventsJson.add(eventJson);
            }
            obj.put("Data", eventsJson);
            writer.println(obj.toString());
        } else {
            JobController jobController = new JobController();
            ArrayList<JobDTO> allJobs = jobController.getAllJobs();
            JSONObject obj = new JSONObject();
            JSONArray eventsJson = new JSONArray();
            for (JobDTO jobDTO : allJobs) {
                JSONObject eventJson = new JSONObject();
                eventJson.put("Id", jobDTO.getId());
                eventJson.put("PosterId", jobDTO.getPosterId());
                eventJson.put("Title", jobDTO.getJobTitle());
                eventJson.put("Description", jobDTO.getDescription());
                eventJson.put("PostDate", jobDTO.getPost_date());
                eventJson.put("OfferedBy", jobDTO.getOfferedBy());
                eventJson.put("Type", jobDTO.getJobType());
                eventsJson.add(eventJson);
            }
            obj.put("Posts", eventsJson);
            PrintWriter writer = response.getWriter();
            writer.println(obj.toJSONString());
        }
    }
}
