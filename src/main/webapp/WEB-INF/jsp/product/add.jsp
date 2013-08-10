<form id="product" class="form-horizontal well" name="product">
	<fieldset>
		<div class="control-group">
			<input name="product.name" id="name" type="text" />
			<textarea name="product.description" rows="3" id="description"></textarea>
			<input name="product.value" id="value" type="text" />
			<input name="add" id="btnAdd" value="add" type="button" class="btn btn-primary btn-large nav pull-right" />
		</div>
	</fieldset>
</form>
<table id="list">
	<thead>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Value</th>
		<tr>	
	</thead>
	<tbody>
	</tbody>
</table>

<div id="model" style="display: none">
	<table>
		<tr>
			<td name="name">&nbsp;</td>
			<td name="description">&nbsp;</td>
			<td name="value">&nbsp;</td>
		</tr>	
	</table>	
</div>