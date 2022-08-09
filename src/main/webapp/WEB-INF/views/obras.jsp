<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

    <div align="center" style="width: 100%;">
        <div style="display: flex; flex-wrap: wrap;">
        <c:forEach var="obra" items="${obras}">
            <div style="flex-direction: row; width: 50%;">
<%--                <img src="data:image/png;base64,${obra.getImagemString()}" alt="" width="80%;">--%>
                <img src="/obra-view.action?id=${obra.getId()}" alt="" width="80%;">
                <div class="card-body bg-dark" style="width: 80%; margin-bottom: 5%; :hover{ width: 90%;}">
                    <h5 class="card-title text-light" style="width: 80%;">${obra.getTitulo()}</h5>
                    <p class="card-text text-light" style="width: 80%;">Artista: ${obra.getArtista().getNome()}<br>
                        Ano: ${obra.getAno()}</p>
                    <form method="post">
                        <button type="submit" formaction="/obra/editar-obra.action?id=${obra.getId()}" class="btn btn-outline-info"
                                style="font-weight: bold;">
                            <span style="white-space: nowrap;"><i class="bi bi-pencil"></i> editar</span>
                        </button>
                    </form>
                </div>
            </div>
        </c:forEach>
        </div>
    </div>


</body>
<%@ include file="footer.jspf" %>