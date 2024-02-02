<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../base.jsp" %>
<div class="container mt-5">
   <div class="d-flex align-items-center justify-content-between">
    <form class="" action="/create-batch" method="POST">
           <h2>Company </h2>
           <div class="form-row">
              <div class="">
                  <label for="companyName">Company Name</label>
                  <input type="text" name="companyName" class="form-control" id="companyName" placeholder="Company Name">
              </div>
               <div class="">
                   <label for="companyEmail">Company Email</label>
                   <input type="text" name="companyEmail" class="form-control" id="companyEmail" placeholder="Company Email">
                </div>
               <div class="">
                   <label for="companyContact">Company Contact</label>
                   <input type="text" name="companyContact" class="form-control" id="companyContact" placeholder="Company Contact">
               </div>
           </div>
           </br>

           <div class="">
             <h2>Department</h2>
             <div class="">
                 <label for="departmentName">Department Name</label>
                 <input type="text" name="departmentName" class="form-control" id="departmentName" placeholder="Department Name">
             </div>
              <div class="">
                  <label for="departmentPrefix">Department Prefix</label>
                  <input type="text" name="departmentPrefix" class="form-control" id="departmentPrefix" placeholder="Department Prefix">
               </div>

            </div>

            <div class="">
                 <h2>Employee</h2>
                 <div class="">
                     <label for="employeeName">Employee Name</label>
                     <input type="text" name="employeeName" class="form-control" id="employeeName" placeholder="Employee Name">
                 </div>
                  <div class="">
                      <label for="employeeContact">Employee Contact</label>
                      <input type="text" name="employeeContact" class="form-control" id="employeeContact" placeholder="Employee Contact">
                   </div>

                   <div class="">
                      <label for="employeeEmail">Employee Email</label>
                      <input type="text" name="employeeEmail" class="form-control" id="employeeEmail" placeholder="Employee Email">
                   </div>

            </div>
            </br>
           <button type="submit" class="btn btn-primary">Create</button>
   </div>
</div>

