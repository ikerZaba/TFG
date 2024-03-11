<?php
    function v_mostrarMenu () {
		if(isset($_SESSION["usuario"])){
			session_destroy();
		}
		echo file_get_contents("Vistas/menu.html");
	}

	function v_mostrarCitaSinLogin(){
		echo file_get_contents("./Vistas/citaSinLogin.html"); //Formualrio para pedir cita
	}

	function v_mostrarCatalogo(){
		echo file_get_contents("./Vistas/catalogo.html"); //catalogo con gafas de sol,gafas graduadas, lentillas, marcas etc.
	}

	function v_mostrarInfo(){
		echo file_get_contents("./Vistas/informacion.html"); //Informacion sobre la histria de la compañia e informacion de contacto
	}

	function v_mostrarLocalizacion(){
		echo file_get_contents("./Vistas/localizacion.html"); //Mapa con la localizacion de nuestra tienda e informacion de contacto
	}

	function v_mostrarLogin ($resultado) {
		if($resultado == 0){
			//admin
			v_mostrarAdmin();
		}
		elseif($resultado==1){
			//mostrar vista de usuario logeado
			v_mostrarVistaLogeado();
		}
		else{
			//gestionar el fallo
			if($resultado == -1){
				//contraseña incorrecta
				echo("contraseña incorrecta");
			}elseif($resultado == -2){
				//el usuario no existe
				echo("El usuario no existe");
			}else{
				//fallo en la BDD
				echo("La Base de Datos ha fallado, inténtelo de nuevo");
			}
			v_mostrarVistaLoginORegistro();
		}
	}

	function v_mostrarRegistro(){
		echo file_get_contents("./Vistas/registro.html");//formulario para el registro
	}

	function v_validarRegistro($resultado){
		if($resultado == 1){
			//alertar al usuario de que ha sido registrado
			v_mostrarMenu();
		}else{
			//informar al usuario del error
			v_mostrarRegistro();
		}
	}

	function v_mostrarVistaLogeado(){
		echo file_get_contents("./Vistas/logeado.html");
	}

	function v_mostrarPedirCita(){
		echo file_get_contents("./Vistas/pedirCita.html");
	}

	function v_mostrarVistaLoginORegistro(){
		echo file_get_contents("./Vistas/loginOregistro.html");//Por si el login falla o se quiere iniciar sesion desde la cita o el catalogo
	}

	function v_mostrarTerminosYCondiciones(){
		echo file_get_contents("./Vistas/terminosYCondiciones.html");
	}

	function v_mostrarPerfil(){ //el perfil del admin es el mismo
		echo file_get_contents("./Vistas/perfil.html");
	}

	function v_mostrarFacturas(){
		echo file_get_contents("./Vistas/facturas.html");
	}

	function v_mostrarAdmin(){
		echo file_get_contents("./Vistas/admin.html");
	}

	function v_mostrarGestionUsuarios(){
		echo file_get_contents("./Vistas/gestionUsers.html");
	}

	function v_mostrarGestionCatalogo(){
		echo file_get_contents("./Vistas/gestionCatalogo.html");
	}

	function v_mostrarCompraGafa(){
		echo file_get_contents("./Vistas/compraGafa.html");
	}

	function v_mostrarAltaGafa(){
		echo file_get_contents("./Vistas/altaGafa.html");
	}

	function v_mostrarModGafa(){
		echo file_get_contents("./Vistas/modificarGafa.html");
	}

	function v_mostrarBajaGafa(){
		echo file_get_contents("./Vistas/bajaGafa.html");
	}

	function v_validarAltaGafa($resultado){
		if($resultado==1){
			echo file_get_contents("./Vistas/gestionCatalogo.html");
		}
		else{
			//gestion de errores
		}
	}

	function v_validarModGafa($resultado){
		if($resultado==1){
			echo file_get_contents("./Vistas/gestionCatalogo.html");
		}
		else{
			//gestion de errores
			echo "error";
		}
	}

	function v_validarBajaGafa($resultado){
		if($resultado==1){
			echo file_get_contents("./Vistas/gestionCatalogo.html");
		}
		else{
			//gestion de errores
		}
	}
?>