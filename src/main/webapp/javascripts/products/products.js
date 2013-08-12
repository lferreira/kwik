$(document).ready(function(){
	form.config = {
		'list':'/kwik/product/list',
		'add': '/kwik/product/add', 
		'clone': function(product, row) {
			$('a[name=name]', row).text(product.name);
			$('img[name=image]', row).attr('src', product.image);
			$('small b[name=value]', row).text(product.value);
			$('small[name=description]', row).text(product.description);
		}
	};
	form.init();
});

var form = {

	config: {
		list: '',
		add: '',
		clone: function(){}
	},	
	init: function() {
		form.list();
		$('#btnAdd').on('click', function() {
			form.add();
		});
	},
	list: function() {
		form.clear();
	    $.ajax({  
			type: 'GET',  
			url:  form.config.list,   
			cache: false,  
			success: function( data ) { 
				if (data != null) {			
					form.row(data);
				}	
			}  
		}); 		
	},
	add: function() {
	    $.ajax({  
			type: 'POST',  
			url: form.config.add,  
			data: {  
				'product.name' : $('#name').val(),  
				'product.description' : $('#description').val(),  
				'product.value' : $('#value').val(),
				'product.image' : $('#image').val()
			},
			cache: false,  
			success: function( data ) {  
				form.list();
			}  
		});  
	},
	clear: function() {
		if ($('form')[0]) {
			$('form')[0].reset();
		}
		$('div#preview>ul').empty();
	},
	row: function(data) {
		$.each(data, function() {
			$.each(this, function(k, product) {
				form.clone(product);
			});
		});
	},
	clone: function(product) {
		var row = $('div#model-preview>ul>li').clone();
		$('div#preview>ul').append(row);
		form.config.clone(product, row);
	}
}
