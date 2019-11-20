<%-- 
    Document   : ReadyToStart
    Created on : Nov 20, 2019, 7:37:55 PM
    Author     : tsch
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:if test="${doquiz == 'true' && takequiz.page == page}">
    <c:forEach items="${question}" var="q" varStatus="qround">
        <div class="card-body text-secondary">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">${qround.count}. ${q.questionName}</h5>
                    <c:forEach items="${choice}" var="c" varStatus="cround">
                        <c:if test="${q.questionId == c.questionId}">
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="result${qround.count}" value="${c.choiceId}">
                                <label class="form-check-label" for="${q.questionId}">
                                    ${c.choiceName}
                                </label>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
            </div>
        </div>
    </c:forEach>
</c:if>