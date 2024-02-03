<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../base.jsp" %>

<div style="padding: 10px 40px">
    <div style="display: flex; align-items: center; justify-content: left; margin-bottom: 10px;">
      <h2 style="margin: 0px">Company</h2>
      <button style="margin-left: 20px" type="button"><a style="color:black" href="/company/add">+ Add</a></button>
    </div>
  <table class="table table-hover">
    <thead style="background: #dfdfdf">
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Contact</th>
      </tr>
    </thead>
    <tbody>
            <c:forEach items="${company}" var="cmp">
                <tr>
                    <td>${cmp.id != null ? cmp.id : 'N/A'}</td>
                    <td>${cmp.companyName != null ? cmp.companyName : 'N/A'}</td>
                    <td>${cmp.companyEmail != null ? cmp.companyEmail : 'N/A'}</td>
                    <td>${cmp.companyContact != null ? cmp.companyContact : 'N/A'}</td>
                </tr>
            </c:forEach>
        </tbody>
  </table>
</div>

</body>
</html>
