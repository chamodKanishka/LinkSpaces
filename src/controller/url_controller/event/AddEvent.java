package controller.url_controller.event;

import controller.db_controller.EventsController;
import model.EventDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;

@WebServlet(urlPatterns = "/event_image")
@MultipartConfig
public class AddEvent extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int success = 0;
        EventDTO eventDTO = new EventDTO();
        EventsController eventsController = new EventsController();
//        eventDTO.setPoster_id(Integer.parseInt(request.getParameter("posterId")));
        eventDTO.setPoster_id(Integer.parseInt(request.getParameter("posterId")));
        eventDTO.setTitle(request.getParameter("eventName"));
        eventDTO.setStart_date(request.getParameter("startDate"));
        eventDTO.setEnd_date(request.getParameter("endDate"));
        eventDTO.setStart_time(request.getParameter("startTime"));
        eventDTO.setVenue(request.getParameter("venueName"));
        eventDTO.setDescription(request.getParameter("description"));
        eventDTO.setOrganized_by(request.getParameter("organizing"));
        eventDTO.setCategory(request.getParameter("attending"));
        eventDTO.setWebsite(request.getParameter("website"));

        String relativeWebPath = "/files";
        String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
        File theDir = new File(absoluteDiskPath);
        if (!theDir.exists()) {
            theDir.mkdir();
        }
        relativeWebPath = "/files/images";
        absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
        theDir = new File(absoluteDiskPath);
        if (!theDir.exists()) {
            theDir.mkdir();
        }
        relativeWebPath = "/files/images/";
        absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        eventDTO.setImage(fileName);
        if (eventsController.addEvent(eventDTO)) {
            success++;
        }

        InputStream fileContent = null;
        OutputStream outputStream = null;
        try {
            fileContent = filePart.getInputStream();
            byte[] buffer = new byte[fileContent.available()];
            fileContent.read(buffer);

            File targetFile = new File(absoluteDiskPath + "\\" + fileName);
            outputStream = new FileOutputStream(targetFile);
            outputStream.write(buffer);
        } catch (Exception e) {
            response.sendRedirect("/views/event/addevents.jsp?path=addevents&upload=failed");
        } finally {
            if (fileContent != null) {
                try {
                    fileContent.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    // outputStream.flush();
                    outputStream.close();
                    success++;
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (success == 2) {
                response.sendRedirect("/views/event/addevents.jsp?path=addevents&upload=success");
            } else {
                response.sendRedirect("/views/event/addevents.jsp?path=addevents&upload=failed");
            }
        }
    }
}
