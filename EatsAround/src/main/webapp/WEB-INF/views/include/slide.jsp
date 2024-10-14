<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="demo" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
    <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
    <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
  </div>
  
  <!-- The slideshow/carousel -->
  <div class="carousel-inner">
  
    <div class="carousel-item">
      <img src="resources/images/aquarium1.jpg" alt="aquarium1" class="d-block w-100">
    </div>
    <div class="carousel-item active">
      <img src="resources/images/aquarium2.jpg" alt="aquarium2" class="d-block w-100" >
    </div>
    <div class="carousel-item">
      <img src="resources/images/aquarium3.jpg" alt="aquarium3" class="d-block w-100">
    </div>
    <div class="carousel-item">
      <img src="resources/images/aquarium4.jpg" alt="aquarium4" class="d-block w-100">
    </div>

  </div>
  
  <!-- Left and right controls/icons -->
  <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
    <span class="carousel-control-next-icon"></span>
  </button>
</div>






