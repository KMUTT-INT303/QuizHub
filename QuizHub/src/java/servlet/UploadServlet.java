/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import db.BuildConnection;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UploadServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)

public class UploadServlet extends HttpServlet {

//    private static final String SAVE_DIR = "images";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ////        processRequest(request, response);
        //
        //        int id = Integer.valueOf((String)(request.getAttribute("currentQuizId")));
        //
        //        response.setContentType("text/html;charset=UTF-8");
        //        PrintWriter out = response.getWriter();
        //        String savePath = "\\images" + File.separator + SAVE_DIR; //specify your path here
        //        File fileSaveDir = new File(savePath);
        //        if (!fileSaveDir.exists()) {
        //            fileSaveDir.mkdir();
        //        }
        //        String fileName=null;
        //        Part part = request.getPart("file");
        //        if (part != null) {
        //            fileName = extractFileName(part);
        //
        //            part.write(savePath + File.separator + fileName);
        //        }
        //        try {
        //            /*
        //        //You need this loop if you submitted more than one file
        //        for (Part part : request.getParts()) {
        //        String fileName = extractFileName(part);
        //        part.write(savePath + File.separator + fileName);
        //        }*/
        //            //you can change this part acc. to your requirements
        //            Class.forName("com.mysql.jdbc.Driver");
        //        } catch (ClassNotFoundException ex) {
        //            Logger.getLogger(UploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        //        }
        //        Connection conn = null;
        //
        //        String query = "INSERT INTO picture(path,quiz_id) values (?,?)";
        //
        //        try {
        //            conn = BuildConnection.getConnection();
        //            PreparedStatement pst = conn.prepareStatement(query);
        //            
        //            String filePath = savePath + File.separator + fileName;
        //            pst.setString(1, filePath);
        //            pst.setInt(2,id);
        //            pst.executeUpdate();
        //        } catch (SQLException ex) {
        //            Logger.getLogger(UploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        //        }
        //        
        //        out.print("upload ok");
        //to get the content type information from JSP Request Header
        
        
        PrintWriter out = response.getWriter();
        String contentType = request.getContentType();
        int id = -1;
        if(request.getAttribute("currentQuizId")!=null){
        id = Integer.valueOf((String)(request.getAttribute("currentQuizId")));
        }
        
        //here we are checking the content type is not equal to Null and

        if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0)) {

            DataInputStream in = new DataInputStream(
                    request.getInputStream());
//we are taking the length of Content type data

            int formDataLength = request.getContentLength();

            byte dataBytes[] = new byte[formDataLength];

            int byteRead = 0;

            int totalBytesRead = 0;
            //this loop converting the uploaded file into byte code

            while (totalBytesRead < formDataLength) {

                byteRead = in.read(dataBytes, totalBytesRead,
                        formDataLength);

                totalBytesRead += byteRead;

            }

            String file = new String(dataBytes);
            //for saving the file name

            String saveFile = file.substring(file.indexOf("filename=\"") + 10);

            saveFile = saveFile.substring(0, saveFile.indexOf("\n"));

            saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,
                    saveFile.indexOf("\""));

            int lastIndex = contentType.lastIndexOf("=");

            String boundary = contentType.substring(lastIndex + 1,
                    contentType.length());

            int pos;
            //extracting the index of file

            pos = file.indexOf("filename=\"");

            pos = file.indexOf("\n", pos) + 1;

            pos = file.indexOf("\n", pos) + 1;

            pos = file.indexOf("\n", pos) + 1;

            int boundaryLocation = file.indexOf(boundary, pos) - 4;

            int startPos = ((file.substring(0, pos)).getBytes()).length;

            int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
            // creating a new file with the same name and writing the content in new file

           // String savePath = application.getRealPath("\\upload\\" + saveFile);
            String savePath = "D:\\Netbean's project\\QuizHub\\QuizHub\\QuizHub\\web\\images\\upload\\"+saveFile;
            
            
            
//            out.println("Upload file Successfully.<br>");
//
//            out.println("Save to : " + savePath);

            FileOutputStream fileOut = new FileOutputStream(savePath);

            fileOut.write(dataBytes, startPos, (endPos - startPos));

            fileOut.flush();

            fileOut.close();
            
            try {
                    String query = "INSERT INTO picture(path,quiz_id) values (?,?)";
                    Connection conn = BuildConnection.getConnection();
                    PreparedStatement pst = conn.prepareStatement(query);
                    
                    String filePath = savePath;
                    pst.setString(1,filePath);
                    pst.setInt(2,id);
                    pst.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(UploadServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
    
    
    
    
    
    
        }
    request.getServletContext().getRequestDispatcher("/WEB-INF/ManageQuiz.jsp").forward(request, response);

    }

    

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
