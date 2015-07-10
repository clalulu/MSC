/**
* NapoXir Login.jsp
* @author: Sir Xiradorn
*/

/*** Funzioni di supporto del login.jsp */

// validazione username
function validateusername() {
    var bool = true;
    var value = $("#username").val();

    if(!value) {
        $("#usernameError").css("display", "");
        $("#usernameError").text("Valore vuoto non valido");
        bool=false;
    } else if (value.length < 3 || value.length > 20) {
        $("#usernameError").css("display", "");
        $("#usernameError").text("Valore non valido o non compreso tra 3 e 20");
        bool=false;
    }

    // ritorno il valore di controllo true/false
    return bool;
}

// Funzione di validazione password
function validatepassword() {
    var bool = true;
    $("#passwordError").css("display", "none");
    var value = $("#password").val();
    if(!value) {
        $("#passwordError").css("display", "");
        $("#passwordError").text("Valore vuoto non valido");
        bool = false;
    } else if (value.length < 3 || value.length > 20) {
        $("#passwordError").css("display", "");
        $("#passwordError").text("Valore non valido o non compreso tra 3 e 20");
        bool = false;
    }

    // Ritorno il valore di controllo true/false
    return bool;
}


// Funzione di controllo
function check() {
    var bool = true;
    $(".input").each(function() {
        var inputName = $(this).attr("name");
        if(!invokeValidateFunction(inputName)) {
            bool = false;
        }
    })

// Ritorno il valore di controllo true/false
return bool;
}
