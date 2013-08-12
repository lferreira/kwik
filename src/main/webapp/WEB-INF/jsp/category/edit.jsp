<div class="container">
	<div class="row">
		<div id="id" style="display: none">${category.id}</div>
		<h4>${category.description}</h4>
	</div>
	<div id="products">
	</div>
	<div class="form-actions">	
		<input name="add" id="btnAdd" value="associate" type="button" class="btn btn-large btn-primary" />
	</div>
	<div id="model" style="display: none">
		<label class="checkbox">
        	<input type="checkbox" /><span name="description">&nbsp;</span>
         </label>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/javascripts/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/javascripts/categories/edit.js"></script>	
</div>	