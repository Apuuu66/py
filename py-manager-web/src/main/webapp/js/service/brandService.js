app.service("brandService", function ($http) {
    this.findAll = function () {
        return $http.get('/brand/findAll');
    };

    this.findPage = function (page, size) {
        return $http.get("/brand/findPage?currPage=" + page + '&pageSize=' + size);
    };

    this.findOne = function (id) {
        return $http.get('/brand/findOne?id=' + id);
    };
    this.add = function (entity) {
        return $http.post('/brand/add', entity);
    };
    this.update = function (entity) {
        return $http.post('/brand/update', entity);
    };
    this.dele = function (ids) {
        return $http.get('/brand/delete?ids=' + ids);
    };
    this.search = function (page, size) {
        $http.post("/brand/search?currPage=" + page + '&pageSize=' + size, $scope.searcEntity);
    };
});