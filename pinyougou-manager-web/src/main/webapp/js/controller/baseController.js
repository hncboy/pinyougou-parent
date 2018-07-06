app.controller("baseController", function ($scope) {

    //分页控件配置
    $scope.paginationConf = {
        currentPage: 1, //当前页
        totalItems: 10, //总记录数
        itemsPerPage: 10, //每页记录数
        perPageOptions: [10, 20, 30, 40, 50], //分页选项
        //当页码变更后自动触发的方法
        onChange: function () {
            $scope.reloadList();
        }
    };

    //刷新列表
    $scope.reloadList = function () {
        $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    };

    $scope.selectIds = []; //用户勾选的id集合
    //用户勾选复选框
    $scope.updateSelection = function ($event, id) {
        if ($event.target.checked) {
            $scope.selectIds.push(id);
        } else {
            var index = $scope.selectIds.indexOf(id); //查找值的位置
            $scope.selectIds.splice(index, 1); //参数1：移除的位置 参数2：移除的个数
        }
    };
});