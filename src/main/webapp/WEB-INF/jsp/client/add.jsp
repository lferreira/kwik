<div class="container">
	<div class="row">
		<form id="product" class="form-horizontal" name="product">
			<div class="control-group">
             	<label for="email" class="control-label">Email *</label>
                <div class="controls">
                	<input type="text" class="input-xlarge" placeholder="your@email.com" name="client.email" id="email">
             	</div>
             </div>				
			<div class="control-group">
             	<label for="password" class="control-label">Password *</label>
                <div class="controls">
                	<input type="password" class="input-xlarge" placeholder="**********" name="client.password" id="password">
             	</div>
             </div>
			<div class="control-group">
             	<label for="zipCode" class="control-label">Zip Code *</label>
                <div class="controls">
                	<input type="text" class="input-xlarge" placeholder="zip code" id="zipCode">
             	</div>
             </div>
			 <div class="control-group">
             	<label class="control-label">Address Line</label>
            	<div class="controls">
                	<input type="text" class="input-xlarge" placeholder="address line" id="street">
                	<p class="help-block">Street address, P.O. box, company name, c/o</p>
            	</div>
        	</div>
			<div class="control-group">
            	<label class="control-label">State / Province / Region</label>
            	<div class="controls">
                	<input type="text" class="input-xlarge" placeholder="state / province / region" id="location">
                	<p class="help-block"></p>
            	</div>
        	</div>
			<input id="adressId" type="hidden" name="client.address.id">			
			<div class="form-actions">
				<input name="add" id="btnAdd" value="add" type="button" class="btn btn-large btn-primary" />
			</div>
		</form>
	</div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/javascripts/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/javascripts/clients/clients.js"></script>