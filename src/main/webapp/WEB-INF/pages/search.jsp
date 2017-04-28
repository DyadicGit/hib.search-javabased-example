<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<head>
    <title>Paieškos langas</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="description" content="Tikslios paieškos langas"/>
    <meta name="keywords" content="jquery, search box, search input, filter, checkbox "/>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />" type="text/css" media="screen"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/style_2.css" />" type="text/css" media="screen"/>
</head>
<body>
<a href="http://localhost:8080/metadatah/"><img src="<c:url value="/resources/icons/logo_statistika.png" />" alt=""
                                                width="234" height="61"/></a>
<div class="content">
    <div class="box">
        <h2>Tikslios paieškos langas</h2>
        <form:form id="ui_element" class="sb_wrapper" action="search" method="POST" commandName="pasirinkimai">
            <p>
                <span class="sb_down"></span>
                <input class="sb_input" type="text" name="searchText"/>
                <input class="sb_search" type="submit" value=""/>
            </p>
            <ul class="sb_dropdown" style="display:none;">
                <li class="sb_filter">FILTRUOKITE SAVO PAIEŠKĄ</li>
                <bind>
                    <li><form:radiobutton path="pasirinkimas" value="zodis_sutampa"/><label>žodis sutampa</label></li>
                    <li><form:radiobutton path="pasirinkimas" value="zodzio_pradzia"/><label>žodžio pradžią</label></li>
                    <li><form:radiobutton path="pasirinkimas" value="zodyje_yra"/><label>žodyje yra</label></li>
                    <br/>
                </bind>
                <li><form:checkbox path="pasirinkimas" value="EN" id="pasirinkimas_EN"/><label>EN</label></li>
                <li><form:checkbox path="pasirinkimas" value="LT" id="pasirinkimas_LT"/><label>LT</label></li>

                <div class="div_klausymai">
                    <li/>
                    <li><a class="a_klausymai">Klausymai</a></li>
                    <li/>
                </div>
                <li><form:select items="${webQuestion_textList}" path="QUESTION_TEXT" multiple="true"/></li>
            </ul>
        </form:form>
        <div class="info_tekstas">
            <a>*Norėdami pažymėti keletą elementų, naudokitės klavišais Shift arba Ctrl</a>
        </div>

    </div>
</div>
<div>
    <%--${allFound.isEmpty()}--%>
    <c:if test="${arIvede != 'ne'}">
        <c:if test="${allFound.isEmpty() == false}">
            <h2>Rasti ${allFound.size()} įrašai:</h2>
            <table border="1">
                <th>Nr.</th>
                <th>ID</th>
                <th>STRUCTURES_ID</th>
                <th>CODE</th>
                <th>TEXT</th>
                <th>ID_ID</th>
                <th>SORTING</th>
                <c:forEach var="book" items="${allFound}" varStatus="cnt">
                    <tr>
                        <td>${cnt.index + 1}</td>
                        <td>${book.getQUESTION_ID()}</td>
                        <td>${book.getQUESTION_STRUCTURES_ID()}</td>
                        <td>${book.getQUESTION_CODE()}</td>
                        <td>${book.getQUESTION_TEXT()}</td>
                        <td>${book.getQUESTION_ID_ID()}</td>
                        <td>${book.getQUESTION_SORTING()}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${allFound.isEmpty() == true}">
            <a>Nėrasta įrašų</a>
        </c:if>
    </c:if>
</div>
<div>
    <c:if test="${not empty pasirinkimai.pasirinkimas}">
        <table>
            <tr>
                <td>Selected values:</td>
                <td>
                    <c:forEach items="${pasirinkimai.pasirinkimas}" var="element">
                        <span>[${element}]</span>
                    </c:forEach>
                </td>
                <br/>
                <td>
                    <c:forEach items="${pasirinkimai.QUESTION_TEXT}" var="element">
                        <span>[${element}]</span>
                    </c:forEach>
                </td>
                <br/>
            </tr>
        </table>
    </c:if>
</div>
<div>
    <span class="reference">
        <a href="http://www.stat.gov.lt/home/">©  Lietuvos statistikos departamentas, 2017</a>
    </span>
</div>
<!-- The JavaScript -->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/js/search_button.js"/>"></script>
<script type="text/javascript">
    /**
     * if no language selected select all
     */
    $(".sb_search").click(function() {
        if ( ( $( "#pasirinkimas_EN" ).attr("checked") == false ) && ( $( "#pasirinkimas_LT" ).attr("checked") == false )) {
            $(":checkbox").attr("checked", true)
        }
    });
</script>
</body>
</html>