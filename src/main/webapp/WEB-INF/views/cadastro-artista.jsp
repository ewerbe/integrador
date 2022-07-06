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
<form id="cadastroColaborador" action="/artista/salvar-artista.action" method="post">
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
                   font-weight: bold;">pa�s de origem</label>
            <select class="form-control bg-dark" id="paisOrigemArtista" name="paisOrigemArtista"
                   value="${artista.getPaisOrigem()}"
                    required style="color: cornsilk;">
                <option value="�frica do Sul">�frica do Sul</option>
                <option value="Alb�nia">Alb�nia</option>
                <option value="Alemanha">Alemanha</option>
                <option value="Andorra">Andorra</option>
                <option value="Angola">Angola</option>
                <option value="Anguilla">Anguilla</option>
                <option value="Antigua">Antigua</option>
                <option value="Ar�bia Saudita">Ar�bia Saudita</option>
                <option value="Argentina">Argentina</option>
                <option value="Arm�nia">Arm�nia</option>
                <option value="Aruba">Aruba</option>
                <option value="Austr�lia">Austr�lia</option>
                <option value="�ustria">�ustria</option>
                <option value="Azerbaij�o">Azerbaij�o</option>
                <option value="Bahamas">Bahamas</option>
                <option value="Bahrein">Bahrein</option>
                <option value="Bangladesh">Bangladesh</option>
                <option value="Barbados">Barbados</option>
                <option value="B�lgica">B�lgica</option>
                <option value="Benin">Benin</option>
                <option value="Bermudas">Bermudas</option>
                <option value="Botsuana">Botsuana</option>
                <option value="Brasil" selected>Brasil</option>
                <option value="Brunei">Brunei</option>
                <option value="Bulg�ria">Bulg�ria</option>
                <option value="Burkina Fasso">Burkina Fasso</option>
                <option value="bot�o">bot�o</option>
                <option value="Cabo Verde">Cabo Verde</option>
                <option value="Camar�es">Camar�es</option>
                <option value="Camboja">Camboja</option>
                <option value="Canad�">Canad�</option>
                <option value="Cazaquist�o">Cazaquist�o</option>
                <option value="Chade">Chade</option>
                <option value="Chile">Chile</option>
                <option value="China">China</option>
                <option value="Cidade do Vaticano">Cidade do Vaticano</option>
                <option value="Col�mbia">Col�mbia</option>
                <option value="Congo">Congo</option>
                <option value="Cor�ia do Sul">Cor�ia do Sul</option>
                <option value="Costa do Marfim">Costa do Marfim</option>
                <option value="Costa Rica">Costa Rica</option>
                <option value="Cro�cia">Cro�cia</option>
                <option value="Dinamarca">Dinamarca</option>
                <option value="Djibuti">Djibuti</option>
                <option value="Dominica">Dominica</option>
                <option value="EUA">EUA</option>
                <option value="Egito">Egito</option>
                <option value="El Salvador">El Salvador</option>
                <option value="Emirados �rabes">Emirados �rabes</option>
                <option value="Equador">Equador</option>
                <option value="Eritr�ia">Eritr�ia</option>
                <option value="Esc�cia">Esc�cia</option>
                <option value="Eslov�quia">Eslov�quia</option>
                <option value="Eslov�nia">Eslov�nia</option>
                <option value="Espanha">Espanha</option>
                <option value="Est�nia">Est�nia</option>
                <option value="Eti�pia">Eti�pia</option>
                <option value="Fiji">Fiji</option>
                <option value="Filipinas">Filipinas</option>
                <option value="Finl�ndia">Finl�ndia</option>
                <option value="Fran�a">Fran�a</option>
                <option value="Gab�o">Gab�o</option>
                <option value="G�mbia">G�mbia</option>
                <option value="Gana">Gana</option>
                <option value="Ge�rgia">Ge�rgia</option>
                <option value="Gibraltar">Gibraltar</option>
                <option value="Granada">Granada</option>
                <option value="Gr�cia">Gr�cia</option>
                <option value="Guadalupe">Guadalupe</option>
                <option value="Guam">Guam</option>
                <option value="Guatemala">Guatemala</option>
                <option value="Guiana">Guiana</option>
                <option value="Guiana Francesa">Guiana Francesa</option>
                <option value="Guin�-bissau">Guin�-bissau</option>
                <option value="Haiti">Haiti</option>
                <option value="Holanda">Holanda</option>
                <option value="Honduras">Honduras</option>
                <option value="Hong Kong">Hong Kong</option>
                <option value="Hungria">Hungria</option>
                <option value="I�men">I�men</option>
                <option value="Ilhas Cayman">Ilhas Cayman</option>
                <option value="Ilhas Cook">Ilhas Cook</option>
                <option value="Ilhas Cura�ao">Ilhas Cura�ao</option>
                <option value="Ilhas Marshall">Ilhas Marshall</option>
                <option value="Ilhas Turks &#038; Caicos">Ilhas Turks & Caicos</option>
                <option value="Ilhas Virgens (brit.)">Ilhas Virgens (brit.)</option>
                <option value="Ilhas Virgens(amer.)">Ilhas Virgens(amer.)</option>
                <option value="Ilhas Wallis e Futuna">Ilhas Wallis e Futuna</option>
                <option value="�ndia">�ndia</option>
                <option value="Indon�sia">Indon�sia</option>
                <option value="Inglaterra">Inglaterra</option>
                <option value="Irlanda">Irlanda</option>
                <option value="Isl�ndia">Isl�ndia</option>
                <option value="Israel">Israel</option>
                <option value="It�lia">It�lia</option>
                <option value="Jamaica">Jamaica</option>
                <option value="Jap�o">Jap�o</option>
                <option value="Jord�nia">Jord�nia</option>
                <option value="Kuwait">Kuwait</option>
                <option value="Latvia">Latvia</option>
                <option value="L�bano">L�bano</option>
                <option value="Liechtenstein">Liechtenstein</option>
                <option value="Litu�nia">Litu�nia</option>
                <option value="Luxemburgo">Luxemburgo</option>
                <option value="Macau">Macau</option>
                <option value="Maced�nia">Maced�nia</option>
                <option value="Madagascar">Madagascar</option>
                <option value="Mal�sia">Mal�sia</option>
                <option value="Malaui">Malaui</option>
                <option value="Mali">Mali</option>
                <option value="Malta">Malta</option>
                <option value="Marrocos">Marrocos</option>
                <option value="Martinica">Martinica</option>
                <option value="Maurit�nia">Maurit�nia</option>
                <option value="Mauritius">Mauritius</option>
                <option value="M�xico">M�xico</option>
                <option value="Moldova">Moldova</option>
                <option value="M�naco">M�naco</option>
                <option value="Montserrat">Montserrat</option>
                <option value="Nepal">Nepal</option>
                <option value="Nicar�gua">Nicar�gua</option>
                <option value="Niger">Niger</option>
                <option value="Nig�ria">Nig�ria</option>
                <option value="Noruega">Noruega</option>
                <option value="Nova Caled�nia">Nova Caled�nia</option>
                <option value="Nova Zel�ndia">Nova Zel�ndia</option>
                <option value="Om�">Om�</option>
                <option value="Palau">Palau</option>
                <option value="Panam�">Panam�</option>
                <option value="Papua-nova Guin�">Papua-nova Guin�</option>
                <option value="Paquist�o">Paquist�o</option>
                <option value="Peru">Peru</option>
                <option value="Polin�sia Francesa">Polin�sia Francesa</option>
                <option value="Pol�nia">Pol�nia</option>
                <option value="Porto Rico">Porto Rico</option>
                <option value="Portugal">Portugal</option>
                <option value="Qatar">Qatar</option>
                <option value="Qu�nia">Qu�nia</option>
                <option value="Rep. Dominicana">Rep. Dominicana</option>
                <option value="Rep. Tcheca">Rep. Tcheca</option>
                <option value="Reunion">Reunion</option>
                <option value="Rom�nia">Rom�nia</option>
                <option value="Ruanda">Ruanda</option>
                <option value="R�ssia">R�ssia</option>
                <option value="Saipan">Saipan</option>
                <option value="Samoa Americana">Samoa Americana</option>
                <option value="Senegal">Senegal</option>
                <option value="Serra Leone">Serra Leone</option>
                <option value="Seychelles">Seychelles</option>
                <option value="Singapura">Singapura</option>
                <option value="S�ria">S�ria</option>
                <option value="Sri Lanka">Sri Lanka</option>
                <option value="St. Kitts &#038; Nevis">St. Kitts & Nevis</option>
                <option value="St. L�cia">St. L�cia</option>
                <option value="St. Vincent">St. Vincent</option>
                <option value="Sud�o">Sud�o</option>
                <option value="Su�cia">Su�cia</option>
                <option value="Sui�a">Sui�a</option>
                <option value="Suriname">Suriname</option>
                <option value="Tail�ndia">Tail�ndia</option>
                <option value="Taiwan">Taiwan</option>
                <option value="Tanz�nia">Tanz�nia</option>
                <option value="Togo">Togo</option>
                <option value="Trinidad &#038; Tobago">Trinidad & Tobago</option>
                <option value="Tun�sia">Tun�sia</option>
                <option value="Turquia">Turquia</option>
                <option value="Ucr�nia">Ucr�nia</option>
                <option value="Uganda">Uganda</option>
                <option value="Uruguai">Uruguai</option>
                <option value="Venezuela">Venezuela</option>
                <option value="Vietn�">Vietn�</option>
                <option value="Zaire">Zaire</option>
                <option value="Z�mbia">Z�mbia</option>
                <option value="Zimb�bue">Zimb�bue</option>
            </select>
        </div>

        <div class="mb-3" align="left">
            <label for="anoNascimentoArtista" class="form-label" style="color: #262630;
                    font-weight: bold;">ano de nascimento</label>
            <input type="number" min="1500" max="2022" class="form-control bg-dark" id="anoNascimentoArtista" name="anoNascimentoArtista"
                   value="${artista.getAnoNascimento()}"
                   placeholder="ano de nascimento do(a) artista" style="color: antiquewhite;"
                   required>
        </div>

        <div class="mb-3" align="left">
            <label for="anoMorteArtista" class="form-label" style="color: #262630;
                    font-weight: bold;">ano de morte</label>
            <input type="number" min="1500" max="2022" class="form-control bg-dark" id="anoMorteArtista" name="anoMorteArtista"
                   value="${artista.getAnoNascimento()}"
                   placeholder="ano de morte do(a) artista" style="color: antiquewhite;">
        </div>

        <div align="left">
            <button type="button" class="btn btn-outline-dark btn-lg" data-bs-toggle="modal" data-bs-target="#modalConfirmacaoArtista">
                salvar
            </button>
        </div>
        <!-- Modal de confirma��o de cadastro-->
        <div class="modal fade" id="modalConfirmacaoArtista" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
             aria-labelledby="modalConfirmacaoArtistaLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header bg-dark" style="color: hotpink;" >
                        <h5 class="modal-title"id="modalConfirmacaoArtistaLabel">confirme as altera��es</h5>
                        <button type="button" class="btn-close btn-outline-dark" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body bg-dark" style="color: antiquewhite;" align="left">
                        deseja salvar estas altera��es?
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
    </div>
    </div>
</form>
</body>
<%@ include file="footer.jspf" %>