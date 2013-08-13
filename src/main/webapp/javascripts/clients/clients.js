$(document).ready(function(){
	form.init();
});

var form = {

	init: function(config) {
		$('#zipCode').blur(function() {
			var zipCode = $('#zipCode').val();
			if (zipCode) {
				form.list(zipCode);
			}	
		});
		$('#btnAdd').click(function(){
			form.add();
		});
	},
	list: function(zipCode) {
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
				form.list();
			}  
		});  
	},
	clear: function() {
		if ($('form')[0]) {
			$('form')[0].reset();
		}	
	}
}
