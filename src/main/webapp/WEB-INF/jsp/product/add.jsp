<div class="container">
	<div class="row">
		<form id="product" class="form-horizontal" name="product">
			<div class="control-group">
				<label class="control-label" for="name">Name</label>
				<div class="controls">
					<input name="product.name" id="name" type="text" />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="description">Description</label>
				<div class="controls">	
					<textarea name="product.description" rows="3" id="description"></textarea>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="value">Value</label>					
				<div class="controls">
					<div class="input-prepend input-append">
						<span class="add-on">$</span><input name="product.value" id="value" type="text" size="6" /><span class="add-on">.00</span>
					</div>
				</div>
			</div>	
			<div class="control-group">
				<label class="control-label" for="image">Image</label>
				<div class="controls">	
					<input name="product.image" id="image" type="text" />
				</div>
			</div>									
			<div class="form-actions">
				<input name="add" id="btnAdd" value="add" type="button" class="btn btn-large btn-primary" />
			</div>
		</form>
		<div class="well">
			<table class="table" id="list">
				<thead>
					<tr>
						<th>Name</th>
						<th>Description</th>
						<th>Value</th>
					</tr>	
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
		<div id="model" style="display: none">
			<table>
				<tr>
					<td name="name">&nbsp;</td>
					<td name="description">&nbsp;</td>
					<td name="value">&nbsp;</td>
				</tr>	
			</table>	
		</div>
		<script type="text/javascript" src="${pageContext.request.contextPath}/javascripts/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/javascripts/products/products.js"></script>
	</div>
</div>