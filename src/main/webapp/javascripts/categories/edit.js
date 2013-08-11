$(document).ready(function(){
	form.init();
});

var form = {
	init: function() {
		form.list();
	},
	list: function() {
		form.clear();
	    $.ajax({  
			type: 'GET',  
			url:  '/kwik/product/list',   
			cache: false,  
			success: function( data ) { 
				if (data != null) {			
					form.row(data);
				}	
			}  
		}); 		
	},
	clear: function() {
		$('div#products').empty();
	},
	row: function(data) {
		$.each(data, function() {
			$.each(this, function(k, product) {
				form.clone(product);
			});
		});
	},
	clone: function(product) {
		var row = $('div#model label').clone();
		$('div#products').append(row);
		$('input[type="checkbox"]', row).val(product.id);
		$('span[name=description]', row).text(product.name);
	}
}
