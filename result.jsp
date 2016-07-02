<jsp:useBean id="beanmain" class="cs.pkgfinal.project.BeanMain" scope="session"/>

<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<%@ page import="org.apache.commons.io.output.*" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar;" %>


<%
try {  
    final String UPLOAD_DIR = getServletContext().getRealPath("/Data");
    if(ServletFileUpload.isMultipartContent(request)){
        List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

        for(FileItem item : multiparts){
            
            if(!item.isFormField()){
                String nameWithPath = UPLOAD_DIR + File.separator + new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_SSS").format(Calendar.getInstance().getTime()) + " - " + new File(item.getName()).getName();

                beanmain.setCurrentUserFilePath(nameWithPath);
                item.write(new File(nameWithPath));
            }
        }
    }
    else {
        if(request.getParameter("funcname").indexOf("SA") >= 0){
            out.println(beanmain.getSimulatedAnnealingSolution(Integer.parseInt(request.getParameter("iterations").trim()), Integer.parseInt(request.getParameter("no_OfProjects").trim())));
        }
    }
}
catch(Exception ex){
    out.println(ex);
}
%>