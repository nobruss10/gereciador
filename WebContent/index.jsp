<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<h1>Bem vindo ao nosso gerenciador de empresas!</h1>
	<br />
	
	<c:if test="${ not empty usuarioLogado }">
		<h3>Logado como: ${usuarioLogado.email}</h3>
	</c:if>
	
	<form action="executa" method="post">
		nome:<input type="text" name="nome">
		<input type="hidden" name="tarefa" value="NovaEmpresa">
		<input type="submit" value="Enviar"></input>
	</form>
	
	<form action="executa" method="POST">
		email :<input type="email" name="email">
		senha :<input type="password" name="senha">
		<input type="hidden" name="tarefa" value="Login">
		<input type="submit" value="Enviar"></input>
	</form>
	<form action="executa" method="POST">
		<input type="hidden" name="tarefa" value="Logout">
		<button type="submit">Deslogar</button>
	</form>
</body>
</html>