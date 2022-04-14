const base = {
    get() {
        return {
            url : "http://localhost:8080/serverPlatform/",
            name: "serverPlatform",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/serverPlatform/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "中小学家校服务系统设计与实现"
        } 
    }
}
export default base
