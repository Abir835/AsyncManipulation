<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../base.jsp" %>

<div style="padding: 10px 40px">
  <h2>Department</h2>
  <table class="table table-hover">
    <thead style="background: #dfdfdf">
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Prefix</th>
      </tr>
    </thead>
    <tbody>
        <c:forEach items="${department}" var="dept">
            <tr>
                <td>${dept.id != null ? dept.id : 'N/A'}</td>
                <td>${dept.departmentName != null ? dept.departmentName : 'N/A'}</td>
                <td>${dept.departmentPrefix != null ?dept.departmentPrefix : 'N/A'}</td>

            </tr>
        </c:forEach>
    </tbody>
  </table>
</div>

