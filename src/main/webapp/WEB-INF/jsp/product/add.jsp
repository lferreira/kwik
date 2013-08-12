<div class="container">
	<div class="row">
		<form id="product" class="form-horizontal" name="product">
			<div class="control-group">
				<label class="control-label" for="name">Name *</label>
				<div class="controls">
					<input name="product.name" id="name" type="text" />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="description">Description *</label>
				<div class="controls">	
					<textarea name="product.description" rows="3" id="description"></textarea>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="value">Value *</label>					
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
		<div id="preview">
			<ul class="thumbnails">
			</ul>
		</div>	
		<div id="model-preview" style="display: none">
			<ul class="thumbnails">
				<li class="span5 clearfix">
					<div class="thumbnail clearfix">
						<img style="margin-right:10px" name="image" class="pull-left span2 clearfix" alt="ALT NAME" src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSUEele--weDNUa9RPXgnv6r7yc2TbTnQ9tsQ_XQTfO3BfVbQKh">
						<div class="caption">
							<h4>      
								<a href="#" name="name">&nbsp;</a>
							</h4>
							<small name="description">&nbsp;</small>
						</div>
						<div class="caption">
							<small>R$ <b name="value">&nbsp;</b></small>
						</div>						
					</div>
				</li>
 			</ul>
		</div>		
		<script type="text/javascript" src="${pageContext.request.contextPath}/javascripts/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/javascripts/products/products.js"></script>
	</div>
</div>