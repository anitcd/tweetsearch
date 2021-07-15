

<%@page import="Retrieval.urlFind"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.lucene.document.Document"%>
<%@page import="Retrieval.JSONRetriever"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search results</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<style>
            .myTweet{
                background: #c0deed;
                //border: 2px solid darkblue;
                width:60%;
                overflow-x: hidden;
                overflow-y: hidden;
                //height:100%;
                padding-top:10px;
                position: relative;
                float: left;
                margin-left: 15%;
                //margin-right: 15%;

            }
            .myTweet_open{
                background: #c0deed;
                //border: 2px solid darkblue;
                width:60%;
                overflow-x: hidden;
                overflow-y: hidden;
                //height:100%;
                padding-top:10px;
                position: relative;
                float: left;
                margin-left: 15%;
                //margin-right: 15%;

            }
            .arrow{
                //content:url("./images/ExpandArrow.png");
                content:url("./images/star_off.png");
                width:30px;
                height:30px;
                position: relative;
                cursor: pointer;
                float: right;
                margin-right: 15%;
                
            }
              .closeArrow{
                //content:url("./images/CloseArrow.png");
                content:url("./images/star_on.png");
                height:30px;
                width:30px;
                position: relative;                
                cursor: pointer;
                float: right;
                margin-right: 15%;
                
            }
            .inner_txt{
                position: relative;
                float: left;               

            }
            .dummy{
                position: relative;
                clear:both;
                margin-left: 15%;
                margin-right: 15%;
                
            }
            img {
                float: left;
                margin: 14px 14px 14px 14px;
            }
            div {
                border: 2px solid #c0deed; /* #0084b4 #c0deed #73AD21; */
                //background-color: lightblue;
            }
            .clearfix {
                overflow: auto;
                margin-left: 15%;
                margin-right: 15%;
                margin-top: 15px;
            }
            .img2 {
                float: left;
            }
            .img3 {
                float: left;
                margin-top: 1px;
                margin-right: 10px;
                margin-left: 15%;
                background: transparent;
            }
            .img4 {
                margin-top: 3px;
                margin-right: 10px;
                margin-left: 76px;  
                background: transparent;
            }
            .img5 {
                //margin-top: 10px;
                float: right;
            }
            .imgVerified {
                position: relative;
                padding-top: 2px;
            }
            header {
                position: fixed;
                background-color: transparent;
                color: #0084b4; /* #00aced #0084b4 */
                text-align: center;
                width: 100%;
                margin-top: 49px;
            }
           
            header1 {
                position: fixed;
                left:0px;
                right:0px;
                background-color: #00aced; /* #0084b4 */
                color: white;
                padding: 10px;
                padding-top: 10px;
                padding-bottom: 0px;
                width: 100%;
                text-align: right;
            }
            header2 {
                position: fixed;
                left:0px;
                right:0px;
                background-color: #red;
                color: white;
                padding: 10px;
                width: 100%;
                text-align: left    ;
                margin-left: 15%;
            }
            footer {
                position:fixed;
                //height:50px;
                background: #001428 url('images/blue6.png') top left repeat-x;
                background-size: contain;
                //background-color: #001428; /* #00aced */
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
            .imgHome {
                //position: fixed;
                margin-top: 6px;
                height: 32px;
                margin-left: 15%;
            }
            
            #retweetimg {
                background: #fff url('./images/retweetG.png') left no-repeat;
                background-size: contain;
                height: 22px;
                width: 69%;
                margin: 0 auto;
                margin-top: -1px;
                margin-left: 15%;
                text-align: left;
                border: 0;
            }
            #retweetimg p1 {
                margin: 0;
                color: grey;
                font-size: 80%;
                font-weight: 600;
                padding-left: 30px;
                //padding-top: 10px;
                //letter-spacing: 1px;
            }
            #likeimg {
                background: #fff url('./images/like3.png') left no-repeat;
                background-size: contain;
                height: 22px;
                width: 60%;
                margin: 0 auto;
                margin-top: -22px;
                margin-left: 25%;
                text-align: left;
                border: 0;
                //padding-top: 10px;
            }
            #likeimg p1 {
                margin: 0;
                color: grey;
                font-size: 80%;
                font-weight: 600;
                padding-left: 30px;
                //padding-top: 10px;
                //letter-spacing: 1px;
            }
         
        </style>
        <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
        <script src="https://cdn.rawgit.com/nnattawat/flip/master/dist/jquery.flip.min.js"></script>
    </head>
    

    
    <%
   
    
      
    %>

    <script>
        var query, url, tweet, tweet1, url1, current_class, tweetId, uId, counter = 0;
        

        // function to show #star box
        function tempAlert(msg,duration)
        {
            var el = document.createElement("div");
            el.setAttribute("style","position:fixed;top:10%;left:90%;background-color:#0084b4;color:white; padding:10px; border:0; border-radius: 22px 22px 22px 22px;");
            el.innerHTML = msg;
           // setTimeout(function(){
           //  el.parentNode.removeChild(el);
           // },duration);
            document.body.appendChild(el);
        }
        
        
        
        $( document ).ready(function() {
        
            //.............To capture the URL clicks.............
            //$('body').on('click', '.myTweet a', function() {
            $('body').on('click', 'a', function() {
                if($(this).attr('href') !== "http://anistudy.adaptcentre.ie/tweetsearch/home.jsp") {
                    var div = $(this).parent().parent();
                    var rank = div.attr('rank');
                    rank++;
                    //var url = "saveData.jsp?uId=100&tweetId=100&text=" + $(this).attr('href') + "&query=pp&rank=" + div.attr('rank') + "&clk=100";
                    var url = "saveData.jsp?uId=" + div.attr('uid') + "&tweetId=" + div.attr('id') + "&text=" + encodeURIComponent(div.attr('text')) 
                                        + "&query=" + encodeURIComponent(div.attr('query')) + "&rank=" + rank + "&clk=1&rel=0";
                    console.log(url);
                    $.get(url, function(data, status){
                        console.log("Data: " + data + "\nStatus: " + status);
                    });
                    
                }
            });



            var animation_time = 50;
            var arrow = "<img class='arrow' src='./images/ExpandArrow.png'>";
           
            // $('.myTweet').append(arrow);
            var opened = null;
            var firstFlag = true;
            //.............To capture Star clicks.............
            $('.arrow').bind( "click", function(e) {
                current_class = $(this).find('.arrow').attr('class');
                tweet = $(this).prev();
                if($(tweet).attr('class')=="myTweet_open"){
                    //$(tweet).animate({'width':'100%'},animation_time);
                    $(tweet).addClass('myTweet').removeClass('myTweet_open');
                   $(this).addClass('arrow').removeClass('closeArrow');
                }
                else{
                    counter++;
                    tempAlert("Starred : " + counter,5000);     // Showing #Star

                    //$('.myTweet_open').animate({'width':'100%'},animation_time);
                    //$('.myTweet_open').next('img').addClass('arrow').removeClass('closeArrow');
                    
                    //$(tweet).animate({'width':'100%'},animation_time);
                    //$('.myTweet_open').addClass('myTweet').removeClass('myTweet_open');
                    $(tweet).addClass('myTweet_open').removeClass('myTweet');
                     $(this).addClass('closeArrow').removeClass('arrow');
                     
                    tweetId = $(tweet).attr('id');
                    uId = $(tweet).attr('uid');
                    
                    // Ani's
                    query = $(tweet).attr('query');
                    query = encodeURIComponent(query);
                    text = $(tweet).attr('text');
                    text = encodeURIComponent(text);

                    // console.log(query);
                    var rank = $(tweet).attr('rank');
                    rank++;
                    
                    // PP var url = "saveData.jsp?tweetId="+tweetId;
                    url = "saveData.jsp?uId="+uId+"&tweetId="+tweetId+"&text="+text+"&query="+query+"&rank="+rank+"&clk=0&rel=1";
                    //var url = "saveData.jsp?query="+query+"&tweetId="+tweetId+"&rank="+rank;
                    console.log(url);
                    
                     $.get(url, function(data, status){
                    console.log("Data: " + data + "\nStatus: " + status);
                 });
                     
                }
                
            });
            
            
            
            
            
            
            
            
        });
        
   
    </script>
        
    <body>

    <%

    String txt = request.getParameter("query");
    //out.println("<header>SHOWING RESULTS FOR : <font size=\"6\"><b>" + txt + " </b></font></header><br><br><br><br>");
    out.println("<header><font size=\"6\">" + txt + "</font></header><br><br><br><br>");

    // Reading the UserID
    FileReader fr = new FileReader("/store/Data/TweetData/TwarcDump/log/uid.txt");       // from Local
    //FileReader fr = new FileReader("/home/achakrab/TweetUserStudy/uid.txt");       // from achakrab@vma57.scss.tcd.ie
    BufferedReader br = new BufferedReader(fr);
    String uid = br.readLine();

    // Writing in a file
    File file = new File("/store/Data/TweetData/TwarcDump/log/tweetLog.txt");       // from Local
    //File file = new File("/home/achakrab/TweetUserStudy/Log/tweetLog.txt");       // from achakrab@vma57.scss.tcd.ie
    file.createNewFile();
    FileWriter writer = new FileWriter(file, true);
    String splitter = "AniSplit_U_C_T_R_Q_T_R"; // AniSplit_U_C_T_R_Q_T_R
    
    writer.write(uid + "\t" + splitter + "\t0\t" + splitter + "\t0\t" + splitter + "\t0\t" + splitter + "\t" + txt + "\t" + splitter + "\tNULL\t" + splitter + "\t0\n");
    writer.close();

    //out.println("txt");


    
    JSONRetriever retriever = new JSONRetriever("/store/Data/TweetData/TwarcDump/initRetrieve.properties"); // from Local
    //JSONRetriever retriever = new JSONRetriever("/home/achakrab/TweetUserStudy/initRetrieve.properties"); // from achakrab@vma57.scss.tcd.ie


    int nDoc = retriever.RetrievedDocCounter(txt);
    //out.println("Length : " + nDoc + "<br><br>");
    
    if(nDoc > 0) {
        Document []docList = retriever.processAll(txt);
        for (int i = 0; i < nDoc; i++) {
            //out.println(docList[i].get("id") + "<br><div id='"+docList[i].get("id")+"' class='myTweet'><div class='inner_txt'>" + docList[i].get("words") + "</div></div><img class='arrow'/> <br><div class='dummy'></div>");
            String image = "<image src= " + docList[i].get("profileImageUrl") + ">";
            urlFind urlfind = new urlFind();
            String tweetText = urlfind.urlFinder(docList[i].get("words")); // text with clickable URL(s)
            
            if("true".equals(docList[i].get("verified")))
                out.println("<div class=\"clearfix\"><img class=\"img2\" src=" + docList[i].get("profileImageUrl") + "><img class=\"imgVerified\" src=\"./images/verified.png\" height=\"23px\"><br>" + "<b><font size=\"4\">" + docList[i].get("name") + "</font></b>" + "<br><font size=\"2\" color=\"grey\">@" + docList[i].get("screenName") + "</font><br><br><font size=\"2\" color=\"grey\"><div style=\"padding-left:73px;\">FOLLOWING <b><font size=\"4\">" + docList[i].get("following") + "</font></b> FOLLOWERS <b><font size=\"4\">" + docList[i].get("followers") + "</font></b> LISTS <b><font size=\"4\">" + docList[i].get("lists") + "</font></b></div></font></div>");
            else
                out.println("<div class=\"clearfix\"><img class=\"img2\" src=" + docList[i].get("profileImageUrl") + ">" + "<br><b><font size=\"4\">" + docList[i].get("name") + "</font></b>" + "<br><font size=\"2\" color=\"grey\">@" + docList[i].get("screenName") + "</font><br><br><font size=\"2\" color=\"grey\"><div style=\"padding-left:73px;\">FOLLOWING <b><font size=\"4\">" + docList[i].get("following") + "</font></b> FOLLOWERS <b><font size=\"4\">" + docList[i].get("followers") + "</font></b> LISTS <b><font size=\"4\">" + docList[i].get("lists") + "</font></b></div></font></div>");

            //out.println(docList[i].get("id") + "  " + docList[i].get("name") + "<br>@" + docList[i].get("screenName") + "<br><div id='"+docList[i].get("id")+"' class='myTweet'><div class='inner_txt'>" + docList[i].get("words") + "</div></div><img class='arrow'/> <br><div class='dummy'></div>");
            // PP out.println("<div id='"+docList[i].get("id")+"' class='myTweet'><div class='inner_txt'>" + docList[i].get("words") + "</div></div><img class='arrow'/> <br><div class='dummy'></div>" + "<br><br>");
            //PPFullText out.println("<div query='"+txt+"' id='"+docList[i].get("id")+"' rank='"+i+"' class='myTweet'><div class='inner_txt'>" + docList[i].get("words") + "</div></div><img class='arrow'/> <br><div class='dummy'></div>" + "<br><br>");
            //out.println("<div query='"+txt+"' id='"+docList[i].get("id")+"' rank='"+i+"' class='myTweet'><div class='inner_txt'>" + docList[i].get("words") + "<br><br><img class=\"img3\" src=\"./images/retweet.png\" height=\"14px\"><font size=\"2\" color=\"grey\"><b>" + docList[i].get("rtCount") + "</b></font> <img class=\"img3\" src=\"./images/like.png\" height=\"18px\"> <font size=\"2\" color=\"grey\"><b>" + docList[i].get("like") + "</b></font></div></div><img class='arrow'/> <br><div class='dummy'></div>" + "<br><br>");
            //out.println("<div query='"+txt+"' id='"+docList[i].get("id")+"' rank='"+i+"' class='myTweet'><div class='inner_txt'>" + docList[i].get("words") + "<br><br></div></div> <img class='arrow'/> <img class=\"img3\" src=\"./images/retweetG.png\" height=\"22px\"><font size=\"2\" color=\"grey\"><b>" + docList[i].get("rtCount") + "</b></font> <img class=\"img4\" src=\"./images/like.png\" height=\"18px\"> <font size=\"2\" color=\"grey\"><b>" + docList[i].get("like") + "</b></font> <div class='dummy'></div>" + "<br><br>");
            //out.println("<div uid='"+uid+"' query='"+txt+"' id='"+docList[i].get("id")+"' text='"+docList[i].get("words")+"' rank='"+i+"' class='myTweet'><div class='inner_txt'>" + docList[i].get("words") + "<br><br></div></div> <img class='arrow'/>  <div class='dummy'></div>" + "<img class=\"img3\" src=\"./images/retweetG.png\" height=\"22px\"><font size=\"2\" color=\"grey\"><b>" + docList[i].get("rtCount") + "</b></font> <img class=\"img4\" src=\"./images/like.png\" height=\"18px\"> <font size=\"2\" color=\"grey\"><b>" + docList[i].get("like") + "</b><br></font><br><br>");
            out.println("<div uid='"+uid+"' query='"+txt+"' id='"+docList[i].get("id")+"' text='"+docList[i].get("words")+"' rank='"+i+"' class='myTweet'><div class='inner_txt'>" + tweetText + "<br><br></div></div> <img class='arrow'/>  <div class='dummy'></div>" + " <div id=\"retweetimg\"><p1>" + docList[i].get("rtCount") + "</p1></div><div id=\"likeimg\"><p1>" + docList[i].get("like") + "</p1></div><br><br>");
            

        }
    }
    else {
        out.println("<h2>No match found!<h2>");
    }
      // ....
    
      
    %>
        <form action="search.jsp">
            <!-- <header1 style="position:fixed; top: 2px;"><input type="text" name="query" required><input type="submit" name="Search" value="Search" style="margin-right: 80px;"></header1> -->
            <header1 style="position:fixed; top: 0px;"> <input type="text" name="query" placeholder="Search for Tweets..." style=" width:200px; height:18px; font-size: 14px; border: 1px solid grey; background-color: AliceBlue; margin-top: 10px; margin-bottom: 10px; border-radius: 8px 8px 8px 8px;" required><input type="image" title="Search" class="img5" src="./images/twitterWhite.png" alt="Search" height="32px" style="padding-right: 16%; margin-top: 5px; margin-bottom: 5px; float: right;"><a title="Home" href="http://anistudy.adaptcentre.ie/tweetsearch/home.jsp"> <img class="imgHome" alt="Home" src="./images/home.png"></a></header1>
            <footer>Developed by Anirban</footer>
            
        </form>
    </body>
</html>
