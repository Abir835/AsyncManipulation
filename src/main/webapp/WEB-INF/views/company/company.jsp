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
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>John</td>
        <td>Doe</td>
        <td>john@example.com</td>
      </tr>
      <tr>
        <td>Mary</td>
        <td>Moe</td>
        <td>mary@example.com</td>
      </tr>
      <tr>
        <td>July</td>
        <td>Dooley</td>
        <td>july@example.com</td>
      </tr>
    </tbody>
  </table>
</div>

</body>
</html>
