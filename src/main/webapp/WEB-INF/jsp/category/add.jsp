<div class="container">
	<div class="row">
		<form id="category" class="form-horizontal well" name="category">
			<div class="control-group">
				<label class="control-label" for="description">Description</label>
				<div class="controls">
					<input name="category.description" id="description" type="text" />
				</div>
				<div class="form-actions">	
					<input name="add" id="btnAdd" value="add" type="button" class="btn btn-large btn-primary" />
				</div>
			</div>
		</form>
		<div class="well">
			<table class="table" id="list">
				<thead>
					<tr>
						<th>Description</th>
						<th>add products</th>
					</tr>	
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
		
		<div id="model" style="display: none">
			<table>
				<tr>
					<td name="description">&nbsp;</td>
					<td><a name="edit" class="btn" href="#"><i class="icon-resize-small"></i></a></td>
				</tr>	
			</table>	
		</div>
		<script type="text/javascript" src="${pageContext.request.contextPath}/javascripts/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/javascripts/categories/categories.js"></script>
	</div>
</div>
