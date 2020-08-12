package controller.url_controller.job;

import controller.db_controller.JobController;
import model.ResumeDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;

@WebServlet(urlPatterns = "/file_up")
@MultipartConfig
public class FileUpload extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String relativeWebPath = "/files";
        String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
        File theDir = new File(absoluteDiskPath);
        if (!theDir.exists()) {
            theDir.mkdir();
        }
        relativeWebPath = "/files/resumes";
        absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
        theDir = new File(absoluteDiskPath);
        if (!theDir.exists()) {
            theDir.mkdir();
        }
        relativeWebPath = "/files/resumes/";
        absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        InputStream fileContent = null;
        OutputStream outputStream = null;
        try {
            fileContent = filePart.getInputStream();
            JobController jobController = new JobController();
            ResumeDTO resumeDTO = new ResumeDTO();
            resumeDTO.setPosterId(Integer.parseInt(request.getParameter("poster_id")));
            resumeDTO.setFileName(fileName);
            jobController.addResume(resumeDTO);
            byte[] buffer = new byte[fileContent.available()];
            fileContent.read(buffer);

            File targetFile = new File(absoluteDiskPath + "\\" + fileName);
            outputStream = new FileOutputStream(targetFile);
            outputStream.write(buffer);
        } catch (Exception e) {
            response.sendRedirect("/views/job/file.jsp?path=resume&upload=failed");
        } finally {
            if (fileContent != null) {
                try {
                    fileContent.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    response.sendRedirect("/views/job/file.jsp?path=resume&upload=failed");
                }
            }
            if (outputStream != null) {
                try {
                    // outputStream.flush();
                    outputStream.close();
                    response.sendRedirect("/views/job/file.jsp?path=resume&upload=success");
                } catch (IOException e) {
                    e.printStackTrace();
                    response.sendRedirect("/views/job/file.jsp?path=resume&upload=failed");
                }

            }
        }
    }
}
