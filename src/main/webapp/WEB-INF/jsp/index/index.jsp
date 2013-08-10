<div class="container">
 	<div class="row">
		<c:forEach items="${products}" var="product">
			<div class="row">
				<div class="span10">
	      			<div>
	        			${product.id}
	        			${product.description}
	   			 	</div>
	   			</div>
   			</div>
		</c:forEach>
	</div>
</div>
