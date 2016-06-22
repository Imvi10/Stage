<%-- 
    Document   : Patient
    Created on : 3 juin 2016, 10:57:45
    Author     : ivl
--%>
<%@page import="com.keosys.dataGen.bussines.TypeVisit"%>
<%@page import="com.keosys.dataGen.bussines.Patient"%>
<%@page import="com.keosys.dataGen.bussines.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visit</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <script src="js/jquery-1.12.4.js" type="text/javascript"></script>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

        <script type="text/javascript">
            function getTypeVisit() {
                codePatient = document.getElementById("codePatient").value;
                $.ajax(
                        {
                            url: "consults/consultTypeVisit.jsp",
                            data: {
                                codePatient: codePatient
                            },
                            context: document.body
                        }
                ).done(
                        function (data) {
                            $("#typeVisit").html(data);
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
                table = "visit";
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

            function cleanVisit() {
                document.getElementById("author").value = "-1";
                document.getElementById("codePatient").value = "-1";
                document.getElementById("typeVisit").value = "-1";
                document.getElementById("protocol").value = "-1";
                inputs = document.getElementsByTagName('input');
                for (index = 0; index < inputs.length; ++index) {
                    inputs[index].value = "";
                }
            }

            function validDataVisit() {
                author = document.getElementById("author").value;
                codePatient = document.getElementById("codePatient").value;
                typeVisit = document.getElementById("typeVisit").value;

                event.preventDefault();
                if (codePatient === "" || typeVisit === "-1" || author === "-1") {
                    alert("ERREUR : Il faut au moins saisir le code patient, l'author et le type de visite");
                } else {
                    modifyFileVisit();
                }
            }

            function modifyFileVisit() {
                var selectTypeVisit = document.getElementById("typeVisit");
                codeVisite = selectTypeVisit[selectTypeVisit.selectedIndex].id;
                var selectCodePatient = document.getElementById("codePatient");
                idPatient = selectCodePatient[selectCodePatient.selectedIndex].id;
                idTypeVisit = document.getElementById("typeVisit").value;
                $.ajax(
                        {
                            type: "post",
                            url: "files/modifyFileVisit.jsp",
                            data: {
                                idPatient: idPatient,
                                idTypeVisit: idTypeVisit,
                                codeTypeVisit: codeVisite
                            },
                            context: document.body
                        }
                ).done(
                        function (data) {
                            if (alertByResult(data) === true) {
                                generateVisit();
                            }
                        }
                );
            }

            function generateVisit() {
                $.ajax(
                        {
                            type: "post",
                            url: "generate/generateVisit.jsp",
                            data: {
                            },
                            context: document.body
                        }
                ).done(
                        function (data) {
                            if (alertByResult(data) === true) {
                                insertInfoType();
                            }

                        }
                );
            }

            function insertInfoType() {
                info = [];
                nom = [];
                inputs = document.getElementsByTagName('input');
                for (index = 0; index < inputs.length; ++index) {
                    nom[index] = inputs[index].getAttribute("id");
                    info[index] = inputs[index].value;
                }
                $.ajax(
                        {
                            type: "post",
                            url: "inserts/insertInfoVisit.jsp",
                            data: {
                                nom: nom,
                                info: info
                            },
                            context: document.body
                        }
                ).done(
                        function (data) {
                            if (alertByResult(data) === true) {
                                insertJoinUserVisit();
                            }
                        }
                );
            }


            function insertJoinUserVisit() {
                author = document.getElementById("author").value;
                $.ajax(
                        {
                            type: "post",
                            url: "inserts/insertJoinVisitUser.jsp",
                            data: {
                                author: author
                            },
                            context: document.body
                        }
                ).done(
                        function (data) {
                            if (verificationSucces(data) === true) {
                                cleanVisit();
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
    <body onload="getProtocols(), getInfoTypePatient()" >

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


                            <form class="form-horizontal">
                                <fieldset>

                                    <!-- Form Name -->
                                    <legend>Visit</legend>

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
                                            <select id="author" name="author" class="form-control" onchange="getPatients()">
                                                <option value="-1" >------</option>

                                            </select>
                                        </div>
                                    </div>

                                    <!-- Select Basic -->
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="codePatient">Code Patient</label>
                                        <div class="col-md-4">
                                            <select id="codePatient" name="codePatient" class="form-control" onchange="getTypeVisit()">
                                                <option value='-1'>------</option>
                                            </select>
                                        </div>
                                    </div>

                                    <!-- Select Basic -->
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="typeVisit">Type Visite</label>
                                        <div class="col-md-4">
                                            <select id="typeVisit" name="typeVisit" required="true" class="form-control">
                                                <option value="-1" >------</option>
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
                                            <button id="btnGenerate" name="btnGenerate" onclick="validDataVisit()" class="btn btn-success">Generate</button>
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
        <%    } else {

        %>
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


        <%        }
        %>
        <script src="js/notiny.js"></script>
        <link href="css/notiny.css" rel="stylesheet" />
    </body>
</html>
