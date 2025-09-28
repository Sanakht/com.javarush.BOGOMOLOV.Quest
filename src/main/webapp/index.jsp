<%@ page import="com.javarush.bogomolov.quest.constants.AppConstants" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Start</title>
</head>
<body>


  <c:if test="${sessionScope.start != true}" >
  <h1>
    <%=
    AppConstants.Question.SHOW
    %>
  </h1>

  <h3>
    <%=
    AppConstants.Question.DESCRIPTION
    %>
    <br/>
  </h3>
    <%--    <%=--%>
<%--    AppConstants.Question.RULES--%>
<%--    %>--%>
  </c:if>


<c:set var="question1" value="<%=AppConstants.Question.QUESTION_1%>"/>
<c:set var="question2" value="<%=AppConstants.Question.QUESTION_2%>"/>
<c:set var="question3" value="<%=AppConstants.Question.QUESTION_3%>"/>
<c:set var="question4" value="<%=AppConstants.Question.QUESTION_4%>"/>


<c:choose>
  <c:when test="${sessionScope.start != true}">
    <form method="get" action="start">
      <button type="submit">Запустить квест</button>
    </form>
  </c:when>
  <c:when test="${sessionScope.dead == true}">
    <p>${sessionScope.question}</p>
    <p>Вы проиграли, хотите перезапустить квест?</p>
    <form method="post" action="restart">
      <button type="submit">Сбросить квест</button>
    </form>
  </c:when>
  <c:when test="${sessionScope.win == true}">
    <p>${sessionScope.question}</p>
    <p>Вы прошли, хотите перезапустить квест?</p>
    <form method="post" action="restart">
      <button type="submit">Сбросить квест</button>
    </form>
  </c:when>
</c:choose>


<br/>

<c:if test="${sessionScope.start == true && sessionScope.dead != true && sessionScope.win != true}">
  <c:set var="chek" value="${true}"/>
</c:if>


<c:if test = "${sessionScope.question == null && chek}">
  <p>
    <%=
    AppConstants.Question.QUESTION_1
    %>
  </p>
  <form method="post" action="start">
    <input type="radio" name="answer" value="ANSWER_1_1"> <%= AppConstants.Answer.ANSWER_1_1%><br/>
    <input type="radio" name="answer" value="ANSWER_1_2"> <%= AppConstants.Answer.ANSWER_1_2%><br/>
    <input type="radio" name="answer" value="ANSWER_1_3"> <%= AppConstants.Answer.ANSWER_1_3%><br/>
    <button type="submit" > Подтвердить </button><br/>
  </form>
</c:if>

<c:if test = "${sessionScope.question == question2 && chek}">
  <p>
    <%=
    AppConstants.Question.QUESTION_2
    %>
  </p>
  <form method="post" action="start">
    <input type="radio" name="answer" value="ANSWER_2_1"> <%= AppConstants.Answer.ANSWER_2_1%><br/>
    <input type="radio" name="answer" value="ANSWER_2_2"> <%= AppConstants.Answer.ANSWER_2_2%><br/>
    <input type="radio" name="answer" value="ANSWER_2_3"> <%= AppConstants.Answer.ANSWER_2_3%><br/>
    <button type="submit" > Подтвердить </button><br/>
  </form>
</c:if>

<c:if test = "${sessionScope.question == question3 && chek}">
  <p>
    <%=
    AppConstants.Question.QUESTION_3
    %>
  </p>
  <form method="post" action="start">
    <input type="radio" name="answer" value="ANSWER_3_1"> <%= AppConstants.Answer.ANSWER_3_1%><br/>
    <input type="radio" name="answer" value="ANSWER_3_2"> <%= AppConstants.Answer.ANSWER_3_2%><br/>
    <input type="radio" name="answer" value="ANSWER_3_3"> <%= AppConstants.Answer.ANSWER_3_3%><br/>
    <button type="submit"> Подтвердить </button><br/>
  </form>
</c:if>

<c:if test = "${sessionScope.question == question4 && chek}">
  <p>
    <%=
    AppConstants.Question.QUESTION_4
    %>
  </p>
  <form method="post" action="start">
    <input type="radio" name="answer" value="ANSWER_4_1"> <%= AppConstants.Answer.ANSWER_4_1%><br/>
    <input type="radio" name="answer" value="ANSWER_4_2"> <%= AppConstants.Answer.ANSWER_4_2%><br/>
    <button type="submit"> Подтвердить </button><br/>
  </form>
</c:if>



</body>
</html>

<c:set var="start" value="<%= session.getAttribute(AppConstants.SessionParameters.START)%>"/>
<c:set var="weapon" value="<%= session.getAttribute(AppConstants.SessionParameters.WEAPON)%>"/>
<c:set var="dead" value="<%= session.getAttribute(AppConstants.SessionParameters.DEAD)%>"/>
<c:set var="win" value="<%= session.getAttribute(AppConstants.SessionParameters.WIN)%>"/>
<c:set var="question" value="<%= session.getAttribute(AppConstants.SessionParameters.QUESTION)%>"/>
<c:set var="answer" value="<%= session.getAttribute(AppConstants.SessionParameters.ANSWER)%>"/>
<c:set var="numberGamesCompleted" value="<%= session.getAttribute(AppConstants.SessionParameters.NUMBER_GAME_COMPLETED)%>"/>

<c:set var="session" value="<%= request.getSession().toString()%>"/>

<p>
  Атрибуты сессии: <br/>
  session: ${session} <br/>
  start: ${start} <br/>
  weapon: ${weapon} <br/>
  dead: ${dead} <br/>
  win: ${win} <br/>
  question: ${question} <br/>
  numberGamesCompleted: ${numberGamesCompleted}<br/>
</p>

<br/>
