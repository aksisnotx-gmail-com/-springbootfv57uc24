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
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' class="select" v-if="type!='info'"  label="打卡类型" prop="dakaleixing">
					<el-select :disabled="ro.dakaleixing" v-model="ruleForm.dakaleixing" placeholder="请选择打卡类型" >
						<el-option
							v-for="(item,index) in dakaleixingOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' v-else class="input" label="打卡类型" prop="dakaleixing">
					<el-input v-model="ruleForm.dakaleixing"
						placeholder="打卡类型" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' class="date" v-if="type!='info'" label="打卡时间" prop="dakashijian">
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.dakashijian"
						type="datetime"
						:readonly="ro.dakashijian"
						placeholder="打卡时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' class="input" v-else-if="ruleForm.dakashijian" label="打卡时间" prop="dakashijian">
					<el-input v-model="ruleForm.dakashijian" placeholder="打卡时间" readonly></el-input>
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
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' class="input" v-if="type!='info'"  label="技术部门经理工号" prop="zhuguangonghao">
					<el-input  v-model="ruleForm.zhuguangonghao" placeholder="技术部门经理工号" clearable  :readonly="ro.zhuguangonghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' v-else class="input" label="技术部门经理工号" prop="zhuguangonghao">
					<el-input v-model="ruleForm.zhuguangonghao" placeholder="技术部门经理工号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' class="upload" v-if="type!='info' && !ro.zhaopian" label="照片" prop="zhaopian">
                    <el-image v-if="ruleForm.zhaopian" :src="ruleForm.zhaopian?$base.url + ruleForm.zhaopian:''" style="width:150px;height:150px;"></el-image>
                    <el-button @click="imgAddClick">人脸识别</el-button>
				</el-form-item>
				<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' class="upload" v-else-if="ruleForm.zhaopian" label="照片" prop="zhaopian">
					<img v-if="ruleForm.zhaopian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.zhaopian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.zhaopian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
			</template>
			<el-form-item :style='{"padding":"0","margin":"30px auto","alignItems":"center","textAlign":"center","background":"none","display":"flex","width":"60%","fontSize":"48px"}' class="btn">
				<el-button class="btn2" v-show="!faceMatchFlag" v-if="type!='info'" type="success" @click="faceMatchHandle">
					<span class="icon iconfont icon-renlian11" :style='{"color":"inherit","margin":"0 2px","fontSize":"18px"}'></span>
					人脸辩认
				</el-button>
				<el-button class="btn3" v-show="faceMatchFlag" v-if="type!='info'" type="success" @click="onSubmit">
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


    <imgAdd ref="imgAdd" @imgChange="imgChange"></imgAdd>
  </div>
</template>
<script>
import imgAdd from "@/components/common/img";
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

			userface : '',
			faceMatchFlag: false,

			ro:{
				dakaleixing : false,
				dakashijian : false,
				yuangonggonghao : false,
				yuangongxingming : false,
				bumen : false,
				zhuguangonghao : false,
				zhaopian : false,
				sfsh : false,
				shhf : false,
			},


			ruleForm: {
				dakaleixing: '',
				dakashijian: '',
				yuangonggonghao: '',
				yuangongxingming: '',
				bumen: '',
				zhuguangonghao: '',
				zhaopian: '',
				shhf: '',
			},

			dakaleixingOptions: [],


			rules: {
				dakaleixing: [
				],
				dakashijian: [
				],
				yuangonggonghao: [
				],
				yuangongxingming: [
				],
				bumen: [
				],
				zhuguangonghao: [
				],
				zhaopian: [
				],
				sfsh: [
				],
				shhf: [
				],
			}
		};
	},
	props: ["parent"],
	computed: {



	},
    components: {
        imgAdd
    },
	created() {
		this.ruleForm.dakashijian = this.getCurDateTime()
	},
	methods: {
        imgAddClick(){
            this.$refs.imgAdd.onTake()
        },
        imgChange(e){
            this.ruleForm.zhaopian = 'upload/' + e
        },

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
						if(o=='dakaleixing'){
							this.ruleForm.dakaleixing = obj[o];
							this.ro.dakaleixing = true;
							continue;
						}
						if(o=='dakashijian'){
							this.ruleForm.dakashijian = obj[o];
							this.ro.dakashijian = true;
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
						if(o=='zhuguangonghao'){
							this.ruleForm.zhuguangonghao = obj[o];
							this.ro.zhuguangonghao = true;
							continue;
						}
						if(o=='zhaopian'){
							this.ruleForm.zhaopian = obj[o];
							this.ro.zhaopian = true;
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
                    if(this.$storage.get("role")=="管理员") {
                        this.faceMatchFlag= true;
                    }
                    this.userface = data.data.touxiang;

					var json = data.data;
					if(((json.yuangonggonghao!=''&&json.yuangonggonghao) || json.yuangonggonghao==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.yuangonggonghao = json.yuangonggonghao
						this.ro.yuangonggonghao = true;
					}
					if(((json.yuangongxingming!=''&&json.yuangongxingming) || json.yuangongxingming==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.yuangongxingming = json.yuangongxingming
						this.ro.yuangongxingming = true;
					}
					if(((json.bumen!=''&&json.bumen) || json.bumen==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.bumen = json.bumen
						this.ro.bumen = true;
					}
					if(((json.zhuguangonghao!=''&&json.zhuguangonghao) || json.zhuguangonghao==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.zhuguangonghao = json.zhuguangonghao
						this.ro.zhuguangonghao = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});

            this.dakaleixingOptions = "上班,下班".split(',')

		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `kaoqinxinxi/info/${id}`,
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

    faceMatchHandle() {
        if(this.ruleForm.zhaopian!=null) {
            this.ruleForm.zhaopian = this.ruleForm.zhaopian.replace(new RegExp(this.$base.url,"g"),"");
        }
            let params = {
                face1:this.userface.replace("upload/",""),
                face2:this.ruleForm.zhaopian.replace("upload/",""),
            }
          this.$http({
            url: `matchFace`,
            method: "get",
            params: params
          }).then(({ data }) => {
            if (data && data.code === 0) {
                if(data.score>60) {
                    this.faceMatchFlag = true;
                    this.$message({
                      message: "匹配成功",
                      type: "success",
                      duration: 1500,
                    });
                } else {
                    this.faceMatchFlag = false;
                    this.$message.error("匹配失败");
                }
            } else {
              this.faceMatchFlag = false;
              this.$message.error("匹配失败");
            }
          });
    },

    // 提交
    onSubmit() {














	if(this.ruleForm.zhaopian!=null) {
		this.ruleForm.zhaopian = this.ruleForm.zhaopian.replace(new RegExp(this.$base.url,"g"),"");
	}





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
				url: "kaoqinxinxi/page",
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
					   url: `kaoqinxinxi/${!this.ruleForm.id ? "save" : "update"}`,
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
						 this.parent.kaoqinxinxiCrossAddOrUpdateFlag = false;
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
			   url: `kaoqinxinxi/${!this.ruleForm.id ? "save" : "update"}`,
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
				 this.parent.kaoqinxinxiCrossAddOrUpdateFlag = false;
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
      this.parent.kaoqinxinxiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    zhaopianUploadChange(fileUrls) {
	    this.ruleForm.zhaopian = fileUrls;
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
