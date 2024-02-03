<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../base.jsp" %>
<div style="padding: 10px 40px">
  <h2>Employee</h2>
  <table class="table table-hover">
    <thead style="background: #dfdfdf">
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Contact</th>
        <th>Email</th>
      </tr>
    </thead>
    <tbody>
            <c:forEach items="${employee}" var="emp">
                <tr>
                    <td>${emp.id != null ? emp.id : 'N/A'}</td>
                    <td>${emp.employeeName != null ? emp.employeeName : 'N/A'}</td>
                    <td>${emp.employeeContact != null ? emp.employeeContact : 'N/A'}</td>
                    <td>${emp.employeeEmail != null ? emp.employeeEmail : 'N/A'}</td>

                </tr>
            </c:forEach>
        </tbody>
  </table>
</div>
