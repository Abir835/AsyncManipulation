<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../base.jsp" %>
<div class="container mt-5" style="width:550px">
    <h1 style="text-align:center">Registration Form</h1>
    <form action="/createUser" method="POST">
        <div class="form-row">
            <div class="form-group col-md-12">
                <label for="name">Name</label>
                <input type="text" name="name" class="form-control" id="name" placeholder="Name">
             </div>
            <div class="form-group col-md-12">
                <label for="inputEmail4">Email</label>
                <input type="text" name="email" class="form-control" id="inputEmail4" placeholder="Email">
            </div>
            <div class="form-group col-md-12">
                <label for="contact">Contact</label>
                <input type="contact" name="contact" class="form-control" id="contact" placeholder="contact">
            </div>
            <div class="form-group col-md-12">
                <label for="password">Password</label>
                <input type="password" name="password" class="form-control" id="password" placeholder="Password">
            </div>
        </div>
        <div style= "padding-left: 16px;">
           <button style="background-color: #333; " type="submit" class="btn btn-primary">Sign Up</button>
        </div>
    </form>
</div>

