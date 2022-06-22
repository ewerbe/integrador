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
<form id="cadastroColaborador" action="/colaborador/salvar-colaborador.action" method="post">
    <div align="center" style="margin-top: 3%;">
        <c:choose>
            <c:when test="${colaborador != null}">
                <h1 style="color: grey; font-weight: bold;
            font-size: 460%;">editar colaborador(a)</h1>
                <input type="hidden" id="idColaborador" name="idColaborador" value="${colaborador.getId()}"
            </c:when>
            <c:otherwise>
                <h1 style="color: grey; font-weight: bold;
            font-size: 460%;">novo(a) colaborador(a)</h1>
            </c:otherwise>
        </c:choose>
    </div>
    <div id="formContainer" style="width: 500px; margin: auto;">
        <div class="mb-3" align="left">
            <label for="nomeColaborador" class="form-label" style="color: #262630;
                   font-weight: bold;">nome</label>
            <input type="text" class="form-control bg-dark" id="nomeColaborador" name="nomeColaborador"
                   value="${colaborador.getNome()}"
                   placeholder="nome do(a) colaborador(a)" style="color: antiquewhite; align-content: space-around;"
                    required>
        </div>
        <div class="mb-3">
            <label for="emailColaborador" class="form-label" style="color: #262630;
                   font-weight: bold;">e-mail</label>
            <input type="email" class="form-control bg-dark" id="emailColaborador" name="emailColaborador"
                   value="${colaborador.getEmail()}"
                   placeholder="e-mail do(a) colaborador(a)" style="color: antiquewhite;"
                   required>
        </div>
        <div class="mb-3">
            <label for="senhaColaborador" class="form-label" style="color: #262630;
                    font-weight: bold;">senha</label>
            <input type="password" class="form-control bg-dark" id="senhaColaborador" name="senhaColaborador"
                   value="${colaborador.getSenha()}"
                   placeholder="senha do(a) colaborador(a)" style="color: antiquewhite;"
                   required>
        </div>
        <div>
            <button type="button" class="btn btn-outline-dark" data-bs-toggle="modal" data-bs-target="#modalConfirmacao">
                salvar
            </button>
        </div>
    </div>
    <!-- Modal de confirmação de cadastro-->
    <div class="modal fade" id="modalConfirmacao" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
         aria-labelledby="modalConfirmacaoLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header bg-dark" style="color: hotpink;" >
                    <h5 class="modal-title"id="modalConfirmacaoLabel">confirme as alterações</h5>
                    <button type="button" class="btn-close btn-outline-dark" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body bg-dark" style="color: antiquewhite;">
                    deseja salvar estas alterações?
                </div>
                <div class="modal-footer bg-dark">
                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">cancelar</button>
                    <input type="submit" class="btn btn-outline-light" data-bs-dismiss="modal">
                    salvar
                    </input>
                </div>
            </div>
        </div>
    </div>
</form>
</body>

<%@ include file="footer.jspf" %>