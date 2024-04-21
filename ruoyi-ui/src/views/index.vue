<template>
  <div class="home">
    <div class="index-text">
      <div class="center-box">
        <h1 style="color: #FFFFFF;font-size: 40px;">基于云原生的学生在校经历管理SaaS系统</h1>
        <div style="color: #FFFFFF;font-size: 18px;">基于Java17、Spring Boot 3、Spring Cloud Alibaba 2022、Vue 3 以及 Element-Plus 构建</div>
      </div>
    </div>
    <div class="index-bg">
      <el-image class="bg" :src="indexBackground" fit="cover" />
    </div>
  </div>
</template>

<script setup name="Index" lang="ts">
import indexBackground from '@/assets/images/index-background.jpg'
import {initWebSocket} from '@/utils/websocket';

onMounted(() => {
  let protocol = window.location.protocol === 'https:' ? 'wss://' : 'ws://'
  initWebSocket(protocol + window.location.host + import.meta.env.VITE_APP_BASE_API + "/resource/websocket");
});
</script>

<style scoped lang="scss">
.home {
  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
}

.index-text {
  height: calc(100vh - 85px);
  width: 100%;
  display: flex;

  .center-box {
    text-align: center;
    margin: auto;
  }
}

.index-bg {
  height: 100%;
  position: absolute;
  bottom: 0;
  z-index: -1;

  .bg {
    height: 100%;
    width: auto;
  }
}
</style>
