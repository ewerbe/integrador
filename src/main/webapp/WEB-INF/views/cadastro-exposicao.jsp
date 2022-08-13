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
<form id="cadastroExposicao" enctype="multipart/form-data" >
    <div id="formContainer" style="width: 60%; margin: auto;" >

        <div align="center" style="margin-top: 3%;">
            <c:choose>
                <c:when test="${exposicao != null}">
                    <h1 style="color: grey; font-weight: bold;
                font-size: 460%;">editar exposição</h1>
                    <input type="hidden" id="idExposicao" name="idExposicao" value="${exposicao.getId()}"
                </c:when>
                <c:otherwise>
                    <h1 style="color: grey; font-weight: bold;
                font-size: 460%;">nova exposição</h1>
                </c:otherwise>
            </c:choose>
        </div>

        <div class="mb-3" align="left">
            <label for="tituloExposicao" class="form-label" style="color: #262630;
                       font-weight: bold;">título</label>
            <input type="text" class="form-control bg-dark" id="tituloExposicao" name="tituloExposicao"
                   value="${exposicao.getTitulo()}"
                   placeholder="título da exposição" style="color: antiquewhite; align-content: space-around;"
                   required/>
        </div>

        <div class="mb-3" align="left">
            <label for="descricaoExposicao" class="form-label" style="color: #262630;
                       font-weight: bold;">descrição</label>
            <input type="text" class="form-control bg-dark" id="descricaoExposicao" name="descricaoExposicao"
                   value="${exposicao.getDescricao()}"
                   placeholder="descrição da exposição" style="color: antiquewhite; align-content: space-around;"
                   required/>
        </div>

        <%--checkbox para configurar exposição como de obras do acervo da instituição ou de procedência mista--%>
        <div class="mb-3" align="left" id="tipoExposicao" style="margin-top: 5%;">
            <label for="tipoExposicao" class="form-label" style="color: #262630;
                       font-weight: bold;">tipo de exposição
            </label>
            <div class="form-check">
                <input class="form-check-input" type="radio" value="${exposicao.getAcervo()}" id="flexCheckAcervo"/>
                    <label class="form-check-label" for="flexCheckAcervo">
                        somente obras do acervo
                    </label>
            </div>
        </div>

<%--        checkbox para ativar ou não exposição--%>
        <div class="mb-3" align="left">
            <label for="tipoExposicao" class="form-label" style="color: #262630;
                       font-weight: bold;">ativar exposição?
            </label>
            <input class="form-check-input" type="checkbox" value="${exposicao.getAtiva()}" id="flexCheckExpoAtiva"/>
            <label class="form-check-label" for="flexCheckExpoAtiva">
                ativar
            </label>
        </div>

        <%--div para imagem de banner atual da exposição--%>
        <div align="center" style="margin-bottom: 5%;">
            <c:if test="${exposicao != null}">
                <p class="form-label">banner atual</p>
                <img src="/banner-exposicao-view.action?id=${exposicao.getId()}" alt=""
                     style="alignment: center;" width="70%;">
            </c:if>
        </div>

        <%--        input para upload do banner da exposição--%>
        <div class="input-group mb-3">
            <input type="file" class="form-control bg-dark" id="bannerToExposicao" name="imgBanner"
                   value="${exposicao.getBanner()}"
                   formenctype="multipart/form-data"/>
            <label class="input-group-text" for="bannerToExposicao">upload</label>
        </div>

<%--        input para a data de início da exposição--%>
        <div class="mb-3" align="left" style="margin-top: 5%;">
            <label for="data_inicio" class="form-label" style="color: #262630;
                       font-weight: bold;">data de início
            </label>
            <input class="bg-dark text-light" type="date" value="${exposicao.getDataInicio()}" id="data_inicio" name="data_inicio"/>
        </div>

        <%--        input para a data de fim da exposição--%>
        <div class="mb-3" align="left">
            <label for="data_fim" class="form-label" style="color: #262630;
                       font-weight: bold; margin-right: 2%;">data de fim
            </label>
            <input class="bg-dark text-light" type="date" value="${exposicao.getDataFim()}" id="data_fim" name="data_fim"/>
        </div>


<%--        <div align="center" style="margin-top: 10%; margin-bottom: 10%;">--%>
<%--            <button class="btn btn-outline-info btn-lg bg-dark"--%>
<%--                        style="font-weight: bold;" data-bs-toggle="modal" data-bs-target="#modalSelecaoObras">--%>
<%--                    <span style="white-space: nowrap;">selecionar obras</span>--%>
<%--            </button>--%>
<%--        </div>--%>

<%--        accordion para seleção de obras pra nova exposição--%>
        <div class="accordion accordion-flush" id="accordionFlushExample" style="margin-top: 8%;">
            <div class="accordion-item">
                <h2 class="accordion-header" id="flush-headingOne">
                    <button class="accordion-button collapsed bg-dark text-light align-baseline" type="button" data-bs-toggle="collapse"
                            data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
                        <span style="font-size: 22px; font-weight: bold; margin-left: 40%; color: hotpink">selecionar obras</span>
                    </button>
                </h2>
                <div id="flush-collapseOne" class="accordion-collapse collapse" aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
                    <div class="accordion-body bg-dark text-light">Placeholder content for this accordion, which is intended to demonstrate the <code>.accordion-flush</code> class. This is the first item's accordion body.</div>
                </div>
            </div>
        </div>




        <%--botões de salvar e excluir para obra--%>
        <div align="left" style="margin-top: 5%;">
            <button class="btn btn-outline-dark btn-lg" data-bs-toggle="modal" data-bs-target="#modalConfirmacaoExposicao">
                salvar
            </button>
            <c:if test="${exposicao != null}">
                <button
                        class="btn btn-outline-danger btn-lg" data-bs-toggle="modal" data-bs-target="#modalConfirmacaoExposicao">
                    excluir
                </button>
                <input type="submit" class="btn btn-dark" data-bs-dismiss="modal"
                       formaction="/exposicoes.action" value="cancelar" formmethod="get" style="margin-left: 30%;"/>
            </c:if>
        </div>



        <%-- Modal de confirmação de cadastro--%>
        <div class="modal fade" id="modalConfirmacaoExposicao" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
             aria-labelledby="modalConfirmacaoExposicaoLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header bg-dark" style="color: hotpink;" >
                        <h5 class="modal-title"id="modalConfirmacaoExposicaoLabel">confirme as alterações</h5>
                        <button type="button" class="btn-close btn-outline-dark" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body bg-dark" style="color: antiquewhite;" align="left">
                        deseja salvar estas alterações?
                    </div>
                    <div class="modal-footer bg-dark">
                        <input type="submit" class="btn btn-outline-light" data-bs-dismiss="modal"
                               formaction="/exposicao/salvar-exposicao.action" formmethod="post" value="salvar"/>
                        <c:if test="${exposicao != null}">
                            <input type="submit" class="btn btn-outline-danger" data-bs-dismiss="modal"
                                   formaction="/exposicao/excluir-exposicao.action" value="excluir" formmethod="post"/>
                        </c:if>
                        <button class="btn btn-danger" data-bs-dismiss="modal">cancelar</button>
                    </div>
                </div>
            </div>
        </div>

    </div>
</form>
</body>
<%@ include file="footer.jspf" %>