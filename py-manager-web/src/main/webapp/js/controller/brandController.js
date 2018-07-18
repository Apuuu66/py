app.controller('brandController', function ($scope, $controller, brandService) {

    $controller('baseController',{$scope:$scope});//继承

    $scope.findAll = function () {
        brandService.findAll().success(function (rtn) {
            $scope.list = rtn;
        });
    };
    $scope.searcEntity = {};

    $scope.findPage = function (page, size) {
        brandService.findPage(page, size).success(function (rtn) {
            $scope.list = rtn.rows;
            $scope.paginationConf.totalItems = rtn.total;
        });
    };
    // 新增
    $scope.save = function () {
        var object = null;
        if ($scope.entity.id != null) {
            object = brandService.update($scope.entity);
        } else {
            object = brandService.add($scope.entity)
        }
        object.success(function (rtn) {
            if (rtn.success) {
                $scope.reloadList();
            } else {
                alert(rtn.message);
            }
        });
    };
    $scope.findOne = function (id) {
        brandService.findOne(id).success(function (rtn) {
            $scope.entity = rtn;
        })
    };


    //批量删除
    $scope.dele = function () {
        //获取选中的复选框
        brandService.dele( $scope.selectIds).success(
            function (response) {
                if (response.success) {
                    $scope.reloadList();//刷新列表
                }
            }
        );
    };
    $scope.search = function (page, size) {
        brandService.search(page,size).success(function (rtn) {
            $scope.list = rtn.rows;
            $scope.paginationConf.totalItems = rtn.total;
        });
    };
});