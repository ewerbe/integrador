<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="navbar.jspf" %>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body style="background-color: darkgrey;">
        <div align="center" style="margin-top: 3%;">
            <h1 style="color: grey; font-weight: bold;
                font-size: 460%;">artistas</h1>
        </div>
        <div align = "center" style="margin: auto; width: 80%;">
            <%@ include file="pesquisa.jspf" %>
        </div>
        <div id="tableColaboradoresContainer" align="center;" style="margin: auto; width: 80%;">
            <table class="table table-dark table-hover">
                <tbody>
                <c:forEach var="artista" items="${artistas}">
                    <tr style="margin-top: 10%;">
                        <th scope="row" style="font-weight: bolder;">${artista.getNome()}</th>

                        <td align="center">
                           <a style="font-weight: bolder; color: hotpink; font-style: normal"
                              href="/obras/obras-artista.action?id=${artista.getId()}">
                               VER OBRAS
                           </a>
                        </td>

                        <td align="center">
                            <form method="post">
                                <input type="submit" class="btn btn-outline-light"
                                       formaction="/artista/editar-artista.action?id=${artista.getId()}" value="editar"/>
                                <button type="button" class="btn btn-outline-danger" data-bs-toggle="modal"
                                        data-bs-target="#modalConfirmacaoExclusaoArtista">
                                    excluir
                                </button>
                            </form>
                        </td>
                    </tr>
<%--modal de confirmacao da exclusao--%>
                    <div class="modal fade" id="modalConfirmacaoExclusaoArtista" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
                         aria-labelledby="modalConfirmacaoExclusaoArtistaLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header bg-dark" style="color: hotpink;" >
                                    <h5 class="modal-title"id="modalConfirmacaoExclusaoArtistaLabel">confirme as alterações</h5>
                                    <button type="button" class="btn-close btn-outline-dark" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body bg-dark" style="color: antiquewhite;">
                                    deseja excluir este cadastro?
                                </div>
                                <div class="modal-footer bg-dark">
                                    <form method="post">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">cancelar</button>
                                        <input type="submit" class="btn btn-outline-danger"
                                               formaction="/artista/excluir-artista.action?id=${artista.getId()}"
                                               value="excluir"/>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                </c:forEach>
                </tbody>
            </table>
        </div>

        <div>
            <form action="/cadastro-artista.action" method="get">
                <button type="submit" class="btn-lg btn-dark"
                        style="font-weight: bolder; color: hotpink; margin-left: 71%;">
                    <span style="white-space: nowrap;">novo(a) <i class="bi bi-plus-circle"></i></span>
                </button>
            </form>

        </div>
</body>
<%@ include file="footer.jspf" %>