<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js">
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js">
    </script>
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"></head>
     
     <nav class="navbar navbar-expand-md navbar-light bg-light">
      <a class="navbar-brand" href="#">
        <img src="images/logo-navbar.PNG" alt="logo">
      </a>
      <form class="mx-2 my-auto d-inline">
        <div class="input-group topnav1">
          <input type="text" class="form-control border border-right-0 bg-light form-rounded" placeholder="Search">
          <span class="input-group-append">
            <button class="btn btn-outline-secondary border border-left-0  form-rounded" type="button">
              <span class="fa fa-search">
              </span>
            </button>
          </span>
        </div>
      </form>
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <a class="nav-link" href="#">
            <span class="fa fa-bell">
            </span>
          </a>
        </li>
        <li class="nav-item">
          <span class="navbar-text">
            Welcome&nbsp&nbsp&nbsp&nbsp
          </span>
          
        </li>
        <h3>${sessionScope.username}  </h3>
      </ul>
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <form class= "mx-2 my-auto w-full">
            <button class="btn btn-secondary  form-rounded" type="button" >Logout
            </button>
          </form>
        </li>
      </ul>
    </nav>
  <div class="container-clearfix">
      <br>
    </div>
    <div class="container-fluid">
      <div class="row">
        <div class="col-md-3 bg-light">
          <br>
          <nav class="navbar navbar-expand-md navbar-dark navbar-custom">
            <span class="navbar-text navbar-">
              <b>PROFILE
              </b>
            </span>
            <ul class="navbar-nav ml-auto">
              <li class="nav-item">
                <a href="" style="color:aliceblue">
                  <b>Edit
                  </b>
                </a>
              </li>
            </ul>
          </nav>
          <br>
          <center>
            <img src="images/profile-picture.PNG" alt="Profile Picture">
            <br>
            <br>
            <b> ${sessionScope.username} 
            </b>
            <br>
            <br>
            ID:
            <br> ${sessionScope.uid} 
            <br>
            <br>
            Designation:
            <br>
            Associate
            <br>
            <br>
            Office:
            <br>
            India,Usa
          </center>
        </div>
        <div class="col-md-6">
          <div class="container">
            <ul class="nav nav-tabs" role="tablist">
              <form method="post" action="List-Product.jsp"><li class="nav-item">
                <a class="nav-link active" data-toggle="tab" href="#home">PRODUCTS
                </a>
              </li></form>
            </ul>
            <!-- Tab panes -->
            <div class="tab-content">
              <div id="home" class="container tab-pane active">
                <br>
                <br>
                <br>
                <div class="container-fluid">
                  <div class="row">
                    <div class="col-md-8 bg-light   ">
                      <picture>
                        <center>
                          <br>
                          <br>
                          <br>
                          <img src="images/add-image.PNG">
                          <br>
                          <br>
                          <br>
                          <b>Add Images
                          </b>
                          <br>
                          <br>
                        </center>
                      </picture>
                    </div>
                    <div class="col-md-4">
                      <form class= "mx-2 my-auto w-full" method="post" action="ProductServlet">
                        <input type="text" name="product_id" placeholder="Enter Product ID">
                        <select name="product_category" name="cars">
                          <option value="Cateogory">Category
                          </option>
                          <option value="personalcare">Personal Care
                          </option>
                          <option value="laptop">Laptop
                          </option>
                          <option value="artsupply">Art Supply
                          </option>
                        </select>
                        <input type="text" name="product_name" placeholder="Name">
                        <input type="text" name="product_description" placeholder="Description">
                        <input type="text" name="product_price" placeholder="Price ">
                        <input type="text" name="product_brand" placeholder="Brand ">
                      <button type="submit" class="btn btn-dark form-rounded" style="width:30%; position: absolute; bottom: 50px; right: 20px;">Add
          </button>
          <br>
          <button type="reset" class="btn btn-secondary form-rounded" style="width:30%;  position: absolute; bottom: 0; right: 20px;"  type="cancel">Cancel
          </button>
                      
                      </form>
                    </div>
                  </div>   
                </div>
              </div>
              <div id="menu1" class="container tab-pane fade">
                <br>
              </div>
            </div>
            <!--tab ends here-->
          </div>
        </div>
        <div class="col-md-3">
         
        </div>
      </div>
      </body>
    </html>