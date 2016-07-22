<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="include/begin-html.jsp" %>
<%@ include file="include/header-html-reg.jsp" %>

<div class="main container">
    <div class="row">
    <legend> <h3>Registration form</h3></legend>
    </div>
    <div class="row">
        <div class="col-sm-6 col-sm-offset-3">
            <form class="form-horizontal" action="do?command=Registration" method="POST">
                <div class="form-group">
                    <label for="name" class="col-sm-4 control-label">First name</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="first_name" id="first_name" placeholder="First name">
                        <span class="help-block">Enter first name</span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="middle" class="col-sm-4 control-label">Middle name</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="middle_name" id="middle_name" placeholder="Middle name">
                        <span class="help-block">Enter middle name</span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="second" class="col-sm-4 control-label">Last name</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="last_name" id="last_name" placeholder="Last name">
                        <span class="help-block">Enter last name</span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="mobile" class="col-sm-4 control-label">Phone</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="phone" id="phone" placeholder="Phone">
                        <span class="help-block">Enter phone in format: +xxx(xx)xxx-xx-xx</span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="address" class="col-sm-4 control-label">Address</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="address" id="address" placeholder="Address">
                        <span class="help-block">Enter state,street, home, flat (from 10 to 40 characters) </span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-4 control-label">Email</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="email" id="email" placeholder="E-mail">
                        <span class="help-block">Enter email</span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="passport" class="col-sm-4 control-label">Passport</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="passport" id="passport" placeholder="Passport">
                        <span class="help-block">Enter data of passport: MC1234567, 2015-12-03</span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="login" class="col-sm-4 control-label">Login</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="login" id="login" placeholder="Login">
                        <span class="help-block">Enter login from 3 to 10 characters</span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-4 control-label">Password</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="password" id="password" placeholder="Password">
                        <span class="help-block">Enter password from 3 to 15 characters</span>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-4 col-sm-10">
                        <button type="submit" class="btn btn-success">Registration</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<%@ include file="include/end-html.jsp" %>