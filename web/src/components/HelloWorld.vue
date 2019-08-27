<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    </ul>
    <el-upload
        class="upload-demo"
        ref="upload"
        :action="getServerAddress()"
        :on-preview="handlePreview"
        :on-remove="handleRemove"
        :file-list="fileList"
        :on-success="handleSuccess"
        :auto-upload="false">
        <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
        <el-button style="margin-left: 10px;" size="small" type="success" @click="submitUpload"><i class="el-icon-upload el-icon--right"></i>上传</el-button>
    </el-upload>
    <div v-if="isSuccess">
        <p> Congratulations! File Location is : {{ fileUrl }}</p>
        <p> File Size is : {{ fileSize }} </p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'Welcome, We Will Simulate Upload Process For Testing',
      fileList: [],
      isSuccess: false,
      fileUrl : '',
      fileSize : 0
    }
  },
  methods: {
    handlePreview(file) {
        console.log(file)
    },
    handleRemove(file, fileList) {
        console.log(file, fileList)
    },
    getServerAddress() {
        return "http://localhost:23335/process/upload";
    },
    submitUpload() {
        this.$refs.upload.submit();
    },
    handleSuccess(response, file, fileList) {
        if (response.code === '200') {
            console.log('Upload Success')
            this.isSuccess = true
            this.fileSize = response.fileSize
            this.fileUrl = response.fileUrl
            this.$message({
                showClose: true,
                message: 'Upload Complete!',
                type: 'success'})
        } else {
            console.log('Fail')
            this.isSuccess = false
            this.$message({
                            showClose: true,
                            message: 'Upload Failed!',
                            type: 'success'})
        }
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
