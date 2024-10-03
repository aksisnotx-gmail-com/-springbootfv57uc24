<template>
	<div class="addEdit-block" :style='{"minHeight":"calc(100vh - 200px)","padding":"30px","margin":"0 auto","color":"#666","background":"#f5f5f5","width":"calc(100% - 60px)","fontSize":"16px","height":"100%"}'>
		<el-form
			:style='{"border":"1px solid rgba(255,255,255,1)","padding":"30px 0","boxShadow":"0 2px 3px 0px rgba(100,100,100,.05)","borderColor":"#fceaee","alignItems":"flex-start","borderRadius":"4px","flexWrap":"wrap","background":"rgba(255,255,255,1)","borderWidth":"0px","display":"flex","fontSize":"inherit","borderStyle":"double"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="200px"
		>
			<template >
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' class="select" v-if="type!='info'"  label="工资月份" prop="gongziyuefen">
					<el-select :disabled="ro.gongziyuefen" v-model="ruleForm.gongziyuefen" placeholder="请选择工资月份" >
						<el-option
							v-for="(item,index) in gongziyuefenOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' v-else class="input" label="工资月份" prop="gongziyuefen">
					<el-input v-model="ruleForm.gongziyuefen"
						placeholder="工资月份" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' class="input" v-if="type!='info'"  label="技术部门员工工号" prop="yuangonggonghao">
					<el-input  v-model="ruleForm.yuangonggonghao" placeholder="技术部门员工工号" clearable  :readonly="ro.yuangonggonghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' v-else class="input" label="技术部门员工工号" prop="yuangonggonghao">
					<el-input v-model="ruleForm.yuangonggonghao" placeholder="技术部门员工工号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' class="input" v-if="type!='info'"  label="技术部门员工姓名" prop="yuangongxingming">
					<el-input  v-model="ruleForm.yuangongxingming" placeholder="技术部门员工姓名" clearable  :readonly="ro.yuangongxingming"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' v-else class="input" label="技术部门员工姓名" prop="yuangongxingming">
					<el-input v-model="ruleForm.yuangongxingming" placeholder="技术部门员工姓名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' class="input" v-if="type!='info'"  label="部门" prop="bumen">
					<el-input  v-model="ruleForm.bumen" placeholder="部门" clearable  :readonly="ro.bumen"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' v-else class="input" label="部门" prop="bumen">
					<el-input v-model="ruleForm.bumen" placeholder="部门" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' class="input" v-if="type!='info'"  label="基本工资" prop="jibengongzi">
					<el-input  v-model.number="ruleForm.jibengongzi" placeholder="基本工资" clearable  :readonly="ro.jibengongzi"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' v-else class="input" label="基本工资" prop="jibengongzi">
					<el-input v-model="ruleForm.jibengongzi" placeholder="基本工资" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' class="input" v-if="type!='info'"  label="绩效工资" prop="jixiaogongzi">
					<el-input type="number" v-model.number="ruleForm.jixiaogongzi" placeholder="绩效工资" clearable  :readonly="ro.jixiaogongzi"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' v-else class="input" label="绩效工资" prop="jixiaogongzi">
					<el-input v-model="ruleForm.jixiaogongzi" placeholder="绩效工资" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' class="input" v-if="type!='info'"  label="加班工资" prop="jiabangongzi">
					<el-input type="number" v-model.number="ruleForm.jiabangongzi" placeholder="加班工资" clearable  :readonly="ro.jiabangongzi"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' v-else class="input" label="加班工资" prop="jiabangongzi">
					<el-input v-model="ruleForm.jiabangongzi" placeholder="加班工资" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' class="input" v-if="type!='info'"  label="个税" prop="geshui">
					<el-input type="number" v-model.number="ruleForm.geshui" placeholder="个税" clearable  :readonly="ro.geshui"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' v-else class="input" label="个税" prop="geshui">
					<el-input v-model="ruleForm.geshui" placeholder="个税" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' class="input" v-if="type!='info'"  label="社保代缴" prop="shebaodaijiao">
					<el-input type="number" v-model.number="ruleForm.shebaodaijiao" placeholder="社保代缴" clearable  :readonly="ro.shebaodaijiao"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' v-else class="input" label="社保代缴" prop="shebaodaijiao">
					<el-input v-model="ruleForm.shebaodaijiao" placeholder="社保代缴" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' class="input" v-if="type!='info'"  label="奖励" prop="jiangli">
					<el-input  v-model.number="ruleForm.jiangli" placeholder="奖励" clearable  :readonly="ro.jiangli"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' v-else class="input" label="奖励" prop="jiangli">
					<el-input v-model="ruleForm.jiangli" placeholder="奖励" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' class="input" v-if="type!='info'"  label="罚款" prop="fakuan">
					<el-input  v-model.number="ruleForm.fakuan" placeholder="罚款" clearable  :readonly="ro.fakuan"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' v-else class="input" label="罚款" prop="fakuan">
					<el-input v-model="ruleForm.fakuan" placeholder="罚款" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' class="input" v-if="type!='info'"  label="奖惩说明" prop="jiangchengshuoming">
					<el-input  v-model="ruleForm.jiangchengshuoming" placeholder="奖惩说明" clearable  :readonly="ro.jiangchengshuoming"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' v-else class="input" label="奖惩说明" prop="jiangchengshuoming">
					<el-input v-model="ruleForm.jiangchengshuoming" placeholder="奖惩说明" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' class="input" v-if="type!='info'" label="实发工资" prop="shifagongzi">
					<el-input v-model="shifagongzi" placeholder="实发工资" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' class="input" v-else-if="ruleForm.shifagongzi" label="实发工资" prop="shifagongzi">
					<el-input v-model="ruleForm.shifagongzi" placeholder="实发工资" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' class="date" v-if="type!='info'" label="录入时间" prop="lurushijian">
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.lurushijian"
						type="datetime"
						:readonly="ro.lurushijian"
						placeholder="录入时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' class="input" v-else-if="ruleForm.lurushijian" label="录入时间" prop="lurushijian">
					<el-input v-model="ruleForm.lurushijian" placeholder="录入时间" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item :style='{"padding":"0","margin":"30px auto","alignItems":"center","textAlign":"center","background":"none","display":"flex","width":"60%","fontSize":"48px"}' class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-tijiao16" :style='{"color":"inherit","margin":"0 2px","fontSize":"18px"}'></span>
					保存
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-quxiao09" :style='{"color":"inherit","margin":"0 2px","fontSize":"18px"}'></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-fanhui01" :style='{"color":"inherit","margin":"0 2px","fontSize":"18px"}'></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>


  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
	data() {
		let self = this
		var validateIdCard = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!checkIdCard(value)) {
				callback(new Error("请输入正确的身份证号码"));
			} else {
				callback();
			}
		};
		var validateUrl = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isURL(value)) {
				callback(new Error("请输入正确的URL地址"));
			} else {
				callback();
			}
		};
		var validateMobile = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isMobile(value)) {
				callback(new Error("请输入正确的手机号码"));
			} else {
				callback();
			}
		};
		var validatePhone = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isPhone(value)) {
				callback(new Error("请输入正确的电话号码"));
			} else {
				callback();
			}
		};
		var validateEmail = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isEmail(value)) {
				callback(new Error("请输入正确的邮箱地址"));
			} else {
				callback();
			}
		};
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',


			ro:{
				gongziyuefen : false,
				yuangonggonghao : false,
				yuangongxingming : false,
				bumen : false,
				jibengongzi : false,
				jixiaogongzi : false,
				jiabangongzi : false,
				geshui : false,
				shebaodaijiao : false,
				jiangli : false,
				fakuan : false,
				jiangchengshuoming : false,
				shifagongzi : false,
				lurushijian : false,
			},


			ruleForm: {
				gongziyuefen: '',
				yuangonggonghao: '',
				yuangongxingming: '',
				bumen: '',
				jibengongzi: '',
				jixiaogongzi: '',
				jiabangongzi: '',
				geshui: '',
				shebaodaijiao: '',
				jiangli: '',
				fakuan: '',
				jiangchengshuoming: '',
				shifagongzi: '',
				lurushijian: '',
			},

			gongziyuefenOptions: [],


			rules: {
				gongziyuefen: [
				],
				yuangonggonghao: [
				],
				yuangongxingming: [
				],
				bumen: [
					{ required: true, message: '部门不能为空', trigger: 'blur' },
				],
				jibengongzi: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				jixiaogongzi: [
					{ validator: validateNumber, trigger: 'blur' },
				],
				jiabangongzi: [
					{ validator: validateNumber, trigger: 'blur' },
				],
				geshui: [
					{ validator: validateNumber, trigger: 'blur' },
				],
				shebaodaijiao: [
					{ validator: validateNumber, trigger: 'blur' },
				],
				jiangli: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				fakuan: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				jiangchengshuoming: [
				],
				shifagongzi: [
					{ validator: validateNumber, trigger: 'blur' },
				],
				lurushijian: [
				],
			}
		};
	},
	props: ["parent"],
	computed: {
		shifagongzi: {
			get: function () {
				return 0+parseFloat(this.ruleForm.jibengongzi==""?0:this.ruleForm.jibengongzi)+parseFloat(this.ruleForm.jixiaogongzi==""?0:this.ruleForm.jixiaogongzi)+parseFloat(this.ruleForm.jiabangongzi==""?0:this.ruleForm.jiabangongzi)-parseFloat(this.ruleForm.geshui==""?0:this.ruleForm.geshui)-parseFloat(this.ruleForm.shebaodaijiao==""?0:this.ruleForm.shebaodaijiao)+parseFloat(this.ruleForm.jiangli==""?0:this.ruleForm.jiangli)-parseFloat(this.ruleForm.fakuan==""?0:this.ruleForm.fakuan) || 0
			}
		},



	},
    components: {
    },
	created() {
		this.ruleForm.lurushijian = this.getCurDateTime()
	},
	methods: {

		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='gongziyuefen'){
							this.ruleForm.gongziyuefen = obj[o];
							this.ro.gongziyuefen = true;
							continue;
						}
						if(o=='yuangonggonghao'){
							this.ruleForm.yuangonggonghao = obj[o];
							this.ro.yuangonggonghao = true;
							continue;
						}
						if(o=='yuangongxingming'){
							this.ruleForm.yuangongxingming = obj[o];
							this.ro.yuangongxingming = true;
							continue;
						}
						if(o=='bumen'){
							this.ruleForm.bumen = obj[o];
							this.ro.bumen = true;
							continue;
						}
						if(o=='jibengongzi'){
							this.ruleForm.jibengongzi = obj[o];
							this.ro.jibengongzi = true;
							continue;
						}
						if(o=='jixiaogongzi'){
							this.ruleForm.jixiaogongzi = obj[o];
							this.ro.jixiaogongzi = true;
							continue;
						}
						if(o=='jiabangongzi'){
							this.ruleForm.jiabangongzi = obj[o];
							this.ro.jiabangongzi = true;
							continue;
						}
						if(o=='geshui'){
							this.ruleForm.geshui = obj[o];
							this.ro.geshui = true;
							continue;
						}
						if(o=='shebaodaijiao'){
							this.ruleForm.shebaodaijiao = obj[o];
							this.ro.shebaodaijiao = true;
							continue;
						}
						if(o=='jiangli'){
							this.ruleForm.jiangli = obj[o];
							this.ro.jiangli = true;
							continue;
						}
						if(o=='fakuan'){
							this.ruleForm.fakuan = obj[o];
							this.ro.fakuan = true;
							continue;
						}
						if(o=='jiangchengshuoming'){
							this.ruleForm.jiangchengshuoming = obj[o];
							this.ro.jiangchengshuoming = true;
							continue;
						}
						if(o=='shifagongzi'){
							this.ruleForm.shifagongzi = obj[o];
							this.ro.shifagongzi = true;
							continue;
						}
						if(o=='lurushijian'){
							this.ruleForm.lurushijian = obj[o];
							this.ro.lurushijian = true;
							continue;
						}
				}















			}


			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {

					var json = data.data;
				} else {
					this.$message.error(data.msg);
				}
			});

            this.gongziyuefenOptions = "1月份,2月份,3月份,4月份,5月份,6月份,7月份,8月份,9月份,10月份,11月份,12月份".split(',')

		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `yuangonggongzi/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {
        this.ruleForm.shifagongzi = this.shifagongzi





























var objcross = this.$storage.getObj('crossObj');

      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
       this.$refs["ruleForm"].validate(valid => {
         if (valid) {
		 if(crossrefid && crossuserid) {
			 this.ruleForm.crossuserid = crossuserid;
			 this.ruleForm.crossrefid = crossrefid;
			let params = {
				page: 1,
				limit: 10,
				crossuserid:this.ruleForm.crossuserid,
				crossrefid:this.ruleForm.crossrefid,
			}
			this.$http({
				url: "yuangonggongzi/page",
				method: "get",
				params: params
			}).then(({
				data
			}) => {
				if (data && data.code === 0) {
				       if(data.data.total>=crossoptnum) {
					     this.$message.error(this.$storage.get('tips'));
					       return false;
				       } else {
					 this.$http({
					   url: `yuangonggongzi/${!this.ruleForm.id ? "save" : "update"}`,
					   method: "post",
					   data: this.ruleForm
					 }).then(({ data }) => {
					   if (data && data.code === 0) {
					     this.$message({
					       message: "操作成功",
					       type: "success",
					       duration: 1500,
					       onClose: () => {
						 this.parent.showFlag = true;
						 this.parent.addOrUpdateFlag = false;
						 this.parent.yuangonggongziCrossAddOrUpdateFlag = false;
						 this.parent.search();
						 this.parent.contentStyleChange();
					       }
					     });
					   } else {
					     this.$message.error(data.msg);
					   }
					 });

				       }
				} else {
				}
			});
		 } else {
			 this.$http({
			   url: `yuangonggongzi/${!this.ruleForm.id ? "save" : "update"}`,
			   method: "post",
			   data: this.ruleForm
			 }).then(({ data }) => {
			   if (data && data.code === 0) {
			     this.$message({
			       message: "操作成功",
			       type: "success",
			       duration: 1500,
			       onClose: () => {
				 this.parent.showFlag = true;
				 this.parent.addOrUpdateFlag = false;
				 this.parent.yuangonggongziCrossAddOrUpdateFlag = false;
				 this.parent.search();
				 this.parent.contentStyleChange();
			       }
			     });
			   } else {
			     this.$message.error(data.msg);
			   }
			 });
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.yuangonggongziCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}

	.search-box {
		position: absolute;
	}

	.el-date-editor.el-input {
		width: auto;
	}

	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: inherit;
	  	  background: none;
	  	  font-weight: 500;
	  	  display: inline-block;
	  	  width: 200px;
	  	  font-size: inherit;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}

	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 200px;
	}

	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 1px solid #C7D5E0;
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: inherit;
	  	  background: #fff;
	  	  width: 400px;
	  	  font-size: 16px;
	  	  height: 36px;
	  	}

	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 1px solid #C7D5E0;
	  	  border-radius: 4px;
	  	  padding: 0 10px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: inherit;
	  	  background: #fff;
	  	  width: auto;
	  	  font-size: 16px;
	  	  min-width: 350px;
	  	  height: 36px;
	  	}

	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 1px solid #C7D5E0;
	  	  border-radius: 4px;
	  	  padding: 0 10px 0 30px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: inherit;
	  	  background: none;
	  	  width: auto;
	  	  font-size: 16px;
	  	  min-width: 250px;
	  	  height: 36px;
	  	}

	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}

	.add-update-preview /deep/ .upload .upload-img {
	  	  border: 1px solid #C7D5E0;
	  	  cursor: pointer;
	  	  border-radius: 4px;
	  	  color: #aaa;
	  	  background: #fff;
	  	  object-fit: cover;
	  	  width: 180px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}

	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 1px solid #C7D5E0;
	  	  cursor: pointer;
	  	  border-radius: 4px;
	  	  color: #aaa;
	  	  background: #fff;
	  	  object-fit: cover;
	  	  width: 180px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}

	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 1px solid #C7D5E0;
	  	  cursor: pointer;
	  	  border-radius: 4px;
	  	  color: #aaa;
	  	  background: #fff;
	  	  object-fit: cover;
	  	  width: 180px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}

	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 1px solid #C7D5E0;
	  	  border-radius: 4px;
	  	  padding: 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: inherit;
	  	  background: #fff;
	  	  width: 500px;
	  	  font-size: 16px;
	  	  height: 140px;
	  	}

	.add-update-preview .btn .btn1 {
				border: 0px solid rgba(126, 96, 16, .2);
				cursor: pointer;
				padding: 0 20px;
				margin: 0px 4px;
				color: #fff;
				display: inline-block;
				font-size: 16px;
				line-height: 24px;
				border-radius: 4px;
				outline: none;
				background: #A8BDCF;
				width: auto;
				height: 40px;
			}

	.add-update-preview .btn .btn1:hover {
				opacity: 0.8;
			}

	.add-update-preview .btn .btn2 {
				border: 0px solid rgba(126, 96, 16, .2);
				cursor: pointer;
				border-radius: 4px;
				padding: 0 20px;
				margin: 0px 4px;
				outline: none;
				color: #fff;
				background: #428bca;
				width: auto;
				font-size: 16px;
				line-height: 24px;
				height: 40px;
			}

	.add-update-preview .btn .btn2:hover {
				opacity: 0.8;
			}

	.add-update-preview .btn .btn3 {
				border: 0px solid rgba(126, 96, 16, .2);
				cursor: pointer;
				border-radius: 4px;
				padding: 0 20px;
				margin: 0px 4px;
				outline: none;
				color: #fff;
				background: #45B6B0;
				width: auto;
				font-size: 16px;
				line-height: 24px;
				height: 40px;
			}

	.add-update-preview .btn .btn3:hover {
				opacity: 0.8;
			}

	.add-update-preview .btn .btn4 {
				border: 0px solid rgba(126, 96, 16, .2);
				cursor: pointer;
				border-radius: 4px;
				padding: 0 20px;
				margin: 0px 4px;
				outline: none;
				color: #fff;
				background: #FF6B6B;
				width: auto;
				font-size: 16px;
				line-height: 24px;
				height: 40px;
			}

	.add-update-preview .btn .btn4:hover {
				opacity: 0.8;
			}

	.add-update-preview .btn .btn5 {
				border: 0px solid rgba(126, 96, 16, .2);
				cursor: pointer;
				border-radius: 3px;
				padding: 0 20px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #65C3DF;
				width: auto;
				font-size: 16px;
				line-height: 24px;
				height: 40px;
			}

	.add-update-preview .btn .btn5:hover {
				opacity: 0.8;
			}
</style>
