<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
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

            function validData() {
                beneratorPath = document.getElementById("beneratorPath").value;
                imagysRep = document.getElementById("imagysRep").value;
                event.preventDefault();
                if (beneratorPath === "" || imagysRep === "") {
                    alert("ERREUR : Il faut saisir les deux chemins");
                } else {
                    validBeneratorPath();
                }
            }
            function validBeneratorPath() {
                beneratorPath = document.getElementById("beneratorPath").value;
                if (beneratorPath.substr(-13) !== "benerator.bat") {
                    alert("ERREUR : Le chemin vers 'benerator.bat' n'est pas correct (Syntaxe)");
                } else {
                    alerte("SUCCES : La syntaxe vers benerator.bat est correcte)");
                    verifyBeneratorExist();
                }
            }


            function verifyBeneratorExist() {
                beneratorPath = document.getElementById("beneratorPath").value;
                event.preventDefault();

                $.ajax(
                        {
                            type: "post",
                            url: "consults/consultBeneratorExist.jsp",
                            data: {
                                beneratorPath: beneratorPath
                            },
                            context: document.body
                        }
                ).done(
                        function (data) {
                            if (alertByResult(data) === true) {
                                verifyImagysRep();
                            }
                        }
                );
            }

            function verifyImagysRep() {
                imagysRep = document.getElementById("imagysRep").value;
                if (imagysRep.substr(-1) !== "/") {
                    imagysRep = imagysRep + "/";
                }
                event.preventDefault();
                $.ajax(
                        {
                            type: "post",
                            url: "consults/consultImagysRep.jsp",
                            data: {
                                imagysRep: imagysRep
                            },
                            context: document.body
                        }
                ).done(
                        function (data) {
                            if (alertByResult(data) === true) {
                                verifyAllFiles();
                            }

                        }
                );
            }

            function verifyAllFiles() {
                imagysRep = document.getElementById("imagysRep").value;
                if (imagysRep.substr(-1) !== "/") {
                    imagysRep = imagysRep + "/";
                }
                event.preventDefault();
                $.ajax(
                        {
                            type: "post",
                            url: "consults/consultAllFiles.jsp",
                            data: {
                                imagysRep: imagysRep
                            },
                            context: document.body
                        }
                ).done(
                        function (data) {
                            if (alertByResult(data) === true) {
                                modifyFileConfigProperties();
                            }
                        }
                );
            }

            function modifyFileConfigProperties() {
                beneratorPath = document.getElementById("beneratorPath").value;
                imagysRep = document.getElementById("imagysRep").value;

                if (imagysRep.substr(-1) !== "/") {
                    imagysRep = imagysRep + "/";
                }
                event.preventDefault();
                $.ajax(
                        {
                            type: "post",
                            url: "files/modifyFileConfig.jsp",
                            data: {
                                imagysRep: imagysRep,
                                beneratorPath: beneratorPath
                            },
                            context: document.body
                        }
                ).done(
                        function (data) {
                            if (alertSucces(data) === true) {
                                cleanConfig();
                            }

                        }
                );
            }
            function cleanConfig() {
                document.getElementById("beneratorPath").value = "";
                document.getElementById("imagysRep").value = "";
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
            
            
            function alertSucces(data) {
                if (data.indexOf("ERREUR") === -1) {
                    alerteSucces(data);
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
                                    <legend>Configuration (Côte Serveur)</legend>
                                    <!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="beneratorPath">Chemin vers Benerator.bat</label>  
                                        <div class="col-md-4">
                                            <input id="beneratorPath" name="beneratorPath" placeholder="Chemin vers Benerator" class="form-control input-md" required="" type="text">
                                            <span class="help-block">Exemple. C:/databene-benerator-0.9.8/bin/benerator.bat</span>  
                                        </div>
                                    </div>
                                    <!-- Text input-->
                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="imagysRep">Chemin vers Fichiers Imagys</label>  
                                        <div class="col-md-4">
                                            <input id="imagysRep" name="imagysRep" placeholder="Chemin vers Fichiers Imagys" class="form-control input-md" required="" type="text" >
                                            <span class="help-block">Exemple. C:/Imagys/</span>  
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-4 control-label" for="btnConfig"></label>
                                        <div class="col-md-4">
                                            <button id="btnConfig" name="btnConfig" class="btn btn-success" onclick="validData()" >Configurer</button>
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
            <div id='note'>
                <footer>
                    <p><h4>Note: Le fichier 'Benerator.bat' doit être localise au serveur</h4></p>
                    <p><h4>Note: Le répertoire d'imagys (Fichiers xml) doit être localise au serveur</h4></p>
                </footer>
            </div>
        </div>
    </body>
    <script src="js/notiny.js"></script>
    <link href="css/notiny.css" rel="stylesheet" />
</html>
