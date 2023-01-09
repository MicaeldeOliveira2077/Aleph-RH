 <%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>

<%
if (session.getAttribute("adm_id") != null) {
	response.sendRedirect("index.jsp");
}
%>
<!doctype html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
	<style>
/*
  Variáveis
*/

:root {
  --main-color: #407bff;
  --link-color: #666666;
  --text1: #999999;
  --highligth-text: #333333;
  --input-text: #555555;
  --white-color: #FFFFFF;
  --point-list: #CCCCCC;
  --line-input: #D9D9D9;
}

  Zerar estilos
*/

* {
	margin: 0px; 
	padding: 0px; 
	box-sizing: border-box;
}

body, html {
	height: 100%;
	
}

ul, li {
	margin: 0px;
	list-style-type: none;
}

input, button {
	outline: none !important;
	border: none;
}

button:hover {
	cursor: pointer;
}

/*
  Utilitários
*/

.text1 {
  
  font-size: 15px;
  color: var(--text1);
  line-height: 1.5;
}

.text2 {
 font-family: Poppins-Regular;
  font-size: 15px;
  color: var(--main-color);
  line-height: 1.5;
}

.margin-bottom-35 {
  margin-bottom: 35px;
}

.margin-top-35 {
  margin-top: 35px;
}

.margin-bottom-8 {
  margin-bottom: 8px;
}

.margin-top-8 {
  margin-top: 8px;
}

.margin-left-50 {
  margin-left: 50px;
}

/*
  Login
*/

.container {
  width: 100%;
  margin: 0 auto;
}

.container-login {
  width: 100%;  
  min-height: 100vh;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  align-items: center;
  padding: 15px;
  background: var(--white-color);  
}

.wrap-login {
  width: 370px;
  margin-right: 50px;
  background: var(--white-color);
}

/*
  Formulário
*/

.login-form {
  width: 100%;
}

.login-form-title {
  display: block;
  
  font-size: 39px;
  color: var(--highligth-text);
  line-height: 1.2;
  text-align: center;
}

/*
  Input
*/

.wrap-input {
  width: 100%;
  position: relative;
  border-bottom: 2px solid var(--line-input);
}

.input-form {
  
  font-size: 18px;
  color: var(--input-text);
  line-height: 1.2;
  display: block;
  width: 100%;
  height: 52px;
  background: transparent;
  padding: 0 5px;
}

.focus-input-form {
  position: absolute;
  display: block;
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  pointer-events: none;
}

.focus-input-form::before {
  content: "";
  display: block;
  position: absolute;
  bottom: -2px;
  left: 0;
  width: 0;
  height: 2px;
  transition: all 0.4s;
  background: var(--main-color);
}

.focus-input-form::after {
 
  font-size: 18px;
  color: var(--text1);
  line-height: 1.2;
  content: attr(data-placeholder);
  display: block;
  width: 100%;
  position: absolute;
  top: 15px;
  left: 0px;
  padding-left: 5px;
  transition: all 0.4s;
}

.input-form:focus + .focus-input-form::after {
  top: -20px;
  font-size: 15px;
}

.input-form:focus + .focus-input-form::before {
  width: 100%;
}

.has-val.input-form + .focus-input-form::after {
  top: -20px;
  font-size: 15px;
}

.has-val.input-form + .focus-input-form::before {
  width: 100%;
}

/*
  Botão
*/

.container-login-form-btn {
  width: 100%;
  display: flex;
  justify-content: center;
}

.login-form-btn {
  
  font-size: 16px;
  color: var(--white-color);
  line-height: 1.2;
  text-transform: uppercase;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 0 20px;
  width: 100%;
  height: 50px;
  background-color: var(--main-color);
  border-radius: 5px;
  transition: all 0.4s;
}

.login-form-btn:hover  {
  background-color: var(--highligth-text);
}

/*
  Links - Login utils
*/

a {
	
	font-size: 14px;
	line-height: 1.7;
	color: var(--link-color);
	margin: 0px;
	transition: all 0.4s;
}

a:focus {
	outline: none !important;
}

a:hover {
	text-decoration: none;
  color: var(--highligth-text);
}

/*
  Login utils
*/

.login-utils {
  margin-top: 20px;
}

.login-utils li {
  position: relative;
  padding-left: 16px;
}

.login-utils li::before {
  content: "";
  display: block;
  position: absolute;
  width: 5px;
  height: 5px;
  border-radius: 50%;
  background-color: var(--point-list);
  top: 45%;
  transform: translateY(-50%);
  left: 0;
}

.feedback-user {
border-radius: 5px;
background-color: #ff3333;
display: flex;
justify-content: center;
align-items: center;
text-align: center;
}

.feedback-user span {
font-size: large;
color: black;
padding: 2px;
display: none;
}

</style>
</head>
<body>
<div class="container">
		<div class="container-login">
			<div class="wrap-login">
				<form class="" action="login-admin" method="post">
					<span class="login-form-title">
						Faça o login
					</span>
					
				    <div class="feedback-user" id="status" value="<%=request.getAttribute("status") %>">
                        <span class="fd-error" id="fd-error">Usuário inválido</span>
                        <span class="fd-empty" id="fd-empty">Preencha todos os campos</span>
                    </div>
                    
					<div class="wrap-input margin-top-35 margin-bottom-35">
						<input class="input-form" type="text" name="cpf" autocomplete="off" id="txtCpf" onkeypress="$(this).mask('000.000.000-00');"
						 for="txtEmail">
						<span class="focus-input-form" data-placeholder="CPF"></span>
					</div>


					<div class="wrap-input margin-bottom-35">
						<input class="input-form" type="password" name="senha" id="txtSenha" for="txtSenha">
						<span class="focus-input-form" data-placeholder="Senha">
						</span>
					</div>

					<div class="container-login-form-btn">
						<button type="submit" class="login-form-btn">
							Login
						</button>
					</div>
				</form>
			</div>
			<img src="img/logo quantun.png" width="300" height="300" class="margin-left-50" />
		</div>
	</div>
	
	<script type="text/javascript">
		let inputs = document.getElementsByClassName('input-form');
		for (let input of inputs) {
			input.addEventListener("blur", function() {
				if(input.value.trim() != ""){
					input.classList.add("has-val");
				} else {
					input.classList.remove("has-val");
				}
			});
		}


        const status = document.getElementById('status').getAttribute('value');
        const fdError = document.getElementById("fd-error");
        const fdEmpty = document.getElementById("fd-empty");
       	const txtCpf = document.getElementById("txtCpf");

        if (status == "error") {
            fdError.style.display = "block";
            setTimeout(() => { fdError.style.display = 'none'; }, 5000);
            txtCpf.value = "${cpf}";
            txtCpf.focus();
        }

        else if (status == "empty") {
        	fdEmpty.style.display = "block";
            setTimeout(() => { fdEmpty.style.display = 'none'; }, 5000);
            txtCpf.value = "${cpf}";
            txtCpf.focus();
        }

    </script>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>

</body>
</html>