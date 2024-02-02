<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../base.jsp" %>
<div style="padding: 10px 40px">
  <h2>User</h2>
  <table class="table table-hover">
    <thead style="background: #dfdfdf">
      <tr>
        <th>Id</th>
        <th>User Name</th>
        <th>Email</th>
        <th>Contact</th>
      </tr>
    </thead>
    <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.contact}</td>
            </tr>
        </c:forEach>
    </tbody>
  </table>
</div>
