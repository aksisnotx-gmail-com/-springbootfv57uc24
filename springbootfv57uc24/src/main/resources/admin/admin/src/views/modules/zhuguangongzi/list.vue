<template>
	<div class="main-content" :style='{"minHeight":"calc(100vh - 200px)","padding":"20px","margin":"0 auto","color":"#666","background":"#f5f5f5","width":"calc(100% - 60px)","fontSize":"14px","height":"100%"}'>
		<!-- 列表页 -->
		<template v-if="showFlag">
			<el-form class="center-form-pv" :style='{"border":"0px solid rgba(0, 0, 0, 0.05)","padding":"20px 20px","margin":"0px","overflow":"hidden","borderRadius":"4px 4px 0 0","flexWrap":"wrap","background":"linear-gradient(323deg, rgba(221,221,221,.5) 0%, rgba(255,255,255,.5) 70%, rgba(221,221,221,.5) 100%),url(http://codegen.caihongy.cn/20230809/02ecb2d595ed42a2b0e8af76771b2f48.gif)","display":"flex","fontSize":"inherit"}' :inline="true" :model="searchForm">
				<el-row :style='{"padding":"0px","boxShadow":"0 0px 0px 0px rgba(115,108,203,.23)","margin":"0 0px 0px 0","borderRadius":"0px","alignItems":"center","color":"#333","textAlign":"left","background":"none","display":"flex","width":"auto","fontSize":"inherit","order":"2"}' >
					<div :style='{"margin":"0 10px 0 0","fontSize":"inherit","display":"inline-block"}' class="select" label="工资月份" prop="gongziyuefen">
						<label :style='{"margin":"0 10px 0 0","color":"inherit","display":"inline-block","lineHeight":"40px","fontSize":"inherit","fontWeight":"500","height":"40px"}' class="item-label">工资月份</label>
						<el-select clearable v-model="searchForm.gongziyuefen" placeholder="请选择工资月份" >
							<el-option v-for="(item,index) in gongziyuefenOptions" v-bind:key="index" :label="item" :value="item"></el-option>
						</el-select>
					</div>
					<div :style='{"margin":"0 10px 0 0","fontSize":"inherit","display":"inline-block"}'>
						<label :style='{"margin":"0 10px 0 0","color":"inherit","display":"inline-block","lineHeight":"40px","fontSize":"inherit","fontWeight":"500","height":"40px"}' class="item-label">技术部门经理工号</label>
						<el-input v-model="searchForm.zhuguangonghao" placeholder="技术部门经理工号" @keydown.enter.native="search()" clearable></el-input>
					</div>
					<div :style='{"margin":"0 10px 0 0","fontSize":"inherit","display":"inline-block"}'>
						<label :style='{"margin":"0 10px 0 0","color":"inherit","display":"inline-block","lineHeight":"40px","fontSize":"inherit","fontWeight":"500","height":"40px"}' class="item-label">部门</label>
						<el-input v-model="searchForm.bumen" placeholder="部门" @keydown.enter.native="search()" clearable></el-input>
					</div>
					<el-button class="search" type="success" @click="search()">
						<span class="icon iconfont icon-chakan18" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","height":"auto"}'></span>
						查询
					</el-button>
				</el-row>

				<el-row class="actions" :style='{"boxShadow":"0 0px 0px 0px rgba(115,108,203,.23)","padding":"0px","margin":"0px 0 0px","color":"#fff","alignItems":"center","textAlign":"left","display":"flex","borderRadius":"0px","flexWrap":"wrap","background":"none","flex":"1","width":"100%","fontSize":"inherit","order":"1"}'>
					<el-button class="add" v-if="isAuth('zhuguangongzi','新增')" type="success" @click="addOrUpdateHandler()">
						<span class="icon iconfont icon-tianjia10" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"inline-block"}'></span>
						新增
					</el-button>
					<el-button class="del" v-if="isAuth('zhuguangongzi','删除')" :disabled="dataListSelections.length?false:true" type="danger" @click="deleteHandler()">
						<span class="icon iconfont icon-shanchu10" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"inline-block"}'></span>
						删除
					</el-button>


					<download-excel v-if="isAuth('zhuguangongzi','导出')" class="export-excel-wrapper" :data = "dataList" :fields = "json_fields" name = "技术部门经理工资.xls">
						<!-- 导出excel -->
						<el-button class="btn18" type="success" @click="importHandler()">
							<span class="icon iconfont icon-daochu1" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"inline-block"}'></span>
							导出
						</el-button>
					</download-excel>
					<el-button class="btn18" v-if="isAuth('zhuguangongzi','打印')" type="success" @click="printJson()">
						<span class="icon iconfont icon-dayin6" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"inline-block"}'></span>
						打印
					</el-button>


				</el-row>
			</el-form>
			<div :style='{"padding":"20px","boxShadow":"0 2px 3px 0px rgba(100,100,100,.05)","borderColor":"rgba(252,234,238,1)","margin":"0 0 0px","borderRadius":"0px","background":"url(http://codegen.caihongy.cn/20230809/02ecb2d595ed42a2b0e8af76771b2f48.gif)","borderWidth":"0px","width":"100%","borderStyle":"solid"}'>
				<el-table class="tables"
					:stripe='true'
					:style='{"padding":"0","borderColor":"#eee","color":"inherit","borderRadius":"0px","borderWidth":"1px 0px 0 1px","background":"none","width":"100%","fontSize":"inherit","borderStyle":"solid"}'
					:border='false'
					v-if="isAuth('zhuguangongzi','查看')"
					:data="dataList"
					v-loading="dataListLoading"
				@selection-change="selectionChangeHandler">
					<el-table-column :resizable='true' type="selection" align="center" width="50"></el-table-column>
					<el-table-column :resizable='true' :sortable='true' label="序号" type="index" width="50" />
					<el-table-column :resizable='true' :sortable='true'
						prop="gongziyuefen"
						label="工资月份">
						<template slot-scope="scope">
							{{scope.row.gongziyuefen}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'
						prop="zhuguangonghao"
						label="技术部门经理工号">
						<template slot-scope="scope">
							{{scope.row.zhuguangonghao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'
						prop="zhuguanxingming"
						label="技术部门经理姓名">
						<template slot-scope="scope">
							{{scope.row.zhuguanxingming}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'
						prop="bumen"
						label="部门">
						<template slot-scope="scope">
							{{scope.row.bumen}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'
						prop="jibengongzi"
						label="基本工资">
						<template slot-scope="scope">
							{{scope.row.jibengongzi}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'
						prop="jixiaogongzi"
						label="绩效工资">
						<template slot-scope="scope">
							{{scope.row.jixiaogongzi}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'
						prop="jiabangongzi"
						label="加班工资">
						<template slot-scope="scope">
							{{scope.row.jiabangongzi}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'
						prop="geshui"
						label="个税">
						<template slot-scope="scope">
							{{scope.row.geshui}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'
						prop="shebaodaijiao"
						label="社保代缴">
						<template slot-scope="scope">
							{{scope.row.shebaodaijiao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'
						prop="jiangli"
						label="奖励">
						<template slot-scope="scope">
							{{scope.row.jiangli}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'
						prop="fakuan"
						label="罚款">
						<template slot-scope="scope">
							{{scope.row.fakuan}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'
						prop="jiangchengshuoming"
						label="奖惩说明">
						<template slot-scope="scope">
							{{scope.row.jiangchengshuoming}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'
						prop="shifagongzi"
						label="实发工资">
						<template slot-scope="scope">
							{{scope.row.shifagongzi}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'
						prop="lurushijian"
						label="录入时间">
						<template slot-scope="scope">
							{{scope.row.lurushijian}}
						</template>
					</el-table-column>
					<el-table-column width="300" label="操作">
						<template slot-scope="scope">
							<el-button class="view" v-if=" isAuth('zhuguangongzi','查看')" type="success" @click="addOrUpdateHandler(scope.row.id,'info')">
								<span class="icon iconfont icon-chakan2" :style='{"margin":"0 0 0 4px","fontSize":"14px","color":"inherit","height":"auto"}'></span>
								详情
							</el-button>
							<el-button class="edit" v-if=" isAuth('zhuguangongzi','修改') " type="success" @click="addOrUpdateHandler(scope.row.id)">
								<span class="icon iconfont icon-xiugai17" :style='{"margin":"0 0 0 4px","fontSize":"14px","color":"inherit","height":"auto"}'></span>
								更改
							</el-button>




							<el-button class="del" v-if="isAuth('zhuguangongzi','删除') " type="primary" @click="deleteHandler(scope.row.id )">
								<span class="icon iconfont icon-shanchu16" :style='{"margin":"0 0 0 4px","fontSize":"inherit","color":"inherit","height":"auto"}'></span>
								移除
							</el-button>
						</template>
					</el-table-column>
				</el-table>
			</div>
			<el-pagination
				@size-change="sizeChangeHandle"
				@current-change="currentChangeHandle"
				:current-page="pageIndex"
				background
				:page-sizes="[10, 20, 30, 50]"
				:page-size="pageSize"
				:layout="layouts.join()"
				:total="totalPage"
				prev-text="上一页 "
				next-text="下一页 "
				:hide-on-single-page="false"
				:style='{"padding":"12px 0","boxShadow":"0 2px 3px 0px rgba(100,100,100,.05)","margin":"0px 0 0","whiteSpace":"nowrap","color":"inherit","borderRadius":"0 0 4px 4px","textAlign":"center","background":"#fff","width":"100%","fontSize":"inherit","fontWeight":"500"}'
			></el-pagination>
		</template>

		<!-- 添加/修改页面  将父组件的search方法传递给子组件-->
		<add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>





	</div>
</template>

<script>
import axios from 'axios'
import AddOrUpdate from "./add-or-update";
	export default {
		data() {
			return {
				gongziyuefenOptions: [],
				searchForm: {
					key: ""
				},
				form:{},
				dataList: [],
				pageIndex: 1,
				pageSize: 10,
				totalPage: 0,
				dataListLoading: false,
				dataListSelections: [],
				showFlag: true,
				sfshVisiable: false,
				shForm: {},
				chartVisiable: false,
				chartVisiable1: false,
				chartVisiable2: false,
				chartVisiable3: false,
				chartVisiable4: false,
				chartVisiable5: false,
				addOrUpdateFlag:false,
				layouts: ["total","prev","pager","next","sizes","jumper"],
//导出excel
				json_fields: {
					"工资月份": "gongziyuefen",    //常规字段
					"技术部门经理工号": "zhuguangonghao",    //常规字段
					"技术部门经理姓名": "zhuguanxingming",    //常规字段
					"部门": "bumen",    //常规字段
					"基本工资": "jibengongzi",    //常规字段
					"绩效工资": "jixiaogongzi",    //常规字段
					"加班工资": "jiabangongzi",    //常规字段
					"个税": "geshui",    //常规字段
					"社保代缴": "shebaodaijiao",    //常规字段
					"奖励": "jiangli",    //常规字段
					"罚款": "fakuan",    //常规字段
					"奖惩说明": "jiangchengshuoming",    //常规字段
					"实发工资": "shifagongzi",    //常规字段
					"录入时间": "lurushijian",    //常规字段
				},
				json_meta: [
					[
						{
							" key ": " charset ",
							" value ": " utf- 8 "
						}
					]
				],
			};
		},
		created() {
			this.init();
			this.getDataList();
			this.contentStyleChange()
		},
		mounted() {
		},
		filters: {
			htmlfilter: function (val) {
				return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
			}
		},
		components: {
			AddOrUpdate,
		},
		methods: {

			contentStyleChange() {
				this.contentPageStyleChange()
			},
			// 分页
			contentPageStyleChange(){
				let arr = []

				// if(this.contents.pageTotal) arr.push('total')
				// if(this.contents.pageSizes) arr.push('sizes')
				// if(this.contents.pagePrevNext){
				//   arr.push('prev')
				//   if(this.contents.pagePager) arr.push('pager')
				//   arr.push('next')
				// }
				// if(this.contents.pageJumper) arr.push('jumper')
				// this.layouts = arr.join()
				// this.contents.pageEachNum = 10
			},






    init () {
          this.gongziyuefenOptions = "1月份,2月份,3月份,4月份,5月份,6月份,7月份,8月份,9月份,10月份,11月份,12月份".split(',')
    },
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },

    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: 'id',
        order: 'desc',
      }
           if(this.searchForm.gongziyuefen!='' && this.searchForm.gongziyuefen!=undefined){
            params['gongziyuefen'] = this.searchForm.gongziyuefen
          }
           if(this.searchForm.zhuguangonghao!='' && this.searchForm.zhuguangonghao!=undefined){
            params['zhuguangonghao'] = '%' + this.searchForm.zhuguangonghao + '%'
          }
           if(this.searchForm.bumen!='' && this.searchForm.bumen!=undefined){
            params['bumen'] = '%' + this.searchForm.bumen + '%'
          }
    params['sort'] = 'lurushijian';
    params['order'] = 'desc';
      this.$http({
        url: "zhuguangongzi/page",
        method: "get",
        params: params
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.dataList = data.data.list;
          this.totalPage = data.data.total;
        } else {
          this.dataList = [];
          this.totalPage = 0;
        }
        this.dataListLoading = false;
      });
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // 添加/修改
    addOrUpdateHandler(id,type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if(type!='info'){
        type = 'else';
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id,type);
      });
    },
    // 下载
    download(file){
      let arr = file.replace(new RegExp('upload/', "g"), "")
      axios.get(this.$base.url + 'file/download?fileName=' + arr, {
      	headers: {
      		token: this.$storage.get('Token')
      	},
      	responseType: "blob"
      }).then(({
      	data
      }) => {
      	const binaryData = [];
      	binaryData.push(data);
      	const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
      		type: 'application/pdf;chartset=UTF-8'
      	}))
      	const a = document.createElement('a')
      	a.href = objectUrl
      	a.download = arr
      	// a.click()
      	// 下面这个写法兼容火狐
      	a.dispatchEvent(new MouseEvent('click', {
      		bubbles: true,
      		cancelable: true,
      		view: window
      	}))
      	window.URL.revokeObjectURL(data)
      },err=>{
		  axios.get((location.href.split(this.$base.name).length>1 ? location.href.split(this.$base.name)[0] :'') + this.$base.name + '/file/download?fileName=' + arr, {
		  	headers: {
		  		token: this.$storage.get('Token')
		  	},
		  	responseType: "blob"
		  }).then(({
		  	data
		  }) => {
		  	const binaryData = [];
		  	binaryData.push(data);
		  	const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
		  		type: 'application/pdf;chartset=UTF-8'
		  	}))
		  	const a = document.createElement('a')
		  	a.href = objectUrl
		  	a.download = arr
		  	// a.click()
		  	// 下面这个写法兼容火狐
		  	a.dispatchEvent(new MouseEvent('click', {
		  		bubbles: true,
		  		cancelable: true,
		  		view: window
		  	}))
		  	window.URL.revokeObjectURL(data)
		  })
	  })
    },
	// 预览
	preClick(file){
		if(!file){
			return false
		}
		window.open((location.href.split(this.$base.name).length>1 ? location.href.split(this.$base.name)[0] :'') + this.$base.name + '/' + file)
	},
	zhuguangongzistatusChange(e,row){
		if(row.status==0){
			row.passwordwrongnum = 0
		}
		this.$http({
			url:'zhuguangongzi/update',
			method:'post',
			data:row
		}).then(res=>{
			if(row.status==1){
				this.$message.error('该用户已锁定')
			}else{
				this.$message.success('该用户已解除锁定')
			}
		})
	},
    // 删除
    deleteHandler(id ) {
      var ids = id
        ? [Number(id)]
        : this.dataListSelections.map(item => {
            return Number(item.id);
          });
      this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "zhuguangongzi/delete",
          method: "post",
          data: ids
        }).then(({ data }) => {
          if (data && data.code === 0) {
			this.$message({
			  message: "操作成功",
			  type: "success",
			  duration: 1500,
			  onClose: () => {
			    this.search();
			  }
			});

          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },


    async printJson() {
      //通过getdata调用后台接口获取数据封装到res
      this.list = this.dataList;
      let data = []
      for (let i=0; i < this.list.length; i++) {
          data.push({
          gongziyuefen: this.list[i].gongziyuefen,
          zhuguangonghao: this.list[i].zhuguangonghao,
          zhuguanxingming: this.list[i].zhuguanxingming,
          bumen: this.list[i].bumen,
          jibengongzi: this.list[i].jibengongzi,
          jixiaogongzi: this.list[i].jixiaogongzi,
          jiabangongzi: this.list[i].jiabangongzi,
          geshui: this.list[i].geshui,
          shebaodaijiao: this.list[i].shebaodaijiao,
          jiangli: this.list[i].jiangli,
          fakuan: this.list[i].fakuan,
          jiangchengshuoming: this.list[i].jiangchengshuoming,
          shifagongzi: this.list[i].shifagongzi,
          lurushijian: this.list[i].lurushijian,
        })
      }
      printJS({
        printable: data,
        properties: [
	  {
		field: 'gongziyuefen',
		displayName: '工资月份',
		columnSize: 1
	  },
	  {
		field: 'zhuguangonghao',
		displayName: '技术部门经理工号',
		columnSize: 1
	  },
	  {
		field: 'zhuguanxingming',
		displayName: '技术部门经理姓名',
		columnSize: 1
	  },
	  {
		field: 'bumen',
		displayName: '部门',
		columnSize: 1
	  },
	  {
		field: 'jibengongzi',
		displayName: '基本工资',
		columnSize: 1
	  },
	  {
		field: 'jixiaogongzi',
		displayName: '绩效工资',
		columnSize: 1
	  },
	  {
		field: 'jiabangongzi',
		displayName: '加班工资',
		columnSize: 1
	  },
	  {
		field: 'geshui',
		displayName: '个税',
		columnSize: 1
	  },
	  {
		field: 'shebaodaijiao',
		displayName: '社保代缴',
		columnSize: 1
	  },
	  {
		field: 'jiangli',
		displayName: '奖励',
		columnSize: 1
	  },
	  {
		field: 'fakuan',
		displayName: '罚款',
		columnSize: 1
	  },
	  {
		field: 'jiangchengshuoming',
		displayName: '奖惩说明',
		columnSize: 1
	  },
	  {
		field: 'shifagongzi',
		displayName: '实发工资',
		columnSize: 1
	  },
	  {
		field: 'lurushijian',
		displayName: '录入时间',
		columnSize: 1
	  },
        ],
        type: 'json',
        header: '技术部门经理工资',
        // 样式设置
        gridStyle: 'border: 2px solid #3971A5;',
        gridHeaderStyle: 'color: red;  border: 2px solid #3971A5;'
      })
    },
  }

};
</script>
<style lang="scss" scoped>
	//导出excel
	.export-excel-wrapper{
		display: inline-block;
	}

	.center-form-pv {
	  .el-date-editor.el-input {
	    width: auto;
	  }
	}

	.el-input {
	  width: auto;
	}

	// form
	.center-form-pv .el-input /deep/ .el-input__inner {
				border: 1px solid #eee;
				border-radius: 3px;
				padding: 0 12px;
				outline: none;
				color: #333;
				background: #fff;
				width: 170px;
				font-size: inherit;
				height: 40px;
			}

	.center-form-pv .el-select /deep/ .el-input__inner {
				border: 1px solid #eee;
				border-radius: 3px;
				padding: 0 10px;
				box-shadow: 0 0 0px rgba(64, 158, 255, .5);
				outline: none;
				color: #333;
				background: #fff;
				width: 170px;
				font-size: inherit;
				height: 40px;
			}

	.center-form-pv .el-date-editor /deep/ .el-input__inner {
				border: 1px solid #eee;
				border-radius: 3px;
				padding: 0 10px 0 30px;
				box-shadow: 0 0 0px rgba(64, 158, 255, .5);
				outline: none;
				color: #333;
				background: #fff;
				width: 170px;
				font-size: inherit;
				height: 40px;
			}

	.center-form-pv .search {
				border: 0;
				cursor: pointer;
				border-radius: 3px;
				padding: 0 12px 0 8px;
				outline: none;
				color: #fff;
				background: #428bca;
				width: auto;
				font-size: inherit;
				height: 40px;
			}

	.center-form-pv .search:hover {
				opacity: 0.8;
			}

	.center-form-pv .actions .add {
				border: 0px solid rgba(244,100,130,.3);
				cursor: pointer;
				border-radius: 4px;
				padding: 0 10px 0 10px;
				margin: 4px 2px 2px;
				outline: none;
				color: inherit;
				background: #428bca;
				width: auto;
				font-size: inherit;
				min-width: 66px;
				height: 36px;
			}

	.center-form-pv .actions .add:hover {
				opacity: 0.8;
			}

	.center-form-pv .actions .del {
				border: 0px solid rgba(244,100,130,.3);
				cursor: pointer;
				padding: 0 10px 0 10px;
				margin: 4px 2px 2px;
				color: inherit;
				font-size: inherit;
				border-radius: 3px;
				box-shadow: inset 0px 0px 12px 0px rgba(244,100,130,.3);
				outline: none;
				background: #d9534f;
				width: auto;
				min-width: 66px;
				height: 36px;
			}

	.center-form-pv .actions .del:hover {
				opacity: 0.8;
			}

	.center-form-pv .actions .statis {
				border: 0px solid rgba(244,100,130,.3);
				cursor: pointer;
				padding: 0 10px 0 10px;
				margin: 4px 2px 2px;
				color: inherit;
				font-size: inherit;
				border-radius: 3px;
				box-shadow: inset 0px 0px 0px 0px rgba(244,100,130,.3);
				outline: none;
				background: #45B6B0;
				width: auto;
				min-width: 66px;
				height: 36px;
			}

	.center-form-pv .actions .statis:hover {
				opacity: 0.8;
			}

	.center-form-pv .actions .btn18 {
				border: 0px solid rgba(244,100,130,.3);
				cursor: pointer;
				border-radius: 4px;
				padding: 0 10px 0 10px;
				margin: 4px 2px 2px;
				outline: none;
				color: inherit;
				background: #A8BDCF;
				width: auto;
				font-size: inherit;
				min-width: 66px;
				height: 36px;
			}

	.center-form-pv .actions .btn18:hover {
				opacity: 0.8;
			}

	// table
	.el-table /deep/ .el-table__header-wrapper thead {
				color: inherit;
				background: rgba(254,169,34,0);
				width: 100%;
			}

	.el-table /deep/ .el-table__header-wrapper thead tr {
				background: none;
			}

	.el-table /deep/ .el-table__header-wrapper thead tr th {
				padding: 6px 0;
				background: #fff;
				border-color: #eee;
				border-width: 0 1px 4px 0;
				border-style: solid;
				text-align: left;
			}

	.el-table /deep/ .el-table__header-wrapper thead tr th .cell {
				padding: 0 10px;
				word-wrap: normal;
				word-break: break-all;
				white-space: normal;
				font-weight: 500;
				display: inline-block;
				vertical-align: middle;
				width: 100%;
				line-height: 24px;
				position: relative;
				text-overflow: ellipsis;
			}


	.el-table /deep/ .el-table__body-wrapper tbody {
				padding: 0;
				width: 100%;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr {
				background: none;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 5px 0 0;
				color: inherit;
				background: #fff;
				font-size: inherit;
				border-color: #eee;
				border-width: 0 1px 1px 0px;
				border-style: solid;
				text-align: left;
			}

		.el-table /deep/ .el-table__body-wrapper tbody tr.el-table__row--striped td {
		background: #f9f9f9;
	}

	.el-table /deep/ .el-table__body-wrapper tbody tr:hover td {
				padding: 5px 0 0;
				color: #666;
				border-color: #eee;
				border-width: 0 1px 1px 0px;
				border-style: solid;
				text-align: left;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 5px 0 0;
				color: inherit;
				background: #fff;
				font-size: inherit;
				border-color: #eee;
				border-width: 0 1px 1px 0px;
				border-style: solid;
				text-align: left;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td .cell {
				padding: 0 10px;
				overflow: hidden;
				color: inherit;
				word-break: break-all;
				white-space: normal;
				line-height: 24px;
				text-overflow: ellipsis;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td .view {
				cursor: pointer;
				padding: 0 6px 0 0px;
				margin: 0 2px 5px 0;
				color: #fff;
				font-size: 13px;
				border-color: rgba(244,111,139,.3);
				line-height: 24px;
				border-radius: 4px;
				box-shadow: inset 0px 0px 0px 0px rgba(244,100,130,.3);
				outline: none;
				background: #428bca;
				width: auto;
				border-width: 0px;
				border-style: solid;
				min-width: 40px;
				height: 24px;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td .view:hover {
				opacity: 0.8;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td .add {
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td .add:hover {
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td .edit {
				cursor: pointer;
				padding: 0 6px 0 0px;
				margin: 0 2px 5px 0;
				color: #fff;
				font-size: 13px;
				border-color: rgba(244,111,139,.3);
				line-height: 24px;
				border-radius: 4px;
				box-shadow: inset 0px 0px 0px 0px rgba(244,100,130,.3);
				outline: none;
				background: #45B6B0;
				width: auto;
				border-width: 0px;
				border-style: solid;
				min-width: 40px;
				height: 24px;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td .edit:hover {
				opacity: 0.8;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td .del {
				cursor: pointer;
				padding: 0 6px 0 0px;
				margin: 0 2px 5px 0;
				color: #fff;
				font-size: 13px;
				border-color: rgba(244,111,139,.3);
				line-height: 24px;
				border-radius: 4px;
				box-shadow: inset 0px 0px 0px 0px rgba(244,100,130,.3);
				outline: none;
				background: #d9534f;
				width: auto;
				border-width: 0px;
				border-style: solid;
				min-width: 40px;
				height: 24px;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td .del:hover {
				opacity: 0.8;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td .btn8 {
				cursor: pointer;
				padding: 0 6px 0 0px;
				margin: 0 2px 5px 0;
				color: #fff;
				font-size: 14px;
				border-color: rgba(244,111,139,.3);
				line-height: 24px;
				border-radius: 4px;
				box-shadow: inset 0px 0px 0px 0px rgba(244,100,130,.3);
				outline: none;
				background: #A8BDCF;
				width: auto;
				border-width: 0px;
				border-style: solid;
				min-width: 40px;
				height: 24px;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td .btn8:hover {
				opacity: 0.8;
			}

	// pagination
	.main-content .el-pagination /deep/ .el-pagination__total {
				margin: 0 10px 0 0;
				color: inherit;
				font-weight: 400;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 28px;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .btn-prev {
				border: none;
				border-radius: 2px;
				padding: 0 5px;
				margin: 0 5px;
				color: inherit;
				background: none;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 28px;
				min-width: 35px;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .btn-next {
				border: none;
				border-radius: 2px;
				padding: 0 5px;
				margin: 0 5px;
				color: inherit;
				background: none;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 28px;
				min-width: 35px;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .btn-prev:disabled {
				border: none;
				cursor: not-allowed;
				border-radius: 2px;
				padding: 0 5px;
				margin: 0 5px;
				color: #999;
				background: none;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 28px;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .btn-next:disabled {
				border: none;
				cursor: not-allowed;
				border-radius: 2px;
				padding: 0 5px;
				margin: 0 5px;
				color: #999;
				background: none;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 28px;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .el-pager {
				padding: 0;
				margin: 0;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
			}

	.main-content .el-pagination /deep/ .el-pager .number {
				cursor: pointer;
				padding: 0 4px;
				margin: 0 5px;
				color: inherit;
				background: none;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 24px;
				text-align: center;
				height: 24px;
			}

	.main-content .el-pagination /deep/ .el-pager .number:hover {
				cursor: pointer;
				border-radius: 3px;
				padding: 0 4px;
				margin: 0 5px;
				color: #fff;
				background: #34bfa3;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: auto;
				text-align: center;
				height: 24px;
			}

	.main-content .el-pagination /deep/ .el-pager .number.active {
				cursor: default;
				border-radius: 3px;
				padding: 0 4px;
				margin: 0 5px;
				color: #fff;
				background: #34bfa3;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: auto;
				text-align: center;
				height: 24px;
			}

	.main-content .el-pagination /deep/ .el-pagination__sizes {
				color: inherit;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 28px;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input {
				margin: 0 5px;
				color: inherit;
				width: 100px;
				font-size: inherit;
				position: relative;
			}

	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
				border: 0px solid #ddd;
				cursor: pointer;
				padding: 0 25px 0 8px;
				color: inherit;
				display: inline-block;
				font-size: inherit;
				line-height: 28px;
				border-radius: 3px;
				outline: 0;
				background: none;
				width: 100%;
				text-align: center;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
				top: 0;
				position: absolute;
				right: 0;
				height: 100%;
			}

	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
				cursor: pointer;
				color: #C0C4CC;
				width: 25px;
				font-size: 14px;
				line-height: 28px;
				text-align: center;
			}

	.main-content .el-pagination /deep/ .el-pagination__jump {
				margin: 0 0 0 24px;
				color: inherit;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 28px;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .el-pagination__jump .el-input {
				border-radius: 3px;
				padding: 0 2px;
				margin: 0 2px;
				color: inherit;
				display: inline-block;
				width: 50px;
				font-size: inherit;
				line-height: 18px;
				position: relative;
				text-align: center;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
				border: 1px solid #eee;
				cursor: pointer;
				padding: 0 0px;
				color: inherit;
				display: inline-block;
				font-size: inherit;
				line-height: 24px;
				border-radius: 3px;
				outline: 0;
				background: #fff;
				width: auto;
				text-align: center;
				height: 24px;
			}

	// list one
	.one .list1-view {
				cursor: pointer;
				padding: 0 4px 0 0px;
				margin: 0px 5px 5px 0;
				color: inherit;
				font-size: 13px;
				border-color: rgba(244,111,139,.3);
				line-height: 24px;
				border-radius: 4px;
				box-shadow: inset 0px 0px 0px 0px rgba(244,100,130,.3);
				outline: none;
				background: #428bca;
				width: auto;
				border-width: 0 0 0px;
				border-style: double;
				min-width: 40px;
				height: 24px;
			}

	.one .list1-view:hover {
				opacity: 0.8;
			}

	.one .list1-edit {
				cursor: pointer;
				padding: 0 4px 0 0px;
				margin: 0px 5px 5px 0;
				color: inherit;
				font-size: inherit;
				border-color: rgba(244,111,139,.3);
				line-height: 24px;
				border-radius: 4px;
				box-shadow: inset 0px 0px 0px 0px rgba(244,100,130,.3);
				outline: none;
				background: #45B6B0;
				width: auto;
				border-width: 0 0 0px;
				border-style: double;
				min-width: 40px;
				height: 24px;
			}

	.one .list1-edit:hover {
				opacity: 0.8;
			}

	.one .list1-del {
				cursor: pointer;
				padding: 0 4px 0 0px;
				margin: 0px 5px 5px 0;
				color: inherit;
				font-size: inherit;
				border-color: rgba(244,111,139,.3);
				line-height: 24px;
				border-radius: 4px;
				box-shadow: inset 0px 0px 0px 0px rgba(244,100,130,.3);
				outline: none;
				background: #FF6B6B;
				width: auto;
				border-width: 0 0 0px;
				border-style: double;
				min-width: 40px;
				height: 24px;
			}

	.one .list1-del:hover {
				opacity: 0.8;
			}

	.one .list1-btn8 {
				cursor: pointer;
				padding: 0 4px 0 0px;
				margin: 0px 5px 5px 0;
				color: inherit;
				font-size: inherit;
				border-color: rgba(244,111,139,.3);
				line-height: 24px;
				border-radius: 4px;
				box-shadow: inset 0px 0px 0px 0px rgba(244,100,130,.3);
				outline: none;
				background: #A8BDCF;
				width: auto;
				border-width: 0 0 0px;
				border-style: double;
				min-width: 40px;
				height: 24px;
			}

	.one .list1-btn8:hover {
				opacity: 0.8;
			}

	.main-content .el-table .el-switch {
				display: inline-flex;
				vertical-align: middle;
				line-height: 30px;
				position: relative;
				align-items: center;
				height: 30px;
			}
	.main-content .el-table .el-switch /deep/ .el-switch__label--left {
				cursor: pointer;
				margin: 0 10px 0 0;
				color: #333;
				font-weight: 500;
				display: inline-block;
				vertical-align: middle;
				font-size: 16px;
				transition: .2s;
				height: 30px;
			}
	.main-content .el-table .el-switch /deep/ .el-switch__label--right {
				cursor: pointer;
				margin: 0 0 0 10px;
				color: #333;
				font-weight: 500;
				display: inline-block;
				vertical-align: middle;
				font-size: 16px;
				transition: .2s;
				height: 30px;
			}
	.main-content .el-table .el-switch /deep/ .el-switch__core {
				border: 1px solid #A8BDCF;
				cursor: pointer;
				border-radius: 15px;
				margin: 0;
				outline: 0;
				background: #A8BDCF;
				display: inline-block;
				width: 50px;
				box-sizing: border-box;
				transition: border-color .3s,background-color .3s;
				height: 24px;
			}
	.main-content .el-table .el-switch /deep/ .el-switch__core::after {
				border-radius: 100%;
				top: 1px;
				left: 1px;
				background: #FFF;
				width: 20px;
				position: absolute;
				transition: all .3s;
				height: 20px;
			}
	.main-content .el-table .el-switch.is-checked /deep/ .el-switch__core::after {
				margin: 0 0 0 -27px;
				left: 100%;
			}

	.main-content .el-table .el-rate /deep/ .el-rate__item {
				cursor: pointer;
				display: inline-block;
				vertical-align: middle;
				font-size: 0;
				position: relative;
			}
	.main-content .el-table .el-rate /deep/ .el-rate__item .el-rate__icon {
				margin: 0 3px;
				color: #c0c4cc;
				display: inline-block;
				font-size: 18px;
				position: relative;
				transition: .3s;
			}
</style>
