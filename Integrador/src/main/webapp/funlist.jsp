 <%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@page import = "Model.Funcionario" %>
<%@page import = "java.util.ArrayList" %>    


<% 
if(session.getAttribute("adm_id") == null) {
	response.sendRedirect("login-admin");
} 

ArrayList<Funcionario> lista = (ArrayList<Funcionario>) request.getAttribute("funs");
%>   

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<!-- aqui está as chamadas do boots... para o javascript-->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
<style>
 @import url("https://fonts.googleapis.com/css2?family=Nunito:wght@400;600;700&display=swap");:root{--header-height: 3rem;--nav-width: 68px;--first-color: #212529;--first-color-light: #AFA5D9;--white-color: #F7F6FB;--body-font: 'Nunito', sans-serif;--normal-font-size: 1rem;--z-fixed: 100}*,::before,::after{box-sizing: border-box}body{position: relative;margin: var(--header-height) 0 0 0;padding: 0 1rem;font-family: var(--body-font);font-size: var(--normal-font-size);transition: .5s}a{text-decoration: none}.header{width: 100%;height: var(--header-height);position: fixed;top: 0;left: 0;display: flex;align-items: center;justify-content: space-between;padding: 0 1rem;background-color: var(--white-color);z-index: var(--z-fixed);transition: .5s}.header_toggle{color: var(--first-color);font-size: 1.5rem;cursor: pointer}.header_img{width: 35px;height: 35px;display: flex;justify-content: center;border-radius: 50%;overflow: hidden}.header_img img{width: 40px}.l-navbar{position: fixed;top: 0;left: -30%;width: var(--nav-width);height: 100vh;background-color: var(--first-color);padding: .5rem 1rem 0 0;transition: .5s;z-index: var(--z-fixed)}.nav{height: 100%;display: flex;flex-direction: column;justify-content: space-between;overflow: hidden}.nav_logo, .nav_link{display: grid;grid-template-columns: max-content max-content;align-items: center;column-gap: 1rem;padding: .5rem 0 .5rem 1.5rem}.nav_logo{margin-bottom: 2rem}.nav_logo-icon{font-size: 1.25rem;color: var(--white-color)}.nav_logo-name{color: var(--white-color);font-weight: 700}.nav_link{position: relative;color: var(--first-color-light);margin-bottom: 1.5rem;transition: .3s}.nav_link:hover{color: var(--white-color)}.nav_icon{font-size: 1.25rem}.show{left: 0}.body-pd{padding-left: calc(var(--nav-width) + 1rem)}.active{color: var(--white-color)}.active::before{content: '';position: absolute;left: 0;width: 2px;height: 32px;background-color: var(--white-color)}.height-100{height:100vh}@media screen and (min-width: 768px){body{margin: calc(var(--header-height) + 1rem) 0 0 0;padding-left: calc(var(--nav-width) + 2rem)}.header{height: calc(var(--header-height) + 1rem);padding: 0 2rem 0 calc(var(--nav-width) + 2rem)}.header_img{width: 40px;height: 40px}.header_img img{width: 45px}.l-navbar{left: 0;padding: 1rem 1rem 0 0}.show{width: calc(var(--nav-width) + 156px)}.body-pd{padding-left: calc(var(--nav-width) + 188px)}}

body {
margin-top: 10%;
width: 100vw;
height: 100vh;
}
.container {
width: 100%;
height: 80%;

display: flex;
flex-direction: row;
justify-content: center;
align-items: center;
color:#212529;
margin: auto;
display: block;

}
.cadastro{


padding: 0px 0px 25px 11px;

}

</style>

<title>Funcionários</title>
</head>


<body>


    <header class="header" id="header">
    
        <div class="header_img"><a href="index.jsp"> <img src="img/logo quantun.png" width="45" height="38"/> </a> </div>
        <div>  <a href="logout"><i class='bx bx-log-out nav_icon'></i> </a></div>
    </header>
    <div class="l-navbar" id="nav-bar">
        <nav class="nav">
           
            
                <div class="nav_list"> <a href="index.jsp" class="nav_link active"> <i class='bx bx-grid-alt nav_icon'></i> <span class="nav_name">Início</span> </a> 
                
                
           <div class="nav_list"> 
 
                <a href="listagem" class="nav_link"> <i class='bx bx-message-square-detail nav_icon'></i> <span class="nav_name">Agenda</span> </a> 
                <a href="buscafun" class="nav_link"> <i class='bx bx-bookmark nav_icon'></i> <span class="nav_name">Funcionários</span> </a> 
            </div> 
        </nav>
    </div>
    
    
    <h3 class="cadastro" >  Cadastro de novos funcionários:<a href="Funcadast.jsp"><button type="button"class="btn btn-primary"> Cadastrar</button></a> </h3>
    
  <div class="container">
   <div class="height-100 bg-light">
        <h4>Funcionarios</h4>

<table class="table table-light" style="border 1px solid">

    <tr>     
      <th scope="col">Código</th>
      <th scope="col">Nome</th>
      <th scope="col">CPF</th>
      <th scope="col">Data de Nascimento</th>
      <th scope="col">Telefone</th>
      <th scope="col">Endereço</th>
      <th scope="col">Entrada na Empresa</th>
      <th scope="col"></th>
      <th scope="col"></th>
    </tr>

<% for(int i=0;i<lista.size();i++){
  %>
    <tr>
      <td><%=lista.get(i).getFun_id()%></td>
      <td><%=lista.get(i).getNome()%></td>
      <td><%=lista.get(i).getCpf()%></td>
      <td><%=lista.get(i).getData_nasc()%></td>
      <td><%=lista.get(i).getTelefone()%></td>
      <td><%=lista.get(i).getEndereco()%></td>
      <td><%=lista.get(i).getEntrada()%></td>
      
       <td><a href="selecionado?fun_id=<%=lista.get(i).getFun_id()%>"><button type="button"class="btn btn-primary">Editar</button></a> </td>
       <td><a href="excluir?fun_id=<%=lista.get(i).getFun_id()%>"><button type="button" class="btn btn-danger">Excluir</button></a> </td>
    </tr>
    
    <%} %>
    
</table>

</div>
   </div>
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>