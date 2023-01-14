function hasLower(string){
    var lower = /[a-z]/;
    return lower.test(string);
 }
 
 function hasUpper(string){
    var upper = /[A-Z]/;
    return upper.test(string);
 }
 
 function hasNumber(string){
    return /\d/.test(string);
 }
 
 function hasSpecialChar(string){
    var specialChars = /[`!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/;
    return specialChars.test(string);
 }
 
 // Validate Account
 
 function validate(){
    var password = document.getElementById("password").value;
    var cpassword = document.getElementById("cpassword").value;
    var flag = false;
    var invString = "Your password is missing the following criteria:\n";

    if (password != cpassword) {
        alert("Password fields do not match");
        event.preventDefault();
        return;
    }
    if (password.length < 7) {
        invString += "  -Passwords must be at least 7 characters\n";
        flag = true;
    }
    if (!hasLower(password)) {
        invString += "  -Passwords must contain a lowercase letter\n";
        flag = true;
    }
    if (!hasUpper(password)) {
        invString += "  -Passwords must contain an uppercase letter\n";
        flag = true;
    }
    if (!hasNumber(password)) {
        invString += "  -Passwords must contain a number\n";
        flag = true;
    }
    if (!hasSpecialChar(password)) {
        invString += "  -Passwords must contain a special character\n";
        flag = true;
    }

    if(flag){
        alert(invString);
        event.preventDefault();
        flag = false;
    }
 }
 
 