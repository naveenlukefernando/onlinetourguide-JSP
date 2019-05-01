function deleteUserFunction(id) {
			
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


function deletePackageFunction(id) {

	var uid = id;

	var r = confirm("Are you sure ? ");
	if (r == true) {
		txt = "You pressed OK!";
		console.log(txt);
		document.location.href="DeletePackage?id="+uid+"&action=2";
		console.log(txt);

	} else {
		txt = "You pressed Cancel!";
		console.log(txt);
	}



}


function confirmBooking(id) {

	var uid = id;

	var r = confirm("Are you sure ? ");
	if (r == true) {
		txt = "You pressed OK!";
		console.log(txt);
		document.location.href="ConfirmBooking?id="+uid+"&confirm=3";
		console.log(txt);

	} else {
		txt = "You pressed Cancel!";
		console.log(txt);
	}



}


function declineBooking(id) {

	var uid = id;

	var r = confirm("Are you sure ? ");
	if (r == true) {
		txt = "You pressed OK!";
		console.log(txt);
		document.location.href="DeclineBooking?id="+uid+"&w=3";
		console.log(txt);

	} else {
		txt = "You pressed Cancel!";
		console.log(txt);
	}



}



function deleteBooking(id) {

	var uid = id;

	var r = confirm("Are you sure ? ");
	if (r == true) {
		txt = "You pressed OK!";
		console.log(txt);
		document.location.href="DeleteCurrentBooking?id="+uid+"&w=3";
		console.log(txt);

	} else {
		txt = "You pressed Cancel!";
		console.log(txt);
	}



}










