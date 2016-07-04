<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<% response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1 
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0 
    response.setDateHeader("Expires", 0); //prevents caching at the proxy server  
%>
<html>
    <head>
        <title>Data Generator</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <script src="js/jquery-1.12.4.js" type="text/javascript"></script>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


        <script type="text/javascript">

            function validData(event) {
                ipServer = document.getElementById("ipServer").value;
                port = document.getElementById("port").value;
                usr = document.getElementById("usr").value;
                pswd = document.getElementById("pswd").value;
                db = document.getElementById("db").value;
                event.preventDefault();
                if (ipServer === "" || port === "" || usr === "" || pswd === "") {
                    document.getElementById("db").value = "-1";
                    console.log("log : All the inputs are not filled");
                } else {
                    checkConnection(event);
                }
            }


            function validDataClick(event) {
                ipServer = document.getElementById("ipServer").value;
                port = document.getElementById("port").value;
                usr = document.getElementById("usr").value;
                pswd = document.getElementById("pswd").value;
                db = document.getElementById("db").value;
                event.preventDefault();
                if (ipServer === "" || port === "" || usr === "" || pswd === "") {
                    alert("ERREUR : Il faut remplir tous les champs de connexion");
                    return true;
                } else {
                    return false;
                }

            }

            function checkConnection(event) {

                ipServer = document.getElementById("ipServer").value;
                port = document.getElementById("port").value;
                usr = document.getElementById("usr").value;
                pswd = document.getElementById("pswd").value;
                event.preventDefault();

                $.ajax(
                        {
                            type: "post",
                            url: "consults/colsultDatabases.jsp",
                            data: {
                                ipServer: ipServer,
                                port: port,
                                usr: usr,
                                pswd: pswd
                            },
                            context: document.body
                        }
                ).done(
                        function (data) {
                            $("#db").html(data);
                        }
                );
            }
            function cleanDatabase() {
                document.getElementById("ipServer").value = "";
                document.getElementById("port").value = "";
                document.getElementById("usr").value = "";
                document.getElementById("pswd").value = "";
                document.getElementById("db").value = "";
            }

            function modifyDatabaseProperties(event) {
                ipServer = document.getElementById("ipServer").value;
                port = document.getElementById("port").value;
                usr = document.getElementById("usr").value;
                pswd = document.getElementById("pswd").value;
                db = document.getElementById("db").value;
                event.preventDefault();

                $.ajax(
                        {
                            type: "post",
                            url: "files/fileConnexion.jsp",
                            data: {
                                ipServer: ipServer,
                                port: port,
                                usr: usr,
                                pswd: pswd,
                                db: db
                            },
                            context: document.body
                        }
                ).done(
                        function (data) {
                            if (verificationSucces(data)) {
                                cleanDatabase();
                            }
                        }
                );
            }

            function login(event) {
                if (validDataClick(event) === true) {
                    event.preventDefault();
                } else {
                    ipServer = document.getElementById("ipServer").value;
                    port = document.getElementById("port").value;
                    usr = document.getElementById("usr").value;
                    pswd = document.getElementById("pswd").value;
                    db = document.getElementById("db").value;
                    event.preventDefault();
                    $.ajax(
                            {
                                type: "post",
                                url: "stabConnection.jsp",
                                data: {
                                    ipServer: ipServer,
                                    port: port,
                                    usr: usr,
                                    pswd: pswd,
                                    db: db
                                },
                                context: document.body

                            }
                    ).done(
                            function (data) {
                                if (alertByResult(data)) {
                                    modifyDatabaseProperties(event);
                                }
                            }
                    );
                }
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

    <body>
        <img src="images/logoKeosys.jpg" alt=""/>
        <div class="container-fluid " >
            <div class="row">
                <div class="col-md-12 vcenter">
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
                                <%
                                    if (session.getAttribute("connected") == Boolean.TRUE) {
                                %>

                                <li>
                                    <a href="Deconnexion.jsp"><span class="glyphicon glyphicon-log-out"> LogOut</span></a>
                                </li>
                                <%}%>
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
                                    <legend>Connexion</legend>
                                    <!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="ipServer">Ip Serveur</label>  
                                        <div class="col-md-4">
                                            <input id="ipServer" name="ipServer" placeholder="Ip Serveur" class="form-control input-md" required="" type="text" onchange="validData(event)">
                                            <span class="help-block">Ex: 192.168.1.1</span>  
                                        </div>
                                    </div>
                                    <!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="port">Port</label>  
                                        <div class="col-md-4">
                                            <input id="port" name="port" placeholder="Port" class="form-control input-md" required="" type="number" onchange="validData(event)">
                                            <span class="help-block">EX: 3306</span>  
                                        </div>
                                    </div>
                                    <!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="usr">Utilisateur</label>  
                                        <div class="col-md-4">
                                            <input id="usr" name="usr" placeholder="Utilisateur" class="form-control input-md" required="" type="text" onchange="validData(event)">
                                            <span class="help-block">Ex: root</span>  
                                        </div>
                                    </div>

                                    <!-- Password input-->
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="pswd">Mot de passe</label>
                                        <div class="col-md-4">
                                            <input id="pswd" name="pswd" placeholder="Mot de passe " class="form-control input-md" type="password" onchange="validData(event)">

                                        </div>
                                    </div>

                                    <!-- Select Basic -->
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="db">Base de Données</label>
                                        <div class="col-md-4">
                                            <select id="db" name="db" class="form-control">
                                                <option value="-1">-------</option>
                                            </select>
                                        </div>
                                    </div>
                                    <!-- Button (Double) -->
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="btnTestConnection"></label>
                                        <div class="col-md-4">
                                            <button id="btnConnect" name="btnConnect" class="btn btn-success" onclick="login(event)" >Connexion</button>
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
        <script src="js/notiny.js"></script>
        <link href="css/notiny.css" rel="stylesheet" />
    </body>
</html>
