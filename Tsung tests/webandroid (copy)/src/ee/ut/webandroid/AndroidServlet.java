package ee.ut.webandroid;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;


public class AndroidServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("Hello<br/>");

        boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
        if (!isMultipartContent) {
            out.println("You are not trying to upload<br/>");
            return;
        }
        out.println("You are trying to upload<br/>");

        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> fields = upload.parseRequest(request);
            out.println("Number of fields: " + fields.size() + "<br/><br/>");


            Iterator<FileItem> it = fields.iterator();
            if (!it.hasNext()) {
                out.println("No fields found");
                return;
            }
            FileItem fileItem = fields.get(0);

            String username = System.getProperty("user.name");
            if (!username.equals("kristiina")) {
                username = "ubuntu";
            }
            String tempFileDirectoryPath = "/home/" + username + "/uploads/";
            out.println(tempFileDirectoryPath);

            File uploadedFile = File.createTempFile("uploaded", ".java", new File(tempFileDirectoryPath));
            out.println("created new empty file");
            fileItem.write(uploadedFile);
            //just a temporary quick test
            String commandOutput = DalvikCompiler.runFile(uploadedFile);
            //String commandOutput = DalvikCompiler.runFile(uploadedFile.getAbsolutePath());
            System.out.println(uploadedFile.getAbsolutePath());
            System.out.println(uploadedFile.getParent());


            out.println(commandOutput);

            out.println("<table border=\"1\">");
                out.println("<tr>");




                boolean isFormField = fileItem.isFormField();
                if (isFormField) {
                    out.println("<td>regular form field</td><td>FIELD NAME: " + fileItem.getFieldName() +
                            "<br/>STRING: " + fileItem.getString()
                    );
                    out.println("</td>");
                } else {
                    out.println("<td>file form field</td><td>FIELD NAME: " + fileItem.getFieldName() +
                            "<br/>STRING: " + fileItem.getString() +
                            "<br/>NAME: " + fileItem.getName() +
                            "<br/>CONTENT TYPE: " + fileItem.getContentType() +
                            "<br/>SIZE (BYTES): " + fileItem.getSize() +
                            "<br/>TO STRING: " + fileItem.toString()
                    );
                    out.println("</td>");
                }
                out.println("</tr>");
            out.println("</table>");
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("no tere");
        // just testing here (as I can easily call this via browser)
    }
}
