<%-- 
    Document   : registration-form
    Created on : Oct 16, 2022, 6:32:39 PM
    Author     : gathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Form</title>
    </head>
    <script type="text/javascript">

        function addUser(event) {
//            $('#registerUser').click(function (e) {
//                e.preventDefault();
//                $.ajax({
//                    url: "http://localhost:8080/Registration-Application/users",
//                    type : "POST",
//                    data : {
//                        "firstName": $("#firstName").val(),
//                        "lastName": $("#lastName").val(),
//                        "username": $("#username").val(),
//                        "password": $("#password").val(),
//                        "middleName": $("#middleName").val(),
//                        "dateOfBirth": $("#dateOfBirth").val(),
//                        "date": $("#date").val(),
//                        "gender": $("#gender").val()
//                    }
//                    success: function(){
//                        console.log(data);
//                    }
//                })
//            });
//            console.log("run method");
//            let form = document.createElement('registerUser')
            console.log("send payload: ");
            console.log(event);
            const myFormData = new FormData(event.target);
            const data = Object.fromEntries(myFormData);
            console.log("payload: " + JSON.stringify(data));
            var url = "http://localhost:8080/Registration-Application/users";
            try {
                const response = fetch(url, {
                    method: 'POST',
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(data)
                }).then(res.json())
                        .then(res => {
                            // Handle response 
                            console.log('Response: ', res);
                        })
                        .catch(err => {
                            // Handle error 
                            console.log('Error message: ', error);
                        });
            } catch (err) {
                console.log(err);
            }
        }
    </script>
    <body>
        <form id="registerUser" class="registerUser" onsubmit="addUser(event)"><!-- action="#" method="post"  -->
            <label for="firstName">First name:</label><br>
            <input type="text" id="firstName" name="firstName"><br>
            <label for="lastName">Last name:</label><br>
            <input type="text" id="lastName" name="lastName"><br>
            <label for="username">Username:</label><br>
            <input type="text" id="username" name="username"><br>
            <label for="password">Password:</label><br>
            <input type="password" id="password" name="password"><br>
            <label for="middleName">Middle name:</label><br>
            <input type="text" id="middleName" name="middleName"><br>
            <label for="dateOfBirth">Date Of Birth</label><br>
            <input type="date" id="dateOfBirth" name="dateOfBirth"><br>
            <label for="gender">Gender</label><br>
            <select id="gender" name="gender">
                <option value = "Male">Male</option>
                <option value = "Female">Female</option>
            </select>
            <br><br><!-- comment -->
            <input type="submit" value="Submit" 
                   ><!--onclick="addUser()" -->
        </form>
    </body>
</html>
