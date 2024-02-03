<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../base.jsp" %>
<div class="container mt-5" style="width:550px">
    <h1 style="text-align:center">Login Form</h1>
    <c:if test="${not empty sessionScope.registrationMessage}">
            <c:set var="sessionScope.registrationMessage" value="" scope="session"/>
    </c:if>
    <form action="/login" method="post">
        <div class="form-row">
            <div class="form-group col-md-12">
                <label for="inputEmail4">Email</label>
                <input type="text" name="username" class="form-control" id="inputEmail4" placeholder="Email">
            </div>
            <div class="form-group col-md-12">
                <label for="password">Password</label>
                <input type="password" name="password" class="form-control" id="password" placeholder="Password">
            </div>
        </div>
        <div style= "padding-left: 16px;">
            <button style="background-color: #333; type="submit" class="btn btn-primary">Sign in</button>
        </div>

    </form>
</div>

