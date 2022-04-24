
var projectName = '中小学家校服务系统';
/**
 * 轮播图配置
 */
var swiper = {
	// 设定轮播容器宽度，支持像素和百分比
	width: '100%',
	height: '400px',
	// hover（悬停显示）
	// always（始终显示）
	// none（始终不显示）
	arrow: 'none',
	// default（左右切换）
	// updown（上下切换）
	// fade（渐隐渐显切换）
	anim: 'default',
	// 自动切换的时间间隔
	// 默认3000
	interval: 2000,
	// 指示器位置
	// inside（容器内部）
	// outside（容器外部）
	// none（不显示）
	indicator: 'outside'
}

/**
 * 个人中心菜单
 */
var centerMenu = [{
	name: '个人中心',
	url: '../' + localStorage.getItem('userTable') + '/center.html'
}, 
{
        name: '我的收藏',
        url: '../storeup/list.html'
}
]


var indexNav = [

{
	name: '学校公告',
	url: './pages/schoolNotice/list.html'
}, 
{
	name: '班级信息',
	url: './pages/clazz/list.html'
}, 
{
	name: '课程信息',
	url: './pages/course/list.html'
}, 
{
	name: '班级公告',
	url: './pages/clazzNotice/list.html'
}, 

]

var adminurl =  "http://localhost:8080/serverPlatform/admin/dist/index.html";

var cartFlag = false

var chatFlag = false




var menu = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-vipcard","buttons":["新增","查看","修改","删除","查看评论"],"menu":"学校公告","menuJump":"列表","tableName":"schoolNotice"}],"menu":"学校公告管理"},{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["新增","查看","修改","删除"],"menu":"家长","menuJump":"列表","tableName":"parent"}],"menu":"家长管理"},{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["新增","查看","修改","删除"],"menu":"教师","menuJump":"列表","tableName":"teacher"}],"menu":"教师管理"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["新增","查看","修改","删除"],"menu":"学生信息","menuJump":"列表","tableName":"student"}],"menu":"学生信息管理"},{"child":[{"appFrontIcon":"cuIcon-paint","buttons":["查看","删除"],"menu":"班干部","menuJump":"列表","tableName":"cadre"}],"menu":"班干部管理"},{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["新增","查看","修改","删除"],"menu":"班级信息","menuJump":"列表","tableName":"clazz"}],"menu":"班级信息管理"},{"child":[{"appFrontIcon":"cuIcon-explore","buttons":["新增","查看","修改","删除"],"menu":"课程信息","menuJump":"列表","tableName":"course"}],"menu":"课程信息管理"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看","删除"],"menu":"班级公告","menuJump":"列表","tableName":"clazzNotice"}],"menu":"班级公告管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["新增","查看","修改","删除","导出","导入"],"menu":"学生成绩","menuJump":"列表","tableName":"score"}],"menu":"学生成绩管理"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["新增","查看","修改","删除"],"menu":"成绩排名","menuJump":"列表","tableName":"scoreRank"}],"menu":"成绩排名管理"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看","修改","删除"],"menu":"轮播图管理","tableName":"config"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看"],"menu":"学校公告列表","menuJump":"列表","tableName":"schoolNotice"}],"menu":"学校公告模块"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看"],"menu":"班级信息列表","menuJump":"列表","tableName":"clazz"}],"menu":"班级信息模块"},{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看"],"menu":"课程信息列表","menuJump":"列表","tableName":"course"}],"menu":"课程信息模块"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["查看"],"menu":"班级公告列表","menuJump":"列表","tableName":"clazzNotice"}],"menu":"班级公告模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"user"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["查看"],"menu":"学生信息","menuJump":"列表","tableName":"student"}],"menu":"学生信息管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看"],"menu":"学生成绩","menuJump":"列表","tableName":"score"}],"menu":"学生成绩管理"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["查看"],"menu":"成绩排名","menuJump":"列表","tableName":"scoreRank"}],"menu":"成绩排名管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看"],"menu":"学校公告列表","menuJump":"列表","tableName":"schoolNotice"}],"menu":"学校公告模块"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看"],"menu":"班级信息列表","menuJump":"列表","tableName":"clazz"}],"menu":"班级信息模块"},{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看"],"menu":"课程信息列表","menuJump":"列表","tableName":"course"}],"menu":"课程信息模块"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["查看"],"menu":"班级公告列表","menuJump":"列表","tableName":"clazzNotice"}],"menu":"班级公告模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"家长","tableName":"parent"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["查看"],"menu":"家长","menuJump":"列表","tableName":"parent"}],"menu":"家长管理"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["查看"],"menu":"学生信息","menuJump":"列表","tableName":"student"}],"menu":"学生信息管理"},{"child":[{"appFrontIcon":"cuIcon-paint","buttons":["新增","查看","修改","删除"],"menu":"班干部","menuJump":"列表","tableName":"cadre"}],"menu":"班干部管理"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["新增","查看","修改","删除"],"menu":"班级公告","menuJump":"列表","tableName":"clazzNotice"}],"menu":"班级公告管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["新增","查看","修改","删除","导出","导入"],"menu":"学生成绩","menuJump":"列表","tableName":"score"}],"menu":"学生成绩管理"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["查看"],"menu":"成绩排名","menuJump":"列表","tableName":"scoreRank"}],"menu":"成绩排名管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看"],"menu":"学校公告列表","menuJump":"列表","tableName":"schoolNotice"}],"menu":"学校公告模块"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看"],"menu":"班级信息列表","menuJump":"列表","tableName":"clazz"}],"menu":"班级信息模块"},{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看"],"menu":"课程信息列表","menuJump":"列表","tableName":"course"}],"menu":"课程信息模块"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["查看"],"menu":"班级公告列表","menuJump":"列表","tableName":"clazzNotice"}],"menu":"班级公告模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"教师","tableName":"teacher"}]


var isAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].backMenu.length;j++){
                for(let k=0;k<menus[i].backMenu[j].child.length;k++){
                    if(tableName==menus[i].backMenu[j].child[k].tableName){
                        let buttons = menus[i].backMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}

var isFrontAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].frontMenu.length;j++){
                for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
                    if(tableName==menus[i].frontMenu[j].child[k].tableName){
                        let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}
