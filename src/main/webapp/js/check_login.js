var token=getCookie("TOKEN_KEY");
$(function(){
    $.ajax({
        url:"http://localhost:8080/user/token",
        type:'get',
        data:{
            token:token
        },dataType:"jsonp",
        success:function(data){
            if(parseInt(data.code)!=200){//登陆失败
                window.location="http://localhost:8080/loginPage"
            }else{
                UserInfoCallback(data.data);//回调函数，用户返回用户信息
            }
        }
    })
})
//获取cookie
function getCookie(cookieName){
    var cookieValue="";
    if (document.cookie && document.cookie != '') {
        var cookies = document.cookie.split(';');
        for (var i = 0; i < cookies.length; i++) {
            var cookie = cookies[i];
            if (cookie.substring(0, cookieName.length + 2).trim() == cookieName.trim() + "=") {
                cookieValue = cookie.substring(cookieName.length + 2, cookie.length);
                break;
            }
        }
    }
    return cookieValue;
}