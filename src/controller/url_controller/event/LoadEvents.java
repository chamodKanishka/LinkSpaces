package controller.url_controller.event;

import controller.db_controller.EventsController;
import model.EventDTO;
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

@WebServlet(urlPatterns = "/load_events")
public class LoadEvents extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("eventYear") != null) {
            EventsController eventsController = new EventsController();
            String startYear = request.getParameter("eventYear");
            String startMonth = request.getParameter("eventStartMonth");
            String endYear = "";
            String endMonth = request.getParameter("eventEndMonth");
            if (Integer.parseInt(request.getParameter("eventStartMonth")) == 12) {
                endYear = (Integer.parseInt(request.getParameter("eventYear")) + 1) + "";
            } else {
                endYear = request.getParameter("eventYear");
            }
            ArrayList<EventDTO> events = eventsController.getEvents(startYear, startMonth, endYear, endMonth);
            printJson(events, response);
        } else if (request.getParameter("uid") != null) {
            EventsController eventsController = new EventsController();
            ArrayList<EventDTO> allEvents = eventsController.getAllEventsViaUid(request.getParameter("uid"));
            printJson(allEvents, response);
        } else {
            EventsController eventsController = new EventsController();
            ArrayList<EventDTO> allEvents = eventsController.getAllEvents();
            printJson(allEvents, response);
        }
    }

    private void printJson(ArrayList<EventDTO> allEvents, HttpServletResponse response) throws IOException {
        JSONObject obj = new JSONObject();
        JSONArray eventsJson = new JSONArray();
        for (EventDTO eventDTO : allEvents) {
            JSONObject eventJson = new JSONObject();
            eventJson.put("Id", eventDTO.getId());
            eventJson.put("Title", eventDTO.getTitle());
            eventJson.put("StartDate", eventDTO.getStart_date());
            eventJson.put("EndDate", eventDTO.getEnd_date());
            eventJson.put("StartTime", eventDTO.getStart_time());
            eventJson.put("Venue", eventDTO.getVenue());
            eventJson.put("Category", eventDTO.getCategory());
            eventJson.put("Website", eventDTO.getWebsite());
            eventJson.put("Description", eventDTO.getDescription());
            eventJson.put("Image", eventDTO.getImage());
            eventsJson.add(eventJson);
        }
        obj.put("Posts", eventsJson);
        PrintWriter writer = response.getWriter();
        writer.println(obj.toJSONString());
    }
}
