$(document).ready(function(){
	form.init();
});

var form = {

	init: function(config) {
		$('#zipCode').blur(function() {
			var zipCode = $('#zipCode').val();
			if (zipCode) {
				form.get_address(zipCode);
			}	
		});
		$('#btnAdd').click(function(){
			form.add();
		});
	},
	list: function() {
		$.ajax({  
			type: 'GET',  
			url: '/kwik/client/list',
			cache: false,  
			success: function( data ) {  
				if (data != null) {
					form.row(data);
				}
			}  
		}); 				
	},
	get_address: function(zipCode) {
	    $.ajax({  
			type: 'GET',  
			url: '/kwik/address/get',
			data: {  
				'zipCode' : zipCode,  
			},
			cache: false,  
			success: function( data ) {  
				if (data != null) {
					form.address(data);
				}
			}  
		}); 		
	},
	address: function(data) {
		$('#street').val(data.address.street);
		$('#location').val(data.address.location);
		$('#adressId').val(data.address.id);
	},
	add: function() {
	    $.ajax({  
			type: 'POST',  
			url: '/kwik/client/add',  
			data: {  
				'client.email' : $('#email').val(),
				'client.password' : $('#password').val(),
				'zipCode' : $('#zipCode').val(),
			},
			cache: false,  
			success: function( data ) {  
				alert('Success!');
			}  
		});  
	},
	clear: function() {
		if ($('form')[0]) {
			$('form')[0].reset();
		}	
	},
	row: function(data) {
		$.each(data, function() {
			$.each(this, function(k, category) {
				form.clone(category);
			});
		});
	},
	clone: function(row) {
		var row = $('div#model table>tbody>tr').clone();
		$('table#list tbody').append(row);
		$('td[name=id]', row).text(category.id);
		$('td[name=email]', row).text(category.email);		
	}
}
