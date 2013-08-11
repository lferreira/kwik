<div class="container">
	<div class="row">
		<form id="category" class="form-horizontal well" name="category">
			<fieldset>
				<div class="control-group">
					<input name="category.description" id="description" type="text" />
					<input name="add" id="btnAdd" value="add" type="button" class="btn btn-primary btn-large nav pull-right" />
				</div>
			</fieldset>
		</form>
		<table id="list">
			<thead>
				<tr>
					<th>Description</th>
					<th></th>
				</tr>	
			</thead>
			<tbody>
			</tbody>
		</table>
		
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
