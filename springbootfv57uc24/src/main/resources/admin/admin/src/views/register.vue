<template>
	<div>
		<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20230808/55e130d408e241d98bdb064f38dcca26.jpg)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
			<el-form v-if="pageFlag=='register'" :style='{"border":"0px solid #f6f6f6","padding":"20px 20px 20px","boxShadow":"0 0px 0px rgba(0, 0, 0, .2)","margin":"0 auto 0 50%","borderRadius":"0px","textAlign":"center","background":"none","width":"40%","fontSize":"16px","position":"relative","height":"auto"}' ref="rgsForm" class="rgs-form" :model="rgsForm" :rules="rules">
				<div v-if="true" :style='{"padding":"0px","margin":"0px auto 30px","borderColor":"#eee","color":"#38567a","background":"none","borderWidth":"0px","display":"inline-block","width":"100%","lineHeight":"40px","fontSize":"26px","borderStyle":"solid","fontWeight":"600"}' class="title">公司部门业务审批管理系统注册</div>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 10px","textAlign":"left","width":"50%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yuangong'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"#666","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('yuangonggonghao')?'required':''">技术部门员工工号：</div>
					<el-input  v-model="ruleForm.yuangonggonghao"  autocomplete="off" placeholder="技术部门员工工号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 10px","textAlign":"left","width":"50%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yuangong'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"#666","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('mima')?'required':''">密码：</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 10px","textAlign":"left","width":"50%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yuangong'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"#666","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 10px","textAlign":"left","width":"50%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yuangong'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"#666","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('yuangongxingming')?'required':''">技术部门员工姓名：</div>
					<el-input  v-model="ruleForm.yuangongxingming"  autocomplete="off" placeholder="技术部门员工姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 10px","textAlign":"left","width":"50%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yuangong'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"#666","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="yuangongtouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 10px","textAlign":"left","width":"50%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yuangong'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"#666","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in yuangongxingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 10px","textAlign":"left","width":"50%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yuangong'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"#666","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('bumen')?'required':''">部门：</div>
                    <el-select @change="yuangongbumenChange" v-model="ruleForm.bumen" placeholder="请选择部门" >
                        <el-option
                            v-for="(item,index) in yuangongbumenOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 10px","textAlign":"left","width":"50%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yuangong'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"#666","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('zhuguangonghao')?'required':''">技术部门经理工号：</div>
					<el-input  v-model="ruleForm.zhuguangonghao" readonly autocomplete="off" placeholder="技术部门经理工号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 10px","textAlign":"left","width":"50%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yuangong'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"#666","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('gangwei')?'required':''">岗位：</div>
					<el-input  v-model="ruleForm.gangwei"  autocomplete="off" placeholder="岗位"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 10px","textAlign":"left","width":"50%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yuangong'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"#666","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('lianxifangshi')?'required':''">联系方式：</div>
					<el-input  v-model="ruleForm.lianxifangshi"  autocomplete="off" placeholder="联系方式"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 10px","textAlign":"left","width":"50%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='zhuguan'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"#666","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('zhuguangonghao')?'required':''">技术部门经理工号：</div>
					<el-input  v-model="ruleForm.zhuguangonghao"  autocomplete="off" placeholder="技术部门经理工号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 10px","textAlign":"left","width":"50%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='zhuguan'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"#666","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('mima')?'required':''">密码：</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 10px","textAlign":"left","width":"50%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='zhuguan'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"#666","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 10px","textAlign":"left","width":"50%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='zhuguan'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"#666","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('zhuguanxingming')?'required':''">技术部门经理姓名：</div>
					<el-input  v-model="ruleForm.zhuguanxingming"  autocomplete="off" placeholder="技术部门经理姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 10px","textAlign":"left","width":"50%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='zhuguan'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"#666","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="zhuguantouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 10px","textAlign":"left","width":"50%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='zhuguan'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"#666","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in zhuguanxingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 10px","textAlign":"left","width":"50%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='zhuguan'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"#666","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('bumen')?'required':''">部门：</div>
                    <el-select v-model="ruleForm.bumen" placeholder="请选择部门" >
                        <el-option
                            v-for="(item,index) in zhuguanbumenOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 auto 10px","textAlign":"left","width":"50%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='zhuguan'">
					<div v-if="true" :style='{"padding":"0 8px 0 0","color":"#666","textAlign":"right","left":"-120px","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable" :class="changeRules('lianxidianhua')?'required':''">联系电话：</div>
					<el-input  v-model="ruleForm.lianxidianhua"  autocomplete="off" placeholder="联系电话"  type="text"  />
				</el-form-item>
				<button :style='{"border":"1px solid #fff","cursor":"pointer","padding":"0 0 0 30px","boxShadow":"0 0 0px rgba(64, 158, 255, .5)","margin":"30px auto 5px","color":"#fff","display":"block","letterSpacing":"10px","outline":"none","borderRadius":"0px","background":"#2b2f30","width":"50%","fontSize":"18px","height":"44px"}' type="button" class="r-btn" @click="login()">注册</button>
				<div :style='{"cursor":"pointer","padding":"0","margin":"20px 0 0","color":"rgba(159, 159, 159, 1)","textAlign":"right","display":"inline-block","width":"50%","lineHeight":"1","fontSize":"14px"}' class="r-login" @click="close()">已有账号，直接登录</div>
			</el-form>

		</div>
	</div>
</template>

<script>
export default {
	data() {
		return {
			ruleForm: {
			},
			forgetForm: {},
            pageFlag : '',
			tableName:"",
			rules: {},
            yuangongxingbieOptions: [],
            yuangongbumenOptions: [],
            zhuguanxingbieOptions: [],
            zhuguanbumenOptions: [],
		};
	},
	mounted(){
		this.pageFlag = this.$route.query.pageFlag
		if(this.$route.query.pageFlag=='register'){

			let table = this.$storage.get("loginTable");
			this.tableName = table;
			if(this.tableName=='yuangong'){
				this.ruleForm = {
					yuangonggonghao: '',
					mima: '',
					yuangongxingming: '',
					touxiang: '',
					xingbie: '',
					bumen: '',
					zhuguangonghao: '',
					gangwei: '',
					lianxifangshi: '',
					sfsh: '',
					shhf: '',
					status: '',
					passwordwrongnum: '',
				}
			}
			if(this.tableName=='zhuguan'){
				this.ruleForm = {
					zhuguangonghao: '',
					mima: '',
					zhuguanxingming: '',
					touxiang: '',
					xingbie: '',
					bumen: '',
					lianxidianhua: '',
					sfsh: '',
					shhf: '',
					status: '',
					passwordwrongnum: '',
				}
			}
			if ('yuangong' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('zhuguan' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			this.yuangongxingbieOptions = "男,女".split(',')
			this.$http({
				url: `option/bumen/bumen`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.yuangongbumenOptions = data.data;
				} else {
					this.$message.error(data.msg);
				}
			});
			this.zhuguanxingbieOptions = "男,女".split(',')
			this.$http({
				url: `option/bumen/bumen`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.zhuguanbumenOptions = data.data;
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	},
	created() {
	},
	destroyed() {
		  	},
	methods: {
		changeRules(name){
			if(this.rules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        yuangongtouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        // 下二随
        yuangongbumenChange () {
            this.$http({
                url: `follow/bumen/bumen?columnValue=`+ this.ruleForm.bumen,
                method: "get"
            }).then(({ data }) => {
                if (data && data.code === 0) {
                    if(data.data.zhuguangonghao){
                        this.ruleForm.zhuguangonghao = data.data.zhuguangonghao
                    }
                } else {
                    this.$message.error(data.msg);
                }
            });
        },
        zhuguantouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
			  if(this.tableName=='yuangong'){
				  this.ruleForm.sfsh = '待审核'
			  }
					if(this.ruleForm.yuangonggonghao && (this.ruleForm.yuangonggonghao.length<3) && `yuangong` == this.tableName){
						this.$message.error(`技术部门员工工号长度不能小于3`);
						return
					}
					if(this.ruleForm.yuangonggonghao && (this.ruleForm.yuangonggonghao.length>10) && `yuangong` == this.tableName){
						this.$message.error(`技术部门员工工号长度不能大于10`);
						return
					}
					if((!this.ruleForm.mima) && `yuangong` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					if(this.ruleForm.mima && (this.ruleForm.mima.length<3) && `yuangong` == this.tableName){
						this.$message.error(`密码长度不能小于3`);
						return
					}
					if(this.ruleForm.mima && (this.ruleForm.mima.length>10) && `yuangong` == this.tableName){
						this.$message.error(`密码长度不能大于10`);
						return
					}
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `yuangong` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
					if(`yuangong` == this.tableName && this.ruleForm.lianxifangshi &&(!this.$validate.isMobile(this.ruleForm.lianxifangshi))){
						this.$message.error(`联系方式应输入手机格式`);
						return
					}
			  if(this.tableName=='zhuguan'){
				  this.ruleForm.sfsh = '待审核'
			  }
					if(this.ruleForm.zhuguangonghao && (this.ruleForm.zhuguangonghao.length<3) && `zhuguan` == this.tableName){
						this.$message.error(`技术部门经理工号长度不能小于3`);
						return
					}
					if(this.ruleForm.zhuguangonghao && (this.ruleForm.zhuguangonghao.length>10) && `zhuguan` == this.tableName){
						this.$message.error(`技术部门经理工号长度不能大于10`);
						return
					}
					if((!this.ruleForm.mima) && `zhuguan` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					if(this.ruleForm.mima && (this.ruleForm.mima.length<3) && `zhuguan` == this.tableName){
						this.$message.error(`密码长度不能小于3`);
						return
					}
					if(this.ruleForm.mima && (this.ruleForm.mima.length>10) && `zhuguan` == this.tableName){
						this.$message.error(`密码长度不能大于10`);
						return
					}
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `zhuguan` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
					if(`zhuguan` == this.tableName && this.ruleForm.lianxidianhua &&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
						this.$message.error(`联系电话应输入手机格式`);
						return
					}
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
	.container {
	  position: relative;
	  background: url(http://codegen.caihongy.cn/20230808/55e130d408e241d98bdb064f38dcca26.jpg);

		.el-date-editor.el-input {
		  width: 100%;
		}

		.rgs-form .el-input /deep/ .el-input__inner {
						border-radius: 0px;
						padding: 0 10px;
						box-shadow: 0 0px 0px rgba(60, 60, 60, .1);
						outline: none;
						color: #666;
						background: none;
						width: calc(100% - 0px);
						font-size: 14px;
						border-color: #eee;
						border-width: 0 0 1px;
						border-style: solid;
						height: 44px;
					}

		.rgs-form .el-select /deep/ .el-input__inner {
						border-radius: 0px;
						padding: 0 10px;
						box-shadow: 0 0px 0px rgba(60, 60, 60, .1);
						outline: none;
						color: #666;
						background: none;
						width: 100%;
						font-size: 14px;
						border-color: #eee;
						border-width: 0 0 1px;
						border-style: solid;
						height: 44px;
					}

		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border-radius: 0px;
						padding: 0 10px 0 30px;
						box-shadow: 0 0px 0px rgba(60, 60, 60, .1);
						outline: none;
						color: #666;
						background: none;
						width: 288px;
						font-size: 14px;
						border-color: #eee;
						border-width: 0 0 1px;
						border-style: solid;
						height: 44px;
					}

		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border-radius: 0px;
						padding: 0 10px 0 30px;
						box-shadow: 0 0px 0px rgba(60, 60, 60, .1);
						outline: none;
						color: #666;
						background: none;
						width: 288px;
						font-size: 14px;
						border-color: #eee;
						border-width: 0 0 1px;
						border-style: solid;
						height: 44px;
					}

		.rgs-form /deep/ .el-upload--picture-card {
			background: transparent;
			border: 0;
			border-radius: 0;
			width: auto;
			height: auto;
			line-height: initial;
			vertical-align: middle;
		}

		.rgs-form /deep/ .upload .upload-img {
		  		  cursor: pointer;
		  		  color: #bbb;
		  		  font-size: 32px;
		  		  border-color: #eee;
		  		  line-height: 80px;
		  		  border-radius: 0px;
		  		  box-shadow: 0 0px 0px rgba(60, 60, 60, .1);
		  		  background: none;
		  		  width: 160px;
		  		  border-width: 1px;
		  		  border-style: solid;
		  		  text-align: center;
		  		  height: 80px;
		  		}

		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  cursor: pointer;
		  		  color: #bbb;
		  		  font-size: 32px;
		  		  border-color: #eee;
		  		  line-height: 80px;
		  		  border-radius: 0px;
		  		  box-shadow: 0 0px 0px rgba(60, 60, 60, .1);
		  		  background: none;
		  		  width: 160px;
		  		  border-width: 1px;
		  		  border-style: solid;
		  		  text-align: center;
		  		  height: 80px;
		  		}

		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  cursor: pointer;
		  		  color: #bbb;
		  		  font-size: 32px;
		  		  border-color: #eee;
		  		  line-height: 80px;
		  		  border-radius: 0px;
		  		  box-shadow: 0 0px 0px rgba(60, 60, 60, .1);
		  		  background: none;
		  		  width: 160px;
		  		  border-width: 1px;
		  		  border-style: solid;
		  		  text-align: center;
		  		  height: 80px;
		  		}
	}
	.required {
		position: relative;
	}
	.required::after{
				color: red;
				position: absolute;
				right: 5px;
				content: "*";
			}
	.editor>.avatar-uploader {
		line-height: 0;
		height: 0;
	}
</style>
