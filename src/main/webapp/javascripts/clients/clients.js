$(document).ready(function(){
	form.init();
});

var form = {

	init: function(config) {
		$('#btnAdd').focusout(function() {
			var zipCode = $('#zipCode').val();
			if (zipCode) {
				form.list(zipCode);
			}	
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
					alert(data.address.street);
				}
			}  
		}); 		
	}
}
