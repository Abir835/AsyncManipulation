
<!-- navbar.jsp -->
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">Asyn Project</a>
    </div>
    <ul class="nav navbar-nav">
        <c:if test="${loggedIn}">
          <li ><a href="/users">User</a></li>
          <li ><a href="/company">Company</a></li>
          <li ><a href="/department">Department</a></li>
          <li ><a href="/employee">Employee</a></li>
          <li ><a href="/file-upload">File Upload</a></li>
        </c:if>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <c:choose>
          <c:when test="${loggedIn}">
            <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
          </c:when>
          <c:otherwise>
            <li><a href="/registration"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
            <li><a href="/signin"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
          </c:otherwise>
      </c:choose>

    </ul>
  </div>
</nav>

