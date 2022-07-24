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
                font-size: 460%;">obras</h1>
</div>
<div align = "center" style="margin: auto; width: 80%;">
    <%@ include file="pesquisa.jspf" %>
</div>
<div id="obrasContainer" align="center;" style="margin: auto; width: 80%;">

    <div>
        <c:forEach var="obra" items="${obras}">
            <c:if test="${obra.getImagemString() != null}">
                <div>
                    <img src="data:image/png;base64,${obra.getImagemString()}"
                     alt="" style="alignment: center;">
                </div>
            </c:if>
                <div align="center">
                    <div>

                    </div>
                    <a style="font-weight: bolder; color: hotpink; font-style: normal"
                       href="/obras/obras-artista.action?id=${obra.getId()}">
                        VER OBRAS
                    </a>
                </div>

                <div align="center">
                    <form method="post">
                        <input type="submit" class="btn btn-outline-light"
                               formaction="/obra/editar-obra.action?id=${obra.getId()}" value="editar"/>
                    </form>
                </div>
        </c:forEach>
    </div>
            <%--modal de confirmacao da exclusao--%>
<%--            <div class="modal fade" id="modalConfirmacaoExclusaoArtista" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"--%>
<%--                 aria-labelledby="modalConfirmacaoExclusaoArtistaLabel" aria-hidden="true">--%>
<%--                <div class="modal-dialog">--%>
<%--                    <div class="modal-content">--%>
<%--                        <div class="modal-header bg-dark" style="color: hotpink;" >--%>
<%--                            <h5 class="modal-title"id="modalConfirmacaoExclusaoArtistaLabel">confirme as alterações</h5>--%>
<%--                            <button type="button" class="btn-close btn-outline-dark" data-bs-dismiss="modal" aria-label="Close"></button>--%>
<%--                        </div>--%>
<%--                        <div class="modal-body bg-dark" style="color: antiquewhite;">--%>
<%--                            deseja excluir este cadastro?--%>
<%--                        </div>--%>
<%--                        <div class="modal-footer bg-dark">--%>
<%--                            <form method="post">--%>
<%--                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">cancelar</button>--%>
<%--                                <input type="submit" class="btn btn-outline-danger"--%>
<%--                                       formaction="/obra/excluir-obra.action?id=${obra.getId()}"--%>
<%--                                       value="excluir"/>--%>
<%--                            </form>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>



    <div>
<%--        <c:if test="${colaborador != null}">--%>
            <form action="/cadastro-obra.action" method="get">
                <button type="submit" class="btn-lg btn-dark"
                        style="font-weight: bolder; color: hotpink; margin-left: 71%;">
                    <span style="white-space: nowrap;">nova <i class="bi bi-plus-circle"></i></span>
                </button>
            </form>
<%--        </c:if>--%>
    </div>
</div>
</body>
<%@ include file="footer.jspf" %>