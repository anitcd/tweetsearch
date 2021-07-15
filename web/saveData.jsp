<%@page import="java.io.FileWriter"%>
<%@page import="java.io.File"%>
<%@page import="Retrieval.JDBC"%>


<%
    String uId = request.getParameter("uId");    
    String tweetId = request.getParameter("tweetId");
    String text = request.getParameter("text");
    String query = request.getParameter("query");
    String rank = request.getParameter("rank");
    String click = request.getParameter("clk"); // URL Click
    String rel = request.getParameter("rel"); // Relevant Star Click
    
    String splitter = "AniSplit_U_C_T_R_Q_T_R"; // AniSplit_U_C_T_R_Q_T_R
    text = "textSample"; // sample
    
    
    JDBC jdbc = new JDBC();
    if("1".equals(rel)) {
        String test = jdbc.JDBCmain(Integer.parseInt(uId), Long.parseLong(tweetId), Integer.parseInt(rank), query);
        out.println("The string is recieved:"+test);
    }

    
    // Writing in a file
    //File file = new File("/store/Data/TweetData/TwarcDump/log/tweetLog.txt");       // from Local
    File file = new File("/home/achakrab/TweetUserStudy/Log/tweetLog.txt");       // from achakrab@vma57.scss.tcd.ie
    file.createNewFile();
    FileWriter writer = new FileWriter(file, true);
    
    writer.write(uId + "\t" + splitter + "\t" + click + "\t" + splitter + "\t" + tweetId + "\t" + splitter + "\t" + rank + "\t" + splitter + "\t" + query + "\t" + splitter + "\t" + text + "\t" + splitter + "\t" + rel + "\n");
    writer.close();
%>