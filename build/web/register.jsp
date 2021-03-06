<%-- 
    Document   : register
    Created on : 6 Jul, 2017, 1:55:22 PM
    Author     : anirban
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        
        <style>
            /*--------------------------------------------------------------
            1.0 - BASE SITE STYLES
            --------------------------------------------------------------*/
            *,*:after,*:before {
              box-sizing:border-box;
              -moz-box-sizing:border-box;
              -webkit-box-sizing:border-box;
            }

            .cf:before,
            .cf:after {
                content:"";
                display:table;
            }
            .cf:after {
                clear:both;
            }

            body {
              background: #3aaae8;
              color: #fff;
              font:12px/18px 'HelveticaNeue', Helvetica, Arial, sans-serif;
            }
            a,a:visited {
              color:#fff
            }

            /*--------------------------------------------------------------
            2.0 - SEARCH FORM
            --------------------------------------------------------------*/
            .searchform {
              background:#f4f4f4;
              background:rgba(244,244,244,.79);
              border: 1px solid #d3d3d3;
                    left: 50%;
              padding: 2px 5px;
              position: absolute;
                    margin: -22px 0 0 -170px;
                    top: 50%;
              width:339px;
              box-shadow:0 4px 9px rgba(0,0,0,.37);
              -moz-box-shadow:0 4px 9px rgba(0,0,0,.37);
              -webkit-box-shadow:0 4px 9px rgba(0,0,0,.37);
              border-radius: 10px;
              -moz-border-radius: 10px;
              -webkit-border-radius: 10px
            }

            .searchform input, .searchform button {
                    float: left
            }
            .searchform input {
                    background:#fefefe;
                    border: none;
                    font:12px/12px 'HelveticaNeue', Helvetica, Arial, sans-serif;
                    margin-right: 5px;
                    padding: 10px;
                    width: 216px;
                    box-shadow: 0 0 4px rgba(0,0,0,.4) inset, 1px 1px 1px rgba(255,255,255,.75);
                    -moz-box-shadow: 0 0 4px rgba(0,0,0,.4) inset, 1px 1px 1px rgba(255,255,255,.75);
                    -webkit-box-shadow: 0 0 4px rgba(0,0,0,.4) inset, 1px 1px 1px rgba(255,255,255,.75);
              border-radius: 9px;
              -moz-border-radius: 9px;
              -webkit-border-radius: 9px
            }
                    .searchform input:focus {
                            outline: none;
                            box-shadow:0 0 4px #0d76be inset;
                            -moz-box-shadow:0 0 4px #0d76be inset;
                            -webkit-box-shadow:0 0 4px #0d76be inset;
                    }
                    .searchform input::-webkit-input-placeholder {
                    font-style: italic;
                    line-height: 15px
                    }

                    .searchform input:-moz-placeholder {
                      font-style: italic;
                    line-height: 15px
                    }

            .searchform button {
                    background: rgb(52,173,236);
                    background: -moz-linear-gradient(top, rgba(52,173,236,1) 0%, rgba(38,145,220,1) 100%);
                    background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(52,173,236,1)), color-stop(100%,rgba(38,145,220,1)));
                    background: -webkit-linear-gradient(top, rgba(52,173,236,1) 0%,rgba(38,145,220,1) 100%);
                    background: -o-linear-gradient(top, rgba(52,173,236,1) 0%,rgba(38,145,220,1) 100%);
                    background: -ms-linear-gradient(top, rgba(52,173,236,1) 0%,rgba(38,145,220,1) 100%);
                    background: linear-gradient(to bottom, rgba(52,173,236,1) 0%,rgba(38,145,220,1) 100%);
                    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#34adec', endColorstr='#2691dc',GradientType=0 );
                    border: none;
                    color:#fff;
                    cursor: pointer;
                    font: 13px/13px 'HelveticaNeue', Helvetica, Arial, sans-serif;
                    padding: 10px;
                    width:106px;
                    box-shadow: 0 0 2px #2692dd inset;
                    -moz-box-shadow: 0 0 2px #2692dd inset;
                    -webkit-box-shadow: 0 0 2px #2692dd inset;
              border-radius: 9px;
              -moz-border-radius: 9px;
              -webkit-border-radius: 9px;
            }
            .searchform button:hover {
                    opacity:.9;
            }
        </style>
    </head>
    
    <body>
        <form class="searchform cf" action="home.jsp">
            <%-- <input type="text" placeholder="Enter your user ID" name="uid" required> --%>
            <input type="number" min="100" max="150" placeholder="Enter your user ID" name="uid" required>
            <button type="submit">Submit</button>
        </form>

<%-- <p>Dribbble Rebound of <a target="_blank" href="http://dribbble.com/shots/843289-Search-Bar?list=tags&tag=ui">Search Bar</a> by <a target="_blank" href="http://dribbble.com/craftyliang">Liang Shi</a></p> --%>
         
    </body>
</html>
