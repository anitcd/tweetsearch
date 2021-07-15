
<%@page import="java.io.FileWriter"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Tweets</title>
        
        <style>
            footer {
                position:fixed;
                //height:50px;
                background-color: #c0deed; /* #c0deed #c0deed */
                bottom: 10px;
                left:0px;
                right:0px;
                margin-bottom:4px;
                text-align: right;
                padding-top: 2px;
                padding-bottom: 2px;
                padding-right: 20px;
            }
            footer1 {
                position:fixed;
                //height:50px;
                background: #001428 url('images/blue6.png') top left repeat-x;
                background-size: contain;
                color: white;
                bottom:0px;
                left:0px;
                right:0px;
                margin-bottom:0px;
                text-align: center;
                padding-top: 4px;
                padding-bottom: 4px;
                padding-right: 5%;
                font-size: 60%;
            }            
            container {
                width: 75%;
            }
            searchBar {
                position: fixed;
                //left:0px;
                //right:0px;
                background-color: transparent;
                color: white;
                //padding: 10px;
                //width: 80%;
                text-align: center;
            }
            
        </style>
    </head>
    <body>
        <%
            String uid = request.getParameter("uid");
            
            // writing the uID into the file uid.txt
            try {
                if(Integer.parseInt(uid) >= 100 && Integer.parseInt(uid) <= 150) {
                    //File file = new File("/store/Data/TweetData/TwarcDump/log/uid.txt");       // from Local
                    File file = new File("/home/achakrab/TweetUserStudy/uid.txt");       // from achakrab@vma57.scss.tcd.ie
                    file.createNewFile();
                    FileWriter writer = new FileWriter(file);

                    writer.write(uid + "\n");
                    writer.close();
                }
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
        %>

<!--        <footer>footer</footer>-->
        <form action="search.jsp">

            <div style="position: absolute; top:0px; left:0px;"><img src="./images/TCD_logo.jpg" width="30%" height="30%" align="left">
            <!-- <footer><div style="position: fixed; bottom: 0px; right: 0px; padding: 0px;"><img src="./images/ADAPT.png" width="10%" height="60%" align="rigt"></footer> -->
            <footer><img src="./images/ADAPT.png" width="8%"></footer>
            <footer1>Developed by Anirban</footer1>
                    
                
                
            <%-- <img src="./images/Twitter_bird_logo.png" width="8%" height="8%" align="right"> --%>

            
            <!-- PP <h1 style="color: #00aced; position: relative; alignment-adjust: central; top: 230px">Search for Tweets...</h1> -->
            
<!--                left: 530px; top: 230px;-->
            <!-- PP <div style="position: absolute; top:300px; left:350px;"><input type="text" name="query" id="query" style=" width:600px; height:35px; font-size: 26px; border: 1px solid; background-color: AliceBlue;" required></div> -->
            <searchBar><input type="text" name="query" placeholder="Search for Tweets..." style=" width:500px; height:35px; font-size: 26px; border: 1px solid grey; background-color: AliceBlue; margin-top: 58%; border-radius: 8px 8px 8px 8px;" required> <input type="image" src="./images/Twitter_bird_logo.png" alt="Search" height="35px" style="margin-top: 58%; float: right;"></searchBar>


            <%-- <input type="text" name="btn" required style="width: 600px;" align="center"> --%>
            <!-- PP <div style="position: absolute; top:300px; left:970px;"><input type="image" src="./images/Twitter_bird_logo.png" alt="Search" height=35px> -->

            <%-- <div style="text-align:center;"><input type="text" name="userid" id="userid"></div>
<input type="image" src="./images/Twitter_bird_logo.png" alt="Search" width="8%" height="8%" align="right"> --%>
            <%-- <input type="submit" value="Search" align="right"> --%>
            

        </form>

        
    </body>
</html>
