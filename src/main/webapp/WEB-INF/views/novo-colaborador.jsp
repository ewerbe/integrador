<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="navbar.jspf" %>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body style="background-color: darkgrey;">
<form>
    <div align="center" style="margin-top: 3%;">
        <h1 style="color: grey; font-weight: bold;
            font-size: 460%;">novo(a) colaborador(a)</h1>
    </div>
    <div id="formContainer" style="width: 500px; margin: auto;">
        <div class="mb-3">
            <label for="nomeColaborador" class="form-label" style="color: #262630;
                   font-weight: bold;">nome</label>
            <input type="text" class="form-control bg-dark" id="nomeColaborador"
                   placeholder="nome do(a) colaborador(a)" style="color: hotpink; align-content: space-around;">
        </div>
        <div class="mb-3">
            <label for="emailColaborador" class="form-label" style="color: #262630;
                   font-weight: bold;">e-mail</label>
            <input type="email" class="form-control bg-dark" id="emailColaborador"
                   placeholder="e-mail do(a) colaborador(a)" style="color: hotpink;">
        </div>
        <div class="mb-3">
            <label for="senhaColaborador" class="form-label" style="color: #262630;
                    font-weight: bold;">senha</label>
            <input type="password" class="form-control bg-dark" id="senhaColaborador"
                   placeholder="senha do(a) colaborador(a)" style="color: hotpink;">
        </div>
        <div>
            <button type="submit" class="btn btn-outline-dark">salvar</button>
        </div>
    </div>
</form>
</body>

<%@ include file="footer.jspf" %>