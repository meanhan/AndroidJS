
function login() {
  var username = document.getElementById("username");
   var pass = document.getElementById("password");

    if (username.value == "") {

        alert("请输入用户名");
        return null;
    } else if (pass.value  == "") {

         alert("请输入密码");
         return null;
    }else{
        return username.value + '-' + pass.value;
    }
}

function getUsername(){
    var username = document.getElementById("username");
    if (username.value == "") {
       alert("请输入用户名");
       return "";
    }else{
       return username.value;
    }
}

function getPassword(){
    var pass = document.getElementById("password");
    if (pass.value  == "") {
         alert("请输入密码");
         return "";
    }else{
        return pass.value;
    }
}

function showDialog(msg) {
    alert(msg);
}

