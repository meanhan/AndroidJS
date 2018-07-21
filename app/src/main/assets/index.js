var androidVersion; // Android 版本
var phoneBrand; // 手机品牌
var phoneModel; // 手机型号
var sdkVersion; // SDK版本


var content = document.getElementsByClassName("dev_table")[0].children[0];

function showMsg() {

    content.children[0].children[1].innerText = phoneBrand;

    content.children[1].children[1].innerText = phoneModel;

    content.children[2].children[1].innerText = androidVersion;

    content.children[3].children[1].innerText = sdkVersion;

}

function getDevMsg() {
    var deviceMsg = window.android.getDeviceMsg();
    phoneBrand = deviceMsg.split("-")[0];
    phoneModel = deviceMsg.split("-")[1];
    androidVersion = deviceMsg.split("-")[2];
    sdkVersion = deviceMsg.split("-")[3];
    showMsg();
}

function showDialog(msg) {
    alert(msg);
}