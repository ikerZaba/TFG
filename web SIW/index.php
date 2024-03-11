<?php
	//Este es el controlador para todas las paginas
	include "vista.php";
	include "modelo.php";
    
    
    //accion indica la seccion de la web a la que hay que acudir
    if (isset($_GET['accion'])) {
		$accion = $_GET['accion'];	
	} else {
		if (isset($_POST["accion"])) {
			$accion = $_POST['accion'];
		} else {
			$accion = "menu";
		}
	}

    //id indica, dentro de la seccion, que funcionalidad se va a realizar
	if (isset($_GET['id'])) {
		$id = $_GET['id'];	
	} else {
		if (isset($_POST["id"])) {
			$id = $_POST['id'];
		} else {
			$id = "1";
		}
	}

    if($accion == "menu"){
        switch($id){
            case "1":
                v_mostrarMenu();
                break;
        }
    }

	if($accion == "cita"){
		switch($id){
			case "1":
				v_mostrarCitaSinLogin();
				break;
			case "2":
				v_mostrarPedirCita();
				break;
		}
	}

	if($accion == "gafas"){
		switch($id){
			case "1":
				v_mostrarCatalogo();
				break;
			case "2":
				v_mostrarCompraGafa();
				break;
		}
	}

	if($accion == "info"){
		switch($id){
			case "1":
				v_mostrarInfo();
				break;
		}
	}

	if($accion == "local"){
		switch($id){
			case "1":
				v_mostrarLocalizacion();
				break;
		}
	}

	if($accion == "login"){
		switch($id){
			case "1":
				v_mostrarLogin(m_validarLogin());
				break;
			case "2":
				v_mostrarVistaLoginORegistro();
		}
	}

	if($accion == "registrar"){
		switch($id){
			case "1":
				v_mostrarRegistro();
				break;
			
			case "2":
				v_validarRegistro(m_validarRegistro());
				break;
		}
	}

	if($accion == "terminosYCondiciones"){
		switch($id){
			case "1":
				v_mostrarTerminosYCondiciones();
				break;
		}
	}

	if($accion == "logeado"){
		switch($id){
			case "1":
				v_mostrarPedirCita();
				break;			
			case "2":
				v_mostrarCatalogo();
				break;
			case "3":
				v_mostrarPerfil();
				break;
			case "4":
				v_mostrarFacturas();
				break;
			case "5":
				m_cerrarSesion();
				v_mostrarMenu();
				break;
			case "6":
				v_mostrarVistaLogeado();
				break;
		}
	}

	if($accion == "admin"){
		switch($id){
			case "1":
				v_mostrarAdmin();
				break;
			case "2":
				v_mostrarPerfil();
				break;
			case "3":
				v_mostrarGestionUsuarios();
				break;
			case "4":
				v_mostrarGestionCatalogo();
				break;
		}
	}

	if($accion == "perfil"){
		switch($id){
			case "1":
				//modificar perfil: update(nombre,apellidos,provincia...)
				break;
			case "2":
				//cambiar contraseña
				break;
			case "3":
				//borrar cuenta
				break;
		}
	}

	if($accion == "facturas"){
		switch($id){
			case "1":
				//generar pdf
				break;
		}
	}

	if($accion == "gestionCatalogo"){
		switch($id){
			case "1":
				//añadir gafa
				v_mostrarAltaGafa();
				break;
			case "2":
				v_validarAltaGafa(m_validarAltaGafa());
				break;
			case "3":
				v_mostrarModGafa();
				break;
			case "4":
				v_validarModGafa(m_validarModGafa());
				break;
			case "5":
				v_mostrarBajaGafa();
				break;
			case "6":
				v_validarBajaGafa(m_validarBajaGafa());
		}
	}

	if($accion == "gestionUsuarios"){
		switch($id){
			case "1":
				//banear usuario
				break;
			case "2":
				//modificar usuario
				break;
			case "3":
				//borrar usuario
				break;
		}
	}


?>