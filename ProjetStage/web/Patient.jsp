<%-- 
    Document   : Patient
    Created on : 3 juin 2016, 10:57:45
    Author     : ivl
--%>


<%@page import="com.keosys.dataGen.util.Constants"%>
<%@page import="com.keosys.dataGen.bussines.InfoType"%>
<%@page import="com.keosys.dataGen.bussines.User"%>
<%@page import="com.keosys.dataGen.bussines.Protocol" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1 
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0 
    response.setDateHeader("Expires", 0); //prevents caching at the proxy server 
%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Patient</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <script src="js/jquery-1.12.4.js" type="text/javascript"></script>

    <script src="http://code.jquery.com/jquery-latest.min.js"></script>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        function getUtilisateurs() {
            idProtocol = document.getElementById("protocol").value;
            $.ajax(
                    {
                        url: "consults/consultUser.jsp",
                        data: {
                            idProtocol: idProtocol
                        },
                        context: document.body
                    }
            ).done(
                    function (data) {
                        $("#author").html(data);
                    }

            );
        }


        function getProtocols() {
            $.ajax(
                    {
                        url: "consults/consultProtocol.jsp",
                        data: {
                        },
                        context: document.body
                    }
            ).done(
                    function (data) {
                        $("#protocol").html(data);
                    }

            );
        }

        function getInfoTypePatient() {
            table = "patient";
            $.ajax(
                    {
                        url: "consults/consultTypeInfo.jsp",
                        data: {
                            table: table
                        },
                        context: document.body
                    }
            ).done(
                    function (data) {
                        $("#containerInfoType").html(data);
                    }

            );
        }

        function getCentreByAuthor(event) {
            author = document.getElementById("author").value;
            event.preventDefault();
            $.ajax(
                    {
                        type: "post",
                        url: "consults/consultCentreByAuthor.jsp",
                        
                        data: {
                            author: author
                        },
                        context: document.body
                    }
            ).done(
                    function (data) {
                        $("#InvestigatorCentre").html(data);
                    }

            );
        }

        function validDataPatient(event) {
            author = document.getElementById("author").value;
            codePatient = document.getElementById("codePatient").value;
            idProtocol = document.getElementById("protocol").value;
            event.preventDefault();
            if (codePatient === "" || idProtocol === "-1" || author === "-1") {
                alert("ERREUR : Il faut au moins saisir le code patient, l'author et le protocol");
            } else {
                verifyPatientNotExists(event);
            }
        }

        function verifyPatientNotExists(event) {
            codePatient = document.getElementById("codePatient").value;
            $.ajax(
                    {
                        type: "post",
                        url: "consults/consultPatientExist.jsp",
                        data: {
                            codePatient: codePatient
                        },
                        context: document.body
                    }
            ).done(
                    function (data) {
                        if (alertByResult(data) === true) {
                            modifyFilePatient();
                        }
                    }
            );
        }

        function cleanPatient() {
            document.getElementById("author").value = "-1";
            document.getElementById("codePatient").value = "";
            document.getElementById("protocol").value = "-1";
            inputs = document.getElementsByTagName('input');
            for (index = 1; index < inputs.length; ++index) {
                inputs[index].value = "";
            }

        }

        function modifyFilePatient() {
            author = document.getElementById("author").value;
            codePatient = document.getElementById("codePatient").value;
            idProtocol = document.getElementById("protocol").value;
            $.ajax(
                    {
                        type: "post",
                        url: "files/modifyFilePatient.jsp",
                        data: {
                            author: author,
                            codePatient: codePatient,
                            idProtocol: idProtocol
                        },
                        context: document.body
                    }
            ).done(
                    function (data) {
                        if (alertByResult(data) === true) {
                            generatePatient();
                        }
                    }
            );
        }

        function generatePatient() {
            $.ajax(
                    {
                        type: "post",
                        url: "generate/generatePatient.jsp",
                        data: {
                        },
                        context: document.body
                    }
            ).done(
                    function (data) {
                        if (alertByResult(data) === true) {
                            insertInfoTypePatient();
                        }

                    }
            );

        }

        function insertInfoTypePatient() {
            info = [];
            nom = [];
            author = document.getElementById("author").value;
            if (document.getElementById("InvestigatorCentre") === 'undefined' || document.getElementById("InvestigatorCentre") === null) {
                centre = "NoCentre";
            } else {
                centre = document.getElementById("InvestigatorCentre").value;
            }
            inputs = document.getElementsByTagName('input');
            for (index = 1; index < inputs.length; ++index) {
                nom[index] = inputs[index].getAttribute("id");
                info[index] = inputs[index].value;
            }

            $.ajax(
                    {
                        type: "post",
                        url: "inserts/insertInfoPatient.jsp",
                        data: {
                            nom: nom,
                            info: info,
                            author: author,
                            centre: centre
                        },
                        context: document.body
                    }
            ).done(
                    function (data) {
                        if (alertByResult(data) === true) {
                            insertJoinUserPatient();
                        }
                    }
            );
        }

        function insertJoinUserPatient() {
            author = document.getElementById("author").value;
            codePatient = document.getElementById("codePatient").value;
            $.ajax(
                    {
                        type: "post",
                        url: "inserts/insertJoinUserPatient.jsp",
                        data: {
                            author: author,
                            codePatient: codePatient
                        },
                        context: document.body
                    }
            ).done(
                    function (data) {
                        if (verificationSucces(data) === true) {
                            cleanPatient();
                        }
                    }
            );
        }

        function alertByResult(data) {
            if (data.indexOf("ERREUR") === -1) {
                alerte(data);
                return true;
            } else {
                alert(data);
                return false;
            }
        }

        function alerte(message) {
            $(document).ready(function () {
                $.notiny({text: message});
            });
        }

        function verificationSucces(data) {
            if (data.indexOf("ERREUR") === -1) {
                alerteSucces(data);
                return true;
            } else {
                alert(data);
                return false;
            }
        }

        function alerteSucces(message) {
            $(document).ready(function () {
                $.notiny({text: message, image: "images/crochet-ok-oui-icone-5594-32.png"});
            });
        }

    </script>
</head>
<%
    if (session.getAttribute("connected") == Boolean.TRUE) {
%>
<body onload="getProtocols(), getInfoTypePatient()">
    <div class="container-fluid " >
        <div class="row">
            <div class="col-md-12 vcenter">
                <img src="images/logoKeosys.jpg" alt=""/>
                <nav class="navbar navbar-default navbar-static-top">

                    <div class="container">
                        <ul class="nav navbar-nav navbar-left">
                            <li>
                                <a href="Patient.jsp"><span class="glyphicon glyphicon-user"> Patient</span></a>
                            </li>
                            <li>
                                <a href="Visit.jsp"><span class="glyphicon glyphicon-inbox"> Visit</span></a>
                            </li>
                            <li>
                                <a href="Serie.jsp"><span class="glyphicon glyphicon-file"> Serie</span></a>
                            </li>
                            <li>
                                <a href="Connexion.jsp"><span class="glyphicon glyphicon-signal"> Connexion</span></a>
                            </li>
                            <li>
                                <a href="Config.jsp"><span class="glyphicon glyphicon glyphicon-cog"> Configuration </span></a>
                            </li>
                            <li>
                                <a href="Deconnexion.jsp"><span class="glyphicon glyphicon-log-out"> LogOut</span></a>
                            </li>
                        </ul>
                    </div>
                </nav>
                <div class="row">
                    <div class="col-md-4">
                    </div>
                    <div class="col-md-4">

                        <form class="form-horizontal" id="form">
                            <fieldset>

                                <!-- Form Name -->
                                <legend>Patient</legend>

                                <!-- Select Basic -->
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="protocol">Protocol</label>
                                    <div class="col-md-4">
                                        <select id="protocol" name="protocol" class="form-control" onchange="getUtilisateurs();">

                                        </select>
                                    </div>
                                </div>

                                <!-- Select Basic -->
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="athor">Author</label>
                                    <div class="col-md-4">
                                        <select id="author" name="author" required="true" class="form-control" onchange="getCentreByAuthor(event);" >
                                            <option value='-1'>------</option>
                                        </select>
                                    </div>
                                </div>
                                <!-- Text input-->
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="codePatient">Code Patient</label>  
                                    <div class="col-md-4">
                                        <input id="codePatient" name="codePatient" required="true"  placeholder="Code Patient" class="form-control input-md" type="text"> 
                                    </div>
                                </div>
                                <!-- Text input-->

                                <div id="containerInfoType" class="containerInfoType">
                                </div>
                                <!-- Button -->
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="btnGenerate"></label>
                                    <div class="col-md-4">
                                        <button id="btnGenerate" name="btnGenerate" onclick="validDataPatient(event)" class="btn btn-success">Generate</button>
                                    </div>
                                </div>

                            </fieldset>
                        </form> 
                    </div>
                    <div class="col-md-4">
                    </div>
                </div>
            </div>
        </div>
    </div>    
    <%} else {%>
<body>
    <div class="container-fluid " >
        <div class="row">
            <div class="col-md-12 vcenter">
                <img src="images/logoKeosys.jpg" alt=""/>
                <nav class="navbar navbar-default navbar-static-top">

                    <div class="container">
                        <ul class="nav navbar-nav navbar-left">

                            <li>
                                <a href="Patient.jsp"><span class="glyphicon glyphicon-user"> Patient</span></a>
                            </li>
                            <li>
                                <a href="Visit.jsp"><span class="glyphicon glyphicon-inbox"> Visit</span></a>
                            </li>
                            <li>
                                <a href="Serie.jsp"><span class="glyphicon glyphicon-file"> Serie</span></a>
                            </li>
                            <li>
                                <a href="Connexion.jsp"><span class="glyphicon glyphicon-signal"> Connexion</span></a>
                            </li>
                        </ul>
                    </div>
                </nav>
                <div class="row">
                    <div class="col-md-12 vcenter">
                        <div class="row">
                            <div class="col-md-4">
                            </div>
                            <div class="col-md-4">

                                <p>Il faut se connecter pour accèder à cette section</p>
                                <img src="images/blocked.jpg" alt=""/>
                            </div>
                            <div class="col-md-4">
                            </div>
                        </div>
                    </div>
                </div>
            </div>    
        </div>
    </div>
    <%}%>
    <script src="js/notiny.js"></script>
    <link href="css/notiny.css" rel="stylesheet" />
</body>



