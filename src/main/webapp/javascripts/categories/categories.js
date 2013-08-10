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
		form.clear();
	    $.ajax({  
			type: 'GET',  
			url: '/kwik/category/list',  
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
			url: '/kwik/category/add',  
			data: {  
				'category.description' : $('#description').val(),  
			},
			cache: false,  
			success: function( data ) {  
				form.list();
			}  
		});  
	},
	row: function(data) {
		$.each(data, function() {
			$.each(this, function(k, category) {
				form.clone(category);
			});
		});
	},	
	clear: function() {
		if ($('form')[0]) {
			$('form')[0].reset();
		}	
		$('table#list tbody').empty();
	},
	clone: function(category) {
		var row = $('div#model table>tbody>tr').clone();
		$('table#list tbody').append(row);
		$('td[name=description]', row).text(category.description);
	}
}
