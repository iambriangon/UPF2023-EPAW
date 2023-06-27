<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="imgs/upf.jpg">
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
        <title>Twitflix</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Inter:wght@100;200;300;400;500;600;700;800;900&display=swap">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <link rel="stylesheet" href="styles/styles.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <script type="text/javascript">
            $(document).ready(function(){
                //Avoids Internet Explorer caching!
                $.ajaxSetup({ cache: false });

                // Navigate between pages
                $(document).on("click",".nav-tag",function(event) {
                    $('#content').load($(this).attr('id'));
                    event.preventDefault();
                });

                // Load page when submit registration or log in
                $(document).on("submit","form", function(event) {
                    $('#content').load($(this).attr('action'),$(this).serialize());
                    event.preventDefault();
                });

                // Update User by Adming
                $(document).on("click", '#updateUserAdminTag', function (event){
                    var user_id = $('#user-id-admin');
                    var newEmail =$('#update-user-email-admin').val();
                    var newPhone =$('#update-user-phone-admin').val();
                    var newPassword =$('#update-user-pwd-admin').val();

                    if (user_id.val() === "") {
                        user_id[0].setCustomValidity("You must enter a user id in order to modify!");
                        user_id[0].reportValidity();
                    }
                    else {
                        $("#content").load("UpdateUserAdmin",  { userId: user_id.val(), email: newEmail, phone: newPhone, pwd: newPassword});
                    }
                    event.preventDefault();
                });

            });
        </script>
    </head>
    <body id="content">

    <!-- Main Content -->
    <jsp:include page="${content}"/>
    <!-- End Main Content -->


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </body>
</html>