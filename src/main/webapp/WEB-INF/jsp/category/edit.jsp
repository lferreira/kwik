<div class="container">
	<div class="row">
		<div id="id">${category.id}</div>
		<div id="description">${category.description}</div>
	</div>
	<div id="products">
	</div>
	<div class="form-actions">	
		<input name="add" id="btnAdd" value="associate" type="button" class="btn btn-primary btn-large nav pull-right" />
	</div>
	<div id="model" style="display: none">
		<label class="checkbox">
        	<input type="checkbox" /><span name="description">&nbsp;</span>
         </label>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/javascripts/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/javascripts/categories/edit.js"></script>	
</div>	