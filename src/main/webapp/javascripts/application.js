$(document).ready(function(){
	form.init();
});

var form = {
	init: function() {
		form.list();
		$('#btnAdd').click(function() {
			form.add();
		});
	},
	list: function() {
	    $.ajax({  
			type: 'GET',  
			url: '/kwik/product/list',  
			cache: false,  
			success: function( data ) {  
				form.row(data);
			}  
		}); 		
	},
	add: function() {
	    $.ajax({  
			type: 'POST',  
			url: '/kwik/product/add',  
			data: {  
				'product.name' : $('#name').val(),  
				'product.description' : $('#description').val(),  
				'product.value' : $('#value').val()
			},
			cache: false,  
			success: function( data ) {  
				form.row(data);
			}  
		});  
	},
	clear: function() {
		$('form')[0].reset();
		$('table#list tbody').empty();
	},
	row: function(data) {
		form.clear();
		$.each(data, function() {
			$.each(this, function(k, product) {
				form.clone(product);
			});
		});
	},
	clone: function(product) {
		var row = $('div#model table>tbody>tr').clone();
		$('table#list tbody').append(row);
		$('td[name=name]', row).text(product.name);
		$('td[name=description]', row).text(product.description);
		$('td[name=value]', row).text(product.value);
	}
}
