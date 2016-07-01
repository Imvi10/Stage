<%-- 
    Document   : Patient
    Created on : 3 juin 2016, 10:57:45
    Author     : ivl
--%>

<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1 
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0 
    response.setDateHeader("Expires", 0); //prevents caching at the proxy server 
%>
<%@page import="com.keosys.dataGen.util.Constants"%>
<%@page import="com.keosys.dataGen.bussines.InfoType"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Serie</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <script src="js/jquery-1.12.4.js" type="text/javascript"></script>
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

            function getPatients() {
                idAuthor = document.getElementById("author").value;
                $.ajax(
                        {
                            url: "consults/consultPatientCodeLikeId.jsp",
                            data: {
                                idAuthor: idAuthor
                            },
                            context: document.body
                        }
                ).done(
                        function (data) {
                            $("#codePatient").html(data);
                        }

                );
            }

            function getTypeVisit() {

                codePatient = document.getElementById("codePatient").value;

                $.ajax(
                        {
                            url: "consults/consultVisit.jsp",
                            data: {
                                codePatient: codePatient
                            },
                            context: document.body
                        }
                ).done(
                        function (data) {
                            $("#visiteSerie").html(data);
                        }

                );
            }
            function getInfoTypeSerie() {
                table = "series";
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

            function validDataSerie() {
                author = document.getElementById("author").value;
                codePatient = document.getElementById("codePatient").value;
                visiteSerie = document.getElementById("visiteSerie").value;
                event.preventDefault();
                if (codePatient === "" || visiteSerie === "-1" || author === "-1") {
                    alert("ERREUR : Il faut au moins saisir le code patient, l'author et la serie");
                } else {
                    modifyFileSerie();
                }
            }

            function cleanSerie() {
                document.getElementById("author").value = "-1";
                document.getElementById("codePatient").value = "-1";
                document.getElementById("visiteSerie").value = "-1";
                document.getElementById("protocol").value = "-1";
                inputs = document.getElementsByTagName('input');
                for (index = 0; index < inputs.length; ++index) {
                    inputs[index].value = "";
                }
            }

            function modifyFileSerie() {
                visiteSerie = document.getElementById("visiteSerie").value;
                author = document.getElementById("author").value;
                $.ajax(
                        {
                            type: "post",
                            url: "files/modifyFileSerie.jsp",
                            data: {
                                author: author,
                                visiteSerie: visiteSerie
                            },
                            context: document.body
                        }
                ).done(
                        function (data) {
                            if (alertByResult(data) === true) {
                                generateSerie();
                            }
                        }
                );
            }


            function  generateSerie() {
                $.ajax(
                        {
                            type: "post",
                            url: "generate/generateSerie.jsp",
                            data: {
                            },
                            context: document.body
                        }
                ).done(
                        function (data) {
                            if (alertByResult(data) === true) {
                                insertTypeInfo();
                            }
                        }
                );

            }
            function insertTypeInfo() {
                info = [];
                nom = [];
                inputs = document.getElementsByTagName('input');
                for (index = 0; index < inputs.length; ++index) {
                    nom[index] = inputs[index].getAttribute("id");
                    info[index] = inputs[index].value;
                }

                author = document.getElementById("author").value;
                codePatient = document.getElementById("codePatient").value;
                visiteSerie = document.getElementById("visiteSerie").value;
                $.ajax(
                        {
                            type: "get",
                            url: "inserts/insertInfoSerie.jsp",
                            data: {
                                nom: nom,
                                info: info
                            },
                            context: document.body
                        }
                ).done(
                        function (data) {
                            if (verificationSucces(data) === true) {
                                cleanSerie();
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
    <body onload="getProtocols(), getInfoTypeSerie()">
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


                            <form class="form-horizontal" id="formSerie">
                                <fieldset>

                                    <!-- Form Name -->
                                    <legend>Serie</legend>


                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="protocol">Protocol</label>
                                        <div class="col-md-4">
                                            <select id="protocol" name="protocol" class="form-control" onchange="getUtilisateurs();">
                                                <option value="-1">------</option>
                                            </select>
                                        </div>
                                    </div>
                                    <!-- Select Basic -->
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="author">Author</label>
                                        <div class="col-md-4">
                                            <select id="author" name="author" required="true" class="form-control" onchange="getPatients()">
                                                <option value="-1">------</option>
                                            </select>
                                        </div>
                                    </div>

                                    <!-- Select Basic -->
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="codePatient">Code Patient</label>
                                        <div class="col-md-4">
                                            <select id="codePatient" name="codePatient" required="true" class="form-control" onchange="getTypeVisit()">
                                                <option value="-1">------</option>
                                            </select>
                                        </div>
                                    </div>

                                    <!-- Select Basic -->
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="visiteSerie">Visite</label>
                                        <div class="col-md-4">
                                            <select required="true" id="visiteSerie" name="visiteSerie" class="form-control">
                                                <option value="-1">------</option>
                                            </select>
                                        </div>
                                    </div>

                                    <!-- Text input-->
                                    <div id="containerInfoType" class="containerInfoType">


                                    </div>

                                    <!-- Button -->
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="btnGenerate"></label>
                                        <div class="col-md-4">
                                            <button id="btnGenerate" name="btnGenerate" class="btn btn-success" onclick="validDataSerie();" id="btnAgregar">Generate</button>
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
        <%}else{%>
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
</html>
