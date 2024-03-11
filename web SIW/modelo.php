<?php
    //modelo
    function connect() {
        $dblink = mysqli_connect("dbserver", "grupo12", "Die9nei0Wi", "db_grupo12");

        if($dblink === false){
            die("Error de conexión con la base de datos. ". mysqli_connect_error());
        }

        return $dblink;

    }

    function m_validarLogin(){
        
        if(isset($_SESSION["usuario"])){
            if($_SESSION["usuario"]=="admin"){
                header("location:index.php?accion=admin&id=1");
            }else{
                
                header("location:index.php?accion=logeado&id=6");
            }
            
            return;
        }

        session_start();
        $con = connect();
        $user = $_POST["user"];
        $pswd = $_POST["pswd"];

        if($user=="admin"){
            $consulta = "select * from final_admins where password = '$pswd'";
        }
        else{
            $consulta = "select * from final_usuarios where user = '$user'";
        }
        
        $resultado = $con -> query($consulta);


        if($resultado){
            if ($datos = $resultado->fetch_assoc()) {
                if ($pswd == $datos["password"]){
					$_SESSION["usuario"] = $user;
					$_SESSION["password"] = $pswd;//necesitamos la contraseña para el cambio de contraseña
                    if($_SESSION["usuario"]=="admin"){
                        return 0;
                    }
                    else{
                        return 1;
                    }					
				}else{
                    return -1; //contraseña incorrecta
                }
                
			}else{
                return -2; //el usuario no existe
            }
        }else{
            return -3; //error en la BDD
        }
    }

    function m_validarRegistro(){
        $con = connect();        
        $user = $_POST["user"];
        $pswd = $_POST["pswd"];
        $nombre = $_POST["nombre"];
        $ap1 = $_POST["apellido1"];
        $ap2 = $_POST["apellido2"];
        $provincia = $_POST["provincia"];
        $ciudad = $_POST["ciudad"];
        $cdp = $_POST["cdp"];
        $email = $_POST["correo"];

        $consulta = "select * from final_usuarios where user = '$user'";
        $resultado = $con->query($consulta);
        if ($resultado->num_rows>0) {
            //el usuario ya existe
            echo '<script>alert("Error en el registro, usuario existente");</script>';
            return -1;
        }
        //generar el id
        $consulta = "insert into final_usuarios (user,password,nombre,apellido1,apellido2,provincia,ciudad,codPostal,email) values ('$user','$pswd','$nombre', '$ap1', '$ap2', '$provincia','$ciudad','$cdp','$email')";
        if ($con->query($consulta)) {
            //todo correcto
            echo '<script>alert("Usuario registrado correctamente");</script>';
            return 1;
        }else{
            echo '<script>alert("Error en el registro");</script>';//esto hay que cambiarlo con css
            die(mysqli_error($con));
            return -1;
        }       
    }

    function m_cerrarSesion(){
        session_destroy();
    }

    function m_validarAltaGafa(){
        $con = connect();        
        $modelo = $_POST["modelo"];
        $marca = $_POST["marca"];
        $tipo = $_POST["tipo"];
        $precio = $_POST["precio"];
        $edad = $_POST["edad"];

        $consulta = "select * from final_catalogo where modelo = '$modelo'";
        $resultado = $con->query($consulta);
        if($resultado->fetch_assoc()){//ya existe el modelo
            return -1;
        }
        
        //crear nombre de la foto
        $idFoto = time() ."-".uniqid();
        //tipo
        if($_FILES["foto"]["type"]=="image/jpeg"){
            $nombreFoto = $idFoto.".jpg";
        }
        elseif($_FILES["foto"]["type"]=="image/jpg"){
            $nombreFoto = $idFoto.".jpg";
        }
        elseif($_FILES["foto"]["type"]=="image/png"){
            $nombreFoto = $idFoto.".png";
        }
        elseif($_FILES["foto"]["type"]=="image/svg"){
            $nombreFoto = $idFoto.".svg";
        }
        else{
            //fallo
            return -3;
        }

        $consulta = "insert into final_catalogo (modelo,marca,tipo,precio,foto,edad) values ('$modelo','$marca','$tipo','$precio','$nombreFoto','$edad')";
        if ($con->query($consulta)) {
            move_uploaded_file($_FILES["foto"]["tmp_name"],"Imagenes/".$nombreFoto);
            return 1;
        }else{
            //error en la BDD
echo mysqli_error($con);
die();
            echo '<script>alert("Error en el alta");</script>';
            return -2;
        }
    }

    function m_validarModGafa(){
        $con = connect();        
        $modelo = $_POST["modelo"];
        $marca = $_POST["marca"];
        $tipo = $_POST["tipo"];
        $precio = $_POST["precio"];
        $edad = $_POST["edad"];

        $consulta = "select * from final_catalogo where modelo = '$modelo'";
        $resultado = $con->query($consulta);
        if($resultado->fetch_assoc()){//ya existe el modelo
            return -1;
        }
        
        //crear nombre de la foto
        $idFoto = time() ."-".uniqid();
        //tipo
        if($_FILES["foto"]["type"]=="image/jpeg"){
            $nombreFoto = $idFoto."jpg";
        }
        elseif($_FILES["foto"]["type"]=="image/jpg"){
            $nombreFoto = $idFoto."jpg";
        }
        elseif($_FILES["foto"]["type"]=="image/png"){
            $nombreFoto = $idFoto."png";
        }
        elseif($_FILES["foto"]["type"]=="image/svg"){
            $nombreFoto = $idFoto."svg";
        }
        else{
            //fallo
            return -3;
        }

        $consulta = "update final_catalogo set modelo = '$modelo',marca ='$marca',tipo='$tipo',precio='$precio',foto='$nombreFoto',edad='$edad' WHERE  modelo = '$modelo'";
        if ($con->query($consulta)) {
            return 1;
        }else{
            //error en la BDD
            echo '<script>alert("Error en la modificación");</script>';
            return -2;
        }
    }

    function m_validarBajaGafa(){
        $con = connect();        
        $modelo = $_POST["modelo"];
        //delete
        $consulta = "delete from final_catalogo where modelo = '$modelo'";
        if ($con->query($consulta)) {
            return 1;
        }else{
            //error en la BDD
            echo '<script>alert("Error en la baja");</script>';
            return -2;
        }
    }
?>