package controller.url_controller.comments;

import controller.db_controller.CommentsEventsController;
import controller.db_controller.CommentsJobsController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete_comment")
public class DeleteComment extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("type").equals("job")) {
            CommentsJobsController commentsJobsController = new CommentsJobsController();
            commentsJobsController.deleteComment(request.getParameter("commentId"));
        } else if (request.getParameter("type").equals("event")) {
            CommentsEventsController commentsEventsController = new CommentsEventsController();
            commentsEventsController.deleteComment(request.getParameter("commentId"));
        }
    }

    @Override
    public void init() throws ServletException {
        System.out.println(321);
    }

    public DeleteComment(){
        System.out.println('A');
    }
}
