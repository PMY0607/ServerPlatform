<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="80px"
	  style="background: transparent;"
    >  
     <el-row>
      <el-col :span="12">
        <el-form-item   v-if="flag=='parent'"  label="家长账号" prop="teacherUsername">
          <el-input v-model="ruleForm.teacherUsername" readonly              placeholder="家长账号" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='parent'"  label="家长姓名" prop="name">
          <el-input v-model="ruleForm.name"               placeholder="家长姓名" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item v-if="flag=='parent'"  label="性别" prop="gender">
          <el-select v-model="ruleForm.gender"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in parentGenderOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='parent'"  label="年龄" prop="age">
          <el-input v-model="ruleForm.age"               placeholder="年龄" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="24">  
        <el-form-item v-if="flag=='parent'" label="头像" prop="headPic">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.headPic?ruleForm.headPic:''"
          @change="parentHeadPicUploadChange"
          ></file-upload>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='parent'"  label="手机" prop="phone">
          <el-input v-model="ruleForm.phone"               placeholder="手机" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='parent'"  label="身份证" prop="idNumber">
          <el-input v-model="ruleForm.idNumber"               placeholder="身份证" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='parent'"  label="邮箱" prop="email">
          <el-input v-model="ruleForm.email"               placeholder="邮箱" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='parent'"  label="住址" prop="address">
          <el-input v-model="ruleForm.address"               placeholder="住址" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='teacher'"  label="教师账号" prop="teacherUsername">
          <el-input v-model="ruleForm.teacherUsername" readonly              placeholder="教师账号" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='teacher'"  label="教师姓名" prop="name">
          <el-input v-model="ruleForm.name"               placeholder="教师姓名" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='teacher'"  label="年龄" prop="age">
          <el-input v-model="ruleForm.age"               placeholder="年龄" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item v-if="flag=='teacher'"  label="性别" prop="gender">
          <el-select v-model="ruleForm.gender"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in teacherGenderOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='teacher'"  label="手机" prop="phone">
          <el-input v-model="ruleForm.phone"               placeholder="手机" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="24">  
        <el-form-item v-if="flag=='teacher'" label="照片" prop="headPic">
          <file-upload
          tip="点击上传照片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.headPic?ruleForm.headPic:''"
          @change="teacherHeadPicUploadChange"
          ></file-upload>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='teacher'"  label="身份证" prop="idNumber">
          <el-input v-model="ruleForm.idNumber"               placeholder="身份证" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='teacher'"  label="邮箱" prop="email">
          <el-input v-model="ruleForm.email"               placeholder="邮箱" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='teacher'"  label="住址" prop="address">
          <el-input v-model="ruleForm.address"               placeholder="住址" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-form-item v-if="flag=='user'" label="用户名" prop="teacherUsername">
        <el-input v-model="ruleForm.teacherUsername"
        placeholder="用户名"></el-input>
      </el-form-item>
      <el-col :span="24">
      <el-form-item>
        <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
      </el-form-item>
      </el-col>
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
      userFlag: false,
      parentGenderOptions: [],
      teacherGenderOptions: [],
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
    this.parentGenderOptions = "男,女".split(',')
    this.teacherGenderOptions = "男,女".split(',')
  },
  methods: {
    parentHeadPicUploadChange(fileUrls) {
        this.ruleForm.headPic = fileUrls;
    },
    teacherHeadPicUploadChange(fileUrls) {
        this.ruleForm.headPic = fileUrls;
    },
    onUpdateHandler() {
      if((!this.ruleForm.teacherUsername)&& 'parent'==this.flag){
        this.$message.error('家长账号不能为空');
        return
      }
      if((!this.ruleForm.password)&& 'parent'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
      if( 'parent' ==this.flag && this.ruleForm.age&&(!isIntNumer(this.ruleForm.age))){
       this.$message.error(`年龄应输入整数`);
        return
      }
        if(this.ruleForm.headPic!=null) {
                this.ruleForm.headPic = this.ruleForm.headPic.replace(new RegExp(this.$base.url,"g"),"");
        }
      if( 'parent' ==this.flag && this.ruleForm.phone&&(!isMobile(this.ruleForm.phone))){
        this.$message.error(`手机应输入手机格式`);
        return
      }
      if( 'parent' ==this.flag && this.ruleForm.idNumber&&(!checkIdCard(this.ruleForm.idNumber))){
        this.$message.error(`身份证应输入身份证格式`);
        return
      }
      if( 'parent' ==this.flag && this.ruleForm.email&&(!isEmail(this.ruleForm.email))){
        this.$message.error(`邮箱应输入邮箱格式`);
        return
      }
      if((!this.ruleForm.teacherUsername)&& 'teacher'==this.flag){
        this.$message.error('教师账号不能为空');
        return
      }
      if((!this.ruleForm.password)&& 'teacher'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
      if((!this.ruleForm.name)&& 'teacher'==this.flag){
        this.$message.error('教师姓名不能为空');
        return
      }
      if( 'teacher' ==this.flag && this.ruleForm.age&&(!isIntNumer(this.ruleForm.age))){
       this.$message.error(`年龄应输入整数`);
        return
      }
      if( 'teacher' ==this.flag && this.ruleForm.phone&&(!isMobile(this.ruleForm.phone))){
        this.$message.error(`手机应输入手机格式`);
        return
      }
        if(this.ruleForm.headPic!=null) {
                this.ruleForm.headPic = this.ruleForm.headPic.replace(new RegExp(this.$base.url,"g"),"");
        }
      if( 'teacher' ==this.flag && this.ruleForm.idNumber&&(!checkIdCard(this.ruleForm.idNumber))){
        this.$message.error(`身份证应输入身份证格式`);
        return
      }
      if( 'teacher' ==this.flag && this.ruleForm.email&&(!isEmail(this.ruleForm.email))){
        this.$message.error(`邮箱应输入邮箱格式`);
        return
      }
      if('user'==this.flag && this.ruleForm.teacherUsername.trim().length<1) {
	this.$message.error(`用户名不能为空`);
        return	
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
</style>
