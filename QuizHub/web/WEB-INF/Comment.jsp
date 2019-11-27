<%-- 
    Document   : Comment
    Created on : Oct 31, 2019, 1:37:01 PM
    Author     : MaxPong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
        <h1>Comment</h1> 
        
    
        
    <c:forEach items="${CommentList}" var="c" varStatus="cs">
        comment ${cs.count}<br>
        Owner:${c.userId}
        Text:${c.comment}
        Time:${c.date}
        <c:choose >
            <c:when test="${user.id==c.userId}">
            <a href="CommentReply?deleteComment=${c.commentId}&currentQuizId=${currentQuizId}" method="post">Delete</a>
            </c:when>
            <c:otherwise>
                
            </c:otherwise>    
        </c:choose> 
        
        <c:forEach items="${c.replys}" var="r" varStatus="rs">
        <br>    
        reply ${rs.count}<br>
        Owner:${r. userId}
        Text:${r.replyComment}
        Time:${r.date}

        <c:if test="${user.id==r.userId}">
            <a href="CommentReply?deleteReply=${r.replyCommentId}&currentQuizId=${currentQuizId}" method="post">Delete</a>
            </c:if>
        </c:forEach>
        
        <br>
        Reply
        <form action="CommentReply" method="post">
        <input type="text" name="reply">
        <input hidden type="text" name="currentQuizId" value="${currentQuizId}">
        <input type="text" name="commentTarget" value="${c.commentId}" hidden>
        <button type="submit">reply</button>
        </form>
        
    </c:forEach>
        
        
        Comment 
        <form action="CommentReply" method="post" id="commentField">
            <input type="text" name="comment">
            <input hidden type="text" name="currentQuizId" value="${currentQuizId}">
            <button type="submit">comment</button>
        </form>    
        
        
    </body>
 
</html>
