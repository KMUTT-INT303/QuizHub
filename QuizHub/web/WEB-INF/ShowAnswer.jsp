<%-- 
    Document   : ShowAnswer
    Created on : Nov 26, 2019, 8:33:26 PM
    Author     : MaxPong
--%>

<%@page import="model.ChoiceResult"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="../Layouts/Menu.jsp" %>
        
    </head>
    <body>
        


        ${quiz.quizName}
        ${quiz.quizCourseName}
        <c:forEach items="${questions}" var="q" varStatus="qround">
            <div class="card-body text-secondary">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">${qround.count}. ${q.questionName}</h5>
                        <c:forEach items="${choices}" var="c" varStatus="cround">
                            <c:if test="${q.questionId == c.questionId}">
                                <div class="form-check">
                                   
                                    <c:choose>
                                        <c:when test="${c.choose=='true'}">
                                            
                                            <input class="form-check-input" type="radio" name="result${qround.count}" value="${c.choiceId}" checked>
                                        </c:when>    
                                            <c:otherwise>
                                            <input class="form-check-input" type="radio" name="result${qround.count}" value="${c.choiceId}" >

                                            </c:otherwise>
                                        
                                    </c:choose>
                                    
                                    <c:choose>
                                        <c:when test="${c.choiceCorrect=='true'}">
                                            <span style="color:yellow">${c.choiceName}</span>   
                                        </c:when>
                                        <c:otherwise>
                                            ${c.choiceName}
                                        </c:otherwise>

                                    </c:choose>

                                    <c:forEach items="${choiceResults}" var="cr" varStatus="crRound">

                                        <c:if test="${c.choiceId==cr.choice_id}">
                                            <c:choose>
                                                <c:when test="${c.choiceCorrect=='true'}">
                                                    <span style="color:greenyellow">correct</span>   
                                                </c:when>
                                                <c:otherwise>
                                                    <span style="color:red">wrong</span>    
                                                </c:otherwise>
                                            </c:choose>
                                        </c:if>
                                    </c:forEach>

                                    </label>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </c:forEach>
        
        <%@include file="Comment.jsp" %>
       
       <%-- <jsp:include page="/CommentReply?currentQuizId=${currentQuizId}&mode=\"getComments\""/> --%>
        
    </body>



</html>
