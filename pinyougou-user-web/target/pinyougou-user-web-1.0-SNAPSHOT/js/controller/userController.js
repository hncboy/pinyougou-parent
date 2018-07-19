//控制层
app.controller('userController', function ($scope, $controller, userService) {

    //注册
    $scope.reg = function () {

        //比较两次输入的密码是否一致
        if ($scope.password != $scope.entity.password) {
            alert("两次输入密码不一致，请重新输入");
            scope.entity.password = "";
            scope.password = "";
            return;
        }

        userService.add($scope.entity, $scope.smscode).success(
            function (response) {
                alert(response.message);
            }
        )
    };

    //发送验证码
    $scope.sendCode = function () {

        if ($scope.entity.phone == null || $scope.entity.phone == "") {
            alert("请填写手机号");
            return;
        }

        userService.sendCode($scope.entity.phone).success(
            function (response) {
                sendMessage();
                alert(response.message);
            }
        )
    };

    var InterValObj; //timer变量，控制时间
    var count = 30; //间隔函数，1秒执行
    var curCount;//当前剩余秒数

    function sendMessage() {
        curCount = count;
        //设置button效果，开始计时
        $("#btnSendCode").attr("disabled", "true");
        $("#btnSendCode").val(curCount + "秒后可重新发送");
        InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次
    }

    //timer处理函数
    function SetRemainTime() {
        if (curCount == 0) {
            window.clearInterval(InterValObj);//停止计时器
            $("#btnSendCode").removeAttr("disabled");//启用按钮
            $("#btnSendCode").val("重新发送验证码");
        }
        else {
            curCount--;
            $("#btnSendCode").val(curCount + "秒后可重新发送");
        }
    }
});	
