package controller.url_controller.comments;

import controller.db_controller.CommentsEventsController;
import controller.db_controller.CommentsJobsController;
import model.CommentDTO;
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

@WebServlet(urlPatterns = "/load_comments")
public class LoadComments extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("type").equals("job")) {
            CommentsJobsController commentsJobsController = new CommentsJobsController();
            ArrayList<CommentDTO> comments = commentsJobsController.getComments(request.getParameter("eventId"));
            JSONObject obj = new JSONObject();
            JSONArray commentsJson = new JSONArray();
            for (CommentDTO commentDTO : comments) {
                JSONObject commentJson = new JSONObject();
                commentJson.put("CommentId", commentDTO.getId());
                commentJson.put("EventOrJobId", commentDTO.getJob_id());
                commentJson.put("PosterId", commentDTO.getPoster_id());
                commentJson.put("PosterName", commentDTO.getPoster_name());
                commentJson.put("Comment", commentDTO.getComment());
                commentJson.put("PostTime", commentDTO.getPost_time());
                commentJson.put("PostDate", commentDTO.getPost_date());
                commentsJson.add(commentJson);
            }
            obj.put("Comments", commentsJson);
            PrintWriter writer = response.getWriter();
            writer.println(obj.toJSONString());
            System.out.println(obj);
        } else if (request.getParameter("type").equals("event")) {
            CommentsEventsController commentsEventsController = new CommentsEventsController();
            ArrayList<CommentDTO> comments = commentsEventsController.getComments(request.getParameter("eventId"));
            JSONObject obj = new JSONObject();
            JSONArray commentsJson = new JSONArray();
            for (CommentDTO commentDTO : comments) {
                JSONObject commentJson = new JSONObject();
                commentJson.put("CommentId", commentDTO.getId());
                commentJson.put("EventOrJobId", commentDTO.getEvent_id());
                commentJson.put("PosterId", commentDTO.getPoster_id());
                commentJson.put("PosterName", commentDTO.getPoster_name());
                commentJson.put("Comment", commentDTO.getComment());
                commentJson.put("PostTime", commentDTO.getPost_time());
                commentJson.put("PostDate", commentDTO.getPost_date());
                commentsJson.add(commentJson);
            }
            obj.put("Comments", commentsJson);
            PrintWriter writer = response.getWriter();
            writer.println(obj.toJSONString());
            System.out.println(obj);
        }
    }
}
