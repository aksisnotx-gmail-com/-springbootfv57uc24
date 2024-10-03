<template>
  <div :style='{"minHeight":"calc(100vh - 200px)","padding":"20px","margin":"0 auto","color":"#666","background":"#f5f5f5","width":"calc(100% - 60px)","fontSize":"14px","height":"100%"}'>
    <el-form
	  :style='{"border":"1px solid rgba(255,255,255,1)","padding":"30px 0","boxShadow":"0 2px 3px 0px rgba(100,100,100,.05)","borderColor":"#fceaee","alignItems":"flex-start","borderRadius":"4px","flexWrap":"wrap","background":"rgba(255,255,255,1)","borderWidth":"0px","display":"flex","fontSize":"inherit","borderStyle":"double"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      label-width="200px"
    >
     <el-row>
        <el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}'   v-if="flag=='yuangong'"  label="技术部门员工工号" prop="yuangonggonghao">
          <el-input v-model="ruleForm.yuangonggonghao" readonly              placeholder="技术部门员工工号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}'   v-if="flag=='yuangong'"  label="技术部门员工姓名" prop="yuangongxingming">
          <el-input v-model="ruleForm.yuangongxingming"               placeholder="技术部门员工姓名" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' v-if="flag=='yuangong'" label="头像" prop="touxiang">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
          @change="yuangongtouxiangUploadChange"
          ></file-upload>
        </el-form-item>
        <el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' v-if="flag=='yuangong'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in yuangongxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' v-if="flag=='yuangong'" label="部门" prop="bumen">
          <el-select  @change="yuangongbumenChange"  v-model="ruleForm.bumen" placeholder="请选择部门">
            <el-option
                v-for="(item,index) in yuangongbumenOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}'   v-if="flag=='yuangong'"  label="技术部门经理工号" prop="zhuguangonghao">
          <el-input v-model="ruleForm.zhuguangonghao"               placeholder="技术部门经理工号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}'   v-if="flag=='yuangong'"  label="岗位" prop="gangwei">
          <el-input v-model="ruleForm.gangwei"               placeholder="岗位" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}'   v-if="flag=='yuangong'"  label="联系方式" prop="lianxifangshi">
          <el-input v-model="ruleForm.lianxifangshi"               placeholder="联系方式" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}'   v-if="flag=='zhuguan'"  label="技术部门经理工号" prop="zhuguangonghao">
          <el-input v-model="ruleForm.zhuguangonghao" readonly              placeholder="技术部门经理工号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}'   v-if="flag=='zhuguan'"  label="技术部门经理姓名" prop="zhuguanxingming">
          <el-input v-model="ruleForm.zhuguanxingming"               placeholder="技术部门经理姓名" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' v-if="flag=='zhuguan'" label="头像" prop="touxiang">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
          @change="zhuguantouxiangUploadChange"
          ></file-upload>
        </el-form-item>
        <el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' v-if="flag=='zhuguan'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in zhuguanxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' v-if="flag=='zhuguan'"  label="部门" prop="bumen">
          <el-select v-model="ruleForm.bumen"  placeholder="请选择部门">
            <el-option
                v-for="(item,index) in zhuguanbumenOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}'   v-if="flag=='zhuguan'"  label="联系电话" prop="lianxidianhua">
          <el-input v-model="ruleForm.lianxidianhua"               placeholder="联系电话" clearable></el-input>
        </el-form-item>
		<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' v-if="flag=='users'" label="用户名" prop="username">
			<el-input v-model="ruleForm.username" placeholder="用户名"></el-input>
		</el-form-item>
		<el-form-item :style='{"padding":"2px 0","margin":"0 auto 24px","color":"inherit","borderRadius":"4px","background":"#f9f9f9","width":"60%","fontSize":"inherit","height":"auto"}' v-if="flag=='users'" label="头像" prop="image">
		  <file-upload
		  tip="点击上传头像"
		  action="file/upload"
		  :limit="1"
		  :multiple="false"
		  :fileUrls="ruleForm.image?ruleForm.image:''"
		  @change="usersimageUploadChange"
		  ></file-upload>
		</el-form-item>
		<el-form-item :style='{"padding":"0","margin":"30px auto","alignItems":"center","textAlign":"center","background":"none","display":"flex","width":"60%","fontSize":"48px"}'>
			<el-button class="btn3" :style='{"border":"0px solid rgba(126, 96, 16, .2)","cursor":"pointer","padding":"0 20px","margin":"0px 4px","outline":"none","color":"#fff","borderRadius":"4px","background":"#45B6B0","width":"auto","fontSize":"16px","lineHeight":"24px","height":"40px"}' type="primary" @click="onUpdateHandler">
				<span class="icon iconfont icon-tijiao16" :style='{"color":"inherit","margin":"0 2px","fontSize":"18px"}'></span>
				保存
			</el-button>
		</el-form-item>
      </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
      yuangongxingbieOptions: [],
      yuangongbumenOptions: [],
      zhuguanxingbieOptions: [],
      zhuguanbumenOptions: [],
    };
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
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
  },
  methods: {
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
    yuangongtouxiangUploadChange(fileUrls) {
        this.ruleForm.touxiang = fileUrls;
    },
    zhuguantouxiangUploadChange(fileUrls) {
        this.ruleForm.touxiang = fileUrls;
    },
	usersimageUploadChange(fileUrls) {
		this.ruleForm.image = fileUrls;
	},
    onUpdateHandler() {

        if(this.ruleForm.yuangonggonghao && (this.ruleForm.yuangonggonghao.length<3) && `yuangong` == this.flag){
            this.$message.error(`技术部门员工工号长度不能小于3`);
            return
        }

        if(this.ruleForm.yuangonggonghao && (this.ruleForm.yuangonggonghao.length>10) && `yuangong` == this.flag){
            this.$message.error(`技术部门员工工号长度不能大于10`);
            return
        }
      if((!this.ruleForm.mima)&& 'yuangong'==this.flag){
        this.$message.error('密码不能为空');
        return
      }

        if(this.ruleForm.mima && (this.ruleForm.mima.length<3) && `yuangong` == this.flag){
            this.$message.error(`密码长度不能小于3`);
            return
        }

        if(this.ruleForm.mima && (this.ruleForm.mima.length>10) && `yuangong` == this.flag){
            this.$message.error(`密码长度不能大于10`);
            return
        }




        if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
        }










      if( 'yuangong' ==this.flag && this.ruleForm.lianxifangshi&&(!isMobile(this.ruleForm.lianxifangshi))){
        this.$message.error(`联系方式应输入手机格式`);
        return
      }






      if( 'yuangong' ==this.flag && this.ruleForm.status&&(!isIntNumer(this.ruleForm.status))){
       this.$message.error(`状态应输入整数`);
        return
      }


      if( 'yuangong' ==this.flag && this.ruleForm.passwordwrongnum&&(!isIntNumer(this.ruleForm.passwordwrongnum))){
       this.$message.error(`密码错误次数应输入整数`);
        return
      }

        if(this.ruleForm.zhuguangonghao && (this.ruleForm.zhuguangonghao.length<3) && `zhuguan` == this.flag){
            this.$message.error(`技术部门经理工号长度不能小于3`);
            return
        }

        if(this.ruleForm.zhuguangonghao && (this.ruleForm.zhuguangonghao.length>10) && `zhuguan` == this.flag){
            this.$message.error(`技术部门经理工号长度不能大于10`);
            return
        }
      if((!this.ruleForm.mima)&& 'zhuguan'==this.flag){
        this.$message.error('密码不能为空');
        return
      }

        if(this.ruleForm.mima && (this.ruleForm.mima.length<3) && `zhuguan` == this.flag){
            this.$message.error(`密码长度不能小于3`);
            return
        }

        if(this.ruleForm.mima && (this.ruleForm.mima.length>10) && `zhuguan` == this.flag){
            this.$message.error(`密码长度不能大于10`);
            return
        }




        if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
        }






      if( 'zhuguan' ==this.flag && this.ruleForm.lianxidianhua&&(!isMobile(this.ruleForm.lianxidianhua))){
        this.$message.error(`联系电话应输入手机格式`);
        return
      }






      if( 'zhuguan' ==this.flag && this.ruleForm.status&&(!isIntNumer(this.ruleForm.status))){
       this.$message.error(`状态应输入整数`);
        return
      }


      if( 'zhuguan' ==this.flag && this.ruleForm.passwordwrongnum&&(!isIntNumer(this.ruleForm.passwordwrongnum))){
       this.$message.error(`密码错误次数应输入整数`);
        return
      }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
	this.$message.error(`用户名不能为空`);
        return
      }
	  if(this.flag=='users'){
	  	this.ruleForm.image = this.ruleForm.image.replace(new RegExp(this.$base.url,"g"),"")
	  }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
				if(this.flag=='users'){
					this.$storage.set('headportrait',this.ruleForm.image)
				}
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

	.add-update-preview .btn3 {
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

	.add-update-preview .btn3:hover {
				opacity: 0.8;
			}

	.editor>.avatar-uploader {
		line-height: 0;
		height: 0;
	}
</style>
