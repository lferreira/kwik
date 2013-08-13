<div class="container">
	<div class="row">
		<form id="product" class="form-horizontal" name="product">
			<div class="control-group">
             	<label for="email" class="control-label">Email *</label>
                <div class="controls">
                	<input type="text" class="input-xlarge" placeholder="" name="client.email" id="email">
             	</div>
             </div>				
			<div class="control-group">
             	<label for="password" class="control-label">Password *</label>
                <div class="controls">
                	<input type="password" class="input-xlarge" placeholder="" name="client.password" id="password">
             	</div>
             </div>
			<div class="control-group">
             	<label for="zipCode" class="control-label">Zip Code *</label>
                <div class="controls">
                	<input type="text" class="input-xlarge" placeholder="" name="client.address.zipCode" id="zipCode">
             	</div>
             </div>				 
			<div class="form-actions">
				<input name="add" id="btnAdd" value="add" type="button" class="btn btn-large btn-primary" />
			</div>
		</form>
	</div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/javascripts/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/javascripts/clients/clients.js"></script>