function deleteFunction(id) {
			
			var uid = id;
			
			var r = confirm("Are you sure ? ");
			  if (r == true) {
			    txt = "You pressed OK!";
			    console.log(txt);
			    document.location.href="DeleteUser?id="+uid+"&action=2";
			    console.log(txt);
			    
			  } else {
			    txt = "You pressed Cancel!";
			    console.log(txt);
			  }
		
			
			
		}











