<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title><decorator:title default="Kwik E-Commerce"/></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/application.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"/>
    <decorator:head/>
  </head>
  <body data-offset="80" data-target=".subnav" data-spy="scroll" id="top" class="preview" style="margin-top: 0px;">
  	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a>
				<a href="/" class="brand">Kwik E-Commerce</a>
				<div id="main-menu" class="nav-collapse collapse">
					<ul id="main-menu-left" class="nav">
						<li><a id="swatch-link" href="<c:url value="/product/add"/>">Products</a></li>
  						<li><a id="swatch-link" href="<c:url value="/category/add"/>">Categories</a></li>
					</ul>
				</div>			
			</div>
		</div>	  	
  	</div>
	<br />
	<br />
	<br />
	<br />
    <decorator:body/>
  </body>
</html>
