<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="include/begin-html.jsp" %>
<%@ include file="include/header-html-log.jsp" %>

<br><br>
<div class="container">
<div class="row">
<legend> <h3>Authorization</h3></legend>
    </div>
   <form class="form-horizontal col-sm-6 col-sm-offset-3" action="do?command=Login" method="POST">
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">Login</label>
            <div class="col-sm-10">
                <input type="login" name="Login" class="form-control" id="inputLogin3" placeholder="Login">
                <span class="help-block">Enter login from 3 to 10 characters</span>
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-10">
                <input type="password" name="Password" class="form-control" id="inputPassword3" placeholder="Password">
                <span class="help-block">Enter password from 3 to 15 characters</span>
            </div>
        </div>
        <div class="form-group">
        <div class="checkbox col-sm-offset-2 col-sm-10">
            <label><input type="checkbox" name="remember" value="yes"> Remember me</label>
          </div>
          </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-success">Sign in</button>
            </div>
        </div>
    </form>

</div>

<%@ include file="include/end-html.jsp" %>