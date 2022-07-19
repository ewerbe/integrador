<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
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
<form id="cadastroArtista">
    <div align="center" style="margin-top: 3%;">
        <c:choose>
            <c:when test="${artista != null}">
                <h1 style="color: grey; font-weight: bold;
            font-size: 460%;">editar artista</h1>
                <input type="hidden" id="idArtista" name="idArtista" value="${artista.getId()}"
            </c:when>
            <c:otherwise>
                <h1 style="color: grey; font-weight: bold;
            font-size: 460%;">novo(a) artista(a)</h1>
            </c:otherwise>
        </c:choose>
    </div>
    <div id="formContainer" style="width: 500px; margin: auto;">
        <div class="mb-3" align="left">
            <label for="nomeArtista" class="form-label" style="color: #262630;
                   font-weight: bold;">nome</label>
            <input type="text" class="form-control bg-dark" id="nomeArtista" name="nomeArtista"
                   value="${artista.getNome()}"
                   placeholder="nome do(a) artista(a)" style="color: antiquewhite; align-content: space-around;"
                   required>
        </div>

        <div class="mb-3" align="left">
            <label for="paisOrigemArtista" class="form-label" style="color: #262630;
                   font-weight: bold;">país de origem</label>
            <select class="form-control bg-dark" id="paisOrigemArtista" name="paisOrigemArtista"
                   value="${artista.getPaisOrigem()}"
                    required style="color: cornsilk;">
              <c:forEach var="pais" items="${paises}">
                  <c:choose>
                      <c:when test="${artista.getPaisOrigem() != null || artista.getPaisOrigem() == pais}">
                          <option value="${artista.getPaisOrigem()}" selected>${pais}</option>
                      </c:when>
                      <c:otherwise>
                          <option value="${pais}">${pais}</option>
                      </c:otherwise>
                  </c:choose>
              </c:forEach>



            </select>
        </div>

        <div class="mb-3" align="left">
            <label for="anoNascimentoArtista" class="form-label" style="color: #262630;
                    font-weight: bold;">ano de nascimento</label>
            <input type="number" min="1820" max="2022" class="form-control bg-dark" id="anoNascimentoArtista" name="anoNascimentoArtista"
                   value="${artista.getAnoNascimento()}"
                   placeholder="ano de nascimento do(a) artista" style="color: antiquewhite;"
                   required>
        </div>

        <div class="mb-3" align="left">
            <label for="anoMorteArtista" class="form-label" style="color: #262630;
                    font-weight: bold;">ano de morte</label>
            <input type="number" min="1820" max="2022" class="form-control bg-dark" id="anoMorteArtista" name="anoMorteArtista"
                   value="${artista.getAnoMorte()}"
                   placeholder="ano de morte do(a) artista" style="color: antiquewhite;">
        </div>

        <div align="left">
            <button type="button" class="btn btn-outline-dark btn-lg" data-bs-toggle="modal" data-bs-target="#modalConfirmacaoArtista">
                salvar
            </button>
            <c:if test="${artista != null}">
                <button type="button" class="btn btn-outline-danger btn-lg" data-bs-toggle="modal" data-bs-target="#modalConfirmacaoArtista">
                    excluir
                </button>
                <input type="submit" class="btn btn-dark" data-bs-dismiss="modal"
                       formaction="/artistas.action" value="cancelar" formmethod="get" style="margin-left: 30%;"/>
            </c:if>
        </div>

        <!-- Modal de confirmação de cadastro-->
        <div class="modal fade" id="modalConfirmacaoArtista" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
             aria-labelledby="modalConfirmacaoArtistaLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header bg-dark" style="color: hotpink;" >
                        <h5 class="modal-title"id="modalConfirmacaoArtistaLabel">confirme as alterações</h5>
                        <button type="button" class="btn-close btn-outline-dark" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body bg-dark" style="color: antiquewhite;" align="left">
                        deseja salvar estas alterações?
                    </div>
                    <div class="modal-footer bg-dark">
                        <input type="submit" class="btn btn-outline-light" data-bs-dismiss="modal"
                               formaction="/artista/salvar-artista.action" formmethod="post" value="salvar"/>
                        <c:if test="${artista != null}">
                            <input type="submit" class="btn btn-outline-danger" data-bs-dismiss="modal"
                                   formaction="/artista/excluir-artista.action" value="excluir" formmethod="post">
                        </c:if>
                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">cancelar</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
</form>
</body>
<%@ include file="footer.jspf" %>