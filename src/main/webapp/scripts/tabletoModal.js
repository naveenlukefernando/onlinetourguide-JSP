$('#editUserModal').on('show.bs.modal', function (e) {
    // get information to update quickly to modal view as loading begins
    var opener = e.relatedTarget;//this holds the element who called the modal

    //we get details from attributes
    var firstname = $(opener).attr('first-name');
    var phone = $(opener).attr('phone');
    var email = $(opener).attr('email');
    var id = $(opener).attr('id');

    //set what we got to our form
    $('#profileForm').find('[name="firstname"]').val(firstname);
    $('#profileForm').find('[name="phone"]').val(phone);
    $('#profileForm').find('[name="email"]').val(email);
    $('#profileForm').find('[name="id"]').val(id);

    console.log(id);

});

