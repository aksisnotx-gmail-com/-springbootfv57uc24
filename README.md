
# 任务分配

| METHOD | PATH             | 
|--------|------------------|
| POST   | renwufenpei/save |

**参数示例**
```json
{
  "id": 1,
  "renwumingcheng": "任务名称示例",
  "renwujianjie": "任务简介示例",
  "renwuxiangqing": "任务详情示例",
  "wanchengriqi": "2024-10-03",
  "yuangonggonghao": "员工工号示例",
  "yuangongxingming": "员工姓名示例",
  "bumen": "技术部门",
  "zhuguangonghao": "经理工号示例",
  "addtime": "2024-10-03 10:00:00"  
}

```

# 工作汇报

| METHOD | PATH             | 
|--------|------------------|
| POST   | gongzuohuibao/save |



**参数示例**
```json
{
  "id": 1,
  "renwumingcheng": "任务名称示例",
  "gongzuojindu": "工作进度示例",
  "gongzuowenjian": "工作文件示例",
  "huibaoxiangqing": "汇报详情示例",
  "zhuguangonghao": "经理工号示例",
  "yuangonggonghao": "员工工号示例",
  "yuangongxingming": "员工姓名示例",
  "huibaoshijian": "2024-10-03 10:00:00",
  "sfsh": "是否审核示例",
  "shhf": "审核回复示例",
  "addtime": "2024-10-03 10:00:00"
}

```

# 日程安排

| METHOD | PATH             | 
|--------|------------------|
| POST   | richenganpai/save |


**参数示例**

```json
{
  "id": 1,
  "renwumingcheng": "示例任务名称",
  "gongzuojindu": "示例工作进度",
  "gongzuowenjian": "示例工作文件",
  "huibaoxiangqing": "示例汇报详情",
  "zhuguangonghao": "示例经理工号",
  "yuangonggonghao": "示例员工工号",
  "yuangongxingming": "示例员工姓名",
  "huibaoshijian": "2024-10-03 10:00:00",
  "sfsh": "示例是否审核",
  "shhf": "示例审核回复",
  "addtime": "2024-10-03 10:00:00"
}

```

# 工作日志

| METHOD | PATH             | 
|--------|------------------|
| POST   | gongzuorizhi/save |

**参数示例**

```json
{
  "id": 1,
  "richengmingcheng": "示例日程名称",
  "gongzuorizhi": "示例工作日志",
  "zhuguangonghao": "示例经理工号",
  "yuangonggonghao": "示例员工工号",
  "yuangongxingming": "示例员工姓名",
  "dengjishijian": "2024-10-03 10:00:00",
  "crossuserid": 1001,
  "crossrefid": 2001,
  "addtime": "2024-10-03 10:00:00"
}
```

# 在线留言

| METHOD | PATH             | 
|--------|------------------|
| POST   | zaixianliuyan/save |


**参数示例**

```json
{
  "id": 1,
  "liuyanbiaoti": "示例留言标题",
  "liuyanxiangqing": "示例留言详情",
  "yuangonggonghao": "示例员工工号",
  "yuangongxingming": "示例员工姓名",
  "bumen": "示例部门",
  "zhuguangonghao": "示例经理工号",
  "liuyanshijian": "2024-10-03 10:00:00",
  "shhf": "示例回复内容",
  "addtime": "2024-10-03 10:00:00"
}
```

# 事务统计


| METHOD | PATH             | 
|--------|------------------|
| POST   |  |
