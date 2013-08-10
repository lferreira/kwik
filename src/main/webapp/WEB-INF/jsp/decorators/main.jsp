<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title><decorator:title default="Vraptor Scaffold"/></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/application.css"/>
    <decorator:head/>
  </head>
  <body>
  	<a id="swatch-link" href="<c:url value="/product/add"/>">Products</a>
  	<a id="swatch-link" href="<c:url value="/category/add"/>">Categories</a>
    <decorator:body/>
  </body>
</html>
