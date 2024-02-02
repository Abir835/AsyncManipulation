<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="base.jsp" %>
<div class="container">
      <h3>File Upload:</h3>
      Select a file to upload: <br />
      <form action = "/save-file" method = "post"
         enctype = "multipart/form-data">
         <input type = "file" name = "file" size = "50" />
         <br />
         <button style="background-color: #333; type="submit" class="btn btn-primary">Upload File</button>
      </form>
</div>