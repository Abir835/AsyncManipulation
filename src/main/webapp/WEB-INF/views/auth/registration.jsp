<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../base.jsp" %>
<div class="container mt-5">
    <form action="user/register" method="POST">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="name">Name</label>
                <input type="text" name="name" class="form-control" id="name" placeholder="Name">
             </div>
            <div class="form-group col-md-6">
                <label for="inputEmail4">Email</label>
                <input type="text" name="email" class="form-control" id="inputEmail4" placeholder="Email">
            </div>
            <div class="form-group col-md-6">
                <label for="contact">Contact</label>
                <input type="contact" name="contact" class="form-control" id="contact" placeholder="contact">
            </div>
            <div class="form-group col-md-6">
                <label for="inputPassword4">Password</label>
                <input type="password" name="pwd" class="form-control" id="inputPassword4" placeholder="Password">
            </div>
        </div>

        <button type="submit" class="btn btn-primary">Sign Up</button>
    </form>
</div>

