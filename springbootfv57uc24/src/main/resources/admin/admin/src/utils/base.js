const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootfv57uc24/",
            name: "springbootfv57uc24",
            // 退出到首页链接
            indexUrl: ''
        };
    },
    getProjectName(){
        return {
            projectName: "公司部门业务审批管理系统"
        } 
    }
}
export default base
