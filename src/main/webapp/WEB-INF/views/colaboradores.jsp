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
        <div align="center" style="margin-top: 3%;">
            <h1 style="color: grey; font-weight: bold;
                font-size: 460%;">colaboradores(as)</h1>
        </div>
        <div id="tableColaboradoresContainer" align="center;" style="margin: auto; width: 80%;">
            <table class="table table-dark table-hover">
                <thead>
                <tr>
                    <th scope="col" style="color: hotpink;">nome</th>
                    <th scope="col" style="color: hotpink;">e-mail</th>
                    <th scope="col" style="color: hotpink;">status</th>
                    <th scope="col" style="color: hotpink; text-align: center;">ações</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="colaborador" items="${colaboradores}">
                    <tr>
                        <th scope="row">${colaborador.getNome()}</th>
                        <td>${colaborador.getEmail()}</td>
                        <td>
                            <c:if test="${colaborador.getAtivo()}">
                                ativo(a)
                            </c:if>
                            <c:if test="${!colaborador.getAtivo()}">
                                inativo(a)
                            </c:if>
                        </td>
                        <td align="center">
                            <form method="post">
                                <input type="submit" class="btn btn-outline-light"
                                       formaction="/colaborador/editar-colaborador.action?id=${colaborador.getId()}" value="editar"/>
                                <input type="submit" class="btn btn-outline-danger"
                                       formaction="/colaborador/excluir-colaborador.action?id=${colaborador.getId()}" value="excluir"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
<%--                <tbody>--%>
<%--                <tr>--%>
<%--                    <th scope="row">Jonelson Braga</th>--%>
<%--                    <td>jonel@gmail.com</td>--%>
<%--                    <td>ativo(a)</td>--%>
<%--                    <td align="center">--%>
<%--                        <button class="btn btn-outline-light">editar</button>--%>
<%--                        <button class="btn btn-outline-danger">excluir</button>--%>
<%--                    </td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <th scope="row">Brunelli de la Vega</th>--%>
<%--                    <td>bruvega@gmail.com</td>--%>
<%--                    <td>ativo(a)</td>--%>
<%--                    <td align="center">--%>
<%--                        <button class="btn btn-outline-light">editar</button>--%>
<%--                        <button class="btn btn-outline-danger">excluir</button>--%>
<%--                    </td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <th scope="row">Toner Muriel</th>--%>
<%--                    <td>toner@gmail.com</td>--%>
<%--                    <td>ativo(a)</td>--%>
<%--                    <td align="center">--%>
<%--                        <button class="btn btn-outline-light">editar</button>--%>
<%--                        <button class="btn btn-outline-danger">excluir</button>--%>
<%--                    </td>--%>
<%--                </tr>--%>
                </tbody>
            </table>
        </div>
</body>
<%@ include file="footer.jspf" %>