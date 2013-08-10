$(document).ready(function(){
	form.config = {
		'list':'/kwik/category/list',
		'add': '/kwik/category/add', 
		'clone': function(category, row) {
			$('td[name=description]', row).text(category.description);
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
	init: function(config) {
		form.list();
		$('#btnAdd').on('click', function() {
			form.add();
		});
	},
	list: function() {
		form.clear();
	    $.ajax({  
			type: 'GET',  
			url: form.config.list,  
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
		form.config.clone(category, row);
	}
}
